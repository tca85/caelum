package br.com.caelum.agenda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	/**
	 * Retorna a conexão com o MySQL
	 * @return
	 * @throws SQLException
	 */
	public Connection getConnection() throws SQLException {
		System.out.println("ConnectionFactory foi chamada...");

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new SQLException(e);
		}
		return DriverManager.getConnection("jdbc:mysql://localhost/fj21", "root", "");
	}
}