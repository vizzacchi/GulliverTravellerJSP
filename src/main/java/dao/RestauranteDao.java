package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Avaliacao;
import model.Bairro;
import model.Cidade;
import model.Culinaria;
import model.Destino;
import model.Endereco;
import model.FaixaPreco;
import model.Foto;
import model.HorarioFuncionamento;
import model.Restaurante;
import model.Telefone;
import model.TipoLogradouro;
import model.Uf;
import model.Usuario;

public class RestauranteDao implements DaoBase<Restaurante> {
	
	private DataSource dataSource;
	
	public RestauranteDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void create(Restaurante object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Restaurante> read() {
		try {
			
			List<Restaurante> resultado = new ArrayList<Restaurante>();
			String sql = "SELECT DISTINCT "
							+ " TP.ID, "
							+ " TP.NOME, "
							+ " TP.SITE, "
							+ " TP.FOTO_PERFIL, "
							+ " CONCAT(TE.LOGRADOURO, ', ', TP.NUMERO, ' - ', TB.BAIRRO, ', ', TC.CIDADE, ' - ', TU.UF, ', ', TE.CEP) AS ENDERECO, "
							+ " TL.NUMERO "
					    + "FROM tb_ponto TP "
					    	+ " JOIN tb_restaurante TR on TR.ID_PONTO = TP.ID "
							+ " LEFT JOIN tb_telefone TL ON TL.ID = TP.ID_TELEFONE "
							+ " LEFT JOIN tb_endereco TE ON TE.ID = TP.ID_ENDERECO "
							+ " LEFT JOIN tb_bairro TB ON TB.ID = TE.ID_BAIRRO "
							+ " LEFT JOIN tb_cidade TC ON TC.ID = TB.ID_CIDADE "
							+ " LEFT JOIN tb_uf TU ON TU.ID = TC.ID_UF "
						+ "ORDER BY TP.NOME ASC";
			
			PreparedStatement stm = dataSource.getConnection().prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()) {
				Restaurante restaurante = new Restaurante();
				restaurante.setId(rs.getInt("ID"));
				restaurante.setNome(rs.getString("NOME"));
				restaurante.setSite(rs.getString("SITE"));
				restaurante.setFotoPerfil(rs.getString("FOTO_PERFIL"));
				
				//ENDEREÇO				
				Endereco endereco = new Endereco(sql);
				endereco.setLogradouro(rs.getString("ENDERECO"));
				restaurante.setEndereco(endereco);
				
				//TELEFONE
				Telefone telefone = new Telefone();
				telefone.setTelefone(rs.getString("NUMERO"));
				restaurante.setTelefone(telefone);
				
				resultado.add(restaurante);
			}			
			return resultado;
			
		} catch (Exception e) {
			System.out.println("Erro ao listar Restaurantes " + e.getMessage());
			return null;
		}
	}

