package br.com.caelum.tarefas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * obs: essa classe não é mais necessária
 * 
 * @author web5440
 *
 */
public class ConnectionFactory {

	public Connection getConnection() throws SQLException {
		System.out.println("ConnectionFactory...");

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new SQLException(e);
		}

		return DriverManager.getConnection("jdbc:mysql://localhost/fj21", "root", "");
	}
}