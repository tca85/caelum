package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;

public class TestaMovimentacaoConta {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("controlefinancas");
			
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		Conta conta = new Conta(); // estado transient
		
		conta.setBanco("Santander");
		conta.setTitular("Thiago Alves");
		conta.setNumero("12345-6");
		conta.setAgencia("0999");
		
		Movimentacao movimentacao = new Movimentacao(); // estado transient
		
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("teste!");
		movimentacao.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
		movimentacao.setValor(new BigDecimal("100.0")); // sempre passar como String, para não ter erro de precisão
		movimentacao.setConta(conta);
		
		// tenta fazer a movimentação ir para o estado persist, vai dar erro porque a conta é transient
		// invalid state exception. Precisa fazer primeiro da conta, porque ela é OneToMany
		// manager.persist(movimentacao);
		
		// se a Conta já existir no banco, ela fica no estado dettached.
		// como fazer ela sair desse estado para persistent?
		// chamar o método find();
		// poderia chamar o merge(), mas não é o indicado
		
		manager.persist(conta);
		manager.persist(movimentacao);
		
		manager.getTransaction().commit();
		manager.close();
				
		System.out.println("Movimentação gravada com sucesso");
	}
}