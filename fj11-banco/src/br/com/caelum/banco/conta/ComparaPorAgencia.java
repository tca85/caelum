package br.com.caelum.banco.conta;

import java.util.Comparator;

/**
 * Ordernar Conta pelo atributo Agência, crescente
 * @author oo5153
 *
 */
public class ComparaPorAgencia implements Comparator<Conta>{

	@Override
	public int compare(Conta conta1, Conta conta2) {
		return Integer.compare(conta1.getAgencia(), conta2.getAgencia());
		
//		if (conta1.getAgencia() < conta2.getAgencia()) {
//			return -1;
//		} else if (conta2.getAgencia() > conta2.getAgencia()) {
//			return 1;
//		}
//		return 0;
	}

}
