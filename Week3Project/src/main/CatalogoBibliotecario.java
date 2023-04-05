package main;

import java.time.LocalDate;
import java.util.Date;

import DAO.ElementoLeggibileDAO;
import classi.Libro;
import classi.Periodicita;
import classi.Prestito;
import classi.Rivista;
import classi.Utente;

public class CatalogoBibliotecario {
	
	public static void main(String[] args) {
		
		Libro l1 = new Libro();
		l1.setAutore("GeorgeOrwell");
		l1.setGenere("Romanzo distopico");
		l1.setTitolo("1984");
		l1.setAnnoPubblicazione(1949);
		l1.setNumeroPagine(320);
		
		//System.out.println(l1);
		
		Rivista r1 = new Rivista();
		r1.setAnnoPubblicazione(1968);
		r1.setNumeroPagine(120);
		r1.setPeriodicita(Periodicita.MENSILE);
		r1.setTitolo("Le Scienze");
		
		//System.out.println(r1);
		
		Libro l2 = new Libro();
		l2.setAnnoPubblicazione(1002);
		l2.setAutore("erfe");
		l2.setGenere("fre");
		l2.setNumeroPagine(213);
		l2.setTitolo("43fre");
		
		Rivista r2 = new Rivista();
		r2.setAnnoPubblicazione(1233);
		r2.setNumeroPagine(2334);
		r2.setPeriodicita(Periodicita.SEMESTRALE);
		r2.setTitolo("fre");
		
		Libro l3 = new Libro();
		l3.setAnnoPubblicazione(1002);
		l3.setAutore("erfe");
		l3.setGenere("fre");
		l3.setNumeroPagine(213);
		l3.setTitolo("43fre");
		
		Rivista r3 = new Rivista();
		r3.setAnnoPubblicazione(1233);
		r3.setNumeroPagine(2334);
		r3.setPeriodicita(Periodicita.SEMESTRALE);
		r3.setTitolo("fre");
		
		Utente u1 = new Utente("Giacomo", "Marangi", LocalDate.of(2000, 10, 23));
		//System.out.println(u1.getNumeroTessera());
		Utente u2 = new Utente("Marina", "Serafini", LocalDate.of(1998, 11, 03));
		
		Utente u3 = new Utente("Gennaro", "Dibello", LocalDate.of(1987, 3, 17));
		
		Prestito p1 = new Prestito(u1, l1, LocalDate.of(2010, 02, 11), LocalDate.of(2010, 03, 12));
		//System.out.println(p1);
		
		Prestito p2 = new Prestito(u3, l3, LocalDate.of(2015, 8, 30), LocalDate.of(2015, 8, 10));
		
		Prestito p3 = new Prestito(u3, l2, LocalDate.of(2023, 04, 01), LocalDate.of(2023, 04, 25));
		
		Prestito p4 = new Prestito(u2, l3, LocalDate.of(2023, 03, 01), null);
		
		ElementoLeggibileDAO dao = new ElementoLeggibileDAO();
//		dao.save(r1);
//		dao.save(l1);
//		dao.save(r2);
//		dao.save(l2);
//		dao.save(r3);
//		dao.save(l3);
//		dao.saveUtente(u1);
//		dao.saveUtente(u2);
//		dao.saveUtente(u3);
//		dao.savePrestito(p1);
//		dao.savePrestito(p2);
//		dao.savePrestito(p3);
//		dao.savePrestito(p4);
//		dao.removeFromCatalogo(1l);
//		System.out.println(dao.findAllElements());
//		System.out.println(dao.findElementByISBN(2l));
//		System.out.println(dao.findElementsByAnnoPubblicazione(1002));
//   	System.out.println(dao.findElementsByAuthor("erfe"));
//		System.out.println(dao.findElementsByTitle("%fre"));
//		System.out.println(dao.findNotAvailableElements(3));
		System.out.println(dao.findPrestitiScadutiNonRestituiti());
	}

}
