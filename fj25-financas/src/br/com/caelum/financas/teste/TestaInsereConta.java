package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.financas.modelo.Conta;

/**
 * Forma passo-a-passo para criar uma persistência da classe Conta
 * obs: poderia ser feito automaticamente através de injeção de dependência
 * 
 * @author Thiago Alves
 * 29.09.2015
 *
 */
public class TestaInsereConta {
	
	public static void main(String[] args) {
		// É muito demorado criar um EntityManagerFactory e um EntityManager sempre
		// Tem formas melhores de fazer o código abaixo. Nesse exemplo, tudo demorou 1.6 segundos
		// ----> Java Profiling tem formas melhores de testar performance
		
		long inicio = System.currentTimeMillis();
		
		// 1 - Lê a tag <persistence-unit> da persistence.xml
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("controlefinancas");
		
		// 2 - Pede para a fábrica criar uma instância de EntityManager
		EntityManager manager = factory.createEntityManager();
		
		// 3 - Cria um objeto que será persistido
		Conta conta = new Conta();
		conta.setBanco("Santander");
		conta.setTitular("Thiago Alves");
		conta.setNumero("12345-6");
		conta.setAgencia("0999");
		
		// 4 - Abre a transação
		manager.getTransaction().begin();
		
		// 5 - Persiste o objeto. Nesse momento só guarda o objeto, ainda não rodou a query
		// nesse momento, se por exemplo cair a energia, quando voltar, ele insere no banco (no commit)
		manager.persist(conta);
		
		// 6 - Faz o commit (executa a query)
		manager.getTransaction().commit();
		
		// 7 - Fecha a transação, senão segura a memória impedindo outros acessos.
		// também deixa o aplicativo lento, porque mantém na memória do EntityManager
		manager.close();
		
		long fim = System.currentTimeMillis();
		System.out.println("Executado e: " + (fim - inicio) + " ms");
		
		System.out.println("Conta gravada com sucesso");
	}
}