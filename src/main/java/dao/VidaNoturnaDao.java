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
import model.VidaNoturna;
import model.FaixaPreco;
import model.Foto;
import model.HorarioFuncionamento;
import model.Telefone;
import model.TipoLogradouro;
import model.Uf;
import model.Usuario;

public class VidaNoturnaDao implements DaoBase<VidaNoturna> {
	
	private DataSource dataSource;
	
	public VidaNoturnaDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void create(VidaNoturna object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<VidaNoturna> read() {
		try {
			
			List<VidaNoturna> resultado = new ArrayList<VidaNoturna>();
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
						+ "WHERE TP.ID_CATEGORIA = 8 "
						+ "ORDER BY TP.NOME ASC";
			
			PreparedStatement stm = dataSource.getConnection().prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()) {
				VidaNoturna vidaNoturna = new VidaNoturna();
				vidaNoturna.setId(rs.getInt("ID"));
				vidaNoturna.setNome(rs.getString("NOME"));
				vidaNoturna.setSite(rs.getString("SITE"));
				vidaNoturna.setFotoPerfil(rs.getString("FOTO_PERFIL"));
				
				//ENDEREÇO				
				Endereco endereco = new Endereco(sql);
				endereco.setLogradouro(rs.getString("ENDERECO"));
				vidaNoturna.setEndereco(endereco);
				
				//TELEFONE
				Telefone telefone = new Telefone();
				telefone.setTelefone(rs.getString("NUMERO"));
				vidaNoturna.setTelefone(telefone);
				
				//Média de avaliações
                //Crio a String SQL que vou ler
                String sqlMedia = "SELECT AVG(`NOTA`) as AVALIACOES_MEDIA "
                                + " FROM `tb_avaliacao` WHERE `ID_PONTO` = " + rs.getInt("ID");
                
                // O ? irá receber o id da chamada
                // gero o Statement a partir da conexao
                PreparedStatement stmMediaAvaliacao = dataSource.getConnection().prepareStatement(sqlMedia);
                
                //Vamos executar o SQL e armazenar em uma objeto ResultSet
                ResultSet rsMediaAvaliacao = stmMediaAvaliacao.executeQuery();
                if(rsMediaAvaliacao.next()) {
                    vidaNoturna.setMediaAvaliacao(rsMediaAvaliacao.getFloat("AVALIACOES_MEDIA"));
                }
				
				resultado.add(vidaNoturna);
			}			
			return resultado;
			
		} catch (Exception e) {
			System.out.println("Erro ao listar VidaNoturnas " + e.getMessage());
			return null;
		}
	}

