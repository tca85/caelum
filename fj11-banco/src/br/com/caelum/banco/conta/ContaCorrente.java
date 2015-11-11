package br.com.caelum.banco.conta;

import br.com.caelum.banco.sistema.Tributavel;




/**
 * Class ContaCorrente herda da classe Conta
 * 
 * @author oo5153
 *
 */
public class ContaCorrente extends Conta implements Tributavel {

	@Override
	public void deposita(double valor) {
		this.saldo += valor - 0.1;
	}

	@Override
	public void atualiza(double taxaSelic) {
		// TODO Auto-generated method stub

	}

	// ---- método que é obrigatório implementar, pois estou usando a interface
	@Override
	public double calculaTributos() {
		return this.getSaldodaConta() * 0.01;
	}

}
