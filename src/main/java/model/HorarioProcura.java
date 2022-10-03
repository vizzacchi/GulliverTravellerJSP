package model;

import java.time.LocalDate;

public class HorarioProcura {

	private int id;
	private LocalDate inicio;	
	private LocalDate fim;
	
	@Override
	public String toString() {
		return "HorarioProcura [id=" + id + ", inicio=" + inicio + ", fim=" + fim + "]";
	}
	
	//CONSTRUTOR VAZIO
	public HorarioProcura() {
		super();
	}
	
	//CONSTRUTOR
	public HorarioProcura(int id, LocalDate inicio, LocalDate fim) {
		super();
		this.id = id;
		this.inicio = inicio;
		this.fim = fim;
	}
	
	//GETTERS AND SETTERS
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getInicio() {
		return inicio;
	}
	public void setInicio(LocalDate inicio) {
		this.inicio = inicio;
	}
	public LocalDate getFim() {
		return fim;
	}
	public void setFim(LocalDate fim) {
		this.fim = fim;
	}	
}