package dao;

import java.time.LocalDate;
import java.util.List;

import entities.Articolo;
import entities.Libro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class ArticoloDao {

	private final EntityManager em;

	public ArticoloDao(EntityManager em) {
		this.em = em;
	}

	
	public List<Articolo> ricercaPerAnno(LocalDate anno){
		try {
			TypedQuery<Articolo> query = em.createNamedQuery("findArticoloByAnno",Articolo.class);
			query.setParameter("annoPubblicazione",anno);
			return query.getResultList();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	
	public List<Libro> ricercaPerAutore(String autore){
		try {
			TypedQuery<Libro> query = em.createNamedQuery("ricercaAutore",Libro.class);
			query.setParameter("autore", autore + "%");
			return query.getResultList();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	
	public List<Articolo> ricercaPerTitolo(String titolo){
		try {
			TypedQuery<Articolo> query = em.createNamedQuery("findByTitle",Articolo.class);
			query.setParameter("titolo","%" + titolo + "%");
			return query.getResultList();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	

}
