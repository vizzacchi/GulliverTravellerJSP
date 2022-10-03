package model;

public class VidaNoturna extends Ponto {
	
	private String melhorDia;
	private HorarioFuncionamento horarioFuncionamento;
	private HorarioProcura horarioProcura;
	
	@Override
	public String toString() {
		return "VidaNoturna [melhorDia=" + melhorDia + ", horarioFuncionamento=" + horarioFuncionamento
				+ ", horarioProcura=" + horarioProcura + "]";
	}
	
	//CONSTRUTOR VAZIO
	public VidaNoturna() {
		super();
	}
	
	//CONSTRUTOR
	public VidaNoturna(int id, String nome, String site, String fotoPerfil, String descricao, Endereco endereco,
			int numero, String complemento, Telefone telefone, Foto fotos, FaixaPreco faixaPreco, Avaliacao avaliacao,
			Destino destino, String melhorDia, HorarioFuncionamento horarioFuncionamento,
			HorarioProcura horarioProcura) {
		super(id, nome, site, fotoPerfil, descricao, endereco, numero, complemento, telefone, fotos, faixaPreco,
				avaliacao, destino);
		this.melhorDia = melhorDia;
		this.horarioFuncionamento = horarioFuncionamento;
		this.horarioProcura = horarioProcura;
	}
	
	//GETTERS AND SETTERS
	public String getMelhorDia() {
		return melhorDia;
	}
	public void setMelhorDia(String melhorDia) {
		this.melhorDia = melhorDia;
	}
	public HorarioFuncionamento getHorarioFuncionamento() {
		return horarioFuncionamento;
	}
	public void setHorarioFuncionamento(HorarioFuncionamento horarioFuncionamento) {
		this.horarioFuncionamento = horarioFuncionamento;
	}
	public HorarioProcura getHorarioProcura() {
		return horarioProcura;
	}
	public void setHorarioProcura(HorarioProcura horarioProcura) {
		this.horarioProcura = horarioProcura;
	}	
}