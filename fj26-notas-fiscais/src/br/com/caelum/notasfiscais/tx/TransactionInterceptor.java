package br.com.caelum.notasfiscais.tx;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

/**
 * Configuração da anotation @Transactional. Ela vai ser usada para abrir e
 * fechar o EntityManager. Tem funcionalidade parecida com o interceptador do
 * Spring MVC e dos filtros do JSP
 * 
 * @author Thiago Alves - 21.10.2015
 *
 */
@Interceptor
@Transactional
public class TransactionInterceptor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	@AroundInvoke
	public Object intercept(InvocationContext ctx) throws Exception {

		System.out.println("Abrindo a transação");
		manager.getTransaction().begin();

		// retorna ao método que está com a anotation
		Object resultado = ctx.proceed();

		manager.getTransaction().commit();
		System.out.println("Comitando a transação");

		return resultado;
	}
}