package br.com.caelum.notasfiscais.mb;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.caelum.notasfiscais.dao.ProdutoDao;
import br.com.caelum.notasfiscais.modelo.Produto;
import br.com.caelum.notasfiscais.tx.Auditavel;
import br.com.caelum.notasfiscais.tx.Transactional;

/**
 * Managed Bean do JSF 2 - javax.faces.bean.ManagedBean é como uma Controller
 * ou seja, recebe os valores da requisição
 * Conceitualmente é um POJO (plain old java object)
 * 
 * O DataBind é feito através da expression language do JSF
 * 
 * @Named e @RequestScoped - significa que será gerenciado pelo CDI
 * 
 * @author Thiago Alves - 14.10.2015
 *
 */
@Model // implementa o @Named e o @RequestScoped
public class ProdutoBean {
	private Produto produto = new Produto();
	private double totalValores = 0;
	private List<Produto> produtos;

	@Inject
	private ProdutoDao dao;

	// ---------------------------------------------------------------------------------------------
	/**
	 * Evitar colocar código nos getters que serão referenciados na View isso
	 * pode causar lentidão
	 * 
	 * @return
	 */
	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	// ---------------------------------------------------------------------------------------------
	/**
	 * Grava um produto novo
	 */
	@Transactional
	@Auditavel
	public String grava() {
		if (produto.getId() == null) {
			dao.adiciona(produto);
		} else {
			dao.atualiza(produto);
		}

		this.produtos = dao.listaTodos();

		// "limpa" o objeto, para que não volte com os dados inseridos
		this.produto = new Produto();
		System.out.println("Produto gravado");
		
		// O ?faces-redirect=true serve para que a requisição não seja feita de novo no F5
		// quando está usando AJAX, isso não é necessário
		return "produto?faces-redirect=true"; 
	}

	// ---------------------------------------------------------------------------------------------
	/**
	 * Retorna uma lista de produtos
	 * 
	 * @return
	 */
	@Transactional
	public List<Produto> getProdutos() {
		if (produtos == null) {
			produtos = dao.listaTodos();
		}
		return produtos;
	}
	
	// ---------------------------------------------------------------------------------------------
	/**
	 * --> fazer esse método dentro do ProdutoDao, com JPQL
	 * 
	 * @return
	 */
	@Transactional
	public double getTotalValores() {
		for (Produto produto : produtos) {
			totalValores = totalValores + produto.getPreco();
		}
		return this.totalValores;
	}
	
	// ---------------------------------------------------------------------------------------------
	@Transactional
	public void remove(Produto produto) {
		dao.remove(produto);
		this.produtos = dao.listaTodos();
	}
	// ---------------------------------------------------------------------------------------------
}