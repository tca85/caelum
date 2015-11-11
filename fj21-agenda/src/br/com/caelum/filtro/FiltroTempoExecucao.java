package br.com.caelum.filtro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Filtros são usados para auditorias, login, interceptações etc
 * são requisitos não relacionados às regras de negócio
 * O código é executado antes da requisição, e depois da resposta
 * implementa a interface javax.servlet.Filter
 * A notação WebFilter pode ser tudo, ou /*.jsp por exemplo
 * 
 * --> Layer7 Firewall faz isso externamente
 * 
 * @author Thiago Alves
 *
 */
@WebFilter("/*")
public class FiltroTempoExecucao implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
		long tempoInicial = System.currentTimeMillis();
		
		// Faz todo processamento. Sem esse método, o sistema pára.
		filterChain.doFilter(request, response);
		
		long tempoFinal = System.currentTimeMillis();
		
		// Cast de tipo referência sem declarar variáveis
		String uri = ((HttpServletRequest) request).getRequestURI();
		
		String parametros = ((HttpServletRequest) request).getParameter("logica");
		
		System.out.println("Tempo de requisição de " + uri
				            + "?logica=" + parametros 
				            + " demorou (ms) :" 
				            + (tempoFinal - tempoInicial));
	}

	@Override
	public void init(FilterConfig filterConfigure) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
