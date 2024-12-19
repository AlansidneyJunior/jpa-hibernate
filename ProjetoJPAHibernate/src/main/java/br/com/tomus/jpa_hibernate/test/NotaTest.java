package br.com.tomus.jpa_hibernate.test;

import br.com.tomus.jpa_hibernate.dao.NotaDAO;
import br.com.tomus.jpa_hibernate.entities.Aluno;
import br.com.tomus.jpa_hibernate.entities.Nota;

public class NotaTest {

	public static void main(String[] args) {
		
		NotaDAO notaDAO = new NotaDAO();
		Aluno aluno = new Aluno();
		Nota nota = new Nota("T1", 9.5);
		
		aluno.setId(252L);
		nota.setAluno(aluno);
		
		notaDAO.save(nota);
	}

}
