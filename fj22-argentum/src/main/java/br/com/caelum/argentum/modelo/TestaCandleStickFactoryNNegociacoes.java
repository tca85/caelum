package br.com.caelum.argentum.modelo;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/**
 * 
 * @author tca85
 *
 */
public class TestaCandleStickFactoryNNegociacoes {
	//---------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		Calendar hoje = Calendar.getInstance();

		Negociacao n1 = new Negociacao(40.5, 100, hoje);
		Negociacao n2 = new Negociacao(45.0, 100, hoje);
		Negociacao n3 = new Negociacao(49.8, 100, hoje);
		Negociacao n4 = new Negociacao(53.3, 100, hoje);

		List<Negociacao> negociacoes = Arrays.asList(n1, n2, n3, n4);

		CandleStickFactory fabrica = new CandleStickFactory();
		CandleStick candle = fabrica.constroiCandleParaData(hoje, negociacoes);

		System.out.println(candle.toString());
	}
	//---------------------------------------------------------------------------------------------
}
