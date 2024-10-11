package entities;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="utenti")
public class Utente {
	
	@Id
	@GeneratedValue
	private UUID numeroTessera;
	private String nome, cognome;
	private LocalDate data;
	
	@OneToMany(mappedBy="utente")
	private List<Prestito> prestiti;
	
	public Utente() {}
	public Utente(String nome, String cognome, LocalDate data, List<Prestito> prestiti) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.data = data;
		this.prestiti = prestiti;
	}
	
	

	public UUID getNumeroTessera() {
		return numeroTessera;
	}
	public void setNumeroTessera(UUID numeroTessera) {
		this.numeroTessera = numeroTessera;
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
	
	

	public List<Prestito> getPrestiti() {
		return prestiti;
	}

	public void setPrestiti(List<Prestito> prestiti) {
		this.prestiti = prestiti;
	}

	@Override
	public String toString() {
		return "Utente [numeroTessera=" + numeroTessera + ", nome=" + nome + ", cognome=" + cognome + ", data=" + data
				+ "]";
	} 
	
	
	
	

}
