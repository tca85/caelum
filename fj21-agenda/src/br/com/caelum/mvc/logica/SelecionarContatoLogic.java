package br.com.caelum.mvc.logica;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;

public class SelecionarContatoLogic implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// Busca a conexão pendurada na requisição, pela FiltroConexao
		Connection connection = (Connection) request.getAttribute("conexao");
		
		ContatoDao dao = new ContatoDao(connection);
		Contato c = new Contato();
		
		c.setId(Long.parseLong(request.getParameter("id")));
		
		Contato contato = dao.getContato(c);
		
		request.setAttribute("contato", contato);

		System.out.println(contato.getNome());
		
		return "/WEB-INF/jsp/alterar-contato.jsp";
	}
}
