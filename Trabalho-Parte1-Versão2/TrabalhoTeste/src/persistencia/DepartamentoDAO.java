package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import dados.Departamento;
import exception.DeleteException;
import exception.InsertException;
import exception.SelectException;
import exception.UpdateException;

public class DepartamentoDAO {
	private static DepartamentoDAO instance = null;
    private PreparedStatement insert;
    private PreparedStatement delete;
    private PreparedStatement update;
    private PreparedStatement select;
    private PreparedStatement selectAll;
    
    public static DepartamentoDAO getInstance() throws ClassNotFoundException, SQLException {

        if(instance == null){
            instance = new DepartamentoDAO();
        }
        return instance;
    }
    
    private DepartamentoDAO() throws ClassNotFoundException, SQLException {
        Connection conexao = Conexao.getConexao();

        insert = conexao.prepareStatement("insert into departamento values (?,?,?,?);");
        delete = conexao.prepareStatement("delete from departamento where numero = ?;");
        update = conexao.prepareStatement("update departamento set escritorio_princ = ?, nome = ?, lider = ? where numero = ?;");
        select = conexao.prepareStatement("select * from departamento where numero = ?;");
        selectAll = conexao.prepareStatement("select * from departamento;");
    }

    public void insert(Departamento departamento) throws SelectException, InsertException {

        try {
            insert.setInt(1, departamento.getNumero());
            insert.setString(2, departamento.getEscritorio_princ());
            insert.setString(3, departamento.getNome());
            insert.setInt(4, departamento.getLider());
            insert.executeUpdate();
        } catch (SQLException e) {
            throw new InsertException("departamento");
        }

    }
    public void delete(Departamento departamento) throws DeleteException {

        try {
            delete.setInt(1, departamento.getNumero());
            delete.executeUpdate();
        } catch (SQLException e) {
            throw new DeleteException("departamento");
        }
    }
    
    public void update(Departamento departamento) throws UpdateException {

        try {    
            update.setString(1, departamento.getEscritorio_princ());
            update.setString(2, departamento.getNome());
            update.setInt(3, departamento.getLider());
            update.setInt(4, departamento.getNumero());
            update.executeUpdate();
        } catch (SQLException e) {
            throw new UpdateException("departamento");
        }

    }
    
    public Departamento select(int numero) throws SelectException {

        try {
            select.setInt(1, numero);
            ResultSet rs = select.executeQuery();

            if(rs.next()){
                String escritorio_princ = rs.getString(2);
                String nome = rs.getString(3);
                int lider = rs.getInt(4);
                

                return new Departamento(numero, escritorio_princ, nome, lider);
            }

        } catch (SQLException e) {
            throw new SelectException("departamento");
        }

        return null;

    }
    
    public List<Departamento> selectAll() throws SelectException {

        List<Departamento> lista = new LinkedList<>();

        try {
            ResultSet rs = selectAll.executeQuery();

            while(rs.next()){
                int numero = rs.getInt(1);
                String escritorio_princ = rs.getString(2);
                String nome = rs.getString(3);
                int lider = rs.getInt(4);
                

                lista.add(new Departamento(numero, escritorio_princ, nome, lider));
            }
        } catch (SQLException e) {
            throw new SelectException("departamento");
        }

        return lista;
    }
}
