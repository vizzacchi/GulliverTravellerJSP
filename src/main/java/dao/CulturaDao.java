package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Cultura;
import model.Avaliacao;
import model.Bairro;
import model.Cidade;
import model.Destino;
import model.Endereco;
import model.FaixaPreco;
import model.Foto;
import model.Telefone;
import model.TipoLogradouro;
import model.Uf;
import model.Usuario;

public class CulturaDao implements DaoBase<Cultura> {
	
	private DataSource dataSource;
	
	public CulturaDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public DataSource getDataSource() {
		return dataSource;
	}

	@Override
	public void create(Cultura object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Cultura> read() {
		try {
			
			List<Cultura> resultado = new ArrayList<Cultura>();
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
						+ "WHERE TP.ID_CATEGORIA = 2 "
						+ "ORDER BY TP.NOME ASC";
			
			PreparedStatement stm = dataSource.getConnection().prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()) {
				Cultura cultura = new Cultura();
				cultura.setId(rs.getInt("ID"));
				cultura.setNome(rs.getString("NOME"));
				cultura.setSite(rs.getString("SITE"));
				cultura.setFotoPerfil(rs.getString("FOTO_PERFIL"));
				
				//ENDEREÇO				
				Endereco endereco = new Endereco(sql);
				endereco.setLogradouro(rs.getString("ENDERECO"));
				cultura.setEndereco(endereco);
				
				//TELEFONE
				Telefone telefone = new Telefone();
				telefone.setTelefone(rs.getString("NUMERO"));
				cultura.setTelefone(telefone);
				
				resultado.add(cultura);
			}			
			return resultado;
			
		} catch (Exception e) {
			System.out.println("Erro ao mostrar pagina cultura " + e.getMessage());
			return null;
		}
	}

	@Override
	public void update(Cultura object) {
		
		
	}

