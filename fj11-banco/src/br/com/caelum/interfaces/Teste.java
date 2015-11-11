package br.com.caelum.interfaces;

public class Teste {

	public static void main(String[] args) {
      // Se o tipo referência for a interface, esse objeto só acessa os
      // métodos da interface que foram implementados na classe Retangulo
      AreaCalculavel a = new Retangulo(3, 2);
      System.out.println(a.calculaArea());
      
      AreaCalculavel circulo = new Circulo(3);
      circulo.calculaArea();

	}

}
