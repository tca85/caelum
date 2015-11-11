package br.com.caelum.banco;

public class TesteErro {
	public static void main(String[] args) {
		System.out.println("inicio do main");
		metodo1();
		System.out.println("fim do main");
	}

	static void metodo1() {
		System.out.println("inicio do método 1");
		metodo2();
		System.out.println("fim do metodo1");
	}

	static void metodo2() {
		System.out.println("inicio do método 2");

		int[] array = new int[10];

		try {
			for (int i = 0; i <= 15; i++) {
				array[i] = i;
				System.out.println(i);
			}
			
			System.out.println("fim do metodo2");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("erro: " + e.getMessage());
		}

	}

}
