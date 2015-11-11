package br.com.caelum.notasfiscais.listener;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

/**
 * Verifica em qual das 6 fases do JSF está
 *
 * Precisa adicionar no faces-config:
 * 
 * 	<lifecycle>
 *		<phase-listener>
 *         br.com.caelum.notasfiscais.listener.CicloDeVidaListener
 *		</phase-listener>
 *	</lifecycle>
 * 
 * @author Thiago Alves - 15.10.2015
 *
 */
public class CicloDeVidaListener implements PhaseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void afterPhase(PhaseEvent event) {
		//System.out.println("Depois da fase " + event.getPhaseId());
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		//System.out.println("Antes da fase " + event.getPhaseId());
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}
}