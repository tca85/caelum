package br.com.caelum.banco;

import br.com.caelum.banco.conta.ContaCorrente;

public class TestaConta {

	public static void main(String[] args) {
		ContaCorrente contaCorrente = new ContaCorrente();
		contaCorrente.deposita(100);
		
		// Se criar uma referência à interface Tributavel, obtém só os métodos dele
		// porém chama método que foi implementado na classe ContaCorrente
		// -------> polimorfismo
//		Tributavel t = new ContaCorrente();

		System.out.println(contaCorrente.getSaldodaConta());

		contaCorrente.saca(40);

		System.out.println(contaCorrente.getSaldodaConta());
	}

}
