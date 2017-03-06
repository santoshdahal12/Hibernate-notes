package com.xyz.orderentry;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtils {
	private static final EntityManagerFactory emf;

	static {

		try {
			emf = Persistence.createEntityManagerFactory("orderentry");
		}

		catch (Throwable ex) {
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}
		
		emf.createEntityManager();
	}
	
	public static EntityManager getEntityManager(){
		return emf.createEntityManager();
	}

}
