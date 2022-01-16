package webcatalog.eilco.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "commande")
public class Commande implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int numero;
	private Date date_creation;
	
	@ManyToOne 
	@JoinColumn(name = "id_client",nullable = false)
	private Client client;
	
	@OneToMany(mappedBy="commande",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<LigneCommande> lignesCommande = new ArrayList<>();
	
	public Commande() {}
	
	
	public Commande(int id,int numero,Date date_creation,Client client,List<LigneCommande> lignesCommande) {
		super();
		this.id = id;
		this.numero = numero;
		this.client = client;
		this.lignesCommande = lignesCommande;
		this.date_creation = date_creation;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public Date getDate_creation() {
		return date_creation;
	}


	public void setDate_creation(Date date_creation) {
		this.date_creation = date_creation;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public List<LigneCommande> getLignesCommande() {
		return lignesCommande;
	}


	public void setLignesCommande(List<LigneCommande> lignesCommande) {
		this.lignesCommande = lignesCommande;
	}
}
