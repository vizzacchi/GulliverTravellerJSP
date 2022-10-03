package model;

public class LocadoraCarro extends Ponto {
	
	private Carro carro;

	//CONSTRUTOR VAZIO
	public LocadoraCarro() {
		super();
	}
	
	//CONSTRUTOR
	public LocadoraCarro(int id, String nome, String site, String fotoPerfil, String descricao, Endereco endereco,
			int numero, String complemento, Telefone telefone, Foto fotos, FaixaPreco faixaPreco, Avaliacao avaliacao,
			Destino destino, Carro carro) {
		super(id, nome, site, fotoPerfil, descricao, endereco, numero, complemento, telefone, fotos, faixaPreco,
				avaliacao, destino);
		this.carro = carro;
	}
	
	//GETTERS AND SETTERS
	public Carro getCarro() {
		return carro;
	}
	public void setCarro(Carro carro) {
		this.carro = carro;
	}
	@Override
	public String toString() {
		return "AluguelCarro [carro=" + carro + "]";
	}	
}