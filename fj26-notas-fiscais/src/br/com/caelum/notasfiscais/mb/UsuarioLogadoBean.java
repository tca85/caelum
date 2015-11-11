package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.caelum.notasfiscais.modelo.Usuario;

/**
 * Essa classe foi criada para evitar ter o UsuarioDAO injetado durante toda
 * sessão. O DAO tem o EntityManager injetado, ou seja, é pesado para manter na
 * sessão
 * 
 * @author Thiago Alves - 16.10.2015
 *
 */
@Named
@SessionScoped
public class UsuarioLogadoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario usuario;

	public void logar(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean isLogado() {
		return usuario != null;
	}

	public String deslogar() {
	   this.usuario = null;
	   return "login?faces-redirect=true";
	}
	
	public Usuario getUsuario() {
		return this.usuario;
	}
}