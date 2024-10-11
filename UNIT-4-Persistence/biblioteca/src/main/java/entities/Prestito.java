package entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@NamedQuery(
	    name = "findArticoliByNumeroTesseraAndDate",
	    query = "SELECT a FROM Articolo a WHERE a.id IN " +
	            "(SELECT p.articolo.id FROM Prestito p WHERE p.utente.numeroTessera = :numeroTessera " +
	            "AND p.dataRestituzionePrevista <= :data)"
	)

@Table(name="prestiti")
public class Prestito {
	@Id
	@GeneratedValue
	private long id;
	private LocalDate dataInizio = LocalDate.now(), dataRestituzionePrevista = dataInizio.plusDays(30), dataRestituizioneEffettiva;
	
	@OneToOne
	@JoinColumn(name = "ISBN")
	private Articolo articolo;
	
	@ManyToOne
	@JoinColumn(name="numeroTessera")
	private Utente utente;
	
	
	public Prestito() {}
	public Prestito(LocalDate dataRestituizioneEffettiva, Articolo articolo, Utente utente) {
		super();
		this.dataRestituizioneEffettiva = dataRestituizioneEffettiva;
		this.articolo = articolo;
		this.utente = utente;
	}


	public LocalDate getDataInizio() {
		return dataInizio;
	}


	public void setDataInizio(LocalDate dataInizio) {
		this.dataInizio = dataInizio;
	}


	public LocalDate getDataRestituzionePrevista() {
		return dataRestituzionePrevista;
	}


	public void setDataRestituzionePrevista(LocalDate dataRestituzionePrevista) {
		this.dataRestituzionePrevista = dataRestituzionePrevista;
	}


	public LocalDate getDataRestituizioneEffettiva() {
		return dataRestituizioneEffettiva;
	}


	public void setDataRestituizioneEffettiva(LocalDate dataRestituizioneEffettiva) {
		this.dataRestituizioneEffettiva = dataRestituizioneEffettiva;
	}

	

	public Articolo getArticolo() {
		return articolo;
	}


	public void setArticolo(Articolo articolo) {
		this.articolo = articolo;
	}


	public Utente getUtente() {
		return utente;
	}


	public void setUtente(Utente utente) {
		this.utente = utente;
	}


	@Override
	public String toString() {
		return "Prestito [id=" + id + ", dataInizio=" + dataInizio + ", dataRestituzionePrevista="
				+ dataRestituzionePrevista + ", dataRestituizioneEffettiva=" + dataRestituizioneEffettiva + "]";
	}
	

}
