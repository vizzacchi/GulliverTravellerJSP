package model;

public class Roteiro {
	private int id; 
	private Foto fotos;
	private String descricao;
	private int duracao;
	
	@Override
	public String toString() {
		return "Roteiro [id=" + id + ", fotos=" + fotos + ", descricao=" + descricao + ", duracao=" + duracao + "]";
	}
	
	//CONSTRUTOR VAZIO
	public Roteiro() {
		super();
	}
	
	//CONSTRUTOR
	public Roteiro(int id, Foto fotos, String descricao, int duracao) {
		super();
		this.id = id;
		this.fotos = fotos;
		this.descricao = descricao;
		this.duracao = duracao;
	}
	
	//GETTERS AND SETTERS
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Foto getFotos() {
		return fotos;
	}
	public void setFotos(Foto fotos) {
		this.fotos = fotos;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getDuracao() {
		return duracao;
	}
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}	
}