	@Override
	public void update(VidaNoturna object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(VidaNoturna object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public VidaNoturna read(VidaNoturna object) {
		try {
			//Crio a String SQL que vou ler
			String SQL = "SELECT DISTINCT "
							+ "	TP.ID AS ID_VIDANOTURNA, "
							+ "	TP.NOME AS NOME_VIDANOTURNA, "
							+ "	TP.SITE, "
							+ "	TP.FOTO_PERFIL, "
							+ "	TP.DESCRICAO AS DESC_VIDANOTURNA, "
							+ "	TP.NUMERO AS NUM_VIDANOTURNA, "
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
							+ "	TUS.EMAIL, "
							+ "	THF.ID AS ID_HORARIO_FUNCIONAMENTO, "
							+ "	THF.DIA, "
							+ "	THF.ABRE, "
							+ "	THF.FECHAR "
						+ "FROM tb_ponto TP "
							+ "	LEFT JOIN tb_vida_noturna TH on TH.ID_PONTO = TP.ID  "
							+ "	LEFT JOIN tb_telefone TL ON TL.ID = TP.ID_TELEFONE  "
							+ "	LEFT JOIN tb_endereco TE ON TE.ID = TP.ID_ENDERECO  "
							+ "	LEFT JOIN tb_tipo_logradouro TLG on TE.ID_TIPOLOGRADOURO = TLG.ID "
							+ "	LEFT JOIN tb_bairro TB ON TB.ID = TE.ID_BAIRRO  "
							+ "	LEFT JOIN tb_cidade TC ON TC.ID = TB.ID_CIDADE  "
							+ "	LEFT JOIN tb_uf TU ON TU.ID = TC.ID_UF  "
							+ "	LEFT JOIN tb_faixa_preco TFP on TFP.ID = TP.ID_FAIXAPRECO "
							+ "	LEFT JOIN tb_destino TD on TD.ID = TP.ID_DESTINO "
							+ "	LEFT JOIN tb_avaliacao TA ON TA.ID = TP.ID_AVALIACAO "
							+ "	LEFT JOIN tb_usuario TUS on TUS.ID = TA.ID_USUARIO "
							+ "	LEFT JOIN tb_horario_funcionamento THF on THF.ID = TH.ID_HORARIOFUNCIONAMENTO "
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
				VidaNoturna vidaNoturna = new VidaNoturna();
				vidaNoturna.setId(rs.getInt("ID_VIDANOTURNA"));
				vidaNoturna.setNome(rs.getString("NOME_VIDANOTURNA"));
				vidaNoturna.setSite(rs.getString("SITE"));
				vidaNoturna.setFotoPerfil(rs.getString("FOTO_PERFIL"));
				vidaNoturna.setDescricao(rs.getString("DESC_VIDANOTURNA"));
				vidaNoturna.setNumero(rs.getInt("NUM_VIDANOTURNA"));
				vidaNoturna.setComplemento(rs.getString("COMPLEMENTO"));
		
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
				
				vidaNoturna.setEndereco(endereco);
				
				//O telefone o relacionamento deveria ser 1 Ponto para n 
				//telefones, vou incluir um só para não deixar nulo
				Telefone telefone = new Telefone();
				telefone.setId(rs.getInt("ID_TELEFONE"));
				telefone.setTipo(rs.getString("TIPO_TELEFONE"));
				telefone.setTelefone(rs.getString("TELEFONE"));
				
				vidaNoturna.setTelefone(telefone);
				
				ArrayList<Foto> fotos = new ArrayList<Foto>();
                
                //Crio a String SQL que vou ler
                String SQLFoto = "SELECT  "
                                + " TF.ID AS ID_FOTO, "
                                + " TF.FOTOS, "
                                + " TF.DESCRICAO AS DESC_FOTOS, "
                                + " TF.TITULO AS TITULO_FOTOS "
                            + "FROM tb_foto TF  "
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
                
                vidaNoturna.setFotos(fotos);
				
				FaixaPreco faixaPreco = new FaixaPreco();
				faixaPreco.setId(rs.getInt("ID_FAIXAPRECO"));
				faixaPreco.setFaixa(rs.getInt("FAIXA"));
				faixaPreco.setDescricao(rs.getString("DESC_FAIXA"));
				vidaNoturna.setFaixaPreco(faixaPreco);


				HorarioFuncionamento horariofuncionamento = new HorarioFuncionamento();
				horariofuncionamento.setId(rs.getInt("ID_HORARIO_FUNCIONAMENTO"));
				horariofuncionamento.setDia(rs.getString("DIA"));
				horariofuncionamento.setAbre(rs.getDate("ABRE").toLocalDate());
				horariofuncionamento.setFecha(rs.getDate("FECHAR").toLocalDate());
				vidaNoturna.setHorarioFuncionamento(horariofuncionamento);
				
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
                vidaNoturna.setAvaliacao(avaliacoes);
                
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
                    vidaNoturna.setNumAvaliacao(rsNumAvaliacao.getFloat("NUM_AVALIACOES"));
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
                    vidaNoturna.setMediaAvaliacao(rsMediaAvaliacao.getFloat("AVALIACOES_MEDIA"));
                }   

				
				Destino destino = new Destino();
				destino.setId(rs.getInt("ID_DESTINO"));
				destino.setDestino(rs.getString("DESTINO"));
				
				vidaNoturna.setDestino(destino);
				
				return vidaNoturna;		
			}
			else {
				return null;
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("VidaNoturnaDao.read=" + ex.getMessage());
		}
		return null;

	}
}