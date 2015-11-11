package br.com.caelum.banco;

import java.io.PrintStream;

import br.com.caelum.banco.conta.Conta;
import br.com.caelum.banco.conta.ContaCorrente;

public class TestaInteger {

	public static void main(String[] args) {
		// classes wrappers
		Integer x1 = new Integer(10);
		Integer x2 = new Integer(10);

		if (x1 == x2) {
			System.out.println("endereço de memória igual");
		} else {
			System.out.println("endereço de memória diferente");
		}

		if (x1.equals(x2)) {
			System.out.println("valor igual");
		}

		// 4 - Tenta converter uma string para inteiro
		try {
			int valorInvalido = Integer.parseInt("xxx");
			int valorValido = Integer.parseInt("12345");

		} catch (NumberFormatException e) {
			System.out.println("Erro: " + e.getMessage());
		}

		// 5 - Objeto referenciado pelo atributo out da System
		PrintStream saida = System.out;
		saida.println("Olá! PrintStream");

		// 6 - Criar e imprimir uma referência de Conta.
		// Tem que dar new em ContaCorrente ou ContaPoupanca, porque Conta é
		// abstrata
		// obs: enquanto não reescrever o método toString da Conta, retorna o
		// endereço de memória
		// br.com.caelum.banco.conta.ContaCorrente@659e0bfd
		Conta c = new ContaCorrente();
		System.out.println(c);
	}
}