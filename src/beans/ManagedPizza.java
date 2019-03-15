package beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.LivraisonPizzaDAO;
import model.Livraison;
import model.Pizza;

@ManagedBean(name="ManagedPizza")
public class ManagedPizza {
	
	private String libelle;
	private int qte;
	private String client;
	private String adresse;
	private List<String> pizzaName;
	private EntityManager entityManager;
	
	public ManagedPizza() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ControleJavaEE");
		this.entityManager = entityManagerFactory.createEntityManager();
		this.pizzaName = entityManager.createNamedQuery("Pizza.getPizzaNames").getResultList();
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
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
	
	public List<String> getPizzaName() {
		return pizzaName;
	}
	
	public void setPizzaName(List<String> pizzaName) {
		this.pizzaName = pizzaName;
	}
	
	// Actions 
	public void addCommandePizza() {
		Pizza pizza = entityManager.find(Pizza.class, this.getLibelle());
		if(pizza != null) {
			Livraison livraison = new Livraison(client, adresse, qte, pizza);
			LivraisonPizzaDAO dao = new LivraisonPizzaDAO(this.entityManager);
			dao.addLivraisonPizza(livraison);
		} else {
			System.out.println("Pizza " + libelle + " n'existe pas !!");
		}
	}
}
