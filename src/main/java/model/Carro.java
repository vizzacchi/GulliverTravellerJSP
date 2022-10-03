package model;

public class Carro {
	
	private int id;
	private String marca;
	private String categoria;
	private String modelo;
	private String disponibilidade;
	private int ano;
	private String combustivel;
	private String descricao;
	private float valorAluguel;
	private String placa;
	private Foto fotos;
	
	@Override
	public String toString() {
		return "Carro [id=" + id + ", marca=" + marca + ", categoria=" + categoria + ", modelo=" + modelo
				+ ", disponibilidade=" + disponibilidade + ", ano=" + ano + ", combustivel=" + combustivel
				+ ", descricao=" + descricao + ", valorAluguel=" + valorAluguel + ", placa=" + placa + ", fotos="
				+ fotos + "]";
	}
	
	//CONSTRUTOR VAZIO
	public Carro() {
		super();
	}
	
	//CONSTRUTOR
	public Carro(int id, String marca, String categoria, String modelo, String disponibilidade, int ano,
			String combustivel, String descricao, float valorAluguel, String placa, Foto fotos) {
		super();
		this.id = id;
		this.marca = marca;
		this.categoria = categoria;
		this.modelo = modelo;
		this.disponibilidade = disponibilidade;
		this.ano = ano;
		this.combustivel = combustivel;
		this.descricao = descricao;
		this.valorAluguel = valorAluguel;
		this.placa = placa;
		this.fotos = fotos;
	}	
	
	//GETTERS AND SETTERS
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getDisponibilidade() {
		return disponibilidade;
	}
	public void setDisponibilidade(String disponibilidade) {
		this.disponibilidade = disponibilidade;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getCombustivel() {
		return combustivel;
	}
	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public float getValorAluguel() {
		return valorAluguel;
	}
	public void setValorAluguel(float valorAluguel) {
		this.valorAluguel = valorAluguel;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public Foto getFotos() {
		return fotos;
	}
	public void setFotos(Foto fotos) {
		this.fotos = fotos;
	}	
}