package model;

import java.time.LocalDate;

public class HorarioFuncionamento {
	
	private int id;
	private String dia;
	private LocalDate abre;
	private LocalDate fecha;
	
	@Override
	public String toString() {
		return "HorarioFuncionamento [id=" + id + ", dia=" + dia + ", abre=" + abre + ", fecha=" + fecha + "]";
	}
	
	//CONSTRUTOR VAZIO
	public HorarioFuncionamento() {
		super();
	}
	
	//CONSTRUTOR
	public HorarioFuncionamento(int id, String dia, LocalDate abre, LocalDate fecha) {
		super();
		this.id = id;
		this.dia = dia;
		this.abre = abre;
		this.fecha = fecha;
	}
	
	//GETTERS AND SETTERS
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public LocalDate getAbre() {
		return abre;
	}
	public void setAbre(LocalDate abre) {
		this.abre = abre;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}	
}