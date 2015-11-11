package br.com.caelum.financas.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.financas.dao.ContaDao;
import br.com.caelum.financas.modelo.Conta;

/**
 * Managed Bean - Usa Named e ViewScoped, do CDI. Antigamente usava o ManagedBean
 * 
 * CDI - com ele, o container injeta o que quiser, onde quiser. Java EE 6
 * 
 * 
 * @author Thiago Alves
 *
 */
@Named
@ViewScoped
public class ContasBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    // injeção de dependencia do container, possível por causa do CDI
    @Inject
    private ContaDao contaDAO;

	private Conta conta = new Conta();
	
	private List<Conta> contas;

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public void grava() {
		contaDAO.adiciona(conta);
		this.contas = contaDAO.lista();
		limpaFormularioDoJSF();
	}

	public List<Conta> getContas() {
		if (this.contas == null) {
			this.contas = contaDAO.lista();
		}

		return this.contas;
	}

	public void remove() {
		contaDAO.remove(this.conta);
		this.contas = contaDAO.lista();
		limpaFormularioDoJSF();
	}
	
	public void altera(){
		if (this.conta.getId() == null) {
			contaDAO.adiciona(this.conta);
		} else {
			contaDAO.altera(this.conta);
		}
	}

	/**
	 * Esse metodo apenas limpa o formulario da forma com que o JSF espera.
	 * Invoque-o no momento em que precisar do formulario vazio.
	 */
	private void limpaFormularioDoJSF() {
		this.conta = new Conta();
	}
}
