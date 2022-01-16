package webcatalog.eilco.beancatalog;

import java.util.ArrayList;

import javax.ejb.Remote;

import webcatalog.eilco.models.Categorie;
import webcatalog.eilco.models.Produit;

@Remote
public interface accesCatalogueBeanRemote {
	
	public ArrayList<Categorie> getListCategories();
	public ArrayList<Produit> getListProduits(int id);
	public Produit find(int id);
}
