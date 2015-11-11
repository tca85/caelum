package br.com.caelum.notasfiscais.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

import br.com.caelum.notasfiscais.modelo.NotaFiscal;

public class NotaFiscalDao implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Quando chama por injeção, ele chama JPAUtil.getEntityManager(), porque está com @Produces
	 */
	@Inject
	private EntityManager manager;

	// ---------------------------------------------------------------------------------------------
	public void adiciona(NotaFiscal nota) {
		manager.persist(nota);
	}
	
	// ---------------------------------------------------------------------------------------------
	public List<NotaFiscal> listaTodos() {
		CriteriaQuery<NotaFiscal> query = manager.getCriteriaBuilder()
				                                 .createQuery(NotaFiscal.class);
		
		query.select(query.from(NotaFiscal.class));

		List<NotaFiscal> lista = manager.createQuery(query).getResultList();

		return lista; 
	}
	
	// ---------------------------------------------------------------------------------------------
	public int contaTodos() {
		String jpql = "select count(n) from NotaFiscal n";
		
		long result = (Long) manager.createQuery(jpql)
				                    .getSingleResult();
		
		return (int) result;
	}

	// ---------------------------------------------------------------------------------------------
	public List<NotaFiscal> listaTodosPaginada(int firstResult, int maxResults) {
		CriteriaQuery<NotaFiscal> query = manager.getCriteriaBuilder()
				                                 .createQuery(NotaFiscal.class);
		
		query.select(query.from(NotaFiscal.class));

		List<NotaFiscal> lista = manager.createQuery(query)
				                        .setFirstResult(firstResult)
				                        .setMaxResults(maxResults)
				                        .getResultList();

		return lista;
	}
	// ---------------------------------------------------------------------------------------------
}