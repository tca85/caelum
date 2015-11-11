package br.com.caelum.notasfiscais.util;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Utiliza o CDI para criar o EntityManager
 * 
 * @author Thiago Alves - 16.10.2015
 *
 */
public class JPAUtil {
	
	/**
	 * Poderia estar anotado com @Produces, e ter 2 emf - "notas" e "rh"
	 * teria que criar anotation e a classe implementadora.
	 * obs: na anotation teria que ter @Qualifier
	 * 	
	 */
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("notas");

	// ---------------------------------------------------------------------------------------------
	/**
	 * Quando alguém chamar o EntityManager via injeção, esse método vai ser
	 * chamado por causa do @Produces
	 * 
	 * @return
	 */
	@Produces
	@RequestScoped
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	// ---------------------------------------------------------------------------------------------
	/**
	 * Fecha o EntityManager no final da requisição
	 * 
	 * @param manager
	 */
	public void close(@Disposes EntityManager manager) {
		manager.close();
	}
	// ---------------------------------------------------------------------------------------------
}