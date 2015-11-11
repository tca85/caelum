package br.com.caelum.livraria;

import java.util.List;

public class TestaLoja {
	public static void main(String[] args) {
		Loja loja = new Loja();

		for (int i = 0; i <= 30; i++) {
			Livro livro = new Livro();

			livro.setAutor("Autor" + i);
			livro.setDescricao("Descrição" + i);
			livro.setTitulo("Titulo" + i);
			livro.setPreco(10 + i);

			loja.adicionarLivro(livro);
		}

		Livro livro = new Livro();

		livro.setAutor("Autor1");
		livro.setDescricao("Descrição1");
		livro.setTitulo("Titulo1");
		livro.setPreco(11);

//		List<Livro> livroEncontrado= loja.buscarLivro(livro);
		
		livro = loja.buscarLivro(livro);

		System.out.println(livro.getTitulo());

	}

}
