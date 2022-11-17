package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import model.Cidade;
import model.Uf;

public class DestinoDao implements DaoBase<Cidade> {

    //DATASOURCE
    private DataSource dataSource;
    
    public DestinoDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    public DataSource getDataSource() {
        return dataSource;
    }

    @Override
    public void create(Cidade object) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<Cidade> read() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Cidade read(Cidade object) {
        // TODO Auto-generated method stub
        return null;
    }
    
    //DESTINO - BUSCA A CIDADE DE ACORDO COM O DESTINO INFORMADO
    public Cidade getByDestino(String destino) {
        try {
            
            String sql = "SELECT "
                        + " TC.ID, "
                        + " TC.CIDADE, "
                        + " TU.UF "
                        + "FROM gulliver.tb_cidade TC "
                        + " JOIN tb_uf TU ON TU.ID = TC.ID_UF "
                        + "WHERE TC.CIDADE = ?";
            
            PreparedStatement stm = dataSource.getConnection().prepareStatement(sql);
            stm.setString(1, destino);
            
            ResultSet rs = stm.executeQuery();
            if(rs.next()) {
                
                //CIDADE
                Cidade cidade = new Cidade();
                cidade.setId(rs.getInt("ID"));
                cidade.setCidade(rs.getString("CIDADE"));
                
                //UF
                Uf uf = new Uf();
                uf.setUf(rs.getString("UF"));
                cidade.setUf(uf);

                return cidade;
            } else {
                return null;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("DestinoDao.getByDestino = " + e.getMessage());
            return null;
        }
    }

    @Override
    public void update(Cidade object) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void delete(Cidade object) {
        // TODO Auto-generated method stub
        
    }
}