package br.com.tomus.jpa_hibernate.dao;

import java.util.List;

import br.com.tomus.jpa_hibernate.connection.ConnectionFactory;
import br.com.tomus.jpa_hibernate.entities.Nota;
import jakarta.persistence.EntityManager;

public class NotaDAO {
	
	public Nota save(Nota nota) {
		EntityManager em = new ConnectionFactory().getConnection();
		
		try {
			em.getTransaction().begin();
			em.persist(nota);
			em.getTransaction().commit();
			
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		
		return nota;
	}
	
	public Nota update(Nota nota) {
	    EntityManager em = new ConnectionFactory().getConnection();
	    
	    try {
	        em.getTransaction().begin();
	        
	        Nota notaExistente = em.find(Nota.class, nota.getId());
	        
	        if (notaExistente != null) {
	            
	            notaExistente.setTurma(nota.getTurma());
	            notaExistente.setNota(nota.getNota());
	            notaExistente.setAluno(nota.getAluno());
	        } else {
	            System.out.println("Nota com id: " + nota.getId() + " não encontrada!");
	        }
	        
	        em.getTransaction().commit();
	        
	        return notaExistente;
	        
	    } catch (Exception e) {
	        em.getTransaction().rollback();
	        e.printStackTrace();
	        return null;
	    } finally {
	        em.close(); 
	    }
	}
	
	public Nota findById(Long id) {
		EntityManager em = new ConnectionFactory().getConnection();
		Nota notaEncontrada = null;
		
		try {
			notaEncontrada = em.find(Nota.class, id);
			return notaEncontrada;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			em.close();
		}
	}
	
	public List<Nota> findAll(){
		EntityManager em = new ConnectionFactory().getConnection();
		List<Nota> notas = null;
		
		try {
			notas = em.createQuery("SELECT n FROM Nota n", Nota.class).getResultList();
			return notas;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			em.close();
		}
	}

}
