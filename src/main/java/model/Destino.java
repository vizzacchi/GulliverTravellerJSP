package model;

public class Destino {
	
	private int id;
	private String destino;
	
	@Override
	public String toString() {
		return "Destino [id=" + id + ", destino=" + destino + "]";
	}
	
	//CONSTRUTOR VAZIO
	public Destino() {
		super();
	}
	
	//CONSTRUTOR
	public Destino(int id, String destino) {
		super();
		this.id = id;
		this.destino = destino;
	}	
		
	//GETTERS AND SETTERS
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}	
}