package dados;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import persistencia.*;

import org.bson.types.ObjectId;

public class Departamento {

    private ObjectId id;
	private int numero;
	private String escritorio_princ;
	private String nome;
	private Professor lider; //professor já existente
	private List<Professor> professores; // lista de professores

	
	
	public Departamento(ObjectId id, int numero, String escritorio_princ, String nome, Professor lider) {
        this.id = id;
		this.numero = numero;
		this.escritorio_princ = escritorio_princ;
		this.nome = nome;
		this.lider = lider;
		this.professores = new ArrayList<>();

	}
	
	public Departamento(){
		
	}
	
//getters and setters
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }
    
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getEscritorio_princ() {
		return escritorio_princ;
	}

	public void setEscritorio_princ(String escritorio_princ) {
		this.escritorio_princ = escritorio_princ;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Professor getLider() {
		return lider;
	}

	public void setLider(Professor lider) {
		this.lider = lider;
	}
	
	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}

	public void adicionarProfessor(Professor professor) {
		professores.add(professor);
	}
	
//equals
	@Override
	public int hashCode() {
		return Objects.hash(escritorio_princ, lider, nome, numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departamento other = (Departamento) obj;
		return Objects.equals(escritorio_princ, other.escritorio_princ) && lider == other.lider
				&& Objects.equals(nome, other.nome) && numero == other.numero;
	}

//string to string
	@Override
	public String toString() {
		return "\n" + "Numero: " + numero + ", Nome: " + nome +  ", Escritório principal: " + escritorio_princ+ ", Líder: " + lider.getNome()+ ", Professores: " + professores;
	}
	
}
