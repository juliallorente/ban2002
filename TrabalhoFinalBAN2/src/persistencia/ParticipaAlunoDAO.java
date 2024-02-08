package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import dados.ParticipaAluno;
import exception.DeleteException;
import exception.InsertException;
import exception.SelectException;
import exception.UpdateException;

public class ParticipaAlunoDAO {
	private static ParticipaAlunoDAO instance = null;
	private static ProfessorDAO professorDAO = null;
	private static DepartamentoDAO departamentoDAO = null;
	
	private PreparedStatement selectNewId;
	private PreparedStatement insert;
    private PreparedStatement delete;
    private PreparedStatement update;
    private PreparedStatement select;
    private PreparedStatement selectAll;
    
    public static ParticipaAlunoDAO getInstance() throws ClassNotFoundException, SQLException{
    	if(instance == null) {
    		instance = new ParticipaAlunoDAO();
    	}
    	return instance;
    }
    
    private ParticipaAlunoDAO() throws ClassNotFoundException, SQLException{
    	Connection conexao = Conexao.getConexao();
    	selectNewId = conexao.prepareStatement("select nextval('id_part_aluno_seq');");
    	insert = conexao.prepareStatement("insert into participa_aluno values(?, ?, ?, ?);");
    	delete = conexao.prepareStatement("delete from participa_aluno where id_part_aluno = ?;");
    	update = conexao.prepareStatement("update participa_aluno set aluno_participante = ?, proj_num = ?, prof_supervisor = ? where id_part_aluno = ?;");
    	select = conexao.prepareStatement("select * from participa_aluno where id_part_aluno = ?;");
    	selectAll = conexao.prepareStatement("select * from participa_aluno;");

    	
    	professorDAO = ProfessorDAO.getInstance();
    	departamentoDAO = DepartamentoDAO.getInstance();
    }
    private int selectNewId() throws SelectException {
        try {
            ResultSet rs = selectNewId.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new SelectException("novo id da tabela ParticipaAluno");
        }
        return 0;
    }
    
    public void insert(ParticipaAluno participaAluno) throws SelectException, InsertException {

        try {
        	insert.setInt(1, selectNewId());
            insert.setInt(2, participaAluno.getAluno_participante());
            insert.setInt(3, participaAluno.getProjeto_numero());
            insert.setInt(4, participaAluno.getProf_supervisor());
            insert.executeUpdate();
        } catch (SQLException e) {
            throw new InsertException("participaAluno");
        }

    }
    public void delete(ParticipaAluno participaAluno) throws DeleteException {

        try {
            delete.setInt(1, participaAluno.getId_part_aluno());
            delete.executeUpdate();
        } catch (SQLException e) {
            throw new DeleteException("participaAluno");
        }
    }
    
    public void update(ParticipaAluno participaAluno) throws UpdateException {

        try {          
            update.setInt(1, participaAluno.getAluno_participante());
            update.setInt(2, participaAluno.getProjeto_numero());
            update.setInt(3, participaAluno.getProf_supervisor());
            update.setInt(4, participaAluno.getId_part_aluno());
            update.executeUpdate();
        } catch (SQLException e) {
            throw new UpdateException("participaAluno");
        }

    }
    
    public ParticipaAluno select(int id_part_aluno) throws SelectException {

        try {
            select.setInt(1, id_part_aluno);
            ResultSet rs = select.executeQuery();

            if(rs.next()){
                int aluno_participante = rs.getInt(2);
                int proj_num = rs.getInt(3);
                int prof_supervisor = rs.getInt(4);
                
                

                return new ParticipaAluno(id_part_aluno, aluno_participante, proj_num, prof_supervisor);
            }

        } catch (SQLException e) {
            throw new SelectException("participaAluno");
        }

        return null;

    }
    
    public List<ParticipaAluno> selectAll() throws SelectException {

        List<ParticipaAluno> lista = new LinkedList<>();

        try {
            ResultSet rs = selectAll.executeQuery();

            while(rs.next()){
                int id_part_aluno = rs.getInt(1);
                int aluno_participante = rs.getInt(2);
                int proj_num = rs.getInt(3);
                int prof_supervisor = rs.getInt(4);

                
                lista.add(new ParticipaAluno(id_part_aluno, aluno_participante, proj_num, prof_supervisor));
            }
        } catch (SQLException e) {
            throw new SelectException("participaAluno");
        }

        return lista;
    }
}
