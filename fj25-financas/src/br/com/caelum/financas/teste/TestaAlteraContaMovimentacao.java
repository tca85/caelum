package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

/**
 * 
 * @author Thiago Alves
 * 
 *         01.10.2015
 *
 */
public class TestaAlteraContaMovimentacao {
	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		MovimentacaoDAO dao = new MovimentacaoDAO(manager);

		manager.getTransaction().begin();

		/*
		 * Geralmente vai receber a informação de fora para atualização, usaria
		 * merge getReference - query que faz a busca só do id. Dá um new no
		 * objeto e retorna. Sempre é lazy Não vai ao banco, se informar um id
		 * errado, vai causar exception na próxima query. A classe sempre vai
		 * estar instanciada, se estivesse com o id errado, daria exception Por
		 * causa disso, muitas vezes é melhor usar o find, e o getReference só
		 * usar quando tem 100% de certeza que o id existe
		 * 
		 * Movimentacao movimentacao = manager.getReference(Movimentacao.class,
		 * 3);
		 */

		Movimentacao movimentacao = dao.busca(3);

		/*
		 * Quando usa o getReference, o select & join está nessa linha. Nesse
		 * momento ainda não tem a informação, e faz o select update
		 */
		movimentacao.getConta().setTitular("xxxAlterei!!!!!!!!");

		manager.getTransaction().commit(); // update
		manager.close();

		System.out.println(movimentacao.getConta().getTitular());
	}

}
