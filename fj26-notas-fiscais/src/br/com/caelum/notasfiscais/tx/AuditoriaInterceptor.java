package br.com.caelum.notasfiscais.tx;

import java.text.SimpleDateFormat;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import com.sun.istack.internal.logging.Logger;

import br.com.caelum.notasfiscais.mb.UsuarioLogadoBean;

/**
 * 
 * @author Thiago Alves
 *
 */
@Interceptor
@Auditavel
public class AuditoriaInterceptor {
	@Inject
	private UsuarioLogadoBean usuarioLogado;

	public static final Logger logger = Logger.getLogger(AuditoriaInterceptor.class);

	// --------------------------------------------------------------------------------------------
	/**
	 * Grava o log de quem executou o método
	 * 
	 * @param context
	 * @return
	 * @throws Exception
	 */
	@AroundInvoke
	public Object audita(InvocationContext context) throws Exception {

		// "entra" no método que tem está com a anotation @Auditavel
		Object resultado = context.proceed();

		logger.info("O método: " + context.getMethod().getName() 
				+ " foi executado pelo usuário: "
				+ usuarioLogado.getUsuario().getLogin() 
				+ " na data: " + new SimpleDateFormat("dd/MM/yyyy ' às ' hh:mm:ss"));

		return resultado;
	}
	// ---------------------------------------------------------------------------------------------
}