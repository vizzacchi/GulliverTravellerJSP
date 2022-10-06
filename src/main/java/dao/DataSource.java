package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataSource {
		
	private static final String hostName = "gulliver.mysql.dbaas.com.br";
	private static final String usuario = "gulliver";
	private static final String senha = "Fiap@2022";
	private static final String url = "jdbc:mysql://"+hostName+":3306/gulliver";
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	
	//Conectar o banco
	public Connection getDatasource(){
		try {
			//Registrar o DRIVER
			Class.forName(DRIVER);
			//Capturar a conexao
			
			Connection  conn = DriverManager.getConnection(url,usuario,senha);
			if(conn != null) {
				System.out.println("Conectado com Sucesso");
				return conn;
			}
			else {
				System.out.println("Erro ao conectar");
			}
		}
		catch(Exception ex){
			System.out.println("Erro ao conectar com SGDB. Erro: " + ex.getMessage());
		}
		return null;
		
	}
}