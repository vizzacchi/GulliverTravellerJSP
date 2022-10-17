package model;

public class Cidade {
	
	private int id;
	private String cidade;
	private Uf uf;
	
	@Override
	public String toString() {
		return cidade + " - " + uf;
	}
	
	//CONSTRUTOR VAZIO
	public Cidade() {
		super();
	}
	
	//CONSTRUTOR
	public Cidade(int id, String cidade, Uf uf) {
		super();
		this.id = id;
		this.cidade = cidade;
		this.uf = uf;
	}
	
	//GETTERS AND SETTERS
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public Uf getUf() {
		return uf;
	}
	public void setUf(Uf uf) {
		this.uf = uf;
	}	
}