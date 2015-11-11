package br.com.caelum.mvc.logica;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;

public class AlterarContatoLogic implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// Busca a conexão pendurada na requisição, pela FiltroConexao
		Connection connection = (Connection) request.getAttribute("conexao");
		
		ContatoDao dao = new ContatoDao(connection);
		Contato contato = new Contato();
		
		String dataEmTexto = request.getParameter("dataNascimento");
		
		try {
			Calendar dataNascimento = null;
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);

			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(date);

			contato.setId(Long.parseLong(request.getParameter("id")));
			contato.setNome(request.getParameter("nome"));
			contato.setEmail(request.getParameter("email"));
			contato.setEndereco(request.getParameter("endereco"));
			contato.setDataNascimento(dataNascimento);
			
			dao.atualiza(contato);

		} catch (ParseException e) {
		}
		
		return "/WEB-INF/jsp/alterar-contato.jsp";
	}
}