package br.com.caelum.financas.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Movimentacao;

public class MovimentacaoDAO {
	private EntityManager manager;

	/**
	 * Injeção de dependência pelo construtor, para que o EntityManager seja
	 * fechado pela classe que o chama
	 * 
	 * @param manager
	 */
	public MovimentacaoDAO(EntityManager manager) {
		this.manager = manager;
	}

	public void adiciona(Movimentacao movimentacao) {
		this.manager.persist(movimentacao);
	}

	public void remove(Movimentacao movimentacao) {
		this.manager.remove(movimentacao);
	}

	public Movimentacao busca(Integer id) {
		return this.manager.find(Movimentacao.class, id);
	}

	public List<Movimentacao> lista() {
		// jpql não tem colunas, por isso não tem *
		// também não tem tabelas, usa a entidade (Conta.class)
		String jpql = "select m from Movimentacao m";

		return this.manager.createQuery(jpql, Movimentacao.class).getResultList();
	}
}
