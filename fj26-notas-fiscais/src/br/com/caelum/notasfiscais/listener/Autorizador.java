package br.com.caelum.notasfiscais.listener;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.inject.Inject;

import br.com.caelum.notasfiscais.mb.UsuarioLogadoBean;

/**
 * 
 * @author Thiago Alves - 19.10.2015
 *
 */
public class Autorizador implements PhaseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioLogadoBean usuarioLogado;

	//---------------------------------------------------------------------------------------------
	/**
	 * Redireciona para a página de login caso o usuário não esteja logado
	 * ---> já tem a árvore de componentes nesse momento
	 */
	@Override
	public void afterPhase(PhaseEvent event) {
		FacesContext context = event.getFacesContext();
		
		// libera a página login
		if ("/login.xhtml".equals(context.getViewRoot().getViewId())) {
			return;
		}
		
		if ("/index.xhtml".equals(context.getViewRoot().getViewId())) {
			return;
		}
		
		// Se o usuário não estiver logado, redireciona para a página de login
		if (!usuarioLogado.isLogado()) {
			NavigationHandler handler = context.getApplication().getNavigationHandler();
			
			handler.handleNavigation(context, null, "login?faces-redirect=true");
			
			// renderiza a tela
			context.renderResponse();
		}
	}
	//---------------------------------------------------------------------------------------------
	@Override
	public void beforePhase(PhaseEvent event) {	}
	
	//---------------------------------------------------------------------------------------------
	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}
	//---------------------------------------------------------------------------------------------
}