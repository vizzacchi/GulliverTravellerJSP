package model;

public class Perfil {
	
	private int id;
	private String perfil;
	private boolean ativo;
	
	@Override
	public String toString() {
		return "Perfil [id=" + id + ", perfil=" + perfil + ", ativo=" + ativo + "]";
	}
	
	//CONSTRUTOR VAZIO
	public Perfil() {
		super();
	}
	
	//CONSTRUTOR
	public Perfil(int id, String perfil, boolean status) {
		super();
		this.id = id;
		this.perfil = perfil;
		this.ativo = status;
	}
	
	//GETTERS AND SETTERS
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}	
}