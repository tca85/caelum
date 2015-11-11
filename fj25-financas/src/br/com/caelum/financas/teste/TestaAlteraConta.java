package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDAO;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestaAlteraConta {
	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		ContaDAO dao = new ContaDAO(manager);
		
		manager.getTransaction().begin();
		
		Conta conta = dao.busca(1);
		conta.setTitular("Joãozinho");
		
		manager.getTransaction().commit();
		manager.close();
	}
}