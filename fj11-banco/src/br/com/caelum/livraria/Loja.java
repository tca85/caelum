package br.com.caelum.livraria;

import java.util.ArrayList;
import java.util.List;

public class Loja {
	private String nome;
	private String link;
	private int qtdLivros;
	// Interface List<TypeRef> xxx = new xxxList<>();
	private List<Livro> livros = new ArrayList<>();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public int getQtdLivros() {
		return qtdLivros;
	}

	public void setQtdLivros(int qtdLivros) {
		this.qtdLivros = qtdLivros;
	}

	public void buscarLivroID(int id) {
		// java.util.Arrays.binarySearch(livros,id);
		// ArrayList.this

		if (this.livros.size() <= id) {
			// int teste = this.livros.get(id);
		}

	}

	// ---------------------------------------------------------------------
	/**
	 * Retorna 1 único livro
	 * 
	 * @param l
	 * @returnstem.out.println(
	 */
	public Livro buscarLivro(Livro l) {
		Livro retorno = new Livro();

		for (Livro livro : this.livros) {
			if (livro.getTitulo().equals(l.getTitulo())) {
				retorno = livro;
			}
		}

		return retorno;
	}

	// ---------------------------------------------------------------------
	/**
	 * Adicionar livro
	 * 
	 * @param livro
	 */
	public void adicionarLivro(Livro livro) {
		this.livros.add(livro);
	}

	// ---------------------------------------------------------------------

	public void imprimirInformacoes() {

	}
	
	
	public void ordernar(List<Livro> livro){
		
	}

	// ---------------------------------------------------------------------
	/**
	 * Cria só para saber qual id do livro quer remover
	 * @param id
	 */
	public void removerLivro(int id) {
		this.livros.remove(new Livro(id));
	}

	// ---------------------------------------------------------------------
	public void imprimirInformacoesLoja() {
		// Amarildo

	}

}
