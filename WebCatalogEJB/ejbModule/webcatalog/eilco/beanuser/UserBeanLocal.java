package webcatalog.eilco.beanuser;

import javax.ejb.Local;

import webcatalog.eilco.models.Client;

@Local
public interface UserBeanLocal {
	
	public Client register(String nom,String prenom,String email,String tele,String fulladresse,String password);
	public Client login(String email,String password);
}
