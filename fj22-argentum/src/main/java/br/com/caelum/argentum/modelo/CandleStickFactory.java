package br.com.caelum.argentum.modelo;

import java.util.Calendar;
import java.util.List;

/**
 * 
 * @author tca85
 *
 */
public class CandleStickFactory {

	/**
	 * 
	 * @param data
	 * @param negociacoes
	 * @return
	 */
	public CandleStick constroiCandleParaData(Calendar data, List<Negociacao> negociacoes) {

		double maximo = 0;
		double minimo = Double.MAX_VALUE;
		double volume = 0;

		for (Negociacao negociacao : negociacoes) {
			volume += negociacao.getVolume();

			if (negociacao.getPreco() > maximo) {
				maximo = negociacao.getPreco();
			} else if (negociacao.getPreco() < minimo) {
				minimo = negociacao.getPreco();
			}
		}

		double abertura = negociacoes.isEmpty() ? 0 : negociacoes.get(0).getPreco();
		double fechamento = negociacoes.isEmpty() ? 0 : negociacoes.get(negociacoes.size() - 1).getPreco();

		return new CandleStick(abertura, fechamento, minimo, maximo, volume, data);
	}
}