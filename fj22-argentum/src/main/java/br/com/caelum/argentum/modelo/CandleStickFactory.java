package br.com.caelum.argentum.modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Design Pattern Factory
 * @author tca85
 *
 */
public class CandleStickFactory {

	//---------------------------------------------------------------------------------------------
	/**
	 * 
	 * @param data
	 * @param negociacoes
	 * @return
	 */
	public CandleStick constroiCandleParaData(Calendar data, List<Negociacao> negociacoes) {

		double maximo = 0;
		double minimo = Double.MAX_VALUE; // verificar porque foi usado
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
	
	//---------------------------------------------------------------------------------------------

	/**
	 * 
	 * @param todasNegociacoes
	 * @return
	 */
	public List<CandleStick> constroiCandles(List<Negociacao> todasNegociacoes) {
		List<CandleStick> candles = new ArrayList<CandleStick>();
		List<Negociacao> negociacoesDoDia = new ArrayList<Negociacao>();
		Calendar dataAtual = todasNegociacoes.get(0).getData();
		
		for (Negociacao negociacao : todasNegociacoes) {
			if (negociacao.getData().before(dataAtual)) {
				throw new IllegalStateException("negociações em ordem errada");
			}
			
			// se não for do mesmo dia, fecha o candle e reinicia as variáveis
			if (!negociacao.isMesmoDia(dataAtual)) {
				CandleStick candleDoDia = constroiCandleParaData(dataAtual, negociacoesDoDia);
				candles.add(candleDoDia);
				
				negociacoesDoDia = new ArrayList<Negociacao>();
				dataAtual = negociacao.getData();
			}
			negociacoesDoDia.add(negociacao);
		}
		
		// adiciona o último candle
		CandleStick candleDoDia = constroiCandleParaData(dataAtual, negociacoesDoDia);
		candles.add(candleDoDia);
		
		return candles;
	}
	//---------------------------------------------------------------------------------------------
}