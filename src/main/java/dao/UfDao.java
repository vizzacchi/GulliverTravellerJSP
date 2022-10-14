package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Uf;

public class UfDao implements DaoBase<Uf>{
	
	private DataSource dataSource;
	
	public UfDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public DataSource getDataSource() {
		return this.getDataSource();
	}
	
	//Inserindo Registro
	@Override
	public void create(Uf object) {
		try {
		//declaro a String SQL correspondente ao comando
		//substituindo os valores pelo caractere "?"
		String SQL = "INSERT INTO `tb_uf` (`ID`, `UF`, `DESCRICAO`) VALUES (null, ?, ?);";
		//gero um Statement a partir da String
		PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL);
			stm.setString(1, object.getUf());
			stm.setString(2, object.getDescricao());
			//executo a operação de atualização da tabela
			int res = stm.executeUpdate();
			//se deu certo, a variavel RES retorna != 0
			if (res!=0) {
				System.out.println("Usuario incluido com sucesso");
			}else {
				throw new RuntimeException("Erro ao incluir o usuário");
			}
		} catch (SQLException ex) {
			System.out.println("UfDao.INSERT =" + ex.getMessage());
		}
	}
	//Apagando Registro
	@Override
	public void delete(Uf object){
		try {
			//declaro a String SQL correspondente ao comando
			//substituindo os valores pelo caractere "?"
			String SQL = "DELETE FROM `tb_uf` WHERE `tb_uf`.`ID` = ?;";
			//gero um Statement a partir da String
			PreparedStatement stm =  dataSource.getConnection().prepareStatement(SQL);
				stm.setInt(1, object.getId());

				//executo a operação de atualização da tabela
				int res = stm.executeUpdate();
				//se deu certo, a variavel RES retorna != 0
				if (res!=0) {
					System.out.println("Uf deletado com sucesso");
				}else {
					throw new RuntimeException("Erro ao deletar o uf");
				}
		}
		catch(Exception ex){
			System.out.println("UfDao.DELETE = " + ex.getMessage());
		}
		
	}
	//Método READ
	@Override
	public Uf read(Uf object) {
		try {
			//declaro a String SQL correspondente ao comando
			//substituindo os valores pelo caractere "?"
			String SQL = "Select * from tb_uf where ID = ?;";
			//gero um Statement a partir da String
			PreparedStatement stm =  dataSource.getConnection().prepareStatement(SQL);
				stm.setInt(1, object.getId());

				//Aqui o resultado é guardado em um objeto ResultSet
				ResultSet rs = stm.executeQuery();
				//o método next() indica se há registro no resultado 
				// se houver, preenche o objeto
				if (rs.next()) {
					Uf uf = new Uf();
					uf.setId(rs.getInt("ID"));
					uf.setUf(rs.getString("UF"));
					uf.setDescricao(rs.getString("DESCRICAO"));
					return uf;
				}else {
					return null;
				}
		}
		catch(Exception ex){
			System.out.println("UfDao.READ = " + ex.getMessage());
		}
		return null;
	}

	//método Update
	@Override
	public void update(Uf object) {
		try {
			//declaro a String SQL correspondente ao comando
			//substituindo os valores pelo caractere "?"
			String SQL = "UPDATE `tb_uf` "
					+ "SET `UF` = ? "
					+ "SET `DESCRICAO` = ? "
					+ "WHERE `tb_uf`.`ID` = ?;";
			//gero um Statement a partir da String
			PreparedStatement stm =  dataSource.getConnection().prepareStatement(SQL);
				stm.setString(1, object.getUf());
				stm.setString(1, object.getDescricao());
				stm.setInt(1, object.getId());

				//executo a operação de atualização da tabela
				int res = stm.executeUpdate();
				//se deu certo, a variavel RES retorna != 0
				if (res!=0) {
					System.out.println("UF alterado com sucesso");
				}else {
					throw new RuntimeException("Erro ao alterar uf");
				}
		}
		catch(Exception ex){
			System.out.println("UfDao.UPDATE = " + ex.getMessage());
		}
		
		
	}	
}
