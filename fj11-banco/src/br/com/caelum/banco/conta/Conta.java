package br.com.caelum.banco.conta;

/**
 * Classe abstrata - Não permite ser instanciada, somente ser herdada
 * 
 * @author oo5153
 * @version 1.0
 *
 */
public abstract class Conta {
	private int numeroDaConta;
	private int agencia;
	// Atributo protected é visível em todas classes que herdam ela
	// não é boa prática, porque o certa seria modificar/obter através de
	// getters & setters
	// através do super().atributo;
	protected double saldo;
	private String nome;
	private int numero;

	/**
	 * Método construtor padrão
	 */
	public Conta() {
		super();
	}

	/**
	 * 
	 * @param teste
	 */
	public Conta(int teste) {

	}

	public int getNumeroDaConta() {
		return numeroDaConta;
	}

	public void setNumeroDaConta(int numero) {
		this.numeroDaConta = numero;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public double getSaldodaConta() {
		return this.saldo;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getNumero() {
		return this.numero;
	}

	/**
	 * Atualiza o saldo de acordo com o valor informado
	 * 
	 * @param taxa
	 * @throws ValorInvalidoException
	 */
	public void deposita(double valor) throws ValorInvalidoException {
		if (valor < 0) {
			// checked exception--> tipo de exceção não poderia ser evitada
			throw new ValorInvalidoException(valor);
		} else {
			this.saldo += valor;
		}
	}

	/**
	 * Método abstrato -> obrigado a ser implementado nas classes que herdam
	 * essa classe
	 * 
	 * @param taxaSelic
	 */
	public abstract void atualiza(double taxaSelic);

	/**
	 * 
	 * @param valor
	 * @return
	 */
	public boolean saca(double valor) {
		if (this.saldo >= valor) {
			this.saldo -= valor;
			return true;
		}

		return false;
	}

	/**
	 * Reescreve o método toString, para evitar exibir o endereço de memória
	 * quando usá-lo
	 */
	@Override
	public String toString() {
		return "Esse objeto é uma conta com saldo R$" + this.saldo;
	}

	/**
	 * Reescreve o método equals (que tem como argumento um Object) para
	 * comparar o conteúdo. Faz um cast do objeto recebido verificando antes
	 */
	// @Override
	// public boolean equals(Object obj) {
	// if (obj instanceof Conta) {
	// Conta outraConta = (Conta) obj;
	//
	// // verifica se são iguais
	// return this.numeroDaConta == outraConta.numeroDaConta
	// && this.nome == outraConta.nome;
	// }
	// return false;
	// }

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		if (agencia != other.agencia)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numero != other.numero)
			return false;
		if (numeroDaConta != other.numeroDaConta)
			return false;
		if (Double.doubleToLongBits(saldo) != Double
				.doubleToLongBits(other.saldo))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + agencia;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + numero;
		result = prime * result + numeroDaConta;
		long temp;
		temp = Double.doubleToLongBits(saldo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

}
