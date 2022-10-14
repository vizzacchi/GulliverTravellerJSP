package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Endereco;
import model.LocadoraCarro;
import model.Telefone;

public class LocadoraCarroDao implements DaoBase<LocadoraCarro> {

	private DataSource dataSource;
	
	public LocadoraCarroDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public DataSource getDataSource() {
		return dataSource;
	}

	@Override
	public void create(LocadoraCarro object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<LocadoraCarro> read() {
		try {
			
			List<LocadoraCarro> locadora = new ArrayList<LocadoraCarro>();
			String sql = "SELECT DISTINCT "
							+ "TP.ID, "
							+ "TP.NOME, "
							+ "TP.SITE, "
							+ "TP.FOTO_PERFIL, "
							+ "CONCAT(TE.LOGRADOURO, ', ', TP.NUMERO, ' - ', TB.BAIRRO, ', ', TC.CIDADE, ' - ', TU.UF, ', ', TE.CEP) AS ENDERECO, "
							+ "TL.NUMERO "
					    + "FROM tb_ponto TP "
							+ "LEFT JOIN tb_telefone TL ON TL.ID = TP.ID_TELEFONE "
							+ "JOIN tb_endereco TE ON TE.ID = TP.ID_ENDERECO "
							+ "JOIN tb_bairro TB ON TB.ID = TE.ID_BAIRRO "
							+ "JOIN tb_cidade TC ON TC.ID = TB.ID_CIDADE "
							+ "JOIN tb_uf TU ON TU.ID = TC.ID_UF "
						+ "WHERE TP.ID_CATEGORIA = 1 "
						+ "ORDER BY TP.NOME ASC";
	
	PreparedStatement stm = dataSource.getConnection().prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()) {
				LocadoraCarro carro = new LocadoraCarro();
				carro.setId(rs.getInt("ID"));
				carro.setNome(rs.getString("NOME"));
				carro.setSite(rs.getString("SITE"));
				carro.setFotoPerfil(rs.getString("FOTO_PERFIL"));
				
				//ENDEREÇO				
				Endereco endereco = new Endereco(sql);
				endereco.setLogradouro(rs.getString("ENDERECO"));
				carro.setEndereco(endereco);
				
				//TELEFONE
				Telefone telefone = new Telefone();
				telefone.setTelefone(rs.getString("NUMERO"));
				carro.setTelefone(telefone);
								
				locadora.add(carro);
			}			
			return locadora;
			
		} catch (Exception e) {
			System.out.println("Erro ao listar Locadoras de Carros " + e.getMessage());
			return null;
		}		
	}

	@Override
	public void update(LocadoraCarro object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(LocadoraCarro object) {
		// TODO Auto-generated method stub
		
	}
}