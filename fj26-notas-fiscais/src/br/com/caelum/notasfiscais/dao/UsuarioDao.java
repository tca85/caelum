package br.com.caelum.notasfiscais.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import br.com.caelum.notasfiscais.modelo.Usuario;
import br.com.caelum.notasfiscais.util.JPAUtil;

/**
 * O Weld (CDI do JSF) exige que implemente Serializable
 * @author Thiago Alves - 16.10.2015
 *
 */
public class UsuarioDao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	//---------------------------------------------------------------------------------------------
	public boolean existe(Usuario usuario) {
		String jpql = "select u from Usuario u "
                     + "where u.login = :pLogin "
                     + "  and u.senha = :pSenha";
		
		manager = new JPAUtil().getEntityManager();

		Query query = manager.createQuery(jpql)
				             .setParameter("pLogin", usuario.getLogin())
				             .setParameter("pSenha", usuario.getSenha());

		boolean encontrado = !query.getResultList().isEmpty();

		return encontrado;
	}
	//---------------------------------------------------------------------------------------------
	public void adiciona(Usuario usuario) {
		manager.persist(usuario);
	}
	//---------------------------------------------------------------------------------------------
	public void atualiza(Usuario usuario) {
		manager.merge(usuario);
	}
	//---------------------------------------------------------------------------------------------
	public void remove(Usuario usuario) {
		manager.remove(manager.merge(usuario));
	}
	//---------------------------------------------------------------------------------------------

	public List<Usuario> listaTodos(){
		CriteriaQuery<Usuario> query = manager.getCriteriaBuilder()
                                              .createQuery(Usuario.class);

        query.select(query.from(Usuario.class));

        List<Usuario> lista = manager.createQuery(query)
                                     .getResultList();

        return lista;
	}
	//---------------------------------------------------------------------------------------------
}