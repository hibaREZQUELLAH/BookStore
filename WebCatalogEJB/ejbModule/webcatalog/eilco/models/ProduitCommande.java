package webcatalog.eilco.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "produit_commande")
public class ProduitCommande implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
    @JoinColumn(name = "id_produit")
	private Produit produit;
	
	@ManyToOne
	@JoinColumn(name="id_commande")
	private Commande commande;
	
	private double quantite;
	
	public ProduitCommande() {}
	
	
	
	public ProduitCommande(Produit produit, Commande commande, double quantite) {
		super();
		this.produit = produit;
		this.commande = commande;
		this.quantite = quantite;
	}
	
	public Produit getProduit_id() {
		return produit;
	}
	
	public void setProduit_id(Produit produit) {
		this.produit = produit;
	}
	
	public Commande getCommande_id() {
		return commande;
	}
	
	public void setCommande_id(Commande commande) {
		this.commande = commande;
	}
	
	public double getQuantite() {
		return quantite;
	}
	
	public void setQuantite(double quantite) {
		this.quantite = quantite;
	}
	
	
}
