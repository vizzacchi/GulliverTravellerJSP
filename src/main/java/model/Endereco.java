package model;

public class Endereco {
	
	private int id;
	private String logradouro;
	private String cep;
	private Bairro bairro;
	private TipoLogradouro tipoLogradouro;
	

	

	@Override
	public String toString() {
		return logradouro  ;
	}

	//CONSTRUTOR VAZIO
	public Endereco() {
		super();
	}
	
	//CONSTRUTOR LOGRADOURO	
	public Endereco(String logradouro) {
		super();
		this.logradouro = logradouro;
	}

	//CONSTRUTOR
	public Endereco(int id, String logradouro, String cep, Bairro bairro,
			TipoLogradouro tipoLogradouro) {
		super();
		this.id = id;
		this.logradouro = logradouro;
		this.cep = cep;
		this.bairro = bairro;
		this.tipoLogradouro = tipoLogradouro;
	}
	
	//GETTERS AND SETTERS
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public Bairro getBairro() {
		return bairro;
	}
	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}
	public TipoLogradouro getTipoLogradouro() {
		return tipoLogradouro;
	}
	public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}
}