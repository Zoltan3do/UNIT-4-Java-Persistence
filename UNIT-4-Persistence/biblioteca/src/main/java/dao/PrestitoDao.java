package dao;


import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import entities.Articolo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class PrestitoDao {
	
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");
	private EntityManager em = emf.createEntityManager();

	public PrestitoDao(EntityManager em) {
		this.em = em;
	}

	public GenericsDao gd = new GenericsDao(em);

	public List<Articolo> ricercaTessera(String numeroTessera, LocalDate data) throws Exception {
	    UUID numeroTesseraUUID = UUID.fromString(numeroTessera);

	    TypedQuery<Articolo> query = em.createNamedQuery("findArticoliByNumeroTesseraAndDate", Articolo.class);
	    query.setParameter("numeroTessera", numeroTesseraUUID);
	    query.setParameter("data", data);

	    return query.getResultList();
	}



}
