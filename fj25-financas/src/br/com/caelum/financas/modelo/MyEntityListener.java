package br.com.caelum.financas.modelo;

import java.util.Calendar;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 * Utiliza o Design Pattern Observer, também chamado de Callback para entidades
 * 
 * O código fica menos claro, porque fica muito especializado
 * 
 * Deve ser usado apenas para requisitos não funcionais nunca para regras de
 * negócio
 * 
 * @author Thiago Alves
 *
 */
public class MyEntityListener {
	/**
	 * Trigger para passar a data/hora no momento que for salvar ou atualizar
	 *
	 * @param entidade
	 */
	@PrePersist
	@PreUpdate
	public void preAltera(Object entidade) {
		if (entidade instanceof Movimentacao) {
			// Cast de referência - "molda" o object para a referência correta
			Movimentacao movimentacao = (Movimentacao) entidade;
			movimentacao.setData(Calendar.getInstance());
		}
	}
}