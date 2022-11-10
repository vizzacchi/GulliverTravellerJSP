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
import model.FaixaPreco;
import model.Foto;
import model.LocadoraCarro;
import model.Telefone;
import model.TipoLogradouro;
import model.Uf;
import model.Usuario;

public class LocadoraCarroDao implements DaoBase<LocadoraCarro> {

	private DataSource dataSource;
	
	public LocadoraCarroDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public DataSource getDataSource() {
		return dataSource;
	}

	@Override
	public void create(LocadoraCarro object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<LocadoraCarro> read() {
		try {
			
			List<LocadoraCarro> locadora = new ArrayList<LocadoraCarro>();
			String sql = "SELECT DISTINCT "
							+ "TP.ID, "
							+ "TP.NOME, "
							+ "TP.SITE, "
							+ "TP.FOTO_PERFIL, "
							+ "CONCAT(TE.LOGRADOURO, ', ', TP.NUMERO, ' - ', TB.BAIRRO, ', ', TC.CIDADE, ' - ', TU.UF, ', ', TE.CEP) AS ENDERECO, "
							+ "TL.NUMERO "
					    + "FROM tb_ponto TP "
					    	+ "JOIN tb_locadora_carro TLC ON TLC.ID_PONTO = TP.ID "
							+ "LEFT JOIN tb_telefone TL ON TL.ID = TP.ID_TELEFONE "
							+ "LEFT JOIN tb_endereco TE ON TE.ID = TP.ID_ENDERECO "
							+ "LEFT JOIN tb_bairro TB ON TB.ID = TE.ID_BAIRRO "
							+ "LEFT JOIN tb_cidade TC ON TC.ID = TB.ID_CIDADE "
							+ "LEFT JOIN tb_uf TU ON TU.ID = TC.ID_UF "
						+ "ORDER BY TP.NOME ASC";
	
	PreparedStatement stm = dataSource.getConnection().prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()) {
				LocadoraCarro carro = new LocadoraCarro();
				carro.setId(rs.getInt("ID"));
				carro.setNome(rs.getString("NOME"));
				carro.setSite(rs.getString("SITE"));
				carro.setFotoPerfil(rs.getString("FOTO_PERFIL"));
				
				//ENDEREÇO				
				Endereco endereco = new Endereco(sql);
				endereco.setLogradouro(rs.getString("ENDERECO"));
				carro.setEndereco(endereco);
				
				//TELEFONE
				Telefone telefone = new Telefone();
				telefone.setTelefone(rs.getString("NUMERO"));
				carro.setTelefone(telefone);
								
				locadora.add(carro);
			}			
			return locadora;
			
		} catch (Exception e) {
			System.out.println("Erro ao listar Locadoras de Carros " + e.getMessage());
			return null;
		}		
	}

