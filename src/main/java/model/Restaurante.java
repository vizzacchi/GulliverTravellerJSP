package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Restaurante extends Ponto {
	
	private boolean refeicaoLocal;
	private boolean entrega;
	private boolean estacionamento;
	private Culinaria culinaria;
	private LocalDate horarioFuncionamento;
	
	@Override
	public String toString() {
		return "Restaurante [refeicaoLocal=" + refeicaoLocal + ", entrega=" + entrega + ", estacionamento="
				+ estacionamento + ", culinaria=" + culinaria + ", horarioFuncionamento=" + horarioFuncionamento + "]";
	}
	
	//CONSTRUTOR VAZIO
	public Restaurante() {
		super();
	}
	
	//CONSTRUTOR
	public Restaurante(int id, String nome, String site, String fotoPerfil, String descricao, Endereco endereco,
			int numero, String complemento, Telefone telefone, ArrayList<Foto> fotos, FaixaPreco faixaPreco, Avaliacao avaliacao,
			Destino destino, boolean refeicaoLocal, boolean entrega, boolean estacionamento, Culinaria culinaria,
			LocalDate horarioFuncionamento) {
		super(id, nome, site, fotoPerfil, descricao, endereco, numero, complemento, telefone, fotos, faixaPreco,
				avaliacao, destino);
		this.refeicaoLocal = refeicaoLocal;
		this.entrega = entrega;
		this.estacionamento = estacionamento;
		this.culinaria = culinaria;
		this.horarioFuncionamento = horarioFuncionamento;
	}
	
	//GETTERS AND SETTERS
	public boolean isRefeicaoLocal() {
		return refeicaoLocal;
	}
	public void setRefeicaoLocal(boolean refeicaoLocal) {
		this.refeicaoLocal = refeicaoLocal;
	}
	public boolean isEntrega() {
		return entrega;
	}
	public void setEntrega(boolean entrega) {
		this.entrega = entrega;
	}
	public boolean isEstacionamento() {
		return estacionamento;
	}
	public void setEstacionamento(boolean estacionamento) {
		this.estacionamento = estacionamento;
	}
	public Culinaria getCulinaria() {
		return culinaria;
	}
	public void setCulinaria(Culinaria culinaria) {
		this.culinaria = culinaria;
	}
	public LocalDate getHorarioFuncionamento() {
		return horarioFuncionamento;
	}
	public void setHorarioFuncionamento(LocalDate horarioFuncionamento) {
		this.horarioFuncionamento = horarioFuncionamento;
	}
}