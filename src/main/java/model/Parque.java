package model;

import java.util.ArrayList;

public class Parque extends Ponto {
	
	private String melhorDia;
	
	@Override
	public String toString() {
		return "Parque [melhorDia=" + melhorDia + "]";
	}
	
	//CONSTRUTOR VAZIO
	public Parque() {
		super();
	}
	
	//CONSTRUTOR
	public Parque(int id, String nome, String site, String fotoPerfil, String descricao, Endereco endereco, int numero,
			String complemento, Telefone telefone, ArrayList<Foto> fotos, FaixaPreco faixaPreco, Avaliacao avaliacao,
			Destino destino, String melhorDia) {
		super(id, nome, site, fotoPerfil, descricao, endereco, numero, complemento, telefone, fotos, faixaPreco,
				avaliacao, destino);
		this.melhorDia = melhorDia;
	}

	//GETTERS AND SETTERS
	public String getMelhorDia() {
		return melhorDia;
	}
	public void setMelhorDia(String melhorDia) {
		this.melhorDia = melhorDia;
	}
}