package br.com.tomus.jpa_hibernate;

import br.com.tomus.jpa_hibernate.connection.ConnectionFactory;
import br.com.tomus.jpa_hibernate.dao.AlunoDAO;
import br.com.tomus.jpa_hibernate.entities.Aluno;
import jakarta.persistence.EntityManager;

public class JPAHibernate {

	public static void main(String[] args) {
		
		EntityManager em = new ConnectionFactory().getConnection();
		AlunoDAO dao = new AlunoDAO();
		
		Aluno aluno = new Aluno();
		aluno.setCpf("123789456-44");
		aluno.setIdade(23);
		aluno.setNome("Henrique Campos");

		dao.save(aluno);
		
		em.close();
	
		
	}	

}
