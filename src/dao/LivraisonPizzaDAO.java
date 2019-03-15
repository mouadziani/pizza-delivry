package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Livraison;

public class LivraisonPizzaDAO {
	
	private EntityManager entityManager;
	
	public LivraisonPizzaDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void addLivraisonPizza(Livraison livraison) {
		entityManager.getTransaction().begin();
		entityManager.persist(livraison);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
}
