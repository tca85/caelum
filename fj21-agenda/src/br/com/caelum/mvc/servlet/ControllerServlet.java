package br.com.caelum.mvc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.mvc.logica.Logica;

/**
 * Obs: só tem uma Servlet nesse projeto, essa
 * coisa ruim de Servlet = herança, porque você é obrigado a conhecer
 * como os métodos foram implementados
 * 
 * Design Patter Front Controller
 * 
 * @author web5440
 *
 */
@SuppressWarnings("serial")
@WebServlet("/mvc")
public class ControllerServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String parametro = request.getParameter("logica");
		String nomeClasse = "br.com.caelum.mvc.logica." + parametro;
		
		try {
			// Implementação do Generics + Reflection
			Class<?> classe = Class.forName(nomeClasse);
			
			// Cast de tipo referência para a interface Logica
			Logica logica = (Logica) classe.newInstance();
			String pagina = logica.executa(request, response);
			
			request.getRequestDispatcher(pagina).forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
