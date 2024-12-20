package br.com.tomus.jpa_hibernate.test;

import java.util.List;

import br.com.tomus.jpa_hibernate.dao.NotaDAO;
import br.com.tomus.jpa_hibernate.entities.Aluno;
import br.com.tomus.jpa_hibernate.entities.Nota;

public class NotaTest {

	public static void main(String[] args) {
		
		NotaDAO notaDAO = new NotaDAO();
//		Aluno aluno = new Aluno();
//		Nota nota = new Nota();
		
		List<Nota> notas = notaDAO.findAll();
		
//		aluno.setId(252L);
//		nota.setId(1L);
//		nota.setTurma("T1");
//		nota.setNota(8.3);
//		nota.setAluno(aluno);
		
//		nota = notaDAO.findById(52L);
//		System.out.println(nota.getTurma() + " " + nota.getAluno().getNome() + " " + nota.getNota());
		System.out.println("----- Notas -----");
		for(Nota nota : notas) {
			
			System.out.println("Aluno: " + nota.getAluno().getNome());
			System.out.println("Turma: " + nota.getTurma());
			System.out.println("Nota: " + nota.getNota());
			System.out.println("----------");
		}
	}

}