	@Override
	public void update(LocadoraCarro object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(LocadoraCarro object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public LocadoraCarro read(LocadoraCarro object) {
		try {
			String SQL = "SELECT DISTINCT "
							+ "	TP.ID AS ID_LOCADORA, "
							+ "	TP.NOME AS NOME_LOCADORA, "
							+ "	TP.SITE, "
							+ "	TP.FOTO_PERFIL, "
							+ "	TP.DESCRICAO AS DESC_LOCADORA, "
							+ "	TP.NUMERO AS NUM_LOCADORA, "
							+ "	TP.COMPLEMENTO, "
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
							+ "JOIN tb_locadora_carro TLC ON TLC.ID_PONTO = TP.ID "
							+ "	LEFT JOIN tb_telefone TL ON TL.ID = TP.ID_TELEFONE "
							+ "	LEFT JOIN tb_endereco TE ON TE.ID = TP.ID_ENDERECO "
							+ "	LEFT JOIN tb_tipo_logradouro TLG on TE.ID_TIPOLOGRADOURO = TLG.ID "
							+ "	LEFT JOIN tb_bairro TB ON TB.ID = TE.ID_BAIRRO "
							+ "	LEFT JOIN tb_cidade TC ON TC.ID = TB.ID_CIDADE "
							+ "	LEFT JOIN tb_uf TU ON TU.ID = TC.ID_UF "
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
				LocadoraCarro locadora = new LocadoraCarro();
				locadora.setId(rs.getInt("ID_LOCADORA"));
				locadora.setNome(rs.getString("NOME_LOCADORA"));
				locadora.setSite(rs.getString("SITE"));
				locadora.setFotoPerfil(rs.getString("FOTO_PERFIL"));
				locadora.setDescricao(rs.getString("DESC_LOCADORA"));
				locadora.setNumero(rs.getInt("NUM_LOCADORA"));
				locadora.setComplemento(rs.getString("COMPLEMENTO"));
						
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
				
				locadora.setEndereco(endereco);
								
				//TELEFONE
				Telefone telefone = new Telefone();
				telefone.setId(rs.getInt("ID_TELEFONE"));
				telefone.setTipo(rs.getString("TIPO_TELEFONE"));
				telefone.setTelefone(rs.getString("TELEFONE"));
				
				locadora.setTelefone(telefone);
				
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
                
                locadora.setFotos(fotos);
				
				//FAIXA DE PREÇO
				FaixaPreco faixaPreco = new FaixaPreco();
				faixaPreco.setId(rs.getInt("ID_FAIXAPRECO"));
				faixaPreco.setFaixa(rs.getInt("FAIXA"));
				faixaPreco.setDescricao(rs.getString("DESC_FAIXA"));
				
				locadora.setFaixaPreco(faixaPreco);

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
				locadora.setAvaliacao(avaliacoes);
				
				//Numero de Avaliações
                
                //Crio a String SQL que vou ler
                String sqlNumAvaliacao = "SELECT COUNT(`NOTA`) as NUM_AVALIACOES "
                                + " FROM `tb_avaliacao` WHERE `ID_PONTO` = ?";
                
                // O ? irá receber o id da chamada
                // gero o Statement a partir da conexao
                PreparedStatement stmNumAvaliacao = dataSource.getConnection().prepareStatement(sqlNumAvaliacao);
                //preenche o ?
                stmNumAvaliacao.setInt(1, object.getId());
                
                //Vamos executar o SQL e armazenar em uma objeto ResultSet
                ResultSet rsNumAvaliacao = stmNumAvaliacao.executeQuery();
                if(rsNumAvaliacao.next()) {
                    locadora.setNumAvaliacao(rsNumAvaliacao.getFloat("NUM_AVALIACOES"));
                }   
                
                
                //Média de avaliações
                //Crio a String SQL que vou ler
                String sqlMediaAvaliacao = "SELECT AVG(`NOTA`) as AVALIACOES_MEDIA "
                                + " FROM `tb_avaliacao` WHERE `ID_PONTO` = ?";
                
                // O ? irá receber o id da chamada
                // gero o Statement a partir da conexao
                PreparedStatement stmMediaAvaliacao = dataSource.getConnection().prepareStatement(sqlMediaAvaliacao);
                //preenche o ?
                stmMediaAvaliacao.setInt(1, object.getId());
                
                //Vamos executar o SQL e armazenar em uma objeto ResultSet
                ResultSet rsMediaAvaliacao = stmMediaAvaliacao.executeQuery();
                if(rsMediaAvaliacao.next()) {
                    locadora.setMediaAvaliacao(rsMediaAvaliacao.getFloat("AVALIACOES_MEDIA"));
                }   
				
				//DESTINO
				Destino destino = new Destino();
				destino.setId(rs.getInt("ID_DESTINO"));
				destino.setDestino(rs.getString("DESTINO"));
				
				locadora.setDestino(destino);
				
				return locadora;		
			}
			else {
				return null;
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("LocadoraCarroDao.read=" + ex.getMessage());
		}
		return null;
	}
}