package br.com.caelum.notasfiscais.dao;

import java.lang.reflect.ParameterizedType;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

/**
 * Através do InjectionPoint conseguimos acessar, via Reflection a classe do
 * tipo genérico passado no ponto de injeção
 * 
 * @author Thiago Alves
 *
 */
public class DaoFactory {

	// ---------------------------------------------------------------------------------------------
	@Produces
	public <T> Dao<T> createDao(InjectionPoint injectionPoint) {
		ParameterizedType type = (ParameterizedType) injectionPoint.getType();

		@SuppressWarnings("rawtypes")
		Class classe = (Class) type.getActualTypeArguments()[0];
		return new Dao(classe);
	}
	// ---------------------------------------------------------------------------------------------
}
