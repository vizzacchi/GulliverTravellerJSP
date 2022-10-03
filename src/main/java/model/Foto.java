package model;

public class Foto {
	
	private int id;
	private String titulo;
	private String foto;
	private String descricao;
	
	@Override
	public String toString() {
		return "Foto [id=" + id + ", titulo=" + titulo + ", foto=" + foto + ", descricao=" + descricao + "]";
	}

	//CONSTRUTOR VAZIO
	public Foto() {
		super();
	}
	
	//CONSTRUTOR
	public Foto(int id, String titulo, String foto, String descricao) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.foto = foto;
		this.descricao = descricao;
	}	

	//GETTERS AND SETTERS
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}	
}