package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteCicloVida {
	public static void main(String[] args) {
		// Ao contrário do exemplo anterior, dessa forma só vai ter uma instância do EntityManager
		// tornando o código mais rápido
		EntityManager manager = JPAUtil.getEntityManager();
		
		Conta conta = new Conta(); // quando cria o objeto = estado transient
		conta.setBanco("Santander");
		conta.setTitular("Thiago Alves");
		conta.setNumero("12345-6");
		conta.setAgencia("0999");
		
		manager.getTransaction().begin();
		manager.persist(conta); // mudou de transient para persist
		manager.getTransaction().commit();
		manager.close();
	}
}
