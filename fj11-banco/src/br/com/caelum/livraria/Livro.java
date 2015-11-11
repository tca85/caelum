package br.com.caelum.livraria;

/**
 * Precisa implementar a interface Comparable para permitir ordenar obrigatorio
 * passar o typeRef no Generics, senão vai ser Object Comparable<Classe>
 * 
 * @author Thiago Alves
 *
 */
public class Livro implements Comparable<Livro> {
	private String titulo;
	private String descricao;
	private String autor;
	private double preco;
	private int id;

	// private static int id;

	public Livro() {
		// Livro.id++;
		//
		// if (Livro.id > 100) {
		// // TODO: criar exception
		// }
	}

	public Livro(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getId() {
		return id;
	}

	// precisa reescrever para usar o contains e o remove do ArrayList
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	
	/**
	 * Reescreve o método
	 */
	@Override
	public int compareTo(Livro outroLivro) {
		if (this.preco < outroLivro.getPreco()) {
			return -1;
		} else if (this.preco > outroLivro.getPreco()) {
			return 1;
		}
		return 0;
	}
}
