package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.LinkedList;
import dados.Professor;
import exception.DeleteException;
import exception.InsertException;
import exception.SelectException;
import exception.UpdateException;

public class ProfessorDAO {

	private static ProfessorDAO instance = null;
	private PreparedStatement selectNewId;
    private PreparedStatement insert;
    private PreparedStatement delete;
    private PreparedStatement update;
    private PreparedStatement select;
    private PreparedStatement selectAll;
    
    public static ProfessorDAO getInstance() throws ClassNotFoundException, SQLException {

        if(instance == null){
            instance = new ProfessorDAO();
        }
        return instance;
    }
    
    private ProfessorDAO() throws ClassNotFoundException, SQLException {
        Connection conexao = Conexao.getConexao();

        insert = conexao.prepareStatement("insert into professor values (?,?,?,?,?);");
        delete = conexao.prepareStatement("delete from professor where matricula = ?;");
        update = conexao.prepareStatement("update professor set nome = ?, idade = ?, sala = ?, especialidade = ? where matricula = ?;");
        select = conexao.prepareStatement("select * from professor where matricula = ?;");
        selectAll = conexao.prepareStatement("select * from professor;");
    }

    public void insert(Professor professor) throws SelectException, InsertException {

        try {
            insert.setInt(1, professor.getMatricula());
            insert.setString(2, professor.getNome());
            insert.setInt(3, professor.getIdade());
            insert.setString(4, professor.getSala());
            insert.setString(5, professor.getEspecialidade());
            insert.executeUpdate();
        } catch (SQLException e) {
            throw new InsertException("Professor");
        }

    }
    public void delete(Professor professor) throws DeleteException {

        try {
            delete.setInt(1, professor.getMatricula());
            delete.executeUpdate();
        } catch (SQLException e) {
            throw new DeleteException("Professor");
        }
    }
    
    public void update(Professor professor) throws UpdateException {

        try {
        	update.setString(1, professor.getNome());
        	update.setInt(2, professor.getIdade());
        	update.setString(3, professor.getSala());
        	update.setString(4, professor.getEspecialidade());
        	update.setInt(5, professor.getMatricula());
            update.executeUpdate();
        } catch (SQLException e) {
            throw new UpdateException("Professor");
        }

    }
    
    public Professor select(int matricula) throws SelectException {

        try {
            select.setInt(1, matricula);
            ResultSet rs = select.executeQuery();

            if(rs.next()){
                String nome = rs.getString(2);
                int idade = rs.getInt(3);
                String sala = rs.getString(4);
                String especialidade = rs.getString(5);
                
                

                return new Professor(matricula, nome, idade, sala, especialidade);
            }

        } catch (SQLException e) {
            throw new SelectException("Professor");
        }

        return null;

    }
    
    public List<Professor> selectAll() throws SelectException {

        List<Professor> lista = new LinkedList<>();

        try {
            ResultSet rs = selectAll.executeQuery();

            while(rs.next()){
                int matricula = rs.getInt(1);
                String nome = rs.getString(2);
                int idade = rs.getInt(3);
                String sala = rs.getString(4);
                String especialidade = rs.getString(5);
                

                lista.add(new Professor(matricula, nome, idade, sala, especialidade));
            }
        } catch (SQLException e) {
            throw new SelectException("Professor");
        }

        return lista;
    }
}
