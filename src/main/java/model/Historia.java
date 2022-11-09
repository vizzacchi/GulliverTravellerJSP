package model;

import java.util.ArrayList;

public class Historia extends Ponto {
	
	private String melhorDia;
	private Roteiro roteiro;
	
	@Override
	public String toString() {
		return "PontoHistorico [melhorDia=" + melhorDia + ", roteiro=" + roteiro + "]";
	}
	
	//CONSTRUTOR VAZIO
	public Historia() {
		super();
	}
	
	//CONSTRUTOR
	public Historia(int id, String nome, String site, String fotoPerfil, String descricao, Endereco endereco,
			int numero, String complemento, Telefone telefone, ArrayList<Foto> fotos, FaixaPreco faixaPreco, Avaliacao avaliacao,
			Destino destino, String melhorDia, Roteiro roteiro) {
		super(id, nome, site, fotoPerfil, descricao, endereco, numero, complemento, telefone, fotos, faixaPreco,
				avaliacao, destino);
		this.melhorDia = melhorDia;
		this.roteiro = roteiro;
	}

	//GETTERS AND SETTERS
	public String getMelhorDia() {
		return melhorDia;
	}
	public void setMelhorDia(String melhorDia) {
		this.melhorDia = melhorDia;
	}
	public Roteiro getRoteiro() {
		return roteiro;
	}
	public void setRoteiro(Roteiro roteiro) {
		this.roteiro = roteiro;
	}
}