package entities;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@NamedQuery(
		name="findArticoloByAnno",
		query="SELECT a FROM Articolo a WHERE a.annoPubblicazione = :annoPubblicazione"
)

@NamedQuery(
		name="findByTitle",
		query = "SELECT a FROM Articolo a WHERE a.titolo LIKE :titolo"
)

@Table(name="articoli")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tipo_articolo")
public abstract class Articolo {
	
	@Id
	@GeneratedValue
	private UUID ISBN;
	private String titolo;
	private LocalDate annoPubblicazione;
	private int nPagine;
	
	public Articolo() {}
	public Articolo(String titolo,LocalDate annoPubblicazione, int nPagine) {
		super();
		this.titolo = titolo;
		this.annoPubblicazione = annoPubblicazione;
		this.nPagine = nPagine;
	}
	
	

	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public LocalDate getAnnoPubblicazione() {
		return annoPubblicazione;
	}


	public void setAnnoPubblicazione(LocalDate annoPubblicazione) {
		this.annoPubblicazione = annoPubblicazione;
	}


	public int getnPagine() {
		return nPagine;
	}


	public void setnPagine(int nPagine) {
		this.nPagine = nPagine;
	}
	
	
	public UUID getISBN() {
		return ISBN;
	}
	public void setISBN(UUID iSBN) {
		ISBN = iSBN;
	}
	@Override
	public String toString() {
		return "Articolo [ISBN=" + ISBN + ", titolo=" + titolo + ", annoPubblicazione=" + annoPubblicazione
				+ ", nPagine=" + nPagine + "]";
	}



	
	

}
