package br.com.caelum.argentum.modelo;

import java.util.Calendar;

/**
 * 
 * Apesar dos atributos serem private final, os atributos de referência podem
 * ser alterados fora da classe. O método clone() impede que isso aconteça,
 * fazendo uma "cópia defensiva" do objeto. É a única forma dele não ser alterado
 * obs: é necessário implementar a interface Cloneable para que nossas classes tenham
 * esse método, e também reescrever o método clone.
 * 
 * @author tca85
 *
 */
public final class Negociacao {
	private final double preco;
	private final int quantidade;
	private final Calendar data;

	//---------------------------------------------------------------------------------------------
	/**
	 * 
	 * @param preco
	 * @param quantidade
	 * @param data
	 */
	public Negociacao(double preco, int quantidade, Calendar data) {
		if (data == null) {
			throw new IllegalArgumentException("data não pode ser nula");
		}
		
		this.preco = preco;
		this.quantidade = quantidade;
		// faz uma cópia defensiva, para evitar que alterem o valor
		this.data = (Calendar) data.clone();
	}

	//---------------------------------------------------------------------------------------------
	public double getPreco() {
		return preco;
	}
	
	//---------------------------------------------------------------------------------------------
	public int getQuantidade() {
		return quantidade;
	}

	//---------------------------------------------------------------------------------------------
	public Calendar getData() {
		return (Calendar) data.clone();
	}

	//---------------------------------------------------------------------------------------------
	public double getVolume() {
		return preco * quantidade;
	}

	//---------------------------------------------------------------------------------------------
	/**
	 * Método criado após o teste, usando a técnica de TDD
	 * @param outraData
	 * @return
	 */
	public boolean isMesmoDia(Calendar outraData) {
		return this.data.get(Calendar.DAY_OF_MONTH) == outraData.get(Calendar.DAY_OF_MONTH)
			&& this.data.get(Calendar.MONTH)        == outraData.get(Calendar.MONTH)
			&& this.data.get(Calendar.YEAR)         == outraData.get(Calendar.YEAR);
	}
	//---------------------------------------------------------------------------------------------
}