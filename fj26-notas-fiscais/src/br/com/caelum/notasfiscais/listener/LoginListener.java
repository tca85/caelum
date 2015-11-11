package br.com.caelum.notasfiscais.listener;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import br.com.caelum.notasfiscais.modelo.Usuario;
import br.com.caelum.notasfiscais.tx.EmailComercial;
import br.com.caelum.notasfiscais.tx.EmailFinanceiro;

/**
 * Classe que observa o Event<Usuario> eventoLogin; da LoginBean
 * 
 * @author Thiago Alves - 21.10.2015
 *
 */
public class LoginListener {
	@Inject
	@EmailComercial
	private String emailComercial;

	@Inject
	@EmailFinanceiro
	private String emailFinanceiro;

	@Inject
	@Any
	private Instance<String> todosEmails;

	//---------------------------------------------------------------------------------------------
	public void onLogin(@Observes Usuario usuario) {
		System.out.printf("Usuário %s se logou no sistema", usuario.getLogin());
		System.out.printf("Email enviado para %s", emailFinanceiro);

		for (String email : todosEmails) {
			System.out.println("Notifica " + email);
		}
	}
	//---------------------------------------------------------------------------------------------
}