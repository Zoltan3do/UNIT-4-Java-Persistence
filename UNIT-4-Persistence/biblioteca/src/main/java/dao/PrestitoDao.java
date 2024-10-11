package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import entities.Articolo;
import entities.Prestito;
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

	public List<Articolo> ricercaTessera(String numeroTessera){
		try {
			TypedQuery<Prestito> query = em.createNamedQuery("findPrestitoByTessera", Prestito.class);
			query.setParameter("nTessera", UUID.fromString(numeroTessera));
			List<Prestito> listaPrestiti = query.getResultList();
			List<Articolo> listaArticoli = new ArrayList<Articolo>();
			for(Prestito p : listaPrestiti) {
				listaArticoli.add(gd.getEventById(Articolo.class, p.getUtente().getNumeroTessera().toString()));
			}
			return listaArticoli;
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}



}
