package classi;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Prestito {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Utente utente;
	@ManyToOne
	private ElementoLeggibile elementoPrestato;
	private LocalDate dataInizioPrestito;
	private Date dataRestituzionePrevista;
	private LocalDate dataRestituzioneEffettiva;
	
	
	public Date add30Days() {
		Calendar c = Calendar.getInstance(TimeZone.getTimeZone("Europe/Rome"), Locale.ITALY);
		Date date = java.sql.Date.valueOf(this.dataInizioPrestito);
		c.setTime(date);
		c.add(Calendar.MONTH, 1);
		return c.getTime();
	}
	
	public Prestito() {
		
	}
	
	
	public Prestito(Utente utente, ElementoLeggibile elementoPrestato, LocalDate dataInizioPrestito,
			LocalDate dataRestituzioneEffettiva) {
		super();
		this.utente = utente;
		this.elementoPrestato = elementoPrestato;
		this.dataInizioPrestito = dataInizioPrestito;
		this.dataRestituzionePrevista = add30Days();
		this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Utente getUtente() {
		return utente;
	}
	public void setUtente(Utente utente) {
		this.utente = utente;
	}
	public ElementoLeggibile getElementoPrestato() {
		return elementoPrestato;
	}
	public void setElementoPrestato(ElementoLeggibile elementoPrestato) {
		this.elementoPrestato = elementoPrestato;
	}
	public LocalDate getDataInizioPrestito() {
		return dataInizioPrestito;
	}
	public void setDataInizioPrestito(LocalDate dataInizioPrestito) {
		this.dataInizioPrestito = dataInizioPrestito;
	}
	public Date getDataRestituzionePrevista() {
		return dataRestituzionePrevista;
	}
	public void setDataRestituzionePrevista(Date dataRestituzionePrevista) {
		this.dataRestituzionePrevista = dataRestituzionePrevista;
	}
	public LocalDate getDataRestituzioneEffettiva() {
		return dataRestituzioneEffettiva;
	}
	public void setDataRestituzioneEffettiva(LocalDate dataRestituzioneEffettiva) {
		this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
	}
	
	@Override
	public String toString() {
		return "Prestito [utente=" + utente + ", elementoPrestato=" + elementoPrestato + ", dataInizioPrestito="
				+ dataInizioPrestito + ", dataRestituzionePrevista=" + dataRestituzionePrevista
				+ ", dataRestituzioneEffettiva=" + dataRestituzioneEffettiva + "]";
	}
	
	
	
}
