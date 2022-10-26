package controller;

import java.util.ArrayList;

import dao.DataSource;
import dao.ParqueDao;
import model.Parque;

public class ListarParque {
	ArrayList<Parque> parque = (ArrayList<Parque>) this.listarParques();
	
	public ArrayList<Parque> listarParques() {
		DataSource dataSource = new DataSource();
		ParqueDao parqueDao = new ParqueDao(dataSource);
		
		return (ArrayList<Parque>)parqueDao.read();
	}
}
