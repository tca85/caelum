package br.com.caelum.argentum.modelo;

import java.util.GregorianCalendar;

/**
 * 
 * @author tca85
 *
 */
public class CandleBuilderTeste {

	//---------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		CandleStick candle = new CandleBuilder()
		        .comAbertura(40.5)
				.comFechamento(42.3)
				.comMinimo(39.8)
				.comMaximo(45.0)
				.comVolume(145234.20)
				.comData(new GregorianCalendar(2008, 8, 12, 0, 0, 0))
				.geraCandle();
		
		//CandleStick candle2 = new CandleBuilder().setAbertura(100.0).getPasso2();
		
		System.out.println(candle.toString());
	}
	//---------------------------------------------------------------------------------------------
}