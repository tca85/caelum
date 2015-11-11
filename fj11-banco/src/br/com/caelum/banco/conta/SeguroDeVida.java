package br.com.caelum.banco.conta;

import br.com.caelum.banco.sistema.Tributavel;



public class SeguroDeVida implements Tributavel {

	@Override
	public double calculaTributos() {
		return 42;
	}

}
