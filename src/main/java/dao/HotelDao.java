package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Endereco;
import model.Hotel;
import model.Telefone;

public class HotelDao implements DaoBase<Hotel> {
	
	private DataSource dataSource;
	
	public HotelDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public DataSource getDataSource() {
		return dataSource;
	}

	@Override
	public void create(Hotel object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Hotel> read() {
		try {
			
			List<Hotel> resultado = new ArrayList<Hotel>();
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
						+ "WHERE TP.ID_CATEGORIA = 6 "
						+ "ORDER BY TP.NOME ASC";
			
			PreparedStatement stm = dataSource.getConnection().prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()) {
				Hotel hotel = new Hotel();
				hotel.setId(rs.getInt("ID"));
				hotel.setNome(rs.getString("NOME"));
				hotel.setSite(rs.getString("SITE"));
				hotel.setFotoPerfil(rs.getString("FOTO_PERFIL"));
				
				//ENDEREÇO				
				Endereco endereco = new Endereco(sql);
				endereco.setLogradouro(rs.getString("ENDERECO"));
				hotel.setEndereco(endereco);
				
				//TELEFONE
				Telefone telefone = new Telefone();
				telefone.setTelefone(rs.getString("NUMERO"));
				hotel.setTelefone(telefone);
				
				resultado.add(hotel);
			}			
			return resultado;
			
		} catch (Exception e) {
			System.out.println("Erro ao listar Hotéis " + e.getMessage());
			return null;
		}
	}

	@Override
	public void update(Hotel object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Hotel object) {
		// TODO Auto-generated method stub
		
	}
}