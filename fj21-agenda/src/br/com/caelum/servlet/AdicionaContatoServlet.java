package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;

/**
 * Servlet implementation class AdicionaContatoServlet
 */
@SuppressWarnings("serial")
@WebServlet("/adicionaContato")
public class AdicionaContatoServlet extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		// Não pode remover o super
		super.init(config);

		System.out.println(this);
	}

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		System.out.println(this);

		PrintWriter out = response.getWriter();

		Contato contato = new Contato();

		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String email = request.getParameter("email");
		String dataEmTexto = request.getParameter("dataNascimento");

		try {
			Calendar dataNascimento = null;
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);

			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(date);

			contato.setNome(nome);
			contato.setEndereco(endereco);
			contato.setEmail(email);
			contato.setDataNascimento(dataNascimento);

		} catch (ParseException e) {
			out.println("Erro de conversão de data");
			return;
		}
		
		// Busca a conexão pendurada na requisição, pela FiltroConexao
		Connection connection = (Connection) request.getAttribute("conexao");
		
		ContatoDao dao = new ContatoDao(connection);
		dao.adiciona(contato);
		
		// Exibe o resultado na JSP:
		RequestDispatcher rd = request.getRequestDispatcher("/contato-adicionado.jsp");
		rd.forward(request, response);
	}
}
