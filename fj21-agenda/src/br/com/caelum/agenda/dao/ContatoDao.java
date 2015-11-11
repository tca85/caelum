package br.com.caelum.agenda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.agenda.ConnectionFactory;
import br.com.caelum.agenda.modelo.Contato;

/**
 * Data Acess Object
 * @author Thiago Alves
 *
 */
@SuppressWarnings("unused")
public class ContatoDao {
	private Connection connection;

	/**
	 * DI - Injeção de dependência, porque a conexão é criada dentro da FiltroConexao
	 * de forma que o DAO só existe se houver conexão
	 * @param connection
	 */
	public ContatoDao(Connection connection) {
		this.connection = connection;
	}

	/**
	 * Adiciona um contato novo
	 * @param contato
	 */
	public void adiciona(Contato contato) {
		try {
			String sql = "insert into contatos (nome, email, endereco, dataNascimento) values (?,?,?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Procura um contato, de acordo com o ID
	 * @param c
	 * @return
	 */
	public Contato getContato(Contato c){
		try {
			Contato contato = new Contato();
			PreparedStatement stmt = this.connection.prepareStatement("select * from contatos where id =?");

			stmt.setLong(1, c.getId());
			
			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {
				//popula o objeto contato
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));

				//popula a data de nascimento do contato, fazendo a conversao
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);
			}
			
			rs.close();
			stmt.close();

			return contato;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Retorna uma lista de contatos
	 * @return
	 */
	public List<Contato> getLista() {
		try {
			List<Contato> contatos = new ArrayList<Contato>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from contatos");

			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {
				Contato contato = new Contato();
				//popula o objeto contato
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));

				//popula a data de nascimento do contato, fazendo a conversao
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);

				//adiciona o contato na lista
				contatos.add(contato);
			}

			rs.close();
			stmt.close();

			return contatos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Exclui um contato, de acordo com o ID
	 * @param contato
	 */
	public void exclui(Contato contato) {
		String sql = "delete from contatos where id=?";
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setLong(1, contato.getId());
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Atualiza o contato
	 * @param contato
	 */
	public void atualiza(Contato contato) {
		String sql = "update contatos set nome = ?, email = ?, endereco = ?, dataNascimento = ? where id = ?";
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new java.sql.Date(contato.getDataNascimento().getTimeInMillis()));
			stmt.setLong(5, contato.getId());

			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
