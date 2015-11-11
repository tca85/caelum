package br.com.caelum.financas.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.financas.modelo.Conta;

/**
 * EJB de sessão --> O container vai criar instâncias do que precisa. Não é um
 * singleton 
 * Stateless - tanto faz quantas instâncias existem. E bean não guarda
 * estado Pouco importa quem vai retornar a informação (ex: perguntar o valor de
 * uma compra a 1 ou n vendedores) 
 * Stateful - guarda estado (ex: carrinho de compras) 
 * Singleton - container mantém uma instância para todos (ex: ler configurações
 * do servidor)
 * 
 * RMI - Remote Method Invocation - executa o método de um EJB em outra máquina,
 * como se estivesse na mesma JVM. (componente distribuído) 1 - Não distribua
 * seus objetos.
 * 
 * CMT - Container Manager Transaction - Envolve vários objetos em memória. Os
 * objetos não precisam estar na mesma máquina.
 * 
 * JAAS - Login, senhas com hash, etc. Na versão 8 vai estar bom
 * 
 * Interceptadores - lógicas antes da chamada de métodos
 * 
 * Injeção de dependências - pode pedir qualquer objeto que o container usa.
 * Isso a partir da versão 6, no CDI
 * 
 * Callback do ciclo de vida
 * 
 * Agendamento de execução/timer para lógicas
 * 
 * JPA - Hibernate
 * 
 * JMS - tratamento de filas (compra via paypal, por exemplo). Dá para
 * configurar quantidade de tentativas, etc. Usado para escalar em volume
 * 
 * Sincronização -
 * 
 * Pool de objetos
 * 
 * Exceções tratadas pelo container
 * 
 * @author Thiago Alves - 02.10.2015
 *
 */
@Stateless
public class ContaDao {

	/*
	 * O EntityManager não vem mais da aplicação, vem do servidor de aplicação
	 * no caso o WildFly
	 * 
	 * ->PersistenceContext - funciona na maioria das vezes só dentro de EJB
	 * serve para a injeção de dependência
	 * 
	 * EntityManager.getTransaction.begin() não vai mais funcionar. Quem cuida
	 * disso é o servidor
	 */
	@PersistenceContext
	EntityManager manager;

	public void adiciona(Conta conta) {
		this.manager.persist(conta);
	}

	public Conta busca(Integer id) {
		return this.manager.find(Conta.class, id);
	}

	public List<Conta> lista() {
		return this.manager.createQuery("select c from Conta c", Conta.class).getResultList();
	}

	public void remove(Conta conta) {
		Conta contaParaRemover = this.manager.find(Conta.class, conta.getId());
		this.manager.remove(contaParaRemover);
	}

	public void altera(Conta conta) {
		this.manager.merge(conta);
	}
}