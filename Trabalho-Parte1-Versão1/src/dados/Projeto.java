package dados;

import java.sql.Date;
import java.util.Objects;

public class Projeto {

	private int numero;
	private String financiador;
	private double orcamento;
	private Date data_inicio;
	private Date data_final;
	private int pesquisador_principal;
	
	
	public Projeto(int numero, String financiador, double orcamento, Date data_inicio, Date data_final,
			int pesquisador_principal) {
		super();
		this.numero = numero;
		this.financiador = financiador;
		this.orcamento = orcamento;
		this.data_inicio = data_inicio;
		this.data_final = data_final;
		this.pesquisador_principal = pesquisador_principal;
	}
	
	public Projeto(){
		
	}

//getters and setters
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getFinanciador() {
		return financiador;
	}

	public void setFinanciador(String financiador) {
		this.financiador = financiador;
	}

	public double getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(double orcamento) {
		this.orcamento = orcamento;
	}

	public Date getData_inicio() {
		return data_inicio;
	}

	public void setData_inicio(Date data_inicio) {
		this.data_inicio = data_inicio;
	}

	public Date getData_final() {
		return data_final;
	}

	public void setData_final(Date data_final) {
		this.data_final = data_final;
	}

	public int getPesquisador_principal() {
		return pesquisador_principal;
	}

	public void setPesquisador_principal(int pesquisador_principal) {
		this.pesquisador_principal = pesquisador_principal;
	}

	
// equals
	@Override
	public int hashCode() {
		return Objects.hash(data_final, data_inicio, financiador, numero, orcamento, pesquisador_principal);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Projeto other = (Projeto) obj;
		return Objects.equals(data_final, other.data_final) && Objects.equals(data_inicio, other.data_inicio)
				&& Objects.equals(financiador, other.financiador) && numero == other.numero
				&& Double.doubleToLongBits(orcamento) == Double.doubleToLongBits(other.orcamento)
				&& pesquisador_principal == other.pesquisador_principal;
	}

//string to string
	@Override
	public String toString() {
		return "Projeto [numero=" + numero + ", financiador=" + financiador + ", orcamento=" + orcamento
				+ ", data_inicio=" + data_inicio + ", data_final=" + data_final + ", pesquisador_principal="
				+ pesquisador_principal + "]";
	}
	
	
	
	
	
}
