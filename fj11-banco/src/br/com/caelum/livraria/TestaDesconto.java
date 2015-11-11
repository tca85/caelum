package br.com.caelum.livraria;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class TestaDesconto {

	public static void main(String[] args) {
		Loja loja = new Loja();
		List<Livro> livros = new LinkedList<>();

		for (int i = 0; i < 100; i++) {
			Livro livro = new Livro();
			Random random = new Random();

			double preco = random.nextDouble();

			livro.setAutor("xxxx");
			livro.setDescricao("xxxx");
			livro.setTitulo("xxxx");
			livro.setPreco(preco);

			livros.add(livro);
		}

	}

}
