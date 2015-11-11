package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDAO;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestaListagemConta {

	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		ContaDAO dao = new ContaDAO(manager);
		
		manager.getTransaction().begin();
		
		List<Conta> lista = dao.lista();
		
		manager.getTransaction().commit();
		manager.close();
			
		for (Conta conta : lista) {
			System.out.println(conta.getNumero());
		}
		
		System.out.println("Conta gravada com sucesso");
	}
}
