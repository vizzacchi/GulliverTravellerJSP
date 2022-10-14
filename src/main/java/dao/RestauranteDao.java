package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Endereco;
import model.Restaurante;
import model.Telefone;

public class RestauranteDao implements DaoBase<Restaurante> {
	
	private DataSource dataSource;
	
	public RestauranteDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void create(Restaurante object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Restaurante> read() {
		try {
			
			List<Restaurante> resultado = new ArrayList<Restaurante>();
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
						+ "WHERE TP.ID_CATEGORIA = 4 "
						+ "ORDER BY TP.NOME ASC";
			
			PreparedStatement stm = dataSource.getConnection().prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()) {
				Restaurante restaurante = new Restaurante();
				restaurante.setId(rs.getInt("ID"));
				restaurante.setNome(rs.getString("NOME"));
				restaurante.setSite(rs.getString("SITE"));
				restaurante.setFotoPerfil(rs.getString("FOTO_PERFIL"));
				
				//ENDEREÇO				
				Endereco endereco = new Endereco(sql);
				endereco.setLogradouro(rs.getString("ENDERECO"));
				restaurante.setEndereco(endereco);
				
				//TELEFONE
				Telefone telefone = new Telefone();
				telefone.setTelefone(rs.getString("NUMERO"));
				restaurante.setTelefone(telefone);
				
				resultado.add(restaurante);
			}			
			return resultado;
			
		} catch (Exception e) {
			System.out.println("Erro ao listar Restaurantes " + e.getMessage());
			return null;
		}
	}

	@Override
	public void update(Restaurante object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Restaurante object) {
		// TODO Auto-generated method stub
		
	}
}