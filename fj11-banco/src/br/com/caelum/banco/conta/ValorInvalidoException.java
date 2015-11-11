package br.com.caelum.banco.conta;

/**
 * A principal classe de exceção é a Throwable. Abaixo dela, estão a Exception e Error 
 * Como a classe Exception tem os métodos getMessage() é melhor usar
 * ela. Ao herdar essa classe, a nossa classe se torna uma "checked exception",
 * ou seja, é obrigatório o tratamento dela por quem a usa
 * 
 * http://blog.caelum.com.br/lidando-com-exceptions/
 * 
 * @author oo5153
 *
 */
public class ValorInvalidoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Para cada mensagem, criar um novo construtor
	 * 
	 * @param valor
	 */
	public ValorInvalidoException(double valor) {
		super("Valor inválido: " + valor);
	}

	public ValorInvalidoException(String mensagem) {
		super("Erro: " + mensagem);
	}
}
