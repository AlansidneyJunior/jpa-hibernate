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
	
	public void update(Aluno aluno) {
		EntityManager em = new ConnectionFactory().getConnection();
	    try {
	        em.getTransaction().begin();
	        
	        Aluno alunoExistente = em.find(Aluno.class, aluno.getId());
	        if (alunoExistente != null) {
	        	
	            alunoExistente.setNome(aluno.getNome());
	            alunoExistente.setCpf(aluno.getCpf());
	            alunoExistente.setIdade(aluno.getIdade());
	            
	            em.merge(alunoExistente);
	        } else {
	            System.out.println("Aluno não encontrado!");
	        }
	        
	        em.getTransaction().commit();
	    } catch (Exception e) {
	        em.getTransaction().rollback();
	        e.printStackTrace();
	    } finally {
	        em.close();
	    }
	}
	
	public Aluno findById(Long id){
		EntityManager em = new ConnectionFactory().getConnection();
		Aluno alunoEncontrado = null;
		
		try {
			em.getTransaction().begin();
			alunoEncontrado= em.find(Aluno.class, id);
			
			if (alunoEncontrado == null) {
				System.out.println("Aluno com id:" + id + " não foi encontrado!");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
		}
		return alunoEncontrado;
	}
	
}
