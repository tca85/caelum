package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.util.JPAUtil;

public class TestaAberturaConexoes {

	public static void main(String[] args) {
		for (int i = 0; i < 30; i++) {
			EntityManager manager = JPAUtil.getEntityManager();

			manager.getTransaction().begin();
			System.out.println("Criado EntityManager número " + i);
		}

		try {
			Thread.sleep(30 * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
