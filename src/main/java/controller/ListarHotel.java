package controller;

import java.util.ArrayList;

import dao.DataSource;
import dao.HotelDao;
import model.Hotel;

public class ListarHotel {
			
	ArrayList<Hotel> hotel = (ArrayList<Hotel>) this.listarHoteis();
	
	public ArrayList<Hotel> listarHoteis() {
		DataSource dataSource = new DataSource();
		HotelDao hotelDao = new HotelDao(dataSource);
		
		return (ArrayList<Hotel>)hotelDao.read();
	}
}