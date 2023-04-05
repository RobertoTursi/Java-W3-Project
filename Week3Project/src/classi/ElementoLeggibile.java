package classi;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipologia", discriminatorType = DiscriminatorType.STRING)
@NamedQuery(name = "ElementoLeggibile.FindAll", query = "SELECT e FROM ElementoLeggibile e")
public abstract class ElementoLeggibile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codiceISBN;
	private String Titolo;
	private Integer annoPubblicazione;
	private Integer numeroPagine;
	@OneToMany(mappedBy = "elementoPrestato")
	private Set<Prestito> listaPrestiti;
	
	
	
	
	//GETTER E SETTER
	public Long getCodiceISBN() {
		return codiceISBN;
	}
	public String getTitolo() {
		return Titolo;
	}
	public void setTitolo(String titolo) {
		Titolo = titolo;
	}
	public Integer getAnnoPubblicazione() {
		return annoPubblicazione;
	}
	public void setAnnoPubblicazione(Integer annoPubblicazione) {
		this.annoPubblicazione = annoPubblicazione;
	}
	public Integer getNumeroPagine() {
		return numeroPagine;
	}
	public void setNumeroPagine(Integer numeroPagine) {
		this.numeroPagine = numeroPagine;
	}
	
	
}
