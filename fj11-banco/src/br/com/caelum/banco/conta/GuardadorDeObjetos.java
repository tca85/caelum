package br.com.caelum.banco.conta;

/**
 * Casting de referência
 * 
 * @author oo5153
 *
 */
public class GuardadorDeObjetos {
	private Object[] arrayDeObjetos = new Object[100];
	private int posicao = 0;

	/**
	 * Método que recebe qualquer objeto
	 * 
	 * @param obj
	 */
	public void adicionaObjeto(Object obj) {
		this.arrayDeObjetos[this.posicao] = obj;
		this.posicao++;
	}

	/**
	 * Retorna o objeto, de acordo com o índice
	 * @param indice
	 * @return
	 */
	public Object pegaObjeto(int indice) {
		return this.arrayDeObjetos[indice];
	}
}
