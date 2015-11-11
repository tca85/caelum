package br.com.caelum.notasfiscais.mb;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.caelum.notasfiscais.dao.UsuarioDao;
import br.com.caelum.notasfiscais.modelo.Usuario;
import br.com.caelum.notasfiscais.tx.Transactional;

/**
 * 
 * @author Thiago Alves
 *
 */
@Model
public class UsuarioBean {
	private Usuario usuario = new Usuario();
	private List<Usuario> usuarios;
	
	@Inject
	private UsuarioDao dao;
	
	// ---------------------------------------------------------------------------------------------
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	// ---------------------------------------------------------------------------------------------
	@Transactional
	public String grava(){
		
		if (usuario.getId() == null) {
			dao.adiciona(usuario);
		} else {
			dao.atualiza(usuario);
		}

		usuario = new Usuario();
		
		usuarios = dao.listaTodos();
		
		return "usuario?faces-redirect=true";
	}
	// ---------------------------------------------------------------------------------------------
	@Transactional
	public List<Usuario> getUsuarios() {
		if (usuarios == null) {
			usuarios = dao.listaTodos();
		}

		return usuarios;
	}
	
	// ---------------------------------------------------------------------------------------------
	@Transactional
	public void remove(Usuario usuario) {
		dao.remove(usuario);
		this.usuarios = dao.listaTodos();
	}
	// ---------------------------------------------------------------------------------------------
}
