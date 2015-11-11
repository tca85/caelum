package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TestaBuscaContaMovimentacao {

	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		MovimentacaoDAO dao = new MovimentacaoDAO(manager);
		
		manager.getTransaction().begin();
		
		// fetch eager, é o padrão do JPA
		Movimentacao movimentacao = dao.busca(3);
		
		// quando tem relacionamento, fica mais rápido
		//Movimentacao movimentacao2 = manager.getReference(Movimentacao.class, 3);
		
		manager.getTransaction().commit();
		manager.close();
		
		System.out.println(movimentacao.getConta().getTitular());
	}
}