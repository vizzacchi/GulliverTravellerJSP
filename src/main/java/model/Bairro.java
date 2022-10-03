package model;

public class Bairro {
	
	private int id;
	private String bairro;
	private Cidade cidade;
	
	@Override
	public String toString() {
		return ", Bairro= " + bairro + ", \n" + cidade;
	}
	
	//CONSTRUTOR VAZIO
	public Bairro() {
		super();
	}
	
	//CONSTRUTOR
	public Bairro(int id, String bairro, Cidade cidade) {
		super();
		this.id = id;
		this.bairro = bairro;
		this.cidade = cidade;
	}
	
	//GETTERS AND SETTERS
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
}