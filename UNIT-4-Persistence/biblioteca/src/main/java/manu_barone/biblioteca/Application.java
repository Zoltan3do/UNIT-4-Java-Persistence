package manu_barone.biblioteca;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dao.ArticoloDao;
import dao.GenericsDao;
import dao.PrestitoDao;
import entities.Articolo;
import entities.Libro;
import entities.Periodicita;
import entities.Prestito;
import entities.Rivista;
import entities.Utente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {

	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");

	public static void main(String[] args) {

		EntityManager em =  emf.createEntityManager();

		GenericsDao dao = new GenericsDao(em);
		ArticoloDao articoloDao = new ArticoloDao(em);
		PrestitoDao prestitoDao = new PrestitoDao(em);

		//		Libro libro1 = new Libro("buonasera",LocalDate.of(2015, 5, 10), 300, "Autore 1", "Genere 1");
		//		Libro libro2 = new Libro("buonpomeriggio",LocalDate.of(2018, 8, 20), 250, "Autore 2", "Genere 2");
		//		Libro libro3 = new Libro("buonpranzo",LocalDate.of(2020, 11, 15), 400, "Autore 3", "Genere 3");
		//
		//		Rivista rivista1 = new Rivista("buongiorno",LocalDate.of(2021, 1, 5), 50, Periodicita.MENSILE);
		//		Rivista rivista2 = new Rivista("buonanotte",LocalDate.of(2022, 3, 12), 40, Periodicita.SETTIMANALE);
		//
		//		dao.save(libro1);
		//		dao.save(libro2);
		//		dao.save(libro3);
		//		dao.save(rivista1);
		//		dao.save(rivista2);
		//
		//		Utente utente1 = new Utente("Mario", "Rossi", LocalDate.of(1990, 2, 12), new ArrayList<>());
		//		Utente utente2 = new Utente("Luca", "Bianchi", LocalDate.of(1985, 4, 23), new ArrayList<>());
		//		Utente utente3 = new Utente("Anna", "Verdi", LocalDate.of(1992, 6, 15), new ArrayList<>());
		//		Utente utente4 = new Utente("Elena", "Neri", LocalDate.of(1988, 8, 8), new ArrayList<>());
		//		Utente utente5 = new Utente("Giulia", "Gialli", LocalDate.of(1995, 10, 30), new ArrayList<>());
		//
		//		dao.save(utente1);
		//		dao.save(utente2);
		//		dao.save(utente3);
		//		dao.save(utente4);
		//		dao.save(utente5);
		//
		//		Prestito prestito1 = new Prestito(null, libro1, utente1);
		//		Prestito prestito2 = new Prestito(null, libro2, utente2);
		//		Prestito prestito3 = new Prestito(null, libro3, utente3);
		//		Prestito prestito4 = new Prestito(null, rivista1, utente4);
		//		Prestito prestito5 = new Prestito(null, rivista2, utente5);
		//
		//		dao.save(prestito1);
		//		dao.save(prestito2);
		//		dao.save(prestito3);
		//		dao.save(prestito4);
		//		dao.save(prestito5);

		//-----------------ELIMINAZIONE PER ID--------------------------------------------------------------------------------------------
		//    	try {
		//			dao.delete(Articolo.class, "0f213290-b11a-459f-b2bf-908c6b117724");
		//		} catch (Exception e) {
		//			e.printStackTrace();
		//		}



		//-----------RICERCA PER ID--------------------------------------------------------------------------------------------------
		//		try {
		//			System.out.println(dao.getEventById(Libro.class, "86860470-911b-406f-b3aa-b0c46acb6f96"));
		//
		//		}catch(Exception e) {
		//			e.printStackTrace();
		//		}



		//-------ANNO PUBBLICAZIONE------------------------------------------------------------------------------------------------------
		//			LocalDate annoRicerca = LocalDate.of(2015, 5, 10);
		//			List<Articolo> articoliPerAnno = articoloDao.ricercaPerAnno(annoRicerca);
		//			for(Articolo articolo:articoliPerAnno) {
		//				System.out.println(articolo);
		//			}



		//-------AUTORE------------------------------------------------------------------------------------------------------

		//			List<Libro> articoliPerAutore = articoloDao.ricercaPerAutore("Autore");
		//			for(Libro libro:articoliPerAutore) {
		//				System.out.println(libro);
		//			}




		//------------TITOLO--------------------------------------------------------------------------------------------------
		//					List<Articolo> articoliPerTitolo = articoloDao.ricercaPerTitolo("buo");
		//					for(Articolo a:articoliPerTitolo) {
		//						System.out.println(a);
		//					}




		//---------------TESSERA----------------------------------------------------------------------------------------------
		List<Articolo> articoliPerTessera;
		try {
			articoliPerTessera = prestitoDao.ricercaTessera("1f4838eb-1192-48bb-8578-281b032b3a73",LocalDate.now());
			if (!articoliPerTessera.isEmpty()) {
			    for (Articolo a : articoliPerTessera) {
			        System.out.println(a);
			    }
			} else {
			    System.out.println("Nessun articolo trovato per la tessera specificata.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}





		em.close();
		emf.close();


	}
}
