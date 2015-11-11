package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.notasfiscais.dao.NotaFiscalDao;
import br.com.caelum.notasfiscais.dao.ProdutoDao;
import br.com.caelum.notasfiscais.modelo.Item;
import br.com.caelum.notasfiscais.modelo.NotaFiscal;
import br.com.caelum.notasfiscais.modelo.Produto;
import br.com.caelum.notasfiscais.tx.Transactional;

/**
 * ManagedBean NotaFiscalBean, gerenciado pelo CDI
 * 
 * @RequestScoped - cria um novo ManagedBean a cada nova requisição. Isso faz
 *                  com que a lista de ítens tenha somente 1 item sempre
 *                  
 * @ConversationScoped - é um escopo intermediário entre Request e Session
 *                       serve para transferir informações entre telas
 * 
 * @author Thiago Alves - 20.10.2015
 *
 */
@Named
@ConversationScoped
public class NotaFiscalBean implements Serializable{
	private static final long serialVersionUID = 1L;

	private NotaFiscal notaFiscal = new NotaFiscal();
	private Item item = new Item();
	private Long idProduto;

	@Inject
	private NotaFiscalDao notaFiscalDao;

	@Inject
	private ProdutoDao produtoDao;
	
	@Inject
	private Conversation conversation;

	// ---------------------------------------------------------------------------------------------
	public NotaFiscal getNotaFiscal() {
		return notaFiscal;
	}
	
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Long getIdProduto() {
		return idProduto;
	}
	
	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public void setNotaFiscal(NotaFiscal notaFiscal) {
		this.notaFiscal = notaFiscal;
	}
	// ---------------------------------------------------------------------------------------------
	/**
	 * Adiciona um produto na lista de ítens da nota fiscal
	 */
	@Transactional
	public void guardaItem() {
		Produto produto = produtoDao.buscaPorId(idProduto);

		item.setProduto(produto);
		item.setValorUnitario(produto.getPreco());

		notaFiscal.getItens().add(item);
		item.setNotaFiscal(notaFiscal);
		// ok

		item = new Item();
		idProduto = null;
	}
	// ---------------------------------------------------------------------------------------------
	/**
	 * Avança a tela no Wizard de criação de nota fiscal + itens
	 * O escopo de convesrsação é aberto, indicando que os dados
	 * dessa tela serão enviado para o outro
	 * @return
	 */
	public String avancar(){
		if (conversation.isTransient()) {
		   conversation.begin();	
		}
		return "item?faces-redirect=true";
	}
	// ---------------------------------------------------------------------------------------------
	/**
	 * Grava a nota fiscal e os ítens, e também fecha o escopo de conversação
	 * que foi aberto anteriormente (notafiscal.xhtml --> item.xhtml)
	 * @return
	 */
	@Transactional
	public String gravar() {
		notaFiscalDao.adiciona(notaFiscal);
		notaFiscal = new NotaFiscal();
		conversation.end();
		return "notafiscal?faces-redirect=true";
	}
	// ---------------------------------------------------------------------------------------------
}