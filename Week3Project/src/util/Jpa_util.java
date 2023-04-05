package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Jpa_util {
	
	private static final EntityManagerFactory entityManagerFactory;
	
	static {
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("Week3Project");
		}catch (Throwable ex){
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}
}
