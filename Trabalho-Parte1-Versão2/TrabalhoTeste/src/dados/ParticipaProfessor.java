package dados;

import java.util.Objects;

public class ParticipaProfessor {
	private int professor_participante;
	private int projeto_numero;
	
	
	public ParticipaProfessor(int professor_participante, int projeto_numero) {
		super();
		this.professor_participante = professor_participante;
		this.projeto_numero = projeto_numero;
	}
	
	public ParticipaProfessor() {
		
	}

//getters and setters
	public int getProfessor_participante() {
		return professor_participante;
	}

	public void setProfessor_participante(int professor_participante) {
		this.professor_participante = professor_participante;
	}

	public int getProjeto_numero() {
		return projeto_numero;
	}

	public void setProjeto_numero(int projeto_numero) {
		this.projeto_numero = projeto_numero;
	}

//equals
	@Override
	public int hashCode() {
		return Objects.hash(professor_participante, projeto_numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParticipaProfessor other = (ParticipaProfessor) obj;
		return professor_participante == other.professor_participante && projeto_numero == other.projeto_numero;
	}

//string to string
	@Override
	public String toString() {
		return "ParticipaProfessor [professor_participante=" + professor_participante + ", projeto_numero="
				+ projeto_numero + "]";
	}
	

	
	
	
}
