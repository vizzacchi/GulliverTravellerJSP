package model;

public class Uf {
	
	private int id;
	private String uf;
	private String descricao;
	
	@Override
	public String toString() {
		return descricao;
	}
	
	//CONSTRUTOR VAZIO
	public Uf() {
		super();
	}
	
	//CONSTRUTOR
	public Uf(int id, String uf, String descricao) {
		super();
		this.id = id;
		this.uf = uf;
		this.descricao = descricao;
	}
	
	//GETTERS AND SETTERS
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}	
}