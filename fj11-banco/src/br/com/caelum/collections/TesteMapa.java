package br.com.caelum.collections;

import java.util.HashMap;
import java.util.Map;

import br.com.caelum.banco.conta.Conta;
import br.com.caelum.banco.conta.ContaCorrente;
import br.com.caelum.banco.conta.ValorInvalidoException;

public class TesteMapa {
	
	public static void main(String[] args) {
		Conta c1 = new ContaCorrente();
		Conta c2 = new ContaCorrente();
		
		try {
			c1.deposita(10000);
			c1.deposita(30000);
		} catch (ValorInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// sem generics
//		Map mapaDeContas = new HashMap();
		// usando Generics:
		Map<String,Conta> mapaDeContas = new HashMap<>();
		
		mapaDeContas.put("diretor", c1);
		mapaDeContas.put("gerente", c2);
		
		// qual a conta do diretor
		//Conta contaDoDiretor = (Conta) mapaDeContas.get("diretor");
		
		Conta contaDoDiretor = mapaDeContas.get("diretor");
		
		System.out.println(contaDoDiretor.getSaldodaConta());
	}
}
