package model;

public class Culinaria {
	
	private int id;
	private String tipoCulinaria;
	
	@Override
	public String toString() {
		return "Culinaria [id=" + id + ", tipoCulinaria=" + tipoCulinaria + "]";
	}
	
	//CONSTRUTOR VAZIO
	public Culinaria() {
		super();
	}
	
	//CONSTRUTOR
	public Culinaria(int id, String tipoCulinaria) {
		super();
		this.id = id;
		this.tipoCulinaria = tipoCulinaria;
	}
	
	//GETTERS AND SETTERS
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTipoCulinaria() {
		return tipoCulinaria;
	}
	public void setTipoCulinaria(String tipoCulinaria) {
		this.tipoCulinaria = tipoCulinaria;
	}
}