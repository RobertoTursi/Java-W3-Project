package DAO;

import java.util.List;

import classi.ElementoLeggibile;
import classi.Prestito;
import classi.Utente;

public interface InterfaceDAO {
	public void save(ElementoLeggibile el);
	public void saveUtente(Utente u);
	public void savePrestito(Prestito p);
	public void removeFromCatalogo(Long id);
	public List<ElementoLeggibile> findAllElements();
	public Object findElementByISBN(Long id);
	public List<ElementoLeggibile> findElementsByAnnoPubblicazione(Integer anno);
	public List<ElementoLeggibile> findElementsByAuthor(String autore);
	public List<ElementoLeggibile> findElementsByTitle(String titolo);
	public List<ElementoLeggibile> findNotAvailableElements(long id);
	public List<Prestito> findPrestitiScadutiNonRestituiti();
}
