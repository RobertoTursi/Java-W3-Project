package DAO;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import classi.ElementoLeggibile;
import classi.Prestito;
import classi.Utente;
import util.Jpa_util;

public class ElementoLeggibileDAO implements InterfaceDAO{

	@Override
	public void save(ElementoLeggibile el) {
		EntityManager em = Jpa_util.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(el);
			em.getTransaction().commit();
			System.out.println("Elemento caricato nel db");
		}catch(Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		
	}

	@Override
	public void saveUtente(Utente u) {
		EntityManager em = Jpa_util.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(u);
			em.getTransaction().commit();
		} catch(Exception ex) {
			System.out.println(ex);
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		
	}

	@Override
	public void savePrestito(Prestito p) {
		EntityManager em = Jpa_util.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(p);
			em.getTransaction().commit();
		}catch(Exception ex) {
			System.out.println(ex);
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
	}

	@Override
	public void removeFromCatalogo(Long id) {
		EntityManager em = Jpa_util.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			ElementoLeggibile elemento = em.find(ElementoLeggibile.class, id);
			em.remove(elemento);
			em.getTransaction().commit();
			System.out.println("Elemento rimosso dal catalogo");
		}catch(Exception ex){
			ex.printStackTrace();
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		
	}

	@Override
	public List<ElementoLeggibile> findAllElements() {
		EntityManager em = Jpa_util.getEntityManagerFactory().createEntityManager();
		Query q = em.createNamedQuery("ElementoLeggibile.FindAll");
		return q.getResultList();
	}

	@Override
	public Object findElementByISBN(Long id) {
		EntityManager em = Jpa_util.getEntityManagerFactory().createEntityManager();
		Query q = em.createQuery("SELECT e FROM ElementoLeggibile e WHERE e.codiceISBN = :ISBN");
		q.setParameter("ISBN", id);
		return q.getSingleResult();
	}

	@Override
	public List<ElementoLeggibile> findElementsByAnnoPubblicazione(Integer anno) {
		EntityManager em = Jpa_util.getEntityManagerFactory().createEntityManager();
		Query q = em.createQuery("SELECT e FROM ElementoLeggibile e WHERE e.annoPubblicazione = :annoPubblicazione");
		q.setParameter("annoPubblicazione", anno);
		return q.getResultList();
	}

	@Override
	public List<ElementoLeggibile> findElementsByAuthor(String autore) {
		EntityManager em = Jpa_util.getEntityManagerFactory().createEntityManager();
		Query q = em.createQuery("SELECT e FROM ElementoLeggibile e WHERE e.autore = :author");
		q.setParameter("author", autore);
		return q.getResultList();
	}

	@Override
	public List<ElementoLeggibile> findElementsByTitle(String titolo) {
		EntityManager em = Jpa_util.getEntityManagerFactory().createEntityManager();
		Query q = em.createQuery("SELECT e FROM ElementoLeggibile e WHERE e.Titolo LIKE :title");
		q.setParameter("title", titolo);
		return q.getResultList();
	}

	@Override
	public List<ElementoLeggibile> findNotAvailableElements(long id) {
		EntityManager em = Jpa_util.getEntityManagerFactory().createEntityManager();
		Query q = em.createQuery("SELECT u FROM Utente u WHERE u.numeroTessera = :numeroTessera");
		q.setParameter("numeroTessera", id);
		List<Utente> lu = q.getResultList();
		Utente numeroTessera = lu.get(0);
		q = em.createQuery("SELECT p FROM Prestito p WHERE p.utente = :numero AND p.dataRestituzioneEffettiva > :data");
		q.setParameter("data", LocalDate.now());
		q.setParameter("numero", numeroTessera);
		List<Prestito> lp = q.getResultList();
		List<ElementoLeggibile> listaISBN = new ArrayList();
		lp.forEach(p -> listaISBN.add(p.getElementoPrestato()));
		
		
		return listaISBN;
	}

	@Override
	public List<Prestito> findPrestitiScadutiNonRestituiti() {
		EntityManager em = Jpa_util.getEntityManagerFactory().createEntityManager();
		Query q = em.createQuery("SELECT p FROM Prestito p WHERE p.dataRestituzioneEffettiva = null AND dataRestituzionePrevista < :data");
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		q.setParameter("data", date);
		return q.getResultList();
	}
	
	
}
