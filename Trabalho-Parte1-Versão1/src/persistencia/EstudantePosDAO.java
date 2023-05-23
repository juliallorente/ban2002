package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import dados.EstudantePos;
import exception.DeleteException;
import exception.InsertException;
import exception.SelectException;
import exception.UpdateException;

public class EstudantePosDAO {

	private static EstudantePosDAO instance = null;
	private PreparedStatement selectNewId;
    private PreparedStatement insert;
    private PreparedStatement delete;
    private PreparedStatement update;
    private PreparedStatement select;
    private PreparedStatement selectAll;
    
    public static EstudantePosDAO getInstance() throws ClassNotFoundException, SQLException {

        if(instance == null){
            instance = new EstudantePosDAO();
        }
        return instance;
    }
    
    private EstudantePosDAO() throws ClassNotFoundException, SQLException {
        Connection conexao = Conexao.getConexao();

        insert = conexao.prepareStatement("insert into estudantePos values (?,?,?,?,?,?);");
        delete = conexao.prepareStatement("delete from estudantePos where matricula = ?;");
        update = conexao.prepareStatement("update estudantePos set nome = ?, tipo_curso = ?, idade = ?, dep = ?, aconselhador = ? where matricula = ?;");
        select = conexao.prepareStatement("select * from estudantePos where matricula = ?;");
        selectAll = conexao.prepareStatement("select * from estudantePos;");
    }

    public void insert(EstudantePos estudantePos) throws SelectException, InsertException {

        try {
            insert.setInt(1, estudantePos.getMatricula());
            insert.setString(2, estudantePos.getNome());
            insert.setString(3, estudantePos.getTipo_curso());
            insert.setInt(4, estudantePos.getIdade());
            insert.setInt(5, estudantePos.getDep());
            insert.setInt(6, estudantePos.getAconselhador());
            insert.executeUpdate();
        } catch (SQLException e) {
            throw new InsertException("estudantePos");
        }

    }
    public void delete(EstudantePos estudantePos) throws DeleteException {

        try {
            delete.setInt(1, estudantePos.getMatricula());
            delete.executeUpdate();
        } catch (SQLException e) {
            throw new DeleteException("EstudantePos");
        }
    }
    
    public void update(EstudantePos estudantePos) throws UpdateException {

        try {          
            update.setString(1, estudantePos.getNome());
            update.setString(2, estudantePos.getTipo_curso());
            update.setInt(3, estudantePos.getIdade());
            update.setInt(4, estudantePos.getDep());
            update.setInt(5, estudantePos.getAconselhador());
            update.executeUpdate();
        } catch (SQLException e) {
            throw new UpdateException("EstudantePos");
        }

    }
    
    public EstudantePos select(int matricula) throws SelectException {

        try {
            select.setInt(1, matricula);
            ResultSet rs = select.executeQuery();

            if(rs.next()){
                String nome = rs.getString(2);
                String tipo_curso = rs.getString(3);
                int idade = rs.getInt(4);
                int dep = rs.getInt(5);
                int aconselhador = rs.getInt(6);
                
                

                return new EstudantePos(matricula, nome, tipo_curso, idade, dep, aconselhador);
            }

        } catch (SQLException e) {
            throw new SelectException("estudantePos");
        }

        return null;

    }
    
    public List<EstudantePos> selectAll() throws SelectException {

        List<EstudantePos> lista = new LinkedList<>();

        try {
            ResultSet rs = selectAll.executeQuery();

            while(rs.next()){
                int matricula = rs.getInt(1);
                String nome = rs.getString(2);
                String tipo_curso = rs.getString(3);
                int idade = rs.getInt(4);
                int dep = rs.getInt(5);
                int aconselhador = rs.getInt(6);
                

                lista.add(new EstudantePos(matricula, nome, tipo_curso, idade, dep, aconselhador));
            }
        } catch (SQLException e) {
            throw new SelectException("estudantePos");
        }

        return lista;
    }
}
