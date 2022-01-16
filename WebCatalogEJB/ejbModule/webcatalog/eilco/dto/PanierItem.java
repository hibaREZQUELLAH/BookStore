package webcatalog.eilco.dto;

import webcatalog.eilco.models.Produit;

public class PanierItem {
	
	private Produit produit;
	private int quantite;
	
	public PanierItem(Produit produit,int qt) {
		this.produit = produit;
		this.quantite = qt;
	}
	
	public Produit getProduit() {
		return produit;
	}
	
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	
	
	public int getQuantite() {
		return quantite;
	}
	
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
}
