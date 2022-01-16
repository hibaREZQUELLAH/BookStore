package webcatalog.eilco.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ligne_commande")
public class LigneCommande implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String designation;
	private double quantite;
	private double prix_unitaire;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_commande",nullable = false)
	private Commande commande;
	
	
	
	public LigneCommande(int id, String designation, double quantite, double prix_unitaire, Commande commande) {
		super();
		this.id = id;
		this.designation = designation;
		this.quantite = quantite;
		this.prix_unitaire = prix_unitaire;
		this.commande = commande;
	}

	public LigneCommande() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getQuantite() {
		return quantite;
	}

	public void setQuantite(double quantite) {
		this.quantite = quantite;
	}

	public double getPrix_unitaire() {
		return prix_unitaire;
	}

	public void setPrix_unitaire(double prix_unitaire) {
		this.prix_unitaire = prix_unitaire;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}
}
