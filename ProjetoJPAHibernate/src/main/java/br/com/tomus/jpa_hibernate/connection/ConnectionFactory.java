package br.com.tomus.jpa_hibernate.connection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnectionFactory {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
	
	public EntityManager getConnection() {
		return emf.createEntityManager();
	}
	
}
