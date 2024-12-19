package br.com.tomus.jpa_hibernate;

import java.util.List;

import br.com.tomus.jpa_hibernate.dao.AlunoDAO;
import br.com.tomus.jpa_hibernate.entities.Aluno;

public class JPAHibernate {

	public static void main(String[] args) {
		
		AlunoDAO dao = new AlunoDAO();
		List<Aluno> alunos = dao.findAll();
		
		if(alunos != null && !alunos.isEmpty()) {
			System.out.println("-----Lista de Alunos Cadastrados-----");
			alunos.forEach( aluno -> {
				System.out.println("ID: " + aluno.getId());
                System.out.println("Nome: " + aluno.getNome());
                System.out.println("CPF: " + aluno.getCpf());
                System.out.println("Idade: " + aluno.getIdade());
                System.out.println("-------------------------");
			});
		} else {
			System.out.println("Nenhum aluno cadastrado no banco de dados.");
		}
	}
}
