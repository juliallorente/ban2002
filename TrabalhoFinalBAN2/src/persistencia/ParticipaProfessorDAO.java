package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import dados.ParticipaProfessor;
import dados.Trabalha;
import exception.DeleteException;
import exception.InsertException;
import exception.SelectException;
import exception.UpdateException;

public class ParticipaProfessorDAO {
	private static ParticipaProfessorDAO instance = null;
	private static ProfessorDAO professorDAO = null;
	private static DepartamentoDAO departamentoDAO = null;
	
	private PreparedStatement selectNewId;
	private PreparedStatement insert;
    private PreparedStatement delete;
    private PreparedStatement update;
    private PreparedStatement select;
    private PreparedStatement selectAll;

    
    public static ParticipaProfessorDAO getInstance() throws ClassNotFoundException, SQLException{
    	if(instance == null) {
    		instance = new ParticipaProfessorDAO();
    	}
    	return instance;
    }
    
    private ParticipaProfessorDAO() throws ClassNotFoundException, SQLException{
    	Connection conexao = Conexao.getConexao();
    	selectNewId = conexao.prepareStatement("select nextval('id_part_prof_seq');");
    	insert = conexao.prepareStatement("insert into participa_professor values(?, ?, ?);");
    	delete = conexao.prepareStatement("delete from participa_professor where id_part_prof = ?;");
    	update = conexao.prepareStatement("update participa_professor set prof_participante = ?, proj_num = ? where id_part_prof = ?;");
    	select = conexao.prepareStatement("select * from participa_professor where id_part_prof = ?;");
    	selectAll = conexao.prepareStatement("select * from participa_professor;");
    	
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
            throw new SelectException("novo id da tabela ParticipaProfessor");
        }
        return 0;
    }
    
    public void insert(ParticipaProfessor participaProf) throws SelectException, InsertException {

        try {
        	insert.setInt(1, selectNewId());
            insert.setInt(2, participaProf.getProfessor_participante());
            insert.setInt(3, participaProf.getProjeto_numero());
            insert.executeUpdate();
        } catch (SQLException e) {
            throw new InsertException("participaProf");
        }

    }
    public void delete(ParticipaProfessor participaProf) throws DeleteException {

        try {
            delete.setInt(1, participaProf.getId_part_prof());
            delete.executeUpdate();
        } catch (SQLException e) {
            throw new DeleteException("participaProf");
        }
    }
    
    public void update(ParticipaProfessor participaProf) throws UpdateException {

        try {          
            update.setInt(1, participaProf.getProfessor_participante());
            update.setInt(2, participaProf.getProjeto_numero());
            update.setInt(3, participaProf.getId_part_prof());
            update.executeUpdate();
        } catch (SQLException e) {
            throw new UpdateException("participaProf");
        }

    }
    
    public ParticipaProfessor select(int id_part_prof) throws SelectException {

        try {
            select.setInt(1, id_part_prof);
            ResultSet rs = select.executeQuery();

            if(rs.next()){
                int prof_participante = rs.getInt(2);
                int proj_num = rs.getInt(3);
                
                

                return new ParticipaProfessor(id_part_prof, prof_participante, proj_num);
            }

        } catch (SQLException e) {
            throw new SelectException("participaProf");
        }

        return null;

    }
    
    public List<ParticipaProfessor> selectAll() throws SelectException {

        List<ParticipaProfessor> lista = new LinkedList<>();

        try {
            ResultSet rs = selectAll.executeQuery();

            while(rs.next()){
                int id_part_prof = rs.getInt(1);
                int prof_participante = rs.getInt(2);
                int proj_num = rs.getInt(3);

                
                lista.add(new ParticipaProfessor(id_part_prof, prof_participante, proj_num));
            }
        } catch (SQLException e) {
            throw new SelectException("participaProf");
        }

        return lista;
    }
}
