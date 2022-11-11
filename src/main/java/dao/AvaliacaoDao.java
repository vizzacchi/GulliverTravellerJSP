package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Avaliacao;
import model.Usuario;

public class AvaliacaoDao implements DaoBase<Avaliacao> {
	
	private DataSource dataSource;
	
	public AvaliacaoDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public DataSource getDataSource() {
		return dataSource;
	}

	@Override
	public void create(Avaliacao object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Avaliacao> read() {
		// TODO Auto-generated method stub
		try {
			
			List<Avaliacao> resultado = new ArrayList<Avaliacao>();
			String sql = "SELECT  TA.ID as ID_AVALIACAO, TA.NOTA, TA.DATA, TA.COMENTARIO, TA.ID_USUARIO, TA.ID_PONTO, "
			        + "TU.NOME, TU.EMAIL, TU.SENHA, TU.ID_PERFIL, TU.ATIVO as SIT_USUARIO, "
			        + "TP.PERFIL, TP.ATIVO AS SIT_PERFIL "
			    + "FROM `tb_avaliacao` TA "
			         + "JOIN tb_usuario        TU on TA.ID_USUARIO = TU.ID "
			         + "JOIN tb_usuario_perfil TP on TP.ID         = TU.ID_PERFIL "
			    + "WHERE TA.ID_PONTO = 19";
			
			PreparedStatement stm = dataSource.getConnection().prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()) {
                Avaliacao avaliacao = new Avaliacao();
                avaliacao.setId(rs.getInt("ID_AVALIACAO"));
                avaliacao.setComentario(rs.getString("COMENTARIO"));
                avaliacao.setNota(rs.getDouble("NOTA"));
                avaliacao.setData(rs.getDate("DATA").toLocalDate());
                
                //Precisamos do usuário que fez a avaliação             
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("ID_USUARIO"));
                usuario.setNome(rs.getString("NOME"));
                usuario.setEmail(rs.getString("EMAIL"));
                
                avaliacao.setUsuario(usuario);
				
				resultado.add(avaliacao);
			}			
			return resultado;
			
		} catch (Exception e) {
			System.out.println("Erro ao listar Avaliacao " + e.getMessage());
			return null;
		}

	}

	@Override
	public Avaliacao read(Avaliacao object) {
		// TODO Auto-generated method stub
		try {
			//Crio a String SQL que vou ler
			String SQL = "SELECT  TA.ID as ID_AVALIACAO, TA.NOTA, TA.DATA, TA.COMENTARIO, TA.ID_USUARIO, TA.ID_PONTO, "
                    + "TU.NOME, TU.EMAIL, TU.SENHA, TU.ID_PERFIL, TU.ATIVO as SIT_USUARIO, "
                    + "TP.PERFIL, TP.ATIVO AS SIT_PERFIL "
                + "FROM `tb_avaliacao` TA "
                     + "JOIN tb_usuario        TU on TA.ID_USUARIO = TU.ID "
                     + "JOIN tb_usuario_perfil TP on TP.ID         = TU.ID_PERFIL "
                + "WHERE TA.ID_PONTO = 19";
			
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
			    Avaliacao avaliacao = new Avaliacao();
                avaliacao.setId(rs.getInt("ID_AVALIACAO"));
                avaliacao.setComentario(rs.getString("COMENTARIO"));
                avaliacao.setNota(rs.getDouble("NOTA"));
                avaliacao.setData(rs.getDate("DATA").toLocalDate());
                
                //Precisamos do usuário que fez a avaliação             
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("ID_USUARIO"));
                usuario.setNome(rs.getString("NOME"));
                usuario.setEmail(rs.getString("EMAIL"));
                
                avaliacao.setUsuario(usuario);
				
				return avaliacao;		
			}
			else {
				return null;
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("AvaliacaoDao.read=" + ex.getMessage());
		}
		return null;
	}


	@Override
	public void update(Avaliacao object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Avaliacao object) {
		// TODO Auto-generated method stub
		
	}

}
