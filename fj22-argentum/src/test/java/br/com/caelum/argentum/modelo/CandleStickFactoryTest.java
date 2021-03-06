package br.com.caelum.argentum.modelo;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

/**
 * 
 * Test using JUnit4
 * 
 * alt + shift + X ... T
 * 
 * @author tca85
 *
 */
@SuppressWarnings("deprecation")
public class CandleStickFactoryTest {

	//---------------------------------------------------------------------------------------------
	/**
	 * 
	 */
	@Test
	public void sequenciaSimplesDeNegociacoes() {
		Calendar hoje = Calendar.getInstance();

		Negociacao n1 = new Negociacao(40.5, 100, hoje);
		Negociacao n2 = new Negociacao(45.0, 100, hoje);
		Negociacao n3 = new Negociacao(39.8, 100, hoje);
		Negociacao n4 = new Negociacao(42.3, 100, hoje);

		List<Negociacao> negociacoes = Arrays.asList(n1, n2, n3, n4);

		CandleStickFactory fabrica = new CandleStickFactory();

		CandleStick candle = fabrica.constroiCandleParaData(hoje, negociacoes);

		Assert.assertEquals(40.5, candle.getAbertura(), 0.00001);
		Assert.assertEquals(42.3, candle.getFechamento(), 0.00001);
		Assert.assertEquals(39.8, candle.getMinimo(), 0.00001);
		Assert.assertEquals(45.0, candle.getMaximo(), 0.00001);
		Assert.assertEquals(16760.0, candle.getVolume(), 0.00001);
	}

	//---------------------------------------------------------------------------------------------
	/**
	 * 
	 */
	@Test
	public void semNegociacoesGeraCandleComZeros() {
		Calendar hoje = Calendar.getInstance();

		List<Negociacao> negociacoes = Arrays.asList();

		CandleStickFactory fabrica = new CandleStickFactory();

		CandleStick candle = fabrica.constroiCandleParaData(hoje, negociacoes);

//		Assert.assertEquals(0.0, candle.getAbertura(), 0.00001);
//		Assert.assertEquals(0.0, candle.getFechamento(), 0.00001);
//		Assert.assertEquals(0.0, candle.getMinimo(), 0.00001);
//		Assert.assertEquals(0.0, candle.getMaximo(), 0.00001);
		Assert.assertEquals(0.0, candle.getVolume(), 0.00001);
	}

	//---------------------------------------------------------------------------------------------
	/**
	 * 
	 */
	@Test
	public void apenasUmaNegociacaoGeraCandleComValoresIguais() {
		Calendar hoje = Calendar.getInstance();

		Negociacao n1 = new Negociacao(40.5, 100, hoje);

		List<Negociacao> negociacoes = Arrays.asList(n1);

		CandleStickFactory fabrica = new CandleStickFactory();

		CandleStick candle = fabrica.constroiCandleParaData(hoje, negociacoes);

		Assert.assertEquals(40.5, candle.getAbertura(), 0.00001);
		Assert.assertEquals(40.5, candle.getFechamento(), 0.00001);
		Assert.assertEquals(40.5, candle.getMinimo(), 0.00001); // <<<<<< verificar o erro!
		Assert.assertEquals(40.5, candle.getMaximo(), 0.00001);
		Assert.assertEquals(4050.0, candle.getVolume(), 0.00001);
	}
	//---------------------------------------------------------------------------------------------
	/**
	 * Exercício 5.4, página 75
	 */
	@Test
	public void paraNegociacoesDeTresDiasDistintosGeraTresCandler(){
		Calendar hoje = Calendar.getInstance();
		
		Negociacao n1 = new Negociacao(40.5, 100, hoje);
		Negociacao n2 = new Negociacao(45.0, 100, hoje);
		Negociacao n3 = new Negociacao(39.8, 100, hoje);
		Negociacao n4 = new Negociacao(42.3, 100, hoje);
		
		Calendar amanha = (Calendar) hoje.clone();
		amanha.add(Calendar.DAY_OF_MONTH, 1);
		
		Negociacao n5 = new Negociacao(48.8, 100, amanha);
		Negociacao n6 = new Negociacao(49.3, 100, amanha);
		
		Calendar depois = (Calendar) amanha.clone();
		depois.add(Calendar.DAY_OF_MONTH, 1);
		
		Negociacao n7 = new Negociacao(51.8, 100, depois);
		Negociacao n8 = new Negociacao(52.3, 100, depois);
		
		List<Negociacao> negociacoes = Arrays.asList(n1, n2, n3, n4, n5, n6, n7, n8);
		
		CandleStickFactory fabrica = new CandleStickFactory();
		
		List<CandleStick> candles = fabrica.constroiCandles(negociacoes);
		
		Assert.assertEquals(3, candles.size());
		Assert.assertEquals(40.5, candles.get(0).getAbertura(), 0.00001);
		Assert.assertEquals(42.3, candles.get(0).getFechamento(), 0.00001);
		Assert.assertEquals(48.8, candles.get(1).getAbertura(), 0.00001);
		Assert.assertEquals(49.3, candles.get(1).getFechamento(), 0.00001);
		Assert.assertEquals(51.8, candles.get(2).getAbertura(), 0.00001);
		Assert.assertEquals(52.3, candles.get(2).getFechamento(), 0.00001);
	}
	//---------------------------------------------------------------------------------------------
	/**
	 * Exercício 5.5, página 77
	 */
	@Test(expected = IllegalArgumentException.class)
	public void naoPermiteConstruirCandlesComNegociacoesForaDeOrdem(){
        Calendar hoje = Calendar.getInstance();
		
		Negociacao n1 = new Negociacao(40.5, 100, hoje);
		Negociacao n2 = new Negociacao(45.0, 100, hoje);
		
		Calendar amanha = (Calendar) hoje.clone();
		amanha.add(Calendar.DAY_OF_MONTH, 1);
		
		Negociacao n3 = new Negociacao(48.8, 100, amanha);
		Negociacao n4 = new Negociacao(49.3, 100, amanha);
		
		// data desordenada
		List<Negociacao> negociacoes = Arrays.asList(n1, n3, n2, n4);
		
		CandleStickFactory fabrica = new CandleStickFactory();
		
		List<CandleStick> candles = fabrica.constroiCandles(negociacoes);
		
		//Assert.assertFalse(candles.size() == 0);
	}	
	//---------------------------------------------------------------------------------------------
}
