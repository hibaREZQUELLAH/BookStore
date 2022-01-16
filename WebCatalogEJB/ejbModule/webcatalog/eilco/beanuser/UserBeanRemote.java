package webcatalog.eilco.beanuser;

import javax.ejb.Remote;

import webcatalog.eilco.models.Client;

@Remote
public interface UserBeanRemote {
	
	public Client register(String nom,String prenom,String email,String tele,String fulladresse,String password);
	public Client login(String email,String password);
}
