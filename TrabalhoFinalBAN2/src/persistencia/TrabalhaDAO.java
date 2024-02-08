package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import dados.Projeto;
import dados.Trabalha;
import exception.DeleteException;
import exception.InsertException;
import exception.SelectException;
import exception.UpdateException;

public class TrabalhaDAO {
	private static TrabalhaDAO instance = null;
	private static ProfessorDAO professorDAO = null;
	private static DepartamentoDAO departamentoDAO = null;
	
	private PreparedStatement selectNewId;
	private PreparedStatement insert;
    private PreparedStatement delete;
    private PreparedStatement update;
    private PreparedStatement select;
    private PreparedStatement selectAll;
    
    public static TrabalhaDAO getInstance() throws ClassNotFoundException, SQLException{
    	if(instance == null) {
    		instance = new TrabalhaDAO();
    	}
    	return instance;
    }
    
    private TrabalhaDAO() throws ClassNotFoundException, SQLException{
    	Connection conexao = Conexao.getConexao();
    	selectNewId = conexao.prepareStatement("select nextval('trab_id_seq');");
    	insert = conexao.prepareStatement("insert into trabalha values(?, ?, ?, ?);");
    	delete = conexao.prepareStatement("delete from trabalha where id_trab = ?;");
    	update = conexao.prepareStatement("update trabalha set mat_prof = ?, dep_num = ?, tempo = ? where id_trab = ?;");
    	select = conexao.prepareStatement("select * from trabalha  where id_trab = ?;");
    	selectAll = conexao.prepareStatement("select * from trabalha;");
    	
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
            throw new SelectException("novo id da tabela trabalha");
        }
        return 0;
    }
    
    public void insert(Trabalha trabalha) throws SelectException, InsertException {

        try {
        	insert.setInt(1, selectNewId());
            insert.setInt(2, trabalha.getDep_num());
            insert.setInt(3, trabalha.getMatricula_prof());
            insert.setFloat(4, trabalha.getTempo());
            insert.executeUpdate();
        } catch (SQLException e) {
            throw new InsertException("trabalha");
        }

    }
    public void delete(Trabalha trabalha) throws DeleteException {

        try {
            delete.setInt(1, trabalha.getId_trab());
            delete.executeUpdate();
        } catch (SQLException e) {
            throw new DeleteException("trabalha");
        }
    }
    
    public void update(Trabalha trabalha) throws UpdateException {

        try {          
        	update.setInt(1, trabalha.getDep_num());
            update.setInt(2, trabalha.getMatricula_prof());
            update.setFloat(3, trabalha.getTempo()); 
            update.setInt(4, trabalha.getId_trab());
            update.executeUpdate();
        } catch (SQLException e) {
            throw new UpdateException("trabalha");
        }

    }
    
    public Trabalha select(int id_trab) throws SelectException {

        try {
            select.setInt(1, id_trab);
            ResultSet rs = select.executeQuery();

            if(rs.next()){
                int dep_num = rs.getInt(2);
                int mat_prof = rs.getInt(3);
                float tempo  = rs.getFloat(4);
                
                

                return new Trabalha(id_trab, dep_num, mat_prof, tempo);
            }

        } catch (SQLException e) {
            throw new SelectException("projeto");
        }

        return null;

    }
    
    public List<Trabalha> selectAll() throws SelectException {

        List<Trabalha> lista = new LinkedList<>();

        try {
            ResultSet rs = selectAll.executeQuery();

            while(rs.next()){
                int id_trab = rs.getInt(1);
                int dep_num = rs.getInt(2);
                int mat_prof = rs.getInt(3);
                float tempo = rs.getFloat(4); 

                
                lista.add(new Trabalha(id_trab, dep_num, mat_prof, tempo));
            }
        } catch (SQLException e) {
            throw new SelectException("trabalha");
        }

        return lista;
    }
}
