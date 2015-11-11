package br.com.caelum.financas.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;

/**
 * Data Access Object
 * @author Thiago Alves
 * 
 * 29.09.2015
 *
 */
public class ContaDAO {
	
	private EntityManager manager;
	
	/**
	 * Injeção de dependência pelo construtor, para que o EntityManager
	 * seja fechado pela classe que o chama
	 * @param manager
	 */
	public ContaDAO(EntityManager manager) {
		this.manager = manager;
	}
	
	public void adiciona(Conta conta){
		this.manager.persist(conta);
	}
		
	public void remove(Conta conta){
		this.manager.remove(conta);
	}
	
	public Conta busca(Integer id){
		return this.manager.find(Conta.class, id);
	}
	
	public List<Conta> lista(){
		// jpql não tem colunas, por isso não tem *
		// também não tem tabelas, usa a entidade (Conta.class)
		String jpql = "select c from Conta c";
		
		return this.manager.createQuery(jpql, Conta.class).getResultList();
	}
	
	public void atualizar(){
		
	}
}