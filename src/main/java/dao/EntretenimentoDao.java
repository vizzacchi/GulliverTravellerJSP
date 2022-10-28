package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Avaliacao;
import model.Bairro;
import model.Cidade;
import model.Destino;
import model.Endereco;
import model.Entretenimento;
import model.FaixaPreco;
import model.Foto;
import model.HorarioFuncionamento;
import model.Entretenimento;
import model.Telefone;
import model.TipoLogradouro;
import model.Uf;
import model.Usuario;

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
		try {
			//Crio a String SQL que vou ler
			String SQL = "SELECT DISTINCT\r\n"
							+ "	TP.ID AS ID_ENTRETENIMENTO,\r\n"
							+ "	TP.NOME AS NOME_ENTRETENIMENTO,\r\n"
							+ "	TP.SITE,\r\n"
							+ "	TP.FOTO_PERFIL,\r\n"
							+ "	TP.DESCRICAO AS DESC_ENTRETENIMENTO,\r\n"
							+ "	TP.NUMERO AS NUM_ENTRETENIMENTO,\r\n"
							+ "	TP.COMPLEMENTO,\r\n"
							+ "	TH.REGIAO,\r\n"
							+ "	TE.ID AS ID_ENDERECO,\r\n"
							+ "	TE.LOGRADOURO,\r\n"
							+ "	TE.CEP,\r\n"
							+ "	TE.ID_BAIRRO,\r\n"
							+ "	TE.ID_TIPOLOGRADOURO,\r\n"
							+ "	TLG.DESCRICAO AS DESC_LOGRADOURO,\r\n"
							+ "	TB.BAIRRO,\r\n"
							+ "	TB.ID_CIDADE,\r\n"
							+ "	TC.CIDADE,\r\n"
							+ "	TC.ID_UF,\r\n"
							+ "	TU.UF,\r\n"
							+ "	TU.DESCRICAO AS DESC_UF,\r\n"
							+ "	TL.ID AS ID_TELEFONE,\r\n"
							+ "	TL.TIPO AS TIPO_TELEFONE,\r\n"
							+ "	TL.NUMERO AS TELEFONE,\r\n"
							+ "	TF.ID AS ID_FOTO,\r\n"
							+ "	TF.FOTOS,\r\n"
							+ "	TF.DESCRICAO AS DESC_FOTOS,\r\n"
							+ "	TF.TITULO AS TITULO_FOTOS,\r\n"
							+ "	TFP.ID AS ID_FAIXAPRECO,\r\n"
							+ "	TFP.FAIXA,\r\n"
							+ "	TFP.DESCRICAO AS DESC_FAIXA,\r\n"
							+ "	TD.ID AS ID_DESTINO,\r\n"
							+ "	TD.DESTINO,\r\n"
							+ "	TA.ID AS ID_AVALIACAO,\r\n"
							+ "	TA.COMENTARIO,\r\n"
							+ "	TA.NOTA,\r\n"
							+ "	TA.DATA,\r\n"
							+ "	TA.ID_USUARIO,\r\n"
							+ "	TUS.NOME AS NOME_USUARIO,\r\n"
							+ "	TUS.EMAIL,\r\n"
							+ "	THF.ID AS ID_HORARIO_FUNCIONAMENTO,\r\n"
							+ "	THF.DIA,\r\n"
							+ "	THF.ABRE,\r\n"
							+ "	THF.FECHAR\r\n"
						+ "FROM tb_ponto TP\r\n"
							+ "	JOIN tb_entretenimento TH on TH.ID_PONTO = TP.ID \r\n"
							+ "	LEFT JOIN tb_telefone TL ON TL.ID = TP.ID_TELEFONE \r\n"
							+ "	JOIN tb_endereco TE ON TE.ID = TP.ID_ENDERECO \r\n"
							+ "	JOIN tb_tipo_logradouro TLG on TE.ID_TIPOLOGRADOURO = TLG.ID\r\n"
							+ "	JOIN tb_bairro TB ON TB.ID = TE.ID_BAIRRO \r\n"
							+ "	JOIN tb_cidade TC ON TC.ID = TB.ID_CIDADE \r\n"
							+ "	JOIN tb_uf TU ON TU.ID = TC.ID_UF \r\n"
							+ "	LEFT JOIN tb_foto TF ON TF.ID = TP.ID_FOTOS\r\n"
							+ "	LEFT JOIN tb_faixa_preco TFP on TFP.ID = TP.ID_FAIXAPRECO\r\n"
							+ "	JOIN tb_destino TD on TD.ID = TP.ID_DESTINO\r\n"
							+ "	LEFT JOIN tb_avaliacao TA ON TA.ID = TP.ID_AVALIACAO\r\n"
							+ "	LEFT JOIN tb_usuario TUS on TUS.ID = TA.ID_USUARIO\r\n"
							+ "	LEFT JOIN tb_horario_funcionamento THF on THF.ID = TH.ID_HORARIOFUNCIONAMENTO\r\n"
						+ "WHERE TP.ID = ?";
			
			// O ? irá receber o id da chamada
			// gero o Statement a partir da conexao
			PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL);
			//preenche o ?
			stm.setInt(1, object.getId());
			
			//Vamos executar o SQL e armazenar em uma objeto ResultSet
			ResultSet rs = stm.executeQuery();
			
			//o método next() indica se há registro no resultado
			//se houver, eu preencho o objeto
			if(rs.next()) {
				Entretenimento entretenimento = new Entretenimento();
				entretenimento.setId(rs.getInt("ID_ENTRETENIMENTO"));
				entretenimento.setNome(rs.getString("NOME_ENTRETENIMENTO"));
				entretenimento.setSite(rs.getString("SITE"));
				entretenimento.setFotoPerfil(rs.getString("FOTO_PERFIL"));
				entretenimento.setDescricao(rs.getString("DESC_ENTRETENIMENTO"));
				entretenimento.setNumero(rs.getInt("NUM_ENTRETENIMENTO"));
				entretenimento.setComplemento(rs.getString("COMPLEMENTO"));
				entretenimento.setRegiao(rs.getString("REGIAO"));
		
				Endereco endereco = new Endereco();
				endereco.setId(rs.getInt("ID_ENDERECO"));
				endereco.setLogradouro(rs.getString("LOGRADOURO"));
				endereco.setCep(rs.getString("CEP"));
				
				Bairro bairro = new Bairro();
				bairro.setId(rs.getInt("ID_BAIRRO"));
				bairro.setBairro(rs.getString("BAIRRO"));
				
				Cidade cidade = new Cidade();
				cidade.setId(rs.getInt("ID_CIDADE"));
				cidade.setCidade(rs.getString("CIDADE"));
				
				Uf uf = new Uf();
				uf.setId(rs.getInt("ID_UF"));
				uf.setUf(rs.getString("UF"));
				uf.setDescricao(rs.getString("DESC_UF"));
				
				TipoLogradouro tipoLogradouro = new TipoLogradouro();
				tipoLogradouro.setId(rs.getInt("id_TIPOLOGRADOURO"));
				tipoLogradouro.setTipoLogradouro(rs.getString("DESC_LOGRADOURO"));
				
				cidade.setUf(uf);
				bairro.setCidade(cidade);
				endereco.setBairro(bairro);
				endereco.setTipoLogradouro(tipoLogradouro);
				
				entretenimento.setEndereco(endereco);
				
				//O telefone o relacionamento deveria ser 1 Ponto para n 
				//telefones, vou incluir um só para não deixar nulo
				Telefone telefone = new Telefone();
				telefone.setId(rs.getInt("ID_TELEFONE"));
				telefone.setTipo(rs.getString("TIPO_TELEFONE"));
				telefone.setTelefone(rs.getString("TELEFONE"));
				
				entretenimento.setTelefone(telefone);
				
				//Fotos o relacionamento também deveria ser 1 ponto para n fotos
				//incluindo uma foto para mostrar na página, depois alteramos				
				Foto foto = new Foto();
				foto.setId(rs.getInt("ID_FOTO"));
				foto.setFoto(rs.getString("FOTOS"));
				foto.setDescricao(rs.getString("DESC_FOTOS"));
				foto.setTitulo(rs.getString("TITULO_FOTOS"));
				
				entretenimento.setFotos(foto);
				
				FaixaPreco faixaPreco = new FaixaPreco();
				faixaPreco.setId(rs.getInt("ID_FAIXAPRECO"));
				faixaPreco.setFaixa(rs.getInt("FAIXA"));
				faixaPreco.setDescricao(rs.getString("DESC_FAIXA"));
				entretenimento.setFaixaPreco(faixaPreco);


				HorarioFuncionamento horariofuncionamento = new HorarioFuncionamento();
				horariofuncionamento.setId(rs.getInt("ID_HORARIO_FUNCIONAMENTO"));
				horariofuncionamento.setDia(rs.getString("DIA"));
				horariofuncionamento.setAbre(rs.getDate("ABRE").toLocalDate());
				horariofuncionamento.setFecha(rs.getDate("FECHAR").toLocalDate());
				entretenimento.setHorarioFuncionamento(horariofuncionamento);
				
				//O relacionamento de Avaliacao também deveria ser 1 ponto para n Avaliações				
				Avaliacao avaliacao = new Avaliacao();
				avaliacao.setId(rs.getInt("ID_AVALIACAO"));
				avaliacao.setComentario(rs.getString("COMENTARIO"));
				avaliacao.setNota(rs.getDouble("NOTA"));
				avaliacao.setData(rs.getDate("DATA").toLocalDate());
				
				//Precisamos do usuário que fez a avaliação				
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("ID_USUARIO"));
				usuario.setNome(rs.getString("NOME_USUARIO"));
				usuario.setEmail(rs.getString("EMAIL"));
				
				avaliacao.setUsuario(usuario);
				
				entretenimento.setAvaliacao(avaliacao);
				
				Destino destino = new Destino();
				destino.setId(rs.getInt("ID_DESTINO"));
				destino.setDestino(rs.getString("DESTINO"));
				
				entretenimento.setDestino(destino);
				
				return entretenimento;		
			}
			else {
				return null;
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("EntretenimentoDao.read=" + ex.getMessage());
		}
		return null;

	}
}