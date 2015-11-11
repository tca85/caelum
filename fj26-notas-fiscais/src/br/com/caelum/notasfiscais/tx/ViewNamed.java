package br.com.caelum.notasfiscais.tx;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.enterprise.inject.Stereotype;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 * Stereotype do CDI - Pode ter todas anotations que utilizaremos na classe
 *                     serve para facilitar a manutenção
 * 
 * @ViewScoped - serve para guardar os dados na tela para que não sejam perdidos
 *             ao adicionar um novo item. Eles são gravados na sessão do
 *             usuário, e são eliminados ao sair da tela (mudar de aba por
 *             exemplo) javax.faces.view.ViewScoped --- só funciona com CDI, JSF
 *             puro não tem
 * 
 * @author Thiago Alves
 *
 */
@Stereotype
@ViewScoped
@Named
@Transactional
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ViewNamed { }
