package br.com.caelum.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

import br.com.caelum.banco.conta.ComparaPorAgencia;
import br.com.caelum.banco.conta.Conta;
import br.com.caelum.banco.conta.ContaPoupanca;

public class TestaOrdenacaoContaAgencia {
	public static void main(String[] args) {

		// List<ContaPoupanca> contas = new ArrayList<>();
		List<ContaPoupanca> contas = new LinkedList<>();

		for (int i = 0; i <= 10; i++) {
			ContaPoupanca contaPoupanca = new ContaPoupanca();
			Random rand = new Random();

			int agencia = rand.nextInt(1000) + i;

			contaPoupanca.setAgencia(agencia);
			contas.add(contaPoupanca);
		}

		// Orderna as contas pela agência
		Collections.sort(contas, new ComparaPorAgencia());

		// Poderia criar uma classe anônima (implementa interface / método)
		// Comparator é uma "interface funcional", dentro dela só tem 1 método
		Collections.sort(contas, new Comparator<Conta>() {
			@Override
			public int compare(Conta conta1, Conta conta2) {
				return Integer.compare(conta1.getAgencia(), conta2.getAgencia());
			}
		});
		
		// Lambda Expressions = só funciona a partir do Java8
		Collections.sort(contas, (conta1, conta2) -> Integer.compare(conta1.getAgencia(), conta2.getAgencia()));
		
		// Usando o método default da interface List:
		contas.sort((conta1, conta2) -> Integer.compare(conta1.getAgencia(), conta2.getAgencia()));
		
//		Default Método: é um método que tem corpo, dentro de uma Interface --- Java8
//	    @SuppressWarnings({"unchecked", "rawtypes"})
//	    default void sort(Comparator<? super E> c) {
//	        Object[] a = this.toArray();
//	        Arrays.sort(a, (Comparator) c);
//	        ListIterator<E> i = this.listIterator();
//	        for (Object e : a) {
//	            i.next();
//	            i.set((E) e);
//	        }
//	    }		
		
		for (int i = 0; i < contas.size(); i++) {
			Conta atual = contas.get(i);
			System.out.println("numero: " + atual.getAgencia());
		}
	}
}