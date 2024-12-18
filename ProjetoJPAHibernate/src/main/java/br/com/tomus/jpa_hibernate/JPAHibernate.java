package br.com.tomus.jpa_hibernate;

import br.com.tomus.jpa_hibernate.entities.Aluno;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAHibernate {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Aluno aluno = new Aluno();
		aluno.setCpf("987654321-00");
		aluno.setIdade(24);
		aluno.setNome("Alansidney Junior");
		
		em.persist(aluno);
		
		System.out.println("Persistiu aluno...");
		em.getTransaction().commit();
		System.out.println("Commit aluno...");
		
		em.close();
		emf.close();
		
	}	

}
