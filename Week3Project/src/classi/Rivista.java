package classi;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue("Rivista")
public class Rivista extends ElementoLeggibile{

	@Enumerated(EnumType.STRING)
	private Periodicita periodicita;
	
	
	@Override
	public String toString() {
		return "Rivista [codiceISBN = " + this.getCodiceISBN() + ", titolo = " + this.getTitolo() + ", anno pubblicazione = " + this.getAnnoPubblicazione() + ", numero pagine = " + this.getNumeroPagine() + ", periodicita=" + periodicita + "]";
	}

	//GETTER E SETTER
	public Periodicita getPeriodicita() {
		return periodicita;
	}

	public void setPeriodicita(Periodicita periodicita) {
		this.periodicita = periodicita;
	}
	
	
}
