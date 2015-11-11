package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.com.caelum.jdbc.dao.DAOException;

/**
 * Classe utilizando o Design Pattern Factory
 * @author Thiago Alves
 *
 */
public class ConnectionFactory {

	/**
	 * Método getConnection
	 * @return
	 */
	public Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost/fj21", "root", "");

		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
}
