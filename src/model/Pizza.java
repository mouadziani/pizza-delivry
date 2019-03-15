package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name="Pizza.getPizzaNames", query="SELECT p.libelle FROM Pizza p")
})
public class Pizza implements Serializable {
	@Id
	private String libelle;
	private float prix;
	
	public String getLibelle() {
		return libelle;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	public Pizza() {
	}

	@Override
	public String toString() {
		return "Pizza [libelle=" + libelle + ", prix=" + prix + "]";
	}
}
