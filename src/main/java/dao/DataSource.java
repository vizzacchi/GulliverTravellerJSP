package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataSource {
	
	private Connection connection;
	
	private String url;
	private String hostName;
	private String usuario;
	private String senha;
	private int porta;
	private String banco;
	
	public DataSource() {
		try {
			
			hostName = "localhost";
			usuario = "root";
			senha = "";
			banco = "gulliver_traveller";
			
			url = "";
			
			//DriverManager.registerDriver(new );
			
			connection = DriverManager.getConnection(url,usuario,senha);
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