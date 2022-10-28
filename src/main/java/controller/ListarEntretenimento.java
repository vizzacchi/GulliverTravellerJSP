package controller;

import java.util.ArrayList;

import dao.DataSource;
import dao.EntretenimentoDao;
import model.Entretenimento;

public class ListarEntretenimento {
			
	ArrayList<Entretenimento> entretenimento = (ArrayList<Entretenimento>) this.listarEntretenimento();
	
	public ArrayList<Entretenimento> listarEntretenimento() {
		DataSource dataSource = new DataSource();
		EntretenimentoDao entretenimentoDao = new EntretenimentoDao(dataSource);
		
		return (ArrayList<Entretenimento>)entretenimentoDao.read();
	}
}