package dados;

import java.util.Objects;

public class ParticipaProfessor {
	private int id_part_prof;
	private int professor_participante;
	private int projeto_numero;
	
	
	public ParticipaProfessor(int id_part_prof, int professor_participante, int projeto_numero) {
		super();
		this.id_part_prof = id_part_prof;
		this.professor_participante = professor_participante;
		this.projeto_numero = projeto_numero;
	}
	
	public ParticipaProfessor() {
		
	}

	public int getId_part_prof() {
		return id_part_prof;
	}

	public void setId_part_prof(int id_part_prof) {
		this.id_part_prof = id_part_prof;
	}

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

	@Override
	public int hashCode() {
		return Objects.hash(id_part_prof, professor_participante, projeto_numero);
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
		return id_part_prof == other.id_part_prof && professor_participante == other.professor_participante
				&& projeto_numero == other.projeto_numero;
	}

	@Override
	public String toString() {
		return "ParticipaProfessor [id_part_prof=" + id_part_prof + ", professor_participante=" + professor_participante
				+ ", projeto_numero=" + projeto_numero + "]";
	}


	
}
