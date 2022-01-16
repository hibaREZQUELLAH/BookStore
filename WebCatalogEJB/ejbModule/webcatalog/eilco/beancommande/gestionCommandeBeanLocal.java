package webcatalog.eilco.beancommande;

import javax.ejb.Local;

import webcatalog.eilco.models.Commande;
import webcatalog.eilco.models.LigneCommande;

@Local
public interface gestionCommandeBeanLocal {
	
	public Commande validerCommande(Commande c);
}
