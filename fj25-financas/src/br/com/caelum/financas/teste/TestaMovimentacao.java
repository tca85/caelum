package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;

public class TestaMovimentacao {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("controlefinancas");
			
		EntityManager manager = factory.createEntityManager();
		
		Movimentacao movimentacao = new Movimentacao();
		
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("teste!");
		movimentacao.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
		movimentacao.setValor(new BigDecimal("100.0")); // sempre passar como String, para não ter erro de precisão
				
		manager.getTransaction().begin();
		manager.persist(movimentacao);
		manager.getTransaction().commit();
		manager.close();
				
		System.out.println("Movimentação gravada com sucesso");
	}
}