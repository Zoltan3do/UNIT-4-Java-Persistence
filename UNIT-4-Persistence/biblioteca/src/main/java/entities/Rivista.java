package entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;

@Entity
public class Rivista extends Articolo{
	private Periodicita periodicita;

	
	public Rivista() {}
	public Rivista(String titolo,LocalDate annoPubblicazione, int nPagine, Periodicita periodicita) {
		super(titolo,annoPubblicazione, nPagine);
		this.periodicita = periodicita;
	}

	public Periodicita getPeriodicita() {
		return periodicita;
	}

	public void setPeriodicita(Periodicita periodicita) {
		this.periodicita = periodicita;
	}

	@Override
	public String toString() {
		return "Rivista [periodicita=" + periodicita + "]";
	}
	
	
	

}
