package webcatalog.eilco.beancommande;

import javax.ejb.Remote;

import webcatalog.eilco.models.Commande;
import webcatalog.eilco.models.LigneCommande;

@Remote
public interface gestionCommandeBeanRemote {
	
	public Commande validerCommande(Commande c);

}
