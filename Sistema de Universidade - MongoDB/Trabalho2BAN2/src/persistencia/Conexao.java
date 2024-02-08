package persistencia;

import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
public class Conexao {
	   private static MongoClient clienteMongo = null;
	    private static MongoDatabase bancoDeDados = null;

	    private Conexao() {}

	    public static MongoDatabase getConexao() {

	        if (bancoDeDados == null) {
	            String connectionString = "mongodb://localhost:27017"; // substitua pelo endereço e porta corretos se necessário
	            MongoClientURI uri = new MongoClientURI(connectionString);
	            clienteMongo = new MongoClient(uri);
	            bancoDeDados = clienteMongo.getDatabase("ban2teste"); // substitua pelo nome do seu banco de dados
	        }

	        return bancoDeDados;
	    }
}
