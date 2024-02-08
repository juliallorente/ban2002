package persistencia;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import dados.Departamento;
import dados.Professor;
import exception.DeleteException;
import exception.InsertException;
import exception.SelectException;
import exception.UpdateException;
import org.bson.Document;
import org.bson.types.ObjectId;
import java.util.ArrayList;
import java.util.List;

public class DepartamentoDAO {
	 private static DepartamentoDAO instance = null;
	    private MongoCollection<Document> collection;
	    private ProfessorDAO professorDAO; // Dependência do ProfessorDAO

	    public static DepartamentoDAO getInstance() {
	        if (instance == null) {
	            instance = new DepartamentoDAO();
	        }
	        return instance;
	    }

	    private DepartamentoDAO() {
	        MongoDatabase database = Conexao.getConexao();
	        collection = database.getCollection("departamento");
	        professorDAO = ProfessorDAO.getInstance(); // Inicialização do ProfessorDAO
	    }

	    public void insert(Departamento departamento) throws InsertException, SelectException {
	        Document document = new Document("_id", new ObjectId())
	                .append("numero", departamento.getNumero())
	                .append("escritorio_princ", departamento.getEscritorio_princ())
	                .append("nomeDep", departamento.getNome());

	        if (departamento.getLider() != null) {
	            Professor lider = professorDAO.select(departamento.getLider().getMatricula());
	            if (lider != null) {
	                document.append("lider", professorToDocument(lider));
	            }
	        }
	        
	        if (departamento.getProfessores() != null) {
	            document.append("professores", professoresToDocumentList(departamento.getProfessores()));
	        }

	        collection.insertOne(document);
	    }

    public void delete(Departamento departamento) throws DeleteException {
        Document filter = new Document("_id", departamento.getId());
        collection.deleteOne(filter);
    }

    public void update(Departamento departamento) throws UpdateException {
        Document filter = new Document("_id", departamento.getId());
        Document update = new Document("$set", new Document("numero", departamento.getNumero())
                .append("escritorio_princ", departamento.getEscritorio_princ())
                .append("nomeDep", departamento.getNome())
                .append("lider", professorToDocument(departamento.getLider())));

        collection.updateOne(filter, update);
    }

    public Departamento select(int numero) throws SelectException {
        Document query = new Document("numero", numero);
        Document document = collection.find(query).first();

        if (document != null) {
            ObjectId id = document.getObjectId("_id");
            String escritorio_princ = document.getString("escritorio_princ");
            String nome = document.getString("nomeDep");
            Document liderDoc = document.get("lider", Document.class);
            Professor lider = documentToProfessor(liderDoc);

            return new Departamento(id, numero, escritorio_princ, nome, lider);
        }

        return null; // Departamento não encontrado
    }

    public List<Departamento> selectAll() throws SelectException {
        List<Departamento> lista = new ArrayList<>();

        for (Document document : collection.find()) {
            ObjectId id = document.getObjectId("_id");
            int numero = document.getInteger("numero");
            String escritorio_princ = document.getString("escritorio_princ");
            String nome = document.getString("nomeDep");
            Document liderDoc = document.get("lider", Document.class);
            Professor lider = documentToProfessor(liderDoc);
            
                Departamento departamento = new Departamento(id, numero, escritorio_princ, nome, lider);
                lista.add(departamento);
        }

        return lista;
    }
    
    public void adicionarProfessor(int matriculaProfessor, int numeroDepartamento) throws SelectException, UpdateException {
        Departamento departamento = select(numeroDepartamento);
        Professor professor = professorDAO.select(matriculaProfessor);

        if (departamento != null && professor != null) {
            List<Professor> professores = departamento.getProfessores();

            if (professores == null) {
                professores = new ArrayList<>();
                departamento.setProfessores(professores);
            }

            if (!professores.contains(professor)) { // Verifica se o professor já está na lista
                professores.add(professor);
                updateProfessores(departamento);
            }
        }
    }
    
    private void updateProfessores(Departamento departamento) throws UpdateException {
        Document filter = new Document("_id", departamento.getId());
        Document update = new Document("$set", new Document("professores", professoresToDocumentList(departamento.getProfessores())));
        collection.updateOne(filter, update);
    }
    
    private Document professorToDocument(Professor professor) {
        return new Document()
                .append("matricula", professor.getMatricula())
                .append("nomeProfessor", professor.getNome())
                .append("idade", professor.getIdade())
                .append("sala", professor.getSala())
                .append("especialidade", professor.getEspecialidade());
    }
    
    private List<Document> professoresToDocumentList(List<Professor> professores) {
        List<Document> professoresDoc = new ArrayList<>();

        for (Professor professor : professores) {
            Document professorDoc = professorToDocument(professor);
            professoresDoc.add(professorDoc);
        }

        return professoresDoc;
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
    
    private List<Professor> documentListToProfessores(List<Document> professoresDoc) {
        List<Professor> professores = new ArrayList<>();

        for (Document professorDoc : professoresDoc) {
            Professor professor = documentToProfessor(professorDoc);
            professores.add(professor);
        }

        return professores;
    }
    

}
