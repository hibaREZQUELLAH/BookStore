package webcatalog.eilco.beancatalog;

import java.util.ArrayList;

import javax.ejb.Local;

import webcatalog.eilco.models.Categorie;
import webcatalog.eilco.models.Produit;

@Local
public interface accesCatalogueBeanLocal {
	
	public ArrayList<Categorie> getListCategories();
	public ArrayList<Produit> getListProduits(int id);
	public Produit find(int id);

}
