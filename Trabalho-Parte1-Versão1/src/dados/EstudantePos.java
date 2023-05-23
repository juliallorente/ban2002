package dados;

import java.util.Objects;

public class EstudantePos {

	private int matricula;
	private String nome;
	private String tipo_curso;
	private int idade;
	private int dep;
	private int aconselhador;
	
	
	public EstudantePos(int matricula, String nome, String tipo_curso, int idade, int dep, int aconselhador) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.tipo_curso = tipo_curso;
		this.idade = idade;
		this.dep = dep;
		this.aconselhador = aconselhador;
	}
	
	public EstudantePos(){
		
	}
	
//getters and setters
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

	public int getDep() {
		return dep;
	}

	public void setDep(int dep) {
		this.dep = dep;
	}

	public int getAconselhador() {
		return aconselhador;
	}

	public void setAconselhador(int aconselhador) {
		this.aconselhador = aconselhador;
	}
	
//equals
	
	@Override
	public int hashCode() {
		return Objects.hash(aconselhador, dep, idade, matricula, nome, tipo_curso);
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
		return aconselhador == other.aconselhador && dep == other.dep && idade == other.idade
				&& matricula == other.matricula && Objects.equals(nome, other.nome)
				&& Objects.equals(tipo_curso, other.tipo_curso);
	}

	
// string to string 
	
	@Override
	public String toString() {
		return "EstudantePos [matricula=" + matricula + ", nome=" + nome + ", tipo_curso=" + tipo_curso + ", idade="
				+ idade + ", dep=" + dep + ", aconselhador=" + aconselhador + "]";
	}
	
}
