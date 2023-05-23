package dados;

import java.util.Objects;

public class Trabalha {
	private int dep_num; //numero de dep já existente
	private int matricula_prof; //matricula do professor que vai trabalhar nesse dep
	private float tempo;
	
	
	public Trabalha(int dep_num, int matricula_prof, float tempo) {
		super();
		this.dep_num = dep_num;
		this.matricula_prof = matricula_prof;
		this.tempo = tempo;
	}

	public Trabalha(){
		
	}
	
//getters and setters
	public int getDep_num() {
		return dep_num;
	}

	public void setDep_num(int dep_num) {
		this.dep_num = dep_num;
	}

	public int getMatricula_prof() {
		return matricula_prof;
	}

	public void setMatricula_prof(int matricula_prof) {
		this.matricula_prof = matricula_prof;
	}

	public float getTempo() {
		return tempo;
	}

	public void setTempo(float tempo) {
		this.tempo = tempo;
	}

//equals
	@Override
	public int hashCode() {
		return Objects.hash(dep_num, matricula_prof, tempo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trabalha other = (Trabalha) obj;
		return dep_num == other.dep_num && matricula_prof == other.matricula_prof
				&& Float.floatToIntBits(tempo) == Float.floatToIntBits(other.tempo);
	}

//string to string
	@Override
	public String toString() {
		return "Trabalha [dep_num=" + dep_num + ", matricula_prof=" + matricula_prof + ", tempo=" + tempo + "]";
	}
	

	
}
