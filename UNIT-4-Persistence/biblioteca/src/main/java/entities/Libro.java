package entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;

@Entity
@NamedQuery(
		name="ricercaAutore",
		query="SELECT l FROM Libro l WHERE l.autore LIKE :autore"
)

public class Libro extends Articolo{
	
	private String autore, genere;
	
	public Libro() {}
	public Libro(String titolo, LocalDate annoPubblicazione, int nPagine, String autore, String genere) {
		super(titolo, annoPubblicazione, nPagine);
		this.autore = autore;
		this.genere = genere;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	@Override
	public String toString() {
		return "Libro [autore=" + autore + ", genere=" + genere + "]";
	}
	

}
