package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import dados.*;
import exception.DeleteException;
import exception.InsertException;
import exception.SelectException;
import exception.UpdateException;

public class EstudantePosDAO {
	private static EstudantePosDAO instance = null;
    private MongoCollection<Document> collection;
    private DepartamentoDAO departamentoDAO; // Dependência do DepartamentoDAO
    private ProfessorDAO professorDAO; // Dependência do ProfessorDAO


    public static EstudantePosDAO getInstance() {
        if (instance == null) {
            instance = new EstudantePosDAO();
        }
        return instance;
    }

    private EstudantePosDAO() {
        MongoDatabase database = Conexao.getConexao();
        collection = database.getCollection("estudantepos");
        departamentoDAO = DepartamentoDAO.getInstance(); // Inicialização do DepartamentoDAO
        professorDAO = ProfessorDAO.getInstance();
    }

    public void insert(EstudantePos estudante) throws InsertException, SelectException {
    	   Document document = new Document("_id", new ObjectId())
    	            .append("matricula", estudante.getMatricula())
    	            .append("nome", estudante.getNome())
    	            .append("tipo_curso", estudante.getTipo_curso())
    	            .append("idade", estudante.getIdade());

    	    Departamento dep = departamentoDAO.select(estudante.getDep().getNumero());
    	    if (dep != null) {
    	        document.append("departamento", departamentoToDocument(dep));
    	    }

    	    collection.insertOne(document);
    }

    public void delete(EstudantePos estudante) throws DeleteException {
        Document filter = new Document("_id", estudante.getId());
        collection.deleteOne(filter);
    }

    public void update(EstudantePos estudante) throws UpdateException {
        Document filter = new Document("_id", estudante.getId());
        Document update = new Document("$set", new Document("matricula", estudante.getMatricula())
                .append("nome", estudante.getNome())
                .append("tipo_curso", estudante.getTipo_curso())
                .append("idade", estudante.getIdade())
                .append("departamento", departamentoToDocument(estudante.getDep())));
        collection.updateOne(filter, update);
    }

    public EstudantePos select(int matricula) throws SelectException {
        Document query = new Document("matricula", matricula);
        Document document = collection.find(query).first();

        if (document != null) {
            ObjectId id = document.getObjectId("_id");
            String nome = document.getString("nome");
            String tipo_curso = document.getString("tipo_curso");
            int idade = document.getInteger("idade");
            Document departamentoDoc = document.get("departamento", Document.class);
            Departamento departamento = documentToDepartamento(departamentoDoc);

            return new EstudantePos(id, matricula, nome, tipo_curso, idade, departamento);
        }

        return null; // Estudante não encontrado
    }

    public List<EstudantePos> selectAll() throws SelectException {
        List<EstudantePos> lista = new ArrayList<>();

        for (Document document : collection.find()) {
            ObjectId id = document.getObjectId("_id");
            int matricula = document.getInteger("matricula");
            String nome = document.getString("nome");
            String tipo_curso = document.getString("tipo_curso");
            int idade = document.getInteger("idade");
            Document departamentoDoc = document.get("departamento", Document.class);
            Departamento departamento = documentToDepartamento(departamentoDoc);

            lista.add(new EstudantePos(id, matricula, nome, tipo_curso, idade, departamento));
        }

        return lista;
    }

    private Document departamentoToDocument(Departamento departamento) {
        return new Document()
                .append("numero", departamento.getNumero())
                .append("escritorio_princ", departamento.getEscritorio_princ())
                .append("nomeDep", departamento.getNome())
                .append("lider", professorToDocument(departamento.getLider()));
    }

    private Departamento documentToDepartamento(Document document) {
        ObjectId id = document.getObjectId("_id");
        int numero = document.getInteger("numero");
        String escritorio_princ = document.getString("escritorio_princ");
        String nome = document.getString("nomeDep");
        Document liderDoc = document.get("lider", Document.class);
        Professor lider = documentToProfessor(liderDoc);

        return new Departamento(id, numero, escritorio_princ, nome, lider);
    }

    private Document professorToDocument(Professor professor) {
        return new Document()
                .append("matricula", professor.getMatricula())
                .append("nomeProfessor", professor.getNome())
                .append("idade", professor.getIdade())
                .append("sala", professor.getSala())
                .append("especialidade", professor.getEspecialidade());
    }

    private Professor documentToProfessor(Document document) {
        ObjectId id = document.getObjectId("_id");
        int matricula = document.getInteger("matricula");
        String nome = document.getString("nomeProfessor");
        int idade = document.getInteger("idade");
        String sala = document.getString("sala");
        String especialidade = document.getString("especialidade");

        return new Professor(id, matricula, nome, idade, sala, especialidade);
    }
}
