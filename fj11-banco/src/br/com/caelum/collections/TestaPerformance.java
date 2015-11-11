package br.com.caelum.collections;

import java.util.Collection;
import java.util.HashSet;

public class TestaPerformance {
	public static void main(String[] args) {
		System.out.println("Iniciando...");
		
//		Collection<Integer> teste = new ArrayList<>(); // Tempo gasto: 5
		Collection<Integer> teste = new HashSet<>();   // Tempo gasto: 12
		
		long inicio = System.currentTimeMillis();
		
		int total = 30000;
		
		for (int i = 0; i < total; i++) {
			teste.add(i);
		}
		
		long fim = System.currentTimeMillis();
		
		long tempo = fim - inicio;
		
		System.out.println("Tempo gasto: " + tempo);
		
		
	}

}
