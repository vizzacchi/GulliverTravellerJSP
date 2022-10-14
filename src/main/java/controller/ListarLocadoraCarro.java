package controller;

import java.util.ArrayList;

import dao.DataSource;
import dao.LocadoraCarroDao;
import model.LocadoraCarro;

public class ListarLocadoraCarro {

	ArrayList<LocadoraCarro> locadora = (ArrayList<LocadoraCarro>) this.listarLocadoraCarro();
	
	public ArrayList<LocadoraCarro> listarLocadoraCarro() {
		DataSource dataSource = new DataSource();
		LocadoraCarroDao locadoraCarroDao = new LocadoraCarroDao(dataSource);
		
		return (ArrayList<LocadoraCarro>)locadoraCarroDao.read();
	}
}