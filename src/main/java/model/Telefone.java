package model;

public class Telefone {
	
	private int id;
	private String tipo;	
	private String telefone;
	

	
	@Override
	public String toString() {
		return " " + telefone;
	}

	//CONSTRUTOR VAZIO
	public Telefone() {
		super();
	}		
	
	//CONSTRUTOR
	public Telefone(int id, String tipo, String telefone) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.telefone = telefone;
	}	

	//GETTERS AND SETTERS
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}	
}