package classi;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "utente")
public class Utente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numeroTessera;
	private String nome;
	private String cognome;
	private LocalDate dataDiNascita;
	@OneToMany(mappedBy="utente")
	private Set<Prestito> listaPrestiti;
	
	
	
	public Utente() {
		super();
	}

	public Utente(String nome, String cognome, LocalDate dataDiNascita) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
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
	public LocalDate getDataDiNascita() {
		return dataDiNascita;
	}
	public void setDataDiNascita(LocalDate dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}
	
	public Long getNumeroTessera() {
		return numeroTessera;
	}
	public void setNumeroTessera(Long numeroTessera) {
		this.numeroTessera = numeroTessera;
	}
	
	public Set<Prestito> getListaPrestiti() {
		return listaPrestiti;
	}
	public void setListaPrestiti(Set<Prestito> listaPrestiti) {
		this.listaPrestiti = listaPrestiti;
	}
	@Override
	public String toString() {
		return "Utente [nome=" + nome + ", cognome=" + cognome + ", dataDiNascita=" + dataDiNascita + ", numeroTessera="
				+ numeroTessera + "]";
	}
	
	
}
