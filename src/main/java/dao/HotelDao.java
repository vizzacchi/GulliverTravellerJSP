package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import model.Hotel;

public class HotelDao implements DaoBase<Hotel> {
	
	private DataSource dataSource;
	
	//public UsuarioDao(DataSource)

	@Override
	public void create(Hotel object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Hotel> read() {
		return null;
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