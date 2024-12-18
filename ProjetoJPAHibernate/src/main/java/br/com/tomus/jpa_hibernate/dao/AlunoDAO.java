package br.com.tomus.jpa_hibernate.dao;

import br.com.tomus.jpa_hibernate.connection.ConnectionFactory;
import br.com.tomus.jpa_hibernate.entities.Aluno;
import jakarta.persistence.EntityManager;

public class AlunoDAO {
	
	public Aluno save(Aluno aluno){
		EntityManager em = new ConnectionFactory().getConnection();
		
		try {
			em.getTransaction().begin();
			em.persist(aluno);
			em.getTransaction().commit();
		
		}catch (Exception e) {
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		
		return aluno;
	}
}
