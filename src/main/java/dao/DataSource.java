package dao;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.cj.jdbc.Driver;

public class DataSource {
	
	private Connection connection;
	
	private String url;
	private String usuario;
	private String senha;
	private int porta;
		
	public DataSource() {
		try {
			DriverManager.registerDriver(new Driver());			
			connection = DriverManager.getConnection("jdbc:mysql://gulliver.mysql.dbaas.com.br:3306/gulliver","gulliver","Fiap@2022");
			
			if (connection != null) {
				System.out.println("Conectado com sucesso!");
			} else {
				System.out.println("Erro ao conectar");
			}
		} catch (Exception ex) {
			System.out.println("Erro ao conectar com o SGBD. Erro: " + ex.getMessage());
		}
	}

	public Connection getConnection() {
		return connection;
	}	
}