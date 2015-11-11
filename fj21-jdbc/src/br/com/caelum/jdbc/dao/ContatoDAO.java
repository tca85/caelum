package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.modelo.Contato;

/**
 * Data Access Object Também pode ser considerado um Java Bean, porque é uma
 * classe com construtor e métodos getters & setters obs: Java Bean não é EJB
 * (Enterprise Java Beans)
 * 
 * @author web5440
 *
 */
public class ContatoDAO {

	private Connection connection;

	public ContatoDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	/**
	 * Adicionar contato
	 * 
	 * @param contato
	 */
	public void adiciona(Contato contato) {
		String sql = "insert into contatos (nome, email, endereco, dataNascimento) values(?,?,?,?)";

		try {
			// Interface PreparedStatement xxx = new
			// ConnectionFactory().getConnection().prepareStatement(sql);
			// Fazendo com referência à interface, faz com que não fixe para
			// nenhum banco
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	/**
	 * Retorna a lista de contatos
	 */
	public List<Contato> getLista() {
		try {

			List<Contato> contatos = new ArrayList<Contato>();

			PreparedStatement stmt = this.connection.prepareStatement("select * from contatos");

			ResultSet rs = stmt.executeQuery();

			// retona um boolean = true enquanto houver registros
			while (rs.next()) {
				Contato contato = new Contato();

				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));

				Calendar data = Calendar.getInstance();
				
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);
				contatos.add(contato);
			}

			rs.close();
			stmt.close();
			return contatos;

		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	
	/**
	 * Pesquisar um contato de acordo com o id
	 * obs por boa prática, é melhor passar o objeto Contato
	 * mesmo que utilize só o id dele
	 * @param id
	 * @return
	 */
	public Contato pesquisar(Contato c){
		try {
			List<Contato> contatos = new ArrayList<Contato>();
			
			String sql = "select * from contatos where id = ?";

			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			stmt.setLong(1, c.getId());

			ResultSet rs = stmt.executeQuery();
			
			Contato contato = new Contato();
			
			if (rs.next()) {
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));

				Calendar data = Calendar.getInstance();
				
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);
				contatos.add(contato);
			}
			
			rs.close();
			stmt.close();
			
//			if (contato == null) {
//				throw new Exception("fdsfsdafdsa");
//			}
			
			
			return contato;
			
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	
	/**
	 * Alterar contato
	 * @param contato
	 */
	public void altera(Contato contato){
		String sql = "update contatos set nome=?, email=?, endereco=?, dataNascimento=? where id=?";
		
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			stmt.setLong(5, contato.getId());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	
	/**
	 * Remove
	 * @param contato
	 */
	public void remove(Contato contato){
		String sql = "delete from contatos where id=?";
		
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			stmt.setLong(1, contato.getId());
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
}
