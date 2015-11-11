package br.com.caelum.banco;

import java.math.BigDecimal;

/**
 * http://www.devmedia.com.br/java-bigdecimal-trabalhando-com-mais-precisao/30286
 * @author oo5153
 *
 */
public class TestaDinheiro {

	public static void main(String[] args) {
		BigDecimal valor1 = new BigDecimal(0.1000000000001);
		BigDecimal valor2 = new BigDecimal(0.2000000000009);
		
		BigDecimal resultado = valor1.add(valor2);
		
		System.out.println(resultado.toString());
	}
}
