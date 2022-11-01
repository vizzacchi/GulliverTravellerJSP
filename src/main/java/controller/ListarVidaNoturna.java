package controller;

import java.util.ArrayList;

import dao.DataSource;
import dao.VidaNoturnaDao;
import model.VidaNoturna;

public class ListarVidaNoturna {
			
	ArrayList<VidaNoturna> vidaNoturna = (ArrayList<VidaNoturna>) this.listarVidaNoturna();
	
	public ArrayList<VidaNoturna> listarVidaNoturna() {
		DataSource dataSource = new DataSource();
		VidaNoturnaDao vidaNoturnaDao = new VidaNoturnaDao(dataSource);
		
		return (ArrayList<VidaNoturna>)vidaNoturnaDao.read();
	}
}