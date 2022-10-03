package model;

public class Hotel extends Ponto {
	
	private String melhorDia;
	
	@Override
	public String toString() {
		return super.toString() + "Hospedagem [melhorDia=" + melhorDia + "]";
	}
	
	//CONSTRUTOR VAZIO
	public Hotel() {
		super();
	}
	
	//CONSTRUTOR
	public Hotel(int id, String nome, String site, String fotoPerfil, String descricao, Endereco endereco,
			int numero, String complemento, Telefone telefone, Foto fotos, FaixaPreco faixaPreco, Avaliacao avaliacao,
			Destino destino, String melhorDia) {
		super(id, nome, site, fotoPerfil, descricao, endereco, numero, complemento, telefone, fotos, faixaPreco,
				avaliacao, destino);
		this.melhorDia = melhorDia;
	}
	
	//GETTERS AND SETTERS
	public void setMelhorDia(String melhorDia) {
		this.melhorDia = melhorDia;
	}
	public String getMelhorDia() {
		return melhorDia;
	}
}