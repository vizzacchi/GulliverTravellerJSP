package controller;

import java.util.ArrayList;

import dao.DataSource;
import dao.AvaliacaoDao;
import model.Avaliacao;

public class ListarAvaliacao {
	ArrayList<Avaliacao> avaliacao = (ArrayList<Avaliacao>) this.listarAvaliacoes();
	
	public ArrayList<Avaliacao> listarAvaliacoes() {
		DataSource dataSource = new DataSource();
		AvaliacaoDao avaliacaoDao = new AvaliacaoDao(dataSource);
		
		return (ArrayList<Avaliacao>)avaliacaoDao.read();
	}
}
