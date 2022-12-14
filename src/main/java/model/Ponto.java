package model;

import java.util.ArrayList;

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
	private ArrayList<Foto> fotos;
	private FaixaPreco faixaPreco;
	private ArrayList<Avaliacao> avaliacoes;
	private Destino destino;
    private float numAvaliacao;
    private float mediaAvaliacao;
	
	@Override
	public String toString() {
		return "Hotel [id=" + id + ", nome=" + nome + ", \nsite=" + site + ", \nfotoPerfil=" + fotoPerfil + ", \ndescricao="
				+ descricao + ", \nendereco=" + endereco + ", numero=" + numero + ", complemento=" + complemento
				+ ", \ntelefone=" + telefone + ", \nfotos=" + fotos + ", \nfaixaPreco=" + faixaPreco + ", \navaliacao="
				+ avaliacoes + ", \ndestino=" + destino + "]";
	}
	
	//CONSTRUTOR VAZIO
	public Ponto() {
		super();
	}
		
	//CONSTRUTOR
	public Ponto(int id, String nome, String site, String fotoPerfil, String descricao, Endereco endereco, int numero,
			String complemento, Telefone telefone, ArrayList<Foto> fotos, FaixaPreco faixaPreco, Avaliacao avaliacao,
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
		this.destino = destino;
	}
	
	//GETTERS AND SETTERS
	
	public int getId() {
		return id;
	}
	public float getNumAvaliacao() {
        return numAvaliacao;
    }

    public void setNumAvaliacao(float numAvaliacao) {
        this.numAvaliacao = numAvaliacao;
    }
    public float getMediaAvaliacao() {
        return mediaAvaliacao;
    }

    public void setMediaAvaliacao(float mediaAvaliacao) {
        this.mediaAvaliacao = mediaAvaliacao;
    }

    public void setAvaliacoes(ArrayList<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
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
	public ArrayList<Foto> getFotos() {
		return fotos;
	}
	public void setFotos(ArrayList<Foto> fotos) {
		this.fotos = fotos;
	}
	public FaixaPreco getFaixaPreco() {
		return faixaPreco;
	}
	public void setFaixaPreco(FaixaPreco faixaPreco) {
		this.faixaPreco = faixaPreco;
	}
	public ArrayList<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}
	public void setAvaliacao(ArrayList<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}
	public Destino getDestino() {
		return destino;
	}
	public void setDestino(Destino destino) {
		this.destino = destino;
	}
}