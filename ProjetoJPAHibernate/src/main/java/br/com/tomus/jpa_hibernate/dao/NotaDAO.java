package br.com.tomus.jpa_hibernate.dao;

import br.com.tomus.jpa_hibernate.connection.ConnectionFactory;
import br.com.tomus.jpa_hibernate.entities.Nota;
import jakarta.persistence.EntityManager;

public class NotaDAO {
	
	public Nota save(Nota nota) {
		EntityManager em = new ConnectionFactory().getConnection();
		
		try {
			em.getTransaction().begin();
			em.persist(nota);
			em.getTransaction().commit();
			
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		
		return nota;
	}
}
