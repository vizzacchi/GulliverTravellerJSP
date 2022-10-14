package controller;

import java.util.ArrayList;

import dao.DataSource;
import dao.RestauranteDao;
import model.Restaurante;

public class ListarRestaurante {
	
	ArrayList<Restaurante> restaurante = (ArrayList<Restaurante>) this.listarRestaurante();
	
	public ArrayList<Restaurante> listarRestaurante() {
		DataSource dataSource = new DataSource();
		RestauranteDao restaurantelDao = new RestauranteDao(dataSource);
		
		return (ArrayList<Restaurante>)restaurantelDao.read();
	}
}