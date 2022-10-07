package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Hotel;

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
	public ArrayList<Hotel> read() {
		try {
			System.out.println("Antes Lista Hotel");
			ArrayList<Hotel> resultado = new ArrayList<Hotel>();
			//Comando em SQL
			String sql = "Select * from tb_hotel";
			//Receita de bolo vai ser sempre assim
			PreparedStatement stm = dataSource.getDatasource().prepareStatement(sql);

			//Para executar o comando
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()) {
				System.out.println("Dentro do While");
				//para ler o resultSet 
				Hotel hotel = new Hotel();
				hotel.setId(rs.getInt("ID"));
				hotel.setNome(rs.getString("NOME"));
				hotel.setSite(rs.getString("SITE"));
				hotel.setFotoPerfil(rs.getString("FOTOPERFIL"));
				hotel.setDescricao(rs.getString("DESCRICAO"));
				hotel.setNumero(rs.getInt("NUMERO"));
				hotel.setAvaliacao(null);
				hotel.setComplemento(null);
				hotel.setDestino(null);
				hotel.setFaixaPreco(null);
				hotel.setEndereco(null);
				hotel.setFotos(null);
				hotel.setMelhorDia(null);
				hotel.setTelefone(null);
				
				resultado.add(hotel);
			}
			return resultado;
		}
		catch(Exception ex){
			ex.printStackTrace();
			System.out.println("UFDAO.GETUFTESTE = " + ex.getMessage());
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