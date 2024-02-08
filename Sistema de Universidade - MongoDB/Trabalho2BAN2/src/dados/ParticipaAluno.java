package dados;

import java.util.Objects;

public class ParticipaAluno {

	private int id_part_aluno;
	private int aluno_participante;
	private int projeto_numero;
	private int prof_supervisor;
	
	
	public ParticipaAluno(int id_part_aluno, int aluno_participante, int projeto_numero, int prof_supervisor) {
		super();
		this.id_part_aluno = id_part_aluno;
		this.aluno_participante = aluno_participante;
		this.projeto_numero = projeto_numero;
		this.prof_supervisor = prof_supervisor;
	}
	
	public ParticipaAluno() {
		
	}

	public int getId_part_aluno() {
		return id_part_aluno;
	}

	public void setId_part_aluno(int id_part_aluno) {
		this.id_part_aluno = id_part_aluno;
	}

	public int getAluno_participante() {
		return aluno_participante;
	}

	public void setAluno_participante(int aluno_participante) {
		this.aluno_participante = aluno_participante;
	}

	public int getProjeto_numero() {
		return projeto_numero;
	}

	public void setProjeto_numero(int projeto_numero) {
		this.projeto_numero = projeto_numero;
	}

	public int getProf_supervisor() {
		return prof_supervisor;
	}

	public void setProf_supervisor(int prof_supervisor) {
		this.prof_supervisor = prof_supervisor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(aluno_participante, id_part_aluno, prof_supervisor, projeto_numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParticipaAluno other = (ParticipaAluno) obj;
		return aluno_participante == other.aluno_participante && id_part_aluno == other.id_part_aluno
				&& prof_supervisor == other.prof_supervisor && projeto_numero == other.projeto_numero;
	}

	@Override
	public String toString() {
		return "ParticipaAluno [id_part_aluno=" + id_part_aluno + ", aluno_participante=" + aluno_participante
				+ ", projeto_numero=" + projeto_numero + ", prof_supervisor=" + prof_supervisor + "]";
	}

	
}