package model;

import java.time.LocalDate;

public class Entretenimento extends Ponto {
	
	private LocalDate horarioFuncionamento;
	
	@Override
	public String toString() {
		return "Entretenimento horarioFuncionamento=" + horarioFuncionamento + "]";
	}
	
	//CONSTRUTOR VAZIO
	public Entretenimento() {
		super();
	}
	
	//CONSTRUTOR
	public Entretenimento(int id, String nome, String site, String fotoPerfil, String descricao, Endereco endereco,
			int numero, String complemento, Telefone telefone, Foto fotos, FaixaPreco faixaPreco, Avaliacao avaliacao,
			Destino destino,
			LocalDate horarioFuncionamento) {
		super(id, nome, site, fotoPerfil, descricao, endereco, numero, complemento, telefone, fotos, faixaPreco,
				avaliacao, destino);
		this.horarioFuncionamento = horarioFuncionamento;
	}
	
	//GETTERS AND SETTERS	
	public LocalDate getHorarioFuncionamento() {
		return horarioFuncionamento;
	}
	public void setHorarioFuncionamento(LocalDate horarioFuncionamento) {
		this.horarioFuncionamento = horarioFuncionamento;
	}
}