package webcatalog.eilco.beancommande;



import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import webcatalog.eilco.models.Commande;

/**
 * Session Bean implementation class gestionCommandeBean
 */
@Stateful(name="beanCommande")
@LocalBean
public class gestionCommandeBean implements gestionCommandeBeanRemote, gestionCommandeBeanLocal {

	@PersistenceContext(name = "managerWebCatalog")
	EntityManager em;
	
	
    /**
     * Default constructor. 
     */
    public gestionCommandeBean() {
        
    }
    
    @Override
    public Commande validerCommande(Commande c) {
    	if(c == null) {
    		return new Commande();
    	}
    	else {
    		em.persist(c);
    		return c;
    	}
    }
}
