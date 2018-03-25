package br.com.evolucao.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	private static final String user = "root";
	private static final String password = "root";
	private static final String url = "jdbc:mysql://localhost/evolucao";
	
	private static Connection connection = null;
	
	private ConnectionFactory() {}

	public static Connection getConnection() {
		try {
			if (connection == null || connection.isClosed()) {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection(url, user, password);
			}
		} catch (Exception e) {
			throw new IllegalArgumentException("Erro ao pegar Conexão com o Banco de Dados!");
		}
		
		return connection;
	}
	
}