	@Override
	public void delete(Cultura object) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Cultura read(Cultura object) {
		try {
			//Crio a String SQL que vou ler
			String SQL = "SELECT DISTINCT\r\n"
							+ "	TP.ID AS ID_CULTURA,\r\n"
							+ "	TP.NOME AS NOME_CULTURA,\r\n"
							+ "	TP.SITE,\r\n"
							+ "	TP.FOTO_PERFIL,\r\n"
							+ "	TP.DESCRICAO AS DESC_CULTURA,\r\n"
							+ "	TP.NUMERO AS NUM_CULTURA,\r\n"
							+ "	TP.COMPLEMENTO,\r\n"
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
							+ "	TUS.EMAIL\r\n"
						+ "FROM tb_ponto TP\r\n"
							+ "	JOIN tb_cultura TH on TH.ID_PONTO = TP.ID \r\n"
							+ "	LEFT JOIN tb_telefone TL ON TL.ID = TP.ID_TELEFONE \r\n"
							+ "	JOIN tb_endereco TE ON TE.ID = TP.ID_ENDERECO \r\n"
							+ "	JOIN tb_tipo_logradouro TLG on TE.ID_TIPOLOGRADOURO = TLG.ID\r\n"
							+ "	JOIN tb_bairro TB ON TB.ID = TE.ID_BAIRRO \r\n"
							+ "	JOIN tb_cidade TC ON TC.ID = TB.ID_CIDADE \r\n"
							+ "	JOIN tb_uf TU ON TU.ID = TC.ID_UF \r\n"
							+ "	LEFT JOIN tb_faixa_preco TFP on TFP.ID = TP.ID_FAIXAPRECO\r\n"
							+ "	JOIN tb_destino TD on TD.ID = TP.ID_DESTINO\r\n"
							+ "	LEFT JOIN tb_avaliacao TA ON TA.ID = TP.ID_AVALIACAO\r\n"
							+ "	LEFT JOIN tb_usuario TUS on TUS.ID = TA.ID_USUARIO\r\n"
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
				Cultura cultura = new Cultura();
				cultura.setId(rs.getInt("ID_CULTURA"));
				cultura.setNome(rs.getString("NOME_CULTURA"));
				cultura.setSite(rs.getString("SITE"));
				cultura.setFotoPerfil(rs.getString("FOTO_PERFIL"));
				cultura.setDescricao(rs.getString("DESC_CULTURA"));
				cultura.setNumero(rs.getInt("NUM_CULTURA"));
				cultura.setComplemento(rs.getString("COMPLEMENTO"));
				//cultura.setMelhorDia(rs.getString("MELHORDIA"));
		
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
				
				cultura.setEndereco(endereco);
				
				//O telefone o relacionamento deveria ser 1 Ponto para n 
				//telefones, vou incluir um só para não deixar nulo
				Telefone telefone = new Telefone();
				telefone.setId(rs.getInt("ID_TELEFONE"));
				telefone.setTipo(rs.getString("TIPO_TELEFONE"));
				telefone.setTelefone(rs.getString("TELEFONE"));
				
				cultura.setTelefone(telefone);
				
				ArrayList<Foto> fotos = new ArrayList<Foto>();
                
                //Crio a String SQL que vou ler
                String SQLFoto = "SELECT \r\n"
                                + " TF.ID AS ID_FOTO,\r\n"
                                + " TF.FOTOS,\r\n"
                                + " TF.DESCRICAO AS DESC_FOTOS,\r\n"
                                + " TF.TITULO AS TITULO_FOTOS\r\n"
                            + "FROM tb_foto TF \r\n"
                            + "WHERE TF.ID_PONTO = ?";
                
                // O ? irá receber o id da chamada
                // gero o Statement a partir da conexao
                PreparedStatement stmFoto = dataSource.getConnection().prepareStatement(SQLFoto);
                //preenche o ?
                stmFoto.setInt(1, object.getId());
                
                //Vamos executar o SQL e armazenar em uma objeto ResultSet
                ResultSet rsFoto = stmFoto.executeQuery();
                                
                //o método next() indica se há registro no resultado
                //se houver, eu preencho o objeto
                while(rsFoto.next()) {
                    Foto foto = new Foto();
                    foto.setId(rsFoto.getInt("ID_FOTO"));
                    foto.setFoto(rsFoto.getString("FOTOS"));
                    foto.setDescricao(rsFoto.getString("DESC_FOTOS"));
                    foto.setTitulo(rsFoto.getString("TITULO_FOTOS"));
                    fotos.add(foto);                
                }
                
                cultura.setFotos(fotos);
				
				FaixaPreco faixaPreco = new FaixaPreco();
				faixaPreco.setId(rs.getInt("ID_FAIXAPRECO"));
				faixaPreco.setFaixa(rs.getInt("FAIXA"));
				faixaPreco.setDescricao(rs.getString("DESC_FAIXA"));
				cultura.setFaixaPreco(faixaPreco);

                //AVALIAÇÕES    
                ArrayList<Avaliacao> avaliacoes = new ArrayList<Avaliacao>();
                String sqlAvaliacao = "SELECT  TA.ID as ID_AVALIACAO, TA.NOTA, TA.DATA, TA.COMENTARIO, TA.ID_USUARIO, TA.ID_PONTO, "
                        + "TU.NOME, TU.EMAIL, TU.SENHA, TU.ID_PERFIL, TU.ATIVO as SIT_USUARIO, "
                        + "TP.PERFIL, TP.ATIVO AS SIT_PERFIL "
                    + "FROM `tb_avaliacao` TA "
                         + "JOIN tb_usuario        TU on TA.ID_USUARIO = TU.ID "
                         + "JOIN tb_usuario_perfil TP on TP.ID         = TU.ID_PERFIL "
                    + "WHERE TA.ID_PONTO = ?";
                
                PreparedStatement stmAvaliacao = dataSource.getConnection().prepareStatement(sqlAvaliacao);
                stmAvaliacao.setInt(1, object.getId());
                ResultSet rsAvaliacao = stmAvaliacao.executeQuery();
                
                
                while(rsAvaliacao.next()) {
                    Avaliacao avaliacao = new Avaliacao();
                    avaliacao.setId(rsAvaliacao.getInt("ID_AVALIACAO"));
                    avaliacao.setComentario(rsAvaliacao.getString("COMENTARIO"));
                    avaliacao.setNota(rsAvaliacao.getDouble("NOTA"));
                    avaliacao.setData(rsAvaliacao.getDate("DATA").toLocalDate());
                    
                    //Precisamos do usuário que fez a avaliação             
                    Usuario usuario = new Usuario();
                    usuario.setId(rsAvaliacao.getInt("ID_USUARIO"));
                    usuario.setNome(rsAvaliacao.getString("NOME"));
                    usuario.setEmail(rsAvaliacao.getString("EMAIL"));
                    
                    avaliacao.setUsuario(usuario);
                    
                    avaliacoes.add(avaliacao);
                } 
				
				cultura.setAvaliacao(avaliacoes);
				
				Destino destino = new Destino();
				destino.setId(rs.getInt("ID_DESTINO"));
				destino.setDestino(rs.getString("DESTINO"));
				
				cultura.setDestino(destino);
				
				return cultura;		
			}
			else {
				return null;
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("CulturaDao.read=" + ex.getMessage());
		}
		return null;
	}
}