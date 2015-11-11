package br.com.caelum.tarefas.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.caelum.tarefas.dao.JdbcTarefaDao;
import br.com.caelum.tarefas.modelo.Tarefa;

/**
 * Controller de Tarefas
 * 
 * Toda classe anota com o Controller, é um Bean
 * 
 * 04.08.2015
 * 
 * @author Thiago Alves
 *
 */
@Controller
public class TarefasController {
	private final JdbcTarefaDao dao;

	// ---------------------------------------------------------------------------------
	/**
	 * Injeção de dependência no construtor padrão
	 * 
	 * @param dao
	 */
	@Autowired
	public TarefasController(JdbcTarefaDao dao) {
		this.dao = dao;
	}

	// ---------------------------------------------------------------------------------
	/**
	 * Esse método é chamado através da requisição à url
	 * http://localhost:8080/fj21-tarefas/novaTarefa
	 * 
	 * @return JSP que está em WEB-INF/views/tarefa/formulario.jsp
	 */
	@RequestMapping("novaTarefa")
	public String form() {
		return "tarefa/formulario";
	}

	// ---------------------------------------------------------------------------------
	/**
	 * Esse método é chamado através da requisição à url:
	 * http://localhost:8080/fj21-tarefas/adicionaTarefa
	 * 
	 * @param tarefa
	 * @return JSP que está em WEB-INF/views/tarefa/adicionada.jsp
	 */
	@RequestMapping("adicionaTarefa")
	public String adiciona(@Valid Tarefa tarefa, BindingResult bindingResult) {

		// Retorna para o formulário se houver erro de validação. Notação na
		// classe Tarefa:
		// @NotNull @Size(min=5)
		// private String descricao;
		if (bindingResult.hasFieldErrors("descricao")) {
			return "tarefa/formulario";
		}

		this.dao.adiciona(tarefa);

		// Criar tratamento para evitar que o usuário envie um JavaScript
		// eval('alert(\'oi\')');

		return "tarefa/adicionada";
	}
	// ---------------------------------------------------------------------------------

	/**
	 * Esse método é chamado através da requisição à url:
	 * http://localhost:8080/fj21-tarefas/listaTarefas
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("listaTarefas")
	public String lista(Model model) {

		// a melhor forma é instanciar de acordo com uma interface, para
		// restringir
		// a visibilidade dos métodos que não precisamos acessar
		// "pendura" a lista de tarefas na requisição
		// obs: precisa importar a JSTL para usar o Foreach na View
		model.addAttribute("tarefas", this.dao.lista());

		return "tarefa/lista";
	}

	// ---------------------------------------------------------------------------------
	/**
	 * 
	 * @param tarefa
	 * @return
	 */
	@RequestMapping("removeTarefa")
	public String remove(Tarefa tarefa) {
		this.dao.remove(tarefa);
		return "redirect:listaTarefas";
	}

	// ---------------------------------------------------------------------------------
	/**
	 * 
	 * @param tarefa
	 * @param model
	 * @return
	 */
	@RequestMapping("mostraTarefa")
	public String mostraTarefa(Tarefa tarefa, Model model) {
		model.addAttribute("tarefa", this.dao.buscaPorId(tarefa.getId()));

		return "tarefa/mostra";
	}

	// ---------------------------------------------------------------------------------
	/**
	 * 
	 * @param tarefa
	 * @param bindingResult
	 * @return
	 */
	@RequestMapping("alteraTarefa")
	public String altera(@Valid Tarefa tarefa, BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors("dataFinalizacao")) {
			return "tarefa/listaTarefas"; // <<<<está voltando para a view
											// listaTarefas
		}

		this.dao.altera(tarefa);

		return "redirect:listaTarefas";
	}

	// ---------------------------------------------------------------------------------
	/**
	 * Chamado através do onClick no link Finalizar Agora da lista.jsp se não
	 * tiver a notação ResponseBody, não funcionará
	 * 
	 * @param id
	 */
	@ResponseBody
	@RequestMapping("finalizaTarefa")
	public void finaliza(long id) {
		this.dao.finaliza(id);
	}
	// ---------------------------------------------------------------------------------
}