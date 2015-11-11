package br.com.caelum.collections;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import br.com.caelum.banco.conta.Conta;
import br.com.caelum.banco.conta.ContaPoupanca;

public class TestaOrdenacao {
	public static void main(String[] args) {

		// List<ContaPoupanca> contas = new ArrayList<>();
		List<ContaPoupanca> contas = new LinkedList<>();

		for (int i = 0; i <= 10; i++) {
			ContaPoupanca contaPoupanca = new ContaPoupanca();
			Random rand = new Random();

			int saldo = rand.nextInt(1000) + i;
			
			contaPoupanca.setNumero(saldo);
			contas.add(contaPoupanca);
		}

		// Orderna a lista crescente
		Collections.sort(contas);
		
		// Ordena a lista decrescente
		Collections.sort(contas ,Collections.reverseOrder());

		// Desordena a lista
		Collections.shuffle(contas);

		for (int i = 0; i < contas.size(); i++) {
			Conta atual = contas.get(i);
			System.out.println("numero: " + atual.getNumero());
		}

	}

}
