package br.com.caelum.tarefas.interceptador;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * Interceptador está mais para as regras de negócio, porque evitaria o acesso à classes e métodos
 * Os filtros, estão mais para infra
 * 
 * AutorizadorInterceptador herda da classe abstrata HandlerInterceptorAdapter (Spring)
 * que implementa a interface AsyncHandlerInterceptor
 * A interface tem 3 métodos: afterCompletion, postHandle, preHandle
 * 
 * http://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/web/servlet/AsyncHandlerInterceptor.html
 * 
 * obs: para que tudo funcione é necessário definir essa classe na tag interceptador do XML do Spring
 * 
 * 07.08.2015
 * 
 * @author Thiago Alves
 *
 */
public class AutorizadorInterceptador extends HandlerInterceptorAdapter{
	
	//---------------------------------------------------------------------------------------------------------------------
	/**
	 * preHandle - verifica o acesso antes de executar uma ação
	 * O usuário só pode acessar os métodos do LoginController sem ter feito o login
	 * e também pode ter acesso às imagens e CSS
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String uri = request.getRequestURI();
		
		// Se a url finalizar com loginForm, ou efetuaLogin, ou conter resources, passa na pré-validação
		if (uri.endsWith("loginForm") || uri.endsWith("efetuaLogin") || uri.contains("resources")) {
			return true;
		}
		
		// Se encontrar o atributo usuarioLogado na Session, e não estiver vazio, passa na pré-validação
		if (request.getSession().getAttribute("usuarioLogado") != null) {
			return true;
		}
		
		// Se o usuário estiver tentando acessar qualquer outra coisa, redireciona para a view loginForm
		// http://localhost:8080/fj21-tarefas/loginForm
		response.sendRedirect("loginForm");
		return false;
	}
	//---------------------------------------------------------------------------------------------------------------------
	

}
