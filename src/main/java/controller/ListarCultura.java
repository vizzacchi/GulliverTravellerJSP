package controller;

import java.util.ArrayList;

import dao.DataSource;
import dao.CulturaDao;
import model.Cultura;

public class ListarCultura {
			
	ArrayList<Cultura> cultura = (ArrayList<Cultura>) this.listarCultura();
	
	public ArrayList<Cultura> listarCultura() {
		DataSource dataSource = new DataSource();
		CulturaDao culturaDao = new CulturaDao(dataSource);
		
		return (ArrayList<Cultura>)culturaDao.read();
	}
}