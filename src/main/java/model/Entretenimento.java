package model;

import java.util.ArrayList;

public class Entretenimento extends Ponto {
	
	private String regiao;
	private HorarioFuncionamento horarioFuncionamento;
	
	@Override
	public String toString() {
		return "Entretenimento horarioFuncionamento=" + horarioFuncionamento + "]";
	}
	
	//CONSTRUTOR VAZIO
	public Entretenimento() {
		super();
	}

    public Entretenimento(int id, String nome, String site, String fotoPerfil, String descricao, Endereco endereco,
            int numero, String complemento, Telefone telefone, ArrayList<Foto> fotos, FaixaPreco faixaPreco,
            Avaliacao avaliacao, Destino destino, String regiao, HorarioFuncionamento horarioFuncionamento) {
        super(id, nome, site, fotoPerfil, descricao, endereco, numero, complemento, telefone, fotos, faixaPreco,
                avaliacao, destino);
        this.regiao = regiao;
        this.horarioFuncionamento = horarioFuncionamento;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public HorarioFuncionamento getHorarioFuncionamento() {
        return horarioFuncionamento;
    }

    public void setHorarioFuncionamento(HorarioFuncionamento horarioFuncionamento) {
        this.horarioFuncionamento = horarioFuncionamento;
    }
	

}