package model;

public class Ponto {
	
	private int id;
	private String nome;
	private String site;
	private String fotoPerfil;
	private String descricao;
	private Endereco endereco;
	private int numero;
	private String complemento;
	private Telefone telefone;
	private Foto fotos;
	private FaixaPreco faixaPreco;
	private Avaliacao avaliacao;
	private Destino destino;
	
	@Override
	public String toString() {
		return "Hotel [id=" + id + ", nome=" + nome + ", \nsite=" + site + ", \nfotoPerfil=" + fotoPerfil + ", \ndescricao="
				+ descricao + ", \nendereco=" + endereco + ", numero=" + numero + ", complemento=" + complemento
				+ ", \ntelefone=" + telefone + ", \nfotos=" + fotos + ", \nfaixaPreco=" + faixaPreco + ", \navaliacao="
				+ avaliacao + ", \ndestino=" + destino + "]";
	}
	
	//CONSTRUTOR VAZIO
	public Ponto() {
		super();
	}
		
	//CONSTRUTOR
	public Ponto(int id, String nome, String site, String fotoPerfil, String descricao, Endereco endereco, int numero,
			String complemento, Telefone telefone, Foto fotos, FaixaPreco faixaPreco, Avaliacao avaliacao,
			Destino destino) {
		super();
		this.id = id;
		this.nome = nome;
		this.site = site;
		this.fotoPerfil = fotoPerfil;
		this.descricao = descricao;
		this.endereco = endereco;
		this.numero = numero;
		this.complemento = complemento;
		this.telefone = telefone;
		this.fotos = fotos;
		this.faixaPreco = faixaPreco;
		this.avaliacao = avaliacao;
		this.destino = destino;
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
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getFotoPerfil() {
		return fotoPerfil;
	}
	public void setFotoPerfil(String fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public Telefone getTelefone() {
		return telefone;
	}
	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}
	public Foto getFotos() {
		return fotos;
	}
	public void setFotos(Foto fotos) {
		this.fotos = fotos;
	}
	public FaixaPreco getFaixaPreco() {
		return faixaPreco;
	}
	public void setFaixaPreco(FaixaPreco faixaPreco) {
		this.faixaPreco = faixaPreco;
	}
	public Avaliacao getAvaliacao() {
		return avaliacao;
	}
	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}
	public Destino getDestino() {
		return destino;
	}
	public void setDestino(Destino destino) {
		this.destino = destino;
	}
}