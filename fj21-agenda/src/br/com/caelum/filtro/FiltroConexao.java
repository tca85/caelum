package br.com.caelum.filtro;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import br.com.caelum.agenda.ConnectionFactory;

/**
* "Pendura" a conexão na request. É melhor do que chamar a conexão em cada DAO
* quanto tempo vive uma conexão? uma Unit of Work, ou seja, até o retorno
* IoC -- inversion of control
* @author Thiago Alves
*
*/
@WebFilter("/*")
public class FiltroConexao implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
		try {
			Connection connection = new ConnectionFactory().getConnection();
			request.setAttribute("conexao", connection);
			
			filterChain.doFilter(request, response);
			
			connection.close();
			
		} catch (SQLException e) {
			throw new ServletException(e);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
	}
}