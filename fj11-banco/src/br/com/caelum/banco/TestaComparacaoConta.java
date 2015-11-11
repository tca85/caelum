package br.com.caelum.banco;

import br.com.caelum.banco.conta.Conta;
import br.com.caelum.banco.conta.ContaCorrente;

public class TestaComparacaoConta {

	public static void main(String[] args) {
		Conta cc1 = new ContaCorrente();
		Conta cc2 = new ContaCorrente();
		//SeguroDeVida s = new SeguroDeVida();

		if (cc1.equals(cc2)) {
			System.out.println("Objetos iguais");
		}else{
			System.out.println("Objetos diferentes");
		}
	}
}