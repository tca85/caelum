package br.com.caelum.notasfiscais.tx;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.interceptor.InterceptorBinding;

/**
 * Interface que representa a anotation customizada que estamos criando, @Transactional
 * 
 * @author Thiago Alves - 21.10.2015
 *
 */
@InterceptorBinding
@Target({ElementType.TYPE, ElementType.METHOD}) // pode ser usado em classes e métodos
@Retention(RetentionPolicy.RUNTIME)
public @interface Transactional { }