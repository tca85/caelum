package br.com.caelum.banco;

import br.com.caelum.banco.conta.Conta;
import br.com.caelum.banco.conta.ContaCorrente;
import br.com.caelum.banco.conta.GuardadorDeObjetos;
import br.com.caelum.banco.conta.SeguroDeVida;

/**
 * Adiciona qualquer objeto e depois obtém ele. Se tentar retornar sem o casting
 * de referência (converter o Object para Conta) ocorre exception: ContaPoupanca
 * cp = guardador.pegaObjeto(0) Exception in thread "main" java.lang.Error:
 * Unresolved compilation problem: ContaPoupanca cannot be resolved to a type ;
 * 
 * @author Thiago Alves
 *
 */
public class TestaGuardador {
	public static void main(String[] args) {
		Conta contaCorrente = new ContaCorrente();
		SeguroDeVida seguroDeVida = new SeguroDeVida();

		contaCorrente.setNumeroDaConta(12345);

		GuardadorDeObjetos guardador = new GuardadorDeObjetos();

		guardador.adicionaObjeto(contaCorrente);
		guardador.adicionaObjeto(seguroDeVida);
		guardador.adicionaObjeto(1);
		guardador.adicionaObjeto("simular erro");

		try {
			// Casting de Object para Conta
			Conta contaResgatada = (Conta) guardador.pegaObjeto(0);
			System.out.println(contaResgatada.getNumero());

			// Casting de Object para SeguroDeVida
			SeguroDeVida seguroResgatado = (SeguroDeVida) guardador.pegaObjeto(1);
			System.out.println(seguroResgatado.calculaTributos());

			// Casting de Object para int
			int inteiroResgatado = (int) guardador.pegaObjeto(2);
			System.out.println(inteiroResgatado);
			
			// Simular erro de cast
			// java.lang.String cannot be cast to java.lang.Integer
			int erroCast = (int) guardador.pegaObjeto(3);
			System.out.println(erroCast);
			
		} catch (ClassCastException e) {
			System.out.println(e.getMessage());
		}
	}
}
