package br.com.caelum.financas.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * 
 * @author Thiago Alves
 * 
 * javax.persistence.Entity = especificação da JPA
 * 
 * 28.09.2015
 *
 */
@Entity                                               // a classe sera gerenciada pela JPA
//@Table(name="tabelameuovo")
@DynamicUpdate                                        // atualiza só os campos que quero, não todos
@DynamicInsert                                        // insere só os campos que foram preenchidos
public class Conta {
	@Id                                               // primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY) // estratégia para implementar a chave = auto incremento
	private Integer id;                               // melhor usar o Integer do que o int
	
	// obs: de acordo com a convenção (Convention over Configuration)
	// não é necessário inserir anotações em todos atributos, 
	// o JPA identica que serão campos na tabela
	
	private String titular;
	private String banco;
	private String agencia;
	private String numero;
	
	// atalho: CTRL + 3 g g a s (getters & setters)
	
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitular() {
		return titular;
	}
	public String getBanco() {
		return banco;
	}
	public String getAgencia() {
		return agencia;
	}
	public String getNumero() {
		return numero;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}
	public void setBanco(String banco) {
		this.banco = banco;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
}