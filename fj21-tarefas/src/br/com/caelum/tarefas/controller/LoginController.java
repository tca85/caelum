package br.com.caelum.tarefas.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.tarefas.dao.JdbcUsuarioDao;
import br.com.caelum.tarefas.modelo.Usuario;

/**
 * 
 * @author Thiago Alves
 *
 */
@Controller
public class LoginController {
	private final JdbcUsuarioDao dao;

	/**
	 * Injeção por construtor
	 * 
	 * @param dao
	 */
	@Autowired
	public LoginController(JdbcUsuarioDao dao) {
		this.dao = dao;
	}

	// ---------------------------------------------------------------------------------------------------------------------
	/**
	 * Carrega a viw de login
	 * 
	 * @return formulario-login
	 */
	@RequestMapping("loginForm")
	public String loginForm() {
		return "formulario-login";
	}

	// ---------------------------------------------------------------------------------------------------------------------
	/**
	 * Tenta realizar o login, e se não conseguir, redireciona para a view de
	 * login http://localhost:8080/fj21-tarefas/loginForm
	 * 
	 * @param usuario
	 * @param session
	 * @return
	 */
	@RequestMapping("efetuaLogin")
	public String efetuaLogin(Usuario usuario, HttpSession session) {
		if (this.dao.existeUsuario(usuario)) {
			session.setAttribute("usuarioLogado", usuario);
			return "menu";
		}

		return "redirect:loginForm";
	}

	// ---------------------------------------------------------------------------------------------------------------------
	/**
	 * Logout da aplicação
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:loginForm";
	}
}