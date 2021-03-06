package br.com.caelum.argentum.modelo;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 
 * @author tca85
 *
 */
public final class CandleStick {

	private final double abertura;
	private final double fechamento;
	private final double minimo;
	private final double maximo;
	private final double volume;
	private final Calendar data;

	//---------------------------------------------------------------------------------------------
	/**
	 * ctrl + 3 gcuf -> cria o construtor com os argumentos automaticamente
	 * 
	 * @param abertura
	 * @param fechamento
	 * @param minimo
	 * @param maximo
	 * @param volume
	 * @param data
	 */
	public CandleStick(double abertura, double fechamento, double minimo, double maximo, double volume, Calendar data) {
		super();
		this.abertura = abertura;
		this.fechamento = fechamento;
		this.minimo = minimo;
		this.maximo = maximo;
		this.volume = volume;
		this.data = data;
	}

	//---------------------------------------------------------------------------------------------
	public boolean isAlta() {
		return this.abertura < this.fechamento;
	}

	//---------------------------------------------------------------------------------------------
	public boolean isBaixa() {
		return this.abertura > this.fechamento;
	}

	//---------------------------------------------------------------------------------------------
	public double getAbertura() {
		return abertura;
	}
	
	//---------------------------------------------------------------------------------------------
	public double getFechamento() {
		return fechamento;
	}

	//---------------------------------------------------------------------------------------------
	public double getMinimo() {
		return minimo;
	}

	//---------------------------------------------------------------------------------------------
	public double getMaximo() {
		return maximo;
	}

	//---------------------------------------------------------------------------------------------
	public double getVolume() {
		return volume;
	}

	//---------------------------------------------------------------------------------------------
	public Calendar getData() {
		return data;
	}

	//---------------------------------------------------------------------------------------------
	@Override
	public String toString() {
		Calendar c = getData();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormatada = sdf.format(c.getTime());

		return " Abertura: " + getAbertura() 
				+ " Fechamento: " + getFechamento() 
				+ " Minima: " + getMinimo()
				+ " Maxima: " + getMaximo() 
				+ " Volume: " + getVolume() 
				+ " Data: " + dataFormatada;
	}
	//---------------------------------------------------------------------------------------------
}