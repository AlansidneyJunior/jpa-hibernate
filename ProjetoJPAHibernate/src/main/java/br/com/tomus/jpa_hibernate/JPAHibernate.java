package br.com.tomus.jpa_hibernate;

import br.com.tomus.jpa_hibernate.connection.ConnectionFactory;
import br.com.tomus.jpa_hibernate.entities.Aluno;
import jakarta.persistence.EntityManager;

public class JPAHibernate {

	public static void main(String[] args) {
		EntityManager em = new ConnectionFactory().getConnection();
		
		em.getTransaction().begin();
		
		Aluno aluno = new Aluno();
		aluno.setCpf("123789456-44");
		aluno.setIdade(23);
		aluno.setNome("Henrique Campos");
		
		em.persist(aluno);
		
		System.out.println("Persistiu aluno...");
		em.getTransaction().commit();
		System.out.println("Commit aluno...");
		
		em.close();
	
		
	}	

}
