package model;

public class Permissao {
	
	private int id;
	private Perfil perfil;
	private String descricao;
	private String permissao;
	
	@Override
	public String toString() {
		return "Permissao [id=" + id + ", perfil=" + perfil + ", descricao=" + descricao + ", permissao=" + permissao + "]";
	}
	
	//CONSTRUTOR VAZIO
	public Permissao() {
		super();
	}
	
	//CONSTRUTOR
	public Permissao(int id, Perfil perfil, String descricao, String permissao) {
		super();
		this.id = id;
		this.perfil = perfil;
		this.descricao = descricao;
		this.permissao = permissao;
	}
	
	//GETTERS AND SETTERS
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Perfil getPerfil() {
		return perfil;
	}
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getPermissao() {
		return permissao;
	}
	public void setPermissao(String permissao) {
		this.permissao = permissao;
	}	
}