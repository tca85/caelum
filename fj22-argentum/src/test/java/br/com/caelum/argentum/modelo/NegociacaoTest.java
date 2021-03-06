package br.com.caelum.argentum.modelo;

import java.util.Calendar;
import java.util.GregorianCalendar;

import junit.framework.Assert;

import org.junit.Test;

/**
 * 
 * @author tca85
 *
 */
public class NegociacaoTest {
	// ---------------------------------------------------------------------------------------------
	@SuppressWarnings("deprecation")
	@Test
	public void dataDaNegociacaoEhImutavel() {
		Calendar c = Calendar.getInstance();

		c.set(Calendar.DAY_OF_MONTH, 15);

		Negociacao n = new Negociacao(10, 5, c);

		n.getData().set(Calendar.DAY_OF_MONTH, 20);

		Assert.assertEquals(15, n.getData().get(Calendar.DAY_OF_MONTH));
	}

	// ---------------------------------------------------------------------------------------------
	@Test(expected = IllegalArgumentException.class)
	public void naoCriaNegociacaoComDataNula() {
		new Negociacao(10, 5, null);
	}

	// ---------------------------------------------------------------------------------------------
	/**
	 * Usando TDD (Test Driven Design) ---> o teste é escrito antes do método
	 * isMesmoDia ser criado
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void mesmoMilissegundoEhDoMesmoDia() {
		Calendar agora = Calendar.getInstance();
		Calendar mesmoMomento = (Calendar) agora.clone();

		Negociacao negociacao = new Negociacao(40.0, 100, agora);

		// o método isMesmoDia será criado agora (CTRL + 1):
		Assert.assertTrue(negociacao.isMesmoDia(mesmoMomento));
	}

	// ---------------------------------------------------------------------------------------------
	/*
	 * Deve aceitar datas com horários diferentes (mas com mesmo dia e mês)
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void comHorariosDiferentesEhNoMesmoDia() {
		Calendar manha = new GregorianCalendar(2011, 10, 20, 8, 30);
		Calendar tarde = new GregorianCalendar(2011, 10, 20, 15, 30);

		Negociacao negociacao = new Negociacao(40.0, 100, manha);
		Assert.assertTrue(negociacao.isMesmoDia(tarde));
	}

	// ---------------------------------------------------------------------------------------------
	/**
	 * Testa se é dá erro ao salvar datas iguais, só com o dia diferente
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void mesmoDiaMasMesesDiferentesNaoSaoDoMesmoDia() {
		Calendar manha = new GregorianCalendar(2011, 11, 20, 15, 30);
		Calendar tarde = new GregorianCalendar(2011, 10, 20, 15, 30);

		Negociacao negociacao = new Negociacao(40.0, 100, manha);
		Assert.assertFalse(negociacao.isMesmoDia(tarde));
	}
	// ---------------------------------------------------------------------------------------------
}