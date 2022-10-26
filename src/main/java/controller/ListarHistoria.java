package controller;

import java.util.ArrayList;

import dao.DataSource;
import dao.HistoriaDao;
import model.Historia;

public class ListarHistoria {
	ArrayList<Historia> historia = (ArrayList<Historia>) this.listarHistorias();
	
	public ArrayList<Historia> listarHistorias() {
		DataSource dataSource = new DataSource();
		HistoriaDao historiaDao = new HistoriaDao(dataSource);
		
		return (ArrayList<Historia>)historiaDao.read();
	}
}
