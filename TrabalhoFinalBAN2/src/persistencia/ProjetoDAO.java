package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    private PreparedStatement selectEstProj = null;
    private PreparedStatement selectProfProj = null;
    private PreparedStatement selectProfEstDep = null;



    
    public static ProjetoDAO getInstance() throws ClassNotFoundException, SQLException {

        if(instance == null){
            instance = new ProjetoDAO();
        }
        return instance;
    }
    
    private ProjetoDAO() throws ClassNotFoundException, SQLException {
        Connection conexao = Conexao.getConexao();

        insert = conexao.prepareStatement("insert into projeto values (?, ?,?,?,?,?,?);");
        delete = conexao.prepareStatement("delete from projeto where numero = ?;");
        update = conexao.prepareStatement("update projeto set nome_proj = ?, financiador = ?, orcamento = ?, data_inicio = ?, data_final = ?, pesquisador_principal = ? where numero = ?;");
        select = conexao.prepareStatement("select * from projeto where numero = ?;");
        selectAll = conexao.prepareStatement("select * from projeto;");
        selectEstProj = conexao.prepareStatement("select e.nome, nome_proj from estudantePos e join participa_aluno on e.matricula = id_part_aluno join projeto p on proj_num = p.numero");
        selectProfProj = conexao.prepareStatement("select p.nome, nome_proj from professor p join participa_professor on p.matricula = id_part_prof join projeto on proj_num = numero");
        selectProfEstDep = conexao.prepareStatement("select p.nome, departamento.nome from professor p join trabalha on p.matricula = id_trab join departamento on dep_num = departamento.numero");

    
    }

    public void insert(Projeto projeto) throws SelectException, InsertException {

        try {
            insert.setInt(1, projeto.getNumero());
            insert.setString(2, projeto.getNome_proj());
            insert.setString(3, projeto.getFinanciador());
            insert.setDouble(4, projeto.getOrcamento());
            insert.setString(5, projeto.getData_inicio()); 
            insert.setString(6, projeto.getData_final());
            insert.setInt(7, projeto.getPesquisador_principal());
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
        	update.setString(1, projeto.getNome_proj());
        	update.setString(2, projeto.getFinanciador());
            update.setDouble(3, projeto.getOrcamento());
            update.setString(4, projeto.getData_inicio()); 
            update.setString(5, projeto.getData_final());
            update.setInt(6, projeto.getPesquisador_principal());
            update.setInt(7, projeto.getNumero());
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
            	String nome_proj = rs.getString(2);
                String financiador = rs.getString(3);
                double orcamento = rs.getDouble(4);
                String data_incio = rs.getString(5); 
                String data_final = rs.getString(6);
                int pesquisador_principal = rs.getInt(7);
                
                

                return new Projeto(numero, nome_proj, financiador, orcamento, data_incio, data_final, pesquisador_principal);
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
                String nome_proj = rs.getString(2);
                String financiador = rs.getString(3);
                double orcamento = rs.getDouble(4);
                String data_incio = rs.getString(5); 
                String data_final = rs.getString(6);
                int pesquisador_principal = rs.getInt(7);

                
                lista.add(new Projeto(numero, nome_proj, financiador, orcamento, data_incio, data_final, pesquisador_principal));
            }
        } catch (SQLException e) {
            throw new SelectException("projeto");
        }

        return lista;
    }
    
    public List<Projeto> selectEstudanteProj() throws SelectException {

        List<Projeto> lista = new LinkedList<>();

        try {
            ResultSet rs = selectAll.executeQuery();

            while(rs.next()){
                int numero = rs.getInt(1);
                String nome_proj = rs.getString(2);
                String financiador = rs.getString(3);
                double orcamento = rs.getDouble(4);
                String data_incio = rs.getString(5); 
                String data_final = rs.getString(6);
                int pesquisador_principal = rs.getInt(7);

                
                lista.add(new Projeto(numero, nome_proj, financiador, orcamento, data_incio, data_final, pesquisador_principal));
            }
        } catch (SQLException e) {
            throw new SelectException("projeto");
        }

        return lista;
    }
    
    public List<Object> EstProjeto() throws SelectException {
    	List<Object> lista = new ArrayList<Object>();
    	
  	  try {
  		  ResultSet rs = selectEstProj.executeQuery();
  		  
  		  while(rs.next()) {
  			 Object[] linha = {rs.getString(1), rs.getString(2)};
  			  
  			 lista.add(linha);
  		  }
  	  }catch(SQLException e) {
  		  throw new SelectException("Estudante de um projeto");
  	  }
  	  return lista;
    }
    
    public List<Object> ProfProjeto() throws SelectException {
    	List<Object> lista = new ArrayList<Object>();
    	
  	  try {
  		  ResultSet rs = selectProfProj.executeQuery();
  		  
  		  while(rs.next()) {
  			 Object[] linha = {rs.getString(1), rs.getString(2)};
  			  
  			 lista.add(linha);
  		  }
  	  }catch(SQLException e) {
  		  throw new SelectException("Professor de um projeto");
  	  }
  	  return lista;
    }
    
}
