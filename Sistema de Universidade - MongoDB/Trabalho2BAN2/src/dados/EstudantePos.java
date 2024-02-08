package dados;

import java.util.Objects;

import org.bson.types.ObjectId;

public class EstudantePos {

    private ObjectId id;
	private int matricula;
	private String nome;
	private String tipo_curso;
	private int idade;
	private Departamento dep;	
	
	public EstudantePos(ObjectId id, int matricula, String nome, String tipo_curso, int idade, Departamento dep) {
        this.id = id;
		this.matricula = matricula;
		this.nome = nome;
		this.tipo_curso = tipo_curso;
		this.idade = idade;
		this.dep = dep;
	}
	
	public EstudantePos(){
		
	}
	
//getters and setters
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }
	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo_curso() {
		return tipo_curso;
	}

	public void setTipo_curso(String tipo_curso) {
		this.tipo_curso = tipo_curso;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Departamento getDep() {
		return dep;
	}

	public void setDep(Departamento dep) {
		this.dep = dep;
	}
	
//equals
	
	@Override
	public int hashCode() {
		return Objects.hash(dep, idade, matricula, nome, tipo_curso);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EstudantePos other = (EstudantePos) obj;
		return dep == other.dep && idade == other.idade
				&& matricula == other.matricula && Objects.equals(nome, other.nome)
				&& Objects.equals(tipo_curso, other.tipo_curso);
	}

	
// string to string 
	
	@Override
	public String toString() {
		return "\n" + "Matricula: " + matricula + ", Nome: " + nome + ", Tipo do curso: " + tipo_curso + ", Idade: "
				+ idade + ", Departamento: " + dep.getNome();
	}
	
}
