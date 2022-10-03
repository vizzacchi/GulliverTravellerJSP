package model;

public class TipoLogradouro {
	
	private int id;
	private String tipoLogradouro;
	
	@Override
	public String toString() {
		return " Logradouro= " + tipoLogradouro ;
	}
	
	//CONSTRUTOR VAZIO
	public TipoLogradouro() {
		super();
	}
	
	//CONSTRUTOR
	public TipoLogradouro(int id, String tipoLogradouro) {
		super();
		this.id = id;
		this.tipoLogradouro = tipoLogradouro;
	}
	
	//GETTERS AND SETTERS
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTipoLogradouro() {
		return tipoLogradouro;
	}
	public void setTipoLogradouro(String tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}	
}