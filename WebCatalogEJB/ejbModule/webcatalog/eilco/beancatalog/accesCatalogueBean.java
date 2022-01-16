package webcatalog.eilco.beancatalog;

import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import webcatalog.eilco.models.Categorie;
import webcatalog.eilco.models.Produit;

/**
 * Session Bean implementation class accesCatalogueBean
 */
@Stateless(name = "accessCatalog")
public class accesCatalogueBean implements accesCatalogueBeanRemote, accesCatalogueBeanLocal {
	
	@PersistenceContext(name = "managerWebCatalog")
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public accesCatalogueBean() {
       
    }

	@Override
	public ArrayList<Categorie> getListCategories() {
		Query q = em.createQuery("select c from Categorie c");
		ArrayList<Categorie> categories = (ArrayList<Categorie>) q.getResultList();
		if(categories.isEmpty()) {
			return new ArrayList<>();
		}
		return categories;	
	}

	@Override
	public ArrayList<Produit> getListProduits(int id) {
		Query q = em.createQuery("SELECT p FROM Produit p left join p.categorie c WHERE p.categorie.id=:id").setParameter("id",id);
		ArrayList<Produit> produits = (ArrayList<Produit>) q.getResultList();
		if(produits.isEmpty()) {
			return new ArrayList<>();
		}
		return produits;
	}
	
	public Produit find(int id) {
		Query q = em.createQuery("select p from Produit p where p.id = :id").setParameter("id", id);
		Produit p = (Produit) q.getSingleResult();
		if(p == null) {
			return new Produit();
		}
		return p;
	}

}
