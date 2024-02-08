package persistencia;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

import dados.Departamento;
import dados.Professor;
import exception.DeleteException;
import exception.InsertException;
import exception.SelectException;
import exception.UpdateException;

import java.util.ArrayList;
import java.util.List;

public class ProfessorDAO {

    private static ProfessorDAO instance = null;
    private DepartamentoDAO departamentoDAO;
    private MongoCollection<Document> collection;

    public static ProfessorDAO getInstance() {
        if (instance == null) {
            instance = new ProfessorDAO();
        }
        return instance;
    }

    private ProfessorDAO() {
        MongoDatabase database = Conexao.getConexao();
        collection = database.getCollection("professor");
    }

    public void insert(Professor professor) throws SelectException, InsertException {
        Document document = new Document("_id", new ObjectId())
                .append("matricula", professor.getMatricula())
                .append("nomeProfessor", professor.getNome())
                .append("idade", professor.getIdade())
                .append("sala", professor.getSala())
                .append("especialidade", professor.getEspecialidade());
        collection.insertOne(document);
    }

    public void delete(Professor professor) throws DeleteException {
        Document filter = new Document("matricula", professor.getMatricula());
        collection.deleteOne(filter);
    }

    public void update(Professor professor) throws UpdateException {
        Document filter = new Document("matricula", professor.getMatricula());
        Document update = new Document("$set", new Document("nomeProfessor", professor.getNome())
                .append("idade", professor.getIdade())
                .append("sala", professor.getSala())
                .append("especialidade", professor.getEspecialidade()));
        collection.updateOne(filter, update);
    }

    public Professor select(int matricula) throws SelectException {
        Document filter = new Document("matricula", matricula);
        Document document = collection.find(filter).first();

        if (document != null) {
            ObjectId id = document.getObjectId("_id");
            String nome = document.getString("nomeProfessor");
            int idade = document.getInteger("idade");
            String sala = document.getString("sala");
            String especialidade = document.getString("especialidade");

            return new Professor(id, matricula, nome, idade, sala, especialidade);
        }

        return null;
    }

    public List<Professor> selectAll() throws SelectException {
        List<Professor> lista = new ArrayList<>();

        for (Document document : collection.find()) {
            ObjectId id = document.getObjectId("_id");
            int matricula = document.getInteger("matricula");
            String nome = document.getString("nomeProfessor");
            int idade = document.getInteger("idade");
            String sala = document.getString("sala");
            String especialidade = document.getString("especialidade");

            lista.add(new Professor(id, matricula, nome, idade, sala, especialidade));
        }

        return lista;
    }

}
