package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;

import javax.enterprise.event.Event;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.caelum.notasfiscais.dao.UsuarioDao;
import br.com.caelum.notasfiscais.modelo.Usuario;

/**
 * Realiza o login e não mantém no escopo de sessão
 * 
 * Separation of Concerns através do CDI
 * 
 * ---- teste!!!
 * 
 * @author Thiago Alves - 16.10.2015
 *
 */
@Model // implementa o @Named e o @RequestScoped
public class LoginBean implements Serializable{
	private static final long serialVersionUID = 1L;

	private Usuario usuario = new Usuario();
	
	@Inject
	private UsuarioDao dao;
	
	@Inject
	private UsuarioLogadoBean usuarioLogado;
	
	@Inject
	Event<Usuario> eventoLogin;

	// ---------------------------------------------------------------------------------------------
	public Usuario getUsuario() {
		return usuario;
	}

	// ---------------------------------------------------------------------------------------------
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	// ---------------------------------------------------------------------------------------------
	public String efetuaLogin() {
		if (dao.existe(usuario)) {
			eventoLogin.fire(usuario); // ---> design pattern Observer
			usuarioLogado.logar(usuario);
			return "produto?faces-redirect=true"; // evita o erro do F5 fazer a mesma requisição
		} else {
			//usuarioLogado.deslogar();
			//this.usuario = new Usuario();
			return usuarioLogado.deslogar();
		}
	}
	// ---------------------------------------------------------------------------------------------
}