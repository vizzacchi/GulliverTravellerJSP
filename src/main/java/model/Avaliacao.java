package model;

import java.time.LocalDate;

public class Avaliacao {

	private int id;
	private double nota;
	private LocalDate data;
	private String comentario;
	private Usuario usuario;
		
	@Override
	public String toString() {
		return "Avaliacao [id=" + id + ", nota=" + nota + ", data=" + data + ", comentario=" + comentario + ", usuario="
				+ usuario + "]";
	}
	
	//CONSTRUTOR VAZIO
	public Avaliacao() {
		super();
	}
	
	//CONSTRUTOR
	public Avaliacao(int id, double nota, LocalDate data, String comentario, Usuario usuario) {
		super();
		this.id = id;
		this.nota = nota;
		this.data = data;
		this.comentario = comentario;
		this.usuario = usuario;
	}
	
	//GETTERS AND SETTERS
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}	
}