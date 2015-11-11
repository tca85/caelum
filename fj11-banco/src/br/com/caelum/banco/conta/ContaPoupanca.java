package br.com.caelum.banco.conta;

/**
 * Precisa implementar a interface Comparable para permitir ordenar obrigatorio
 * passar o typeRef no Generics, senão vai ser Object Comparable<Classe>
 * 
 * @author oo5153
 *
 */
public class ContaPoupanca extends Conta implements Comparable<ContaPoupanca> {

	@Override
	public void atualiza(double taxaSelic) {
		// TODO Auto-generated method stub

	}

	/**
	 * Sem esse método, poderia passar qualquer objeto para a ordenação e isso
	 * poderia causar exception
	 */
	@Override
	public int compareTo(ContaPoupanca c) {
		if (this.getNumero() < c.getNumero()) {
			return -1;
		} else if (this.getNumero() > c.getNumero()) {
			return 1;
		}
		return 0;
	}

}
