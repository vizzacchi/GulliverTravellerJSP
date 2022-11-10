package model;

import java.util.ArrayList;

public class Parque extends Ponto {
	
	private String melhorDia;

	
	@Override
    public String toString() {
        return "Parque [melhorDia=" + melhorDia + "]";
    }
    public Parque() {
        super();
    }
    public Parque(int id, String nome, String site, String fotoPerfil, String descricao, Endereco endereco, int numero,
            String complemento, Telefone telefone, ArrayList<Foto> fotos, FaixaPreco faixaPreco, Avaliacao avaliacao,
            Destino destino, String melhorDia, float numAvaliacao, float mediaAvaliacao) {
        super(id, nome, site, fotoPerfil, descricao, endereco, numero, complemento, telefone, fotos, faixaPreco,
                avaliacao, destino);
        this.melhorDia = melhorDia;
    }
    public String getMelhorDia() {
        return melhorDia;
    }
    public void setMelhorDia(String melhorDia) {
        this.melhorDia = melhorDia;
    }
}