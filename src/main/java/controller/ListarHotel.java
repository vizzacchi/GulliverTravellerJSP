package controller;

import java.util.ArrayList;

import dao.DataSource;
import dao.HotelDao;
import model.Hotel;

public class ListarHotel {

	private ArrayList<Hotel> lista;
	
	public ArrayList<Hotel> ListarHotel() {
		System.out.println("Passou Aqui");
		//LISTA OS HOTÉIS
		lista = new ArrayList<Hotel>();
		System.out.println("Após Lista");
		DataSource dataSource = new DataSource();
		HotelDao hotelDao = new HotelDao(dataSource);
		
		return (ArrayList<Hotel>)hotelDao.read();
	}
	
	public ArrayList<Hotel> getLista() {
		return lista;
	}
	
	public void setLista(ArrayList<Hotel> lista) {
		this.lista = lista;
	}
}