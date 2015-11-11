package br.com.caelum.argentum.modelo;

import java.util.Calendar;

/**
 * 
 * @author tca85
 *
 */
public final class Negociacao {
	private final double preco;
	private final int quantidade;
	// Ainda é possível mudar a referência de fora da classe. Precisa usar o
	// método clone para impedir que isso aconteça
	private final Calendar data;

	public Negociacao(double preco, int quantidade, Calendar data) {
		if (data == null) {
			throw new IllegalArgumentException("data não pode ser nula");
		}
		
		this.preco = preco;
		this.quantidade = quantidade;
		// faz uma cópia defensiva, para evitar que alterem o valor
		this.data = (Calendar) data.clone();
	}

	public double getPreco() {
		return preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public Calendar getData() {
		return (Calendar) data.clone();
	}

	public double getVolume() {
		return preco * quantidade;
	}
}