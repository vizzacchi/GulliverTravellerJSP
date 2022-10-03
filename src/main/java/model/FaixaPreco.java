package model;

public class FaixaPreco {
	
	private int id;
	private int faixa;
	private String descricao;
	
	@Override
	public String toString() {
		return "FaixaPreco [id=" + id + ", faixa=" + faixa + ", descricao=" + descricao + "]";
	}
	
	//CONSTRUTOR VAZIO
	public FaixaPreco() {
		super();
	}
	
	//CONSTRUTOR
	public FaixaPreco(int id, int faixa, String descricao) {
		super();
		this.id = id;
		this.faixa = faixa;
		this.descricao = descricao;
	}
		
	//GETTERS AND SETTERS
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFaixa() {
		return faixa;
	}
	public void setFaixa(int faixa) {
		this.faixa = faixa;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}	
}