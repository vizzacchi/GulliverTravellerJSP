package model;

public class Usuario {
	
	private int id;
	private String nome;
	private String email;
	private String senha;
	private Perfil perfil;
	private int ativo;
	
	@Override
	public String toString() {
		return " " + nome ;
	}
	
	//CONSTRUTOR VAZIO
	public Usuario() {
		super();
	}
	
	//CONSTRUTOR
	public Usuario(int id, String nome, String email, String senha, Perfil perfil, int ativo) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.perfil = perfil;
		this.ativo = ativo;
	}	
	
	//GETTERS AND SETTERS
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Perfil getPerfil() {
		return perfil;
	}
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	public int getAtivo() {
		return ativo;
	}
	public void setAtivo(int ativo) {
		this.ativo = ativo;
	}	
}