	@Override
	public void update(Restaurante object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Restaurante object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Restaurante read(Restaurante object) {
		try {
			String SQL = "SELECT DISTINCT "
							+ "	TP.ID AS ID_RESTAURANTE, "
							+ "	TP.NOME AS NOME_RESTAURANTE, "
							+ "	TP.SITE, "
							+ "	TP.FOTO_PERFIL, "
							+ "	TP.DESCRICAO AS DESC_RESTAURANTE, "
							+ "	TP.NUMERO AS NUM_RESTAURANTE, "
							+ "	TP.COMPLEMENTO, "
							+ " TR.REFEICAOLOCAL, "
							+ " TR.ENTREGA, "
							+ " TR.ESTACIONAMENTO, "
							+ " TCU.ID AS ID_CULINARIA, "
							+ " TCU.TIPOCULINARIA, "
							+ " THF.ID AS ID_HORARIOFUNCIONAMENTO,"
							+ " THF.DIA, "
						    + " THF.ABRE, "
						    + " THF.FECHAR, "
							+ "	TE.ID AS ID_ENDERECO, "
							+ "	TE.LOGRADOURO, "
							+ "	TE.CEP, "
							+ "	TE.ID_BAIRRO, "
							+ "	TE.ID_TIPOLOGRADOURO, "
							+ "	TLG.DESCRICAO AS DESC_LOGRADOURO, "
							+ "	TB.BAIRRO, "
							+ "	TB.ID_CIDADE, "
							+ "	TC.CIDADE, "
							+ "	TC.ID_UF, "
							+ "	TU.UF, "
							+ "	TU.DESCRICAO AS DESC_UF, "
							+ "	TL.ID AS ID_TELEFONE, "
							+ "	TL.TIPO AS TIPO_TELEFONE, "
							+ "	TL.NUMERO AS TELEFONE, "
							+ "	TF.ID AS ID_FOTO, "
							+ "	TF.FOTOS, "
							+ "	TF.DESCRICAO AS DESC_FOTOS, "
							+ "	TF.TITULO AS TITULO_FOTOS, "
							+ "	TFP.ID AS ID_FAIXAPRECO, "
							+ "	TFP.FAIXA, "
							+ "	TFP.DESCRICAO AS DESC_FAIXA, "
							+ "	TD.ID AS ID_DESTINO, "
							+ "	TD.DESTINO, "
							+ "	TA.ID AS ID_AVALIACAO, "
							+ "	TA.COMENTARIO, "
							+ "	TA.NOTA, "
							+ "	TA.DATA, "
							+ "	TA.ID_USUARIO, "
							+ "	TUS.NOME AS NOME_USUARIO, "
							+ "	TUS.EMAIL "
					+ "FROM tb_ponto TP "
							+ "	JOIN tb_restaurante TR on TR.ID_PONTO = TP.ID "
							+ "	LEFT JOIN gulliver.tb_culinaria TCU ON TCU.ID = TR.ID_CULINARIA "
							+ "	LEFT JOIN gulliver.tb_horario_funcionamento THF ON THF.ID = TR.ID_HORARIOFUNCIONAMENTO "
							+ "	LEFT JOIN tb_telefone TL ON TL.ID = TP.ID_TELEFONE "
							+ "	LEFT JOIN tb_endereco TE ON TE.ID = TP.ID_ENDERECO "
							+ "	LEFT JOIN tb_tipo_logradouro TLG on TE.ID_TIPOLOGRADOURO = TLG.ID "
							+ "	LEFT JOIN tb_bairro TB ON TB.ID = TE.ID_BAIRRO "
							+ "	LEFT JOIN tb_cidade TC ON TC.ID = TB.ID_CIDADE "
							+ "	LEFT JOIN tb_uf TU ON TU.ID = TC.ID_UF "
							+ "	LEFT JOIN tb_foto TF ON TF.ID = TP.ID_FOTOS "
							+ "	LEFT JOIN tb_faixa_preco TFP on TFP.ID = TP.ID_FAIXAPRECO "
							+ "	LEFT JOIN tb_destino TD on TD.ID = TP.ID_DESTINO "
							+ "	LEFT JOIN tb_avaliacao TA ON TA.ID = TP.ID_AVALIACAO "
							+ "	LEFT JOIN tb_usuario TUS on TUS.ID = TA.ID_USUARIO "
					+ "WHERE TP.ID = ?";
			
			// O ? IRÁ RECEBER O (ID) DA CHAMADA
			PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL);
			stm.setInt(1, object.getId());
			
			//EXECUTA O SQL E ARMAZENA EM UM OBJETO ResultSet
			ResultSet rs = stm.executeQuery();
			
			//O MÉTODO next() INDICA SE HÁ REGISTRO NO RESULTADO
			if(rs.next()) {
				Restaurante restaurante = new Restaurante();
				restaurante.setId(rs.getInt("ID_RESTAURANTE"));
				restaurante.setNome(rs.getString("NOME_RESTAURANTE"));
				restaurante.setSite(rs.getString("SITE"));
				restaurante.setFotoPerfil(rs.getString("FOTO_PERFIL"));
				restaurante.setDescricao(rs.getString("DESC_RESTAURANTE"));
				restaurante.setNumero(rs.getInt("NUM_RESTAURANTE"));
				restaurante.setComplemento(rs.getString("COMPLEMENTO"));
				restaurante.setRefeicaoLocal(rs.getBoolean("REFEICAOLOCAL"));
				restaurante.setEntrega(rs.getBoolean("ENTREGA"));
				restaurante.setEstacionamento(rs.getBoolean("ESTACIONAMENTO"));
				
				//CULINÁRIA
				Culinaria culinaria = new Culinaria();
				culinaria.setId(rs.getInt("ID_CULINARIA"));
				culinaria.setTipoCulinaria(rs.getString("TIPOCULINARIA"));
				
				//HORÁRIO FUNCIONAMENTO
				HorarioFuncionamento horario = new HorarioFuncionamento();
				horario.setId(rs.getInt("ID_HORARIOFUNCIONAMENTO"));
				horario.setDia(rs.getString("DIA"));
				horario.setAbre(rs.getDate("ABRE").toLocalDate());
				horario.setFecha(rs.getDate("FECHAR").toLocalDate());
				
				restaurante.setCulinaria(culinaria);
				restaurante.setHorarioFuncionamento(null);
		
				//ENDEREÇO
				Endereco endereco = new Endereco();
				endereco.setId(rs.getInt("ID_ENDERECO"));
				endereco.setLogradouro(rs.getString("LOGRADOURO"));
				endereco.setCep(rs.getString("CEP"));
				
				//BAIRRO
				Bairro bairro = new Bairro();
				bairro.setId(rs.getInt("ID_BAIRRO"));
				bairro.setBairro(rs.getString("BAIRRO"));
				
				//CIDADE
				Cidade cidade = new Cidade();
				cidade.setId(rs.getInt("ID_CIDADE"));
				cidade.setCidade(rs.getString("CIDADE"));
				
				//UF
				Uf uf = new Uf();
				uf.setId(rs.getInt("ID_UF"));
				uf.setUf(rs.getString("UF"));
				uf.setDescricao(rs.getString("DESC_UF"));
				
				//LOGRADOURO
				TipoLogradouro tipoLogradouro = new TipoLogradouro();
				tipoLogradouro.setId(rs.getInt("id_TIPOLOGRADOURO"));
				tipoLogradouro.setTipoLogradouro(rs.getString("DESC_LOGRADOURO"));
				
				cidade.setUf(uf);
				bairro.setCidade(cidade);
				endereco.setBairro(bairro);
				endereco.setTipoLogradouro(tipoLogradouro);
				
				restaurante.setEndereco(endereco);
								
				//TELEFONE
				Telefone telefone = new Telefone();
				telefone.setId(rs.getInt("ID_TELEFONE"));
				telefone.setTipo(rs.getString("TIPO_TELEFONE"));
				telefone.setTelefone(rs.getString("TELEFONE"));
				
				restaurante.setTelefone(telefone);
				
				//FOTOS			
				Foto foto = new Foto();
				foto.setId(rs.getInt("ID_FOTO"));
				foto.setFoto(rs.getString("FOTOS"));
				foto.setDescricao(rs.getString("DESC_FOTOS"));
				foto.setTitulo(rs.getString("TITULO_FOTOS"));
				
				restaurante.setFotos(foto);
				
				//FAIXA DE PREÇO
				FaixaPreco faixaPreco = new FaixaPreco();
				faixaPreco.setId(rs.getInt("ID_FAIXAPRECO"));
				faixaPreco.setFaixa(rs.getInt("FAIXA"));
				faixaPreco.setDescricao(rs.getString("DESC_FAIXA"));
				
				restaurante.setFaixaPreco(faixaPreco);

				//AVALIAÇÕES			
				Avaliacao avaliacao = new Avaliacao();
				avaliacao.setId(rs.getInt("ID_AVALIACAO"));
				avaliacao.setComentario(rs.getString("COMENTARIO"));
				avaliacao.setNota(rs.getDouble("NOTA"));
				avaliacao.setData(rs.getDate("DATA").toLocalDate());
				
				//USUÁRIO
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("ID_USUARIO"));
				usuario.setNome(rs.getString("NOME_USUARIO"));
				usuario.setEmail(rs.getString("EMAIL"));
				
				avaliacao.setUsuario(usuario);				
				restaurante.setAvaliacao(avaliacao);
				
				//DESTINO
				Destino destino = new Destino();
				destino.setId(rs.getInt("ID_DESTINO"));
				destino.setDestino(rs.getString("DESTINO"));
				
				restaurante.setDestino(destino);
				
				return restaurante;		
			}
			else {
				return null;
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("RestauranteDao.read=" + ex.getMessage());
		}
		return null;
	}
}