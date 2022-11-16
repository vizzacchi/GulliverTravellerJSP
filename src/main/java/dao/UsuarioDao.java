package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import model.Perfil;
import model.Usuario;

public class UsuarioDao implements DaoBase<Usuario> {
    
    //DATASOURCE
    private DataSource dataSource;
    
    public UsuarioDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    public DataSource getDataSource() {
        return dataSource;
    }

    //CREATE - CADASTRAR USUÁRIO
    @Override
    public void create(Usuario object) {
        try {
            String sql = "INSERT INTO tb_usuario (NOME, EMAIL, SENHA, ID_PERFIL, ATIVO) VALUES "
                       + " (?, ?, ?, ?, ?)";
            
            PreparedStatement stm = dataSource.getConnection().prepareStatement(sql);
            stm.setString(1, object.getNome());
            stm.setString(2, object.getEmail());
            stm.setString(3, object.getSenha());
            stm.setInt(4, object.getPerfil().getId());
            stm.setInt(5, object.getAtivo());
            
            int res = stm.executeUpdate();
            if(res != 0) {
                System.out.println("Usuário Cadastrado");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("UsuarioDao.create = " + e.getMessage());
        }
    }

    @Override
    public List<Usuario> read() {
        // TODO Auto-generated method stub
        return null;
    }
    
    //LOGIN - BUSCA E-MAIL NO BANCO
    public Usuario getByEmailSenha(String email, String senha) {
        try {
            
            String sql = "SELECT "
                            + " US.ID, "
                            + " US.NOME, "
                            + " US.EMAIL, "
                            + " US.SENHA, "
                            + " US.ATIVO, "
                            + " UP.PERFIL "
                        + " FROM tb_usuario US "
                        + " JOIN tb_usuario_perfil UP ON UP.ID = US.ID_PERFIL "
                        + " WHERE EMAIL = ? "
                            + " AND SENHA = ?";
            
            PreparedStatement stm = dataSource.getConnection().prepareStatement(sql);
            stm.setString(1, email);
            stm.setString(2, senha);
            
            ResultSet rs = stm.executeQuery();
            if(rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("ID"));
                usuario.setNome(rs.getString("NOME"));
                usuario.setEmail(rs.getString("EMAIL"));
                usuario.setSenha(rs.getString("SENHA"));
                usuario.setAtivo(rs.getInt("ATIVO"));
                
                //PERFIL
                Perfil perfil = new Perfil();
                perfil.setPerfil(rs.getString("PERFIL"));
                usuario.setPerfil(perfil);

                return usuario;
            } else {
                return null;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("UsuarioDao.getByEmailSenha = " + e.getMessage());
            return null;
        }
    }

    @Override
    public Usuario read(Usuario object) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void update(Usuario object) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void delete(Usuario object) {
        // TODO Auto-generated method stub
        
    }
}