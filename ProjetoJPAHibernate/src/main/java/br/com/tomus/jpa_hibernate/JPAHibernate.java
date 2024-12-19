package br.com.tomus.jpa_hibernate;

import java.util.List;

import br.com.tomus.jpa_hibernate.dao.AlunoDAO;
import br.com.tomus.jpa_hibernate.entities.Aluno;

public class JPAHibernate {

	public static void main(String[] args) {
		
		AlunoDAO dao = new AlunoDAO();
		Aluno alunoRemovido = null;
		
		alunoRemovido = dao.remove(452L);
		System.out.println("Nome: " + alunoRemovido.getNome());
	}
}
