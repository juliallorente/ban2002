package dados;

import java.util.Objects;

import org.bson.types.ObjectId;

public class Professor {

    private ObjectId id;
	private int matricula;
	private String nome;
	private int idade;
	private String sala;
	private String especialidade;
	
	
	public Professor(ObjectId id, int matricula, String nome, int idade, String sala, String especialidade) {
        this.id = id;
		this.matricula = matricula;
		this.nome = nome;
		this.idade = idade;
		this.sala = sala;
		this.especialidade = especialidade;
	}
	
	public Professor(){
		
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
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getSala() {
		return sala;
	}
	public void setSala(String sala) {
		this.sala = sala;
	}
	public String getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	
//equals

	@Override
	public int hashCode() {
		return Objects.hash(especialidade, idade, matricula, nome, sala);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Professor other = (Professor) obj;
		return Objects.equals(especialidade, other.especialidade) && idade == other.idade
				&& Objects.equals(matricula, other.matricula) && Objects.equals(nome, other.nome)
				&& Objects.equals(sala, other.sala);
	}

	
//string to string
	
	@Override
	public String toString() {
		return "\n"
				+ "Matrícula: " + matricula + ", Nome:" + nome +", Idade: " + idade + ", Sala: " + sala+", Especialidade: " + especialidade;
	}
	
	
}
