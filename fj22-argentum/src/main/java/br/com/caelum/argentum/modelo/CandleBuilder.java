package br.com.caelum.argentum.modelo;

import java.util.Calendar;

/**
 * Usando interfaces fluentes e o design pattern Builder
 * 
 * @author tca85
 * 
 */
public class CandleBuilder {
	private double abertura;
	private double fechamento;
	private double minimo;
	private double maximo;
	private double volume;
	private Calendar data;
	
	
    // **********************************************************************
	// testar melhor. Com isso é possível estabelecer que o passo2 só pode
	// ser chamado após o passo1
	// **********************************************************************
	public Passo1 setAbertura(double abertura) {
		return new Passo1(abertura);
	}

	public class Passo1 {
		private Passo1(double abertura) {
			CandleBuilder.this.abertura = abertura;
		}

		Passo2 getPasso2() {
			return new Passo2();
		}
	}

	class Passo2 {
		private Passo2() {
		}
	}

	// **********************************************************************

	//---------------------------------------------------------------------------------------------
	public CandleBuilder comAbertura(double abertura) {
		this.abertura = abertura;
		return this;
	}
	//---------------------------------------------------------------------------------------------
	public CandleBuilder comFechamento(double fechamento) {
		this.fechamento = fechamento;
		return this;
	}

	//---------------------------------------------------------------------------------------------
	public CandleBuilder comMinimo(double minimo) {
		this.minimo = minimo;
		return this;
	}

	//---------------------------------------------------------------------------------------------
	public CandleBuilder comMaximo(double maximo) {
		this.fechamento = maximo;
		return this;
	}

	//---------------------------------------------------------------------------------------------
	public CandleBuilder comVolume(double volume) {
		this.volume = volume;
		return this;
	}

	//---------------------------------------------------------------------------------------------
	public CandleBuilder comData(Calendar data) {
		this.data = data;
		return this;
	}

	//---------------------------------------------------------------------------------------------
	public CandleStick geraCandle() {
		return new CandleStick(abertura, fechamento, minimo, maximo, volume, data);
	}
	//---------------------------------------------------------------------------------------------
}
