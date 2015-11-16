package br.com.caelum.banco;

import br.com.caelum.banco.conta.Conta;
import br.com.caelum.banco.conta.ContaPoupanca;
import br.com.caelum.banco.conta.ValorInvalidoException;

/**
 * 
 * @author tca85
 *
 */
public class TestaDeposita {

	public static void main(String[] args) {

		try {
			Conta cp = new ContaPoupanca();
			cp.deposita(-100);
			
		} catch (ValorInvalidoException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getClass().toString());
		}
	}
}