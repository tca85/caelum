package br.com.caelum.argentum.modelo;

import java.util.Calendar;

import org.junit.Test;

import junit.framework.Assert;

/**
 * 
 * @author tca85
 *
 */
public class NegociacaoTest {

	@SuppressWarnings("deprecation")
	@Test
	public void dataDaNegociacaoEhImutavel() {
		Calendar c = Calendar.getInstance();

		c.set(Calendar.DAY_OF_MONTH, 15);

		Negociacao n = new Negociacao(10, 5, c);

		n.getData().set(Calendar.DAY_OF_MONTH, 20);

		Assert.assertEquals(15, n.getData().get(Calendar.DAY_OF_MONTH));
	}

	@Test(expected = IllegalArgumentException.class)
	public void naoCriaNegociacaoComDataNula() {
		new Negociacao(10, 5, null);
	}
}