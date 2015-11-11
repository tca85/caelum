package br.com.caelum.argentum.modelo;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/**
 * 
 * @author tca85
 *
 */
public class TestaCandleStickFactoryComUmaNegociacaoApenas {
	public static void main(String[] args) {
		Calendar hoje = Calendar.getInstance();

		Negociacao n1 = new Negociacao(40.5, 100, hoje);

		List<Negociacao> negociacoes = Arrays.asList(n1);

		CandleStickFactory fabrica = new CandleStickFactory();
		CandleStick candle = fabrica.constroiCandleParaData(hoje, negociacoes);

		System.out.println(candle.toString());
	}
}
