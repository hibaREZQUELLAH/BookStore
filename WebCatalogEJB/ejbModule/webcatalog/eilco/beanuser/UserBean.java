package webcatalog.eilco.beanuser;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import webcatalog.eilco.models.Client;

/**
 * Session Bean implementation class UserBean
 */
@LocalBean
@Stateful(name="userBean")
public class UserBean implements UserBeanRemote, UserBeanLocal {
	
	@PersistenceContext(name = "managerWebCatalog")
	EntityManager em;
	
	Client c;
    /**
     * Default constructor. 
     */
    public UserBean() {
        
    }
    
    
    //check if user exist in database
    
    private boolean isExist(String email) {
    	Query q = em.createQuery("select count(email) FROM Client c WHERE c.email=:email").setParameter("email", email);
    	long count = ((Number) q.getSingleResult()).longValue();
    	if(count > 0) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }

    //save the user to database
	@Override
	public Client register(String nom,String prenom,String email,String tele,String fulladresse,String password) {
		c = new Client();
		c.setNom(nom);
		c.setPrenom(prenom);
		c.setEmail(email);
		c.setTelephone(tele);
		c.setAdresse(fulladresse);
		c.setPassword(password);
		
		boolean exist = isExist(email);
		if(exist) {
			return null;
		}
		else {
			em.persist(c);
			return c;
		}
	}

	
	@Override
	public Client login(String email, String password) {
		c = null;
		Query q = em.createQuery("SELECT c FROM Client c WHERE c.email=:email and c.password=:password");
		q.setParameter("email", email);
		q.setParameter("password", password);
		try {
			c = (Client) q.getSingleResult();
		}
		catch(NoResultException nre) {
			nre.getMessage();
		}
		
		if(c == null) {
			return null;
		}
		else {
			return c;
		}
	}
}
