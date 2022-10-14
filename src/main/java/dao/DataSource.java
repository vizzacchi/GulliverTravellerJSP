package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataSource {
	
	private Connection connection;
		
	private static final String hostName = "gulliver.mysql.dbaas.com.br";
	private static final String usuario = "gulliver";
	private static final String senha = "Fiap@2022";
	private static final String url = "jdbc:mysql://"+hostName+":3306/gulliver";
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	
	//Conectar o banco
	public DataSource(){
		try {
			//Registrar o DRIVER
			Class.forName(DRIVER);
			//Capturar a conexao
			
			connection = DriverManager.getConnection(url,usuario,senha);
			if(connection != null) {
				System.out.println("Conectado com Sucesso");
			}
			else {
				System.out.println("Erro ao conectar");
			}
		}
		catch(Exception ex){
			System.out.println("Erro ao conectar com SGDB. Erro: " + ex.getMessage());
		}	
	}
	public Connection getConnection() {
		return connection;
	}
}