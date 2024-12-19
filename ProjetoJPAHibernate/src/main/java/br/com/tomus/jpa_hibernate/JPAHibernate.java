package br.com.tomus.jpa_hibernate;

import br.com.tomus.jpa_hibernate.dao.AlunoDAO;
import br.com.tomus.jpa_hibernate.entities.Aluno;

public class JPAHibernate {

	public static void main(String[] args) {
		
		AlunoDAO dao = new AlunoDAO();
		
		Aluno aluno = dao.findById(232L);
		
//        aluno.setNome("Ismael Sales");
//        aluno.setCpf("987321654-25");
//        aluno.setIdade(30);
//         
//		dao.save(aluno);
		
		System.out.println(aluno.getNome());
	}

}
