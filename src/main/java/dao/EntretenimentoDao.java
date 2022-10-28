package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Endereco;
import model.Entretenimento;
import model.Telefone;

public class EntretenimentoDao implements DaoBase<Entretenimento> {
	
	private DataSource dataSource;
	
	public EntretenimentoDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void create(Entretenimento object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Entretenimento> read() {
		try {
			
			List<Entretenimento> resultado = new ArrayList<Entretenimento>();
			String sql = "SELECT DISTINCT "
							+ "TP.ID, "
							+ "TP.NOME, "
							+ "TP.SITE, "
							+ "TP.FOTO_PERFIL, "
							+ "CONCAT(TE.LOGRADOURO, ', ', TP.NUMERO, ' - ', TB.BAIRRO, ', ', TC.CIDADE, ' - ', TU.UF, ', ', TE.CEP) AS ENDERECO, "
							+ "TL.NUMERO "
					    + "FROM tb_ponto TP "
							+ "LEFT JOIN tb_telefone TL ON TL.ID = TP.ID_TELEFONE "
							+ "JOIN tb_endereco TE ON TE.ID = TP.ID_ENDERECO "
							+ "JOIN tb_bairro TB ON TB.ID = TE.ID_BAIRRO "
							+ "JOIN tb_cidade TC ON TC.ID = TB.ID_CIDADE "
							+ "JOIN tb_uf TU ON TU.ID = TC.ID_UF "
						+ "WHERE TP.ID_CATEGORIA = 3 "
						+ "ORDER BY TP.NOME ASC";
			
			PreparedStatement stm = dataSource.getConnection().prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()) {
				Entretenimento entretenimento = new Entretenimento();
				entretenimento.setId(rs.getInt("ID"));
				entretenimento.setNome(rs.getString("NOME"));
				entretenimento.setSite(rs.getString("SITE"));
				entretenimento.setFotoPerfil(rs.getString("FOTO_PERFIL"));
				
				//ENDEREÇO				
				Endereco endereco = new Endereco(sql);
				endereco.setLogradouro(rs.getString("ENDERECO"));
				entretenimento.setEndereco(endereco);
				
				//TELEFONE
				Telefone telefone = new Telefone();
				telefone.setTelefone(rs.getString("NUMERO"));
				entretenimento.setTelefone(telefone);
				
				resultado.add(entretenimento);
			}			
			return resultado;
			
		} catch (Exception e) {
			System.out.println("Erro ao listar Entretenimentos " + e.getMessage());
			return null;
		}
	}

	@Override
	public void update(Entretenimento object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Entretenimento object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Entretenimento read(Entretenimento object) {
		// TODO Auto-generated method stub
		return null;
	}
}