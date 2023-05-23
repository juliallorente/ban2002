package dados;

import java.util.Objects;

public class Departamento {

	private int numero;
	private String escritorio_princ;
	private String nome;
	private int lider; //professor já existente
	
	
	public Departamento(int numero, String escritorio_princ, String nome, int lider) {
		super();
		this.numero = numero;
		this.escritorio_princ = escritorio_princ;
		this.nome = nome;
		this.lider = lider;
	}
	
	public Departamento(){
		
	}

	
//getters and setters
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

	public int getLider() {
		return lider;
	}

	public void setLider(int lider) {
		this.lider = lider;
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
		return "Departamento [numero=" + numero + ", escritorio_princ=" + escritorio_princ + ", nome=" + nome
				+ ", lider=" + lider + "]";
	}
	
	
	
	
}
