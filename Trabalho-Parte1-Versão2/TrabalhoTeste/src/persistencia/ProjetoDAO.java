package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import dados.Projeto;
import exception.DeleteException;
import exception.InsertException;
import exception.SelectException;
import exception.UpdateException;

public class ProjetoDAO {
	private static ProjetoDAO instance = null;
    private PreparedStatement insert;
    private PreparedStatement delete;
    private PreparedStatement update;
    private PreparedStatement select;
    private PreparedStatement selectAll;
    
    public static ProjetoDAO getInstance() throws ClassNotFoundException, SQLException {

        if(instance == null){
            instance = new ProjetoDAO();
        }
        return instance;
    }
    
    private ProjetoDAO() throws ClassNotFoundException, SQLException {
        Connection conexao = Conexao.getConexao();

        insert = conexao.prepareStatement("insert into projeto values (?,?,?,?,?,?);");
        delete = conexao.prepareStatement("delete from projeto where numero = ?;");
        update = conexao.prepareStatement("update projeto set financiador = ?, orcamento = ?, data_inicio = ?, data_final = ?, pesquisador_principal = ? where numero = ?;");
        select = conexao.prepareStatement("select * from projeto where numero = ?;");
        selectAll = conexao.prepareStatement("select * from projeto;");
    }

    public void insert(Projeto projeto) throws SelectException, InsertException {

        try {
            insert.setInt(1, projeto.getNumero());
            insert.setString(2, projeto.getFinanciador());
            insert.setDouble(3, projeto.getOrcamento());
            insert.setString(4, projeto.getData_inicio()); //arrumar o setData
            insert.setString(5, projeto.getData_final());
            insert.setInt(6, projeto.getPesquisador_principal());
            insert.executeUpdate();
        } catch (SQLException e) {
            throw new InsertException("projeto");
        }

    }
    public void delete(Projeto projeto) throws DeleteException {

        try {
            delete.setInt(1, projeto.getNumero());
            delete.executeUpdate();
        } catch (SQLException e) {
            throw new DeleteException("projeto");
        }
    }
    
    public void update(Projeto projeto) throws UpdateException {

        try {          
        	update.setString(1, projeto.getFinanciador());
            update.setDouble(2, projeto.getOrcamento());
            update.setString(3, projeto.getData_inicio()); 
            update.setString(4, projeto.getData_final());
            update.setInt(5, projeto.getPesquisador_principal());
            update.setInt(6, projeto.getNumero());
            update.executeUpdate();
        } catch (SQLException e) {
            throw new UpdateException("projeto");
        }

    }
    
    public Projeto select(int numero) throws SelectException {

        try {
            select.setInt(1, numero);
            ResultSet rs = select.executeQuery();

            if(rs.next()){
                String financiador = rs.getString(2);
                double orcamento = rs.getDouble(3);
                String data_incio = rs.getString(4); //arrumar o get
                String data_final = rs.getString(5);
                int pesquisador_principal = rs.getInt(6);
                
                

                return new Projeto(numero, financiador, orcamento, data_incio, data_final, pesquisador_principal);
            }

        } catch (SQLException e) {
            throw new SelectException("projeto");
        }

        return null;

    }
    
    public List<Projeto> selectAll() throws SelectException {

        List<Projeto> lista = new LinkedList<>();

        try {
            ResultSet rs = selectAll.executeQuery();

            while(rs.next()){
                int numero = rs.getInt(1);
                String financiador = rs.getString(2);
                double orcamento = rs.getDouble(3);
                String data_incio = rs.getString(4); //arrumar o get
                String data_final = rs.getString(5);
                int pesquisador_principal = rs.getInt(6);

                
                lista.add(new Projeto(numero, financiador, orcamento, data_incio, data_final, pesquisador_principal));
            }
        } catch (SQLException e) {
            throw new SelectException("projeto");
        }

        return lista;
    }
}
