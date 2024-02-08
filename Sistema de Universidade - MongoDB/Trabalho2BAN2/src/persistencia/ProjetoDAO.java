package persistencia;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import dados.Professor;
import dados.Projeto;
import exception.DeleteException;
import exception.InsertException;
import exception.SelectException;
import exception.UpdateException;
import org.bson.Document;
import org.bson.types.ObjectId;
import java.util.ArrayList;
import java.util.List;

public class ProjetoDAO {
    private static ProjetoDAO instance = null;
    private MongoCollection<Document> collection;
    private ProfessorDAO professorDAO; // Dependência do ProfessorDAO

    public static ProjetoDAO getInstance() {
        if (instance == null) {
            instance = new ProjetoDAO();
        }
        return instance;
    }

    private ProjetoDAO() {
        MongoDatabase database = Conexao.getConexao();
        collection = database.getCollection("projeto");
        professorDAO = ProfessorDAO.getInstance(); // Inicialização do ProfessorDAO
    }

    public void insert(Projeto projeto) throws InsertException, SelectException {
        Document document = new Document("_id", new ObjectId())
                .append("numero", projeto.getNumero())
                .append("nome_proj", projeto.getNome_proj())
                .append("financiador", projeto.getFinanciador())
                .append("orcamento", projeto.getOrcamento())
                .append("data_inicio", projeto.getData_inicio())
                .append("data_final", projeto.getData_final());
                
        if (projeto.getPesquisador_principal() != null) {
        	Professor pesquisador = professorDAO.select(projeto.getPesquisador_principal().getMatricula());
        	if (pesquisador != null) {
        		document.append("pesquisador_principal", professorToDocument(pesquisador));
        	}
        }
        collection.insertOne(document);
    }

    public void delete(Projeto projeto) throws DeleteException {
        Document filter = new Document("_id", projeto.getId());
        collection.deleteOne(filter);
    }

    public void update(Projeto projeto) throws UpdateException {
        Document filter = new Document("_id", projeto.getId());
        Document update = new Document("$set", new Document("numero", projeto.getNumero())
                .append("nome_proj", projeto.getNome_proj())
                .append("financiador", projeto.getFinanciador())
                .append("orcamento", projeto.getOrcamento())
                .append("data_inicio", projeto.getData_inicio())
                .append("data_final", projeto.getData_final())
                .append("pesquisador_principal", professorToDocument(projeto.getPesquisador_principal())));
        collection.updateOne(filter, update);
    }

    public Projeto select(int numero) throws SelectException {
        Document query = new Document("numero", numero);
        Document document = collection.find(query).first();

        if (document != null) {
            ObjectId id = document.getObjectId("_id");
            String nome_proj = document.getString("nome_proj");
            String financiador = document.getString("financiador");
            int orcamento = document.getInteger("orcamento");
            String data_inicio = document.getString("data_inicio");
            String data_final = document.getString("data_final");
            Document pesquisadorPrincipalDoc = document.get("pesquisador_principal", Document.class);
            Professor pesquisadorPrincipal = documentToProfessor(pesquisadorPrincipalDoc);

            return new Projeto(id, numero, nome_proj, financiador, orcamento, data_inicio, data_final,
                    pesquisadorPrincipal);
        }

        return null; // Projeto não encontrado
    }

    public List<Projeto> selectAll() throws SelectException {
        List<Projeto> lista = new ArrayList<>();

        for (Document document : collection.find()) {
            ObjectId id = document.getObjectId("_id");
            int numero = document.getInteger("numero");
            String nome_proj = document.getString("nome_proj");
            String financiador = document.getString("financiador");
            int orcamento = document.getInteger("orcamento");
            String data_inicio = document.getString("data_inicio");
            String data_final = document.getString("data_final");
            Document pesquisadorPrincipalDoc = document.get("pesquisador_principal", Document.class);
            Professor pesquisadorPrincipal = documentToProfessor(pesquisadorPrincipalDoc);

            Projeto projeto = new Projeto(id, numero, nome_proj, financiador, orcamento, data_inicio, data_final,
                    pesquisadorPrincipal);
            lista.add(projeto);
        }

        return lista;
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
