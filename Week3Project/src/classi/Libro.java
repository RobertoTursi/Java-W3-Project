package classi;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("Libro")
public class Libro extends ElementoLeggibile{
	
	
	private String autore;
	private String genere;
	

	
	@Override
	public String toString() {
		return "Libro [codiceISBN = " + this.getCodiceISBN() + ", titolo = " + this.getTitolo() + ", autore = " + autore + ", genere = " + genere + ", anno pubblicazione = " + this.getAnnoPubblicazione() + ", numero pagine = " + this.getNumeroPagine() + "]";
	}
	//GETTER E SETTER
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
	
	
	
	
}
