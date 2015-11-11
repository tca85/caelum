package br.com.caelum.financas.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Classe auxiliar para criar um EntityManagerFactory utilizando Singleton
 * 
 * @author Thiago Alves
 * 
 * 29.09.2015
 *
 */
public class JPAUtil {

	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("controlefinancas");
	
	public static EntityManager getEntityManager(){
		return factory.createEntityManager();	
	}	
}