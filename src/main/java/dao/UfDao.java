package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import model.Uf;

public class UfDao implements DaoBase<Uf>{
	
	private DataSource dataSource;
	
	public UfDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public DataSource getDataSource() {
		return dataSource;
	}

	@Override
	public void create(Uf object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Uf> read() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Uf object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Uf object) {
		// TODO Auto-generated method stub
		
	}
	public Uf getUfTeste() {
		try {
			//Comando em SQL
			String sql = "Select id, uf, descricao from uf where id=1";
			//Receita de bolo vai ser sempre assim
			PreparedStatement stm = dataSource.getDatasource().prepareStatement(sql);

			//Para executar o comando
			ResultSet rs = stm.executeQuery();
			if(rs.next()) {
				//para ler o resultSet 
				Uf uf = new Uf();
				uf.setId(rs.getInt("id"));
				uf.setUf(rs.getString("uf"));
				uf.setDescricao(rs.getString("descricao"));
				
				return uf;
			}
			else {
				return null;
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
			System.out.println("UFDAO.GETUFTESTE = " + ex.getMessage());
			return null;
		}
	}
}
