package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Livraison implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int NBL;
	private String client;
	private String adresse;
	private int qte;
	
	@ManyToOne
	@JoinColumn(name="libelle")
	private Pizza pizza;
	
	public Livraison() {
	}
	
	public Livraison(String client, String adresse, int qte, Pizza pizza) {
		this.client = client;
		this.adresse = adresse;
		this.qte = qte;
		this.pizza = pizza;
	}

	public int getNBL() {
		return NBL;
	}
	
	public void setNBL(int nBL) {
		NBL = nBL;
	}
	
	public String getClient() {
		return client;
	}
	
	public void setClient(String client) {
		this.client = client;
	}
	
	public String getAdresse() {
		return adresse;
	}
	
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public int getQte() {
		return qte;
	}
	
	public void setQte(int qte) {
		this.qte = qte;
	}
	
	public Pizza getPizza() {
		return pizza;
	}
	
	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}
	
}
