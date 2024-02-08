package dados;

import java.util.Objects;

public class Projeto {
	
	private int numero;
	private String nome_proj;
	private String financiador;
	private double orcamento;
	private String data_inicio;
	private String data_final;
	private int pesquisador_principal; //professor que comanda o projeto
	
	
	public Projeto(int numero, String nome_proj, String financiador, double orcamento, String data_inicio, String data_final,
			int pesquisador_principal) {
		super();
		this.numero = numero;
		this.nome_proj = nome_proj;
		this.financiador = financiador;
		this.orcamento = orcamento;
		this.data_inicio = data_inicio;
		this.data_final = data_final;
		this.pesquisador_principal = pesquisador_principal;
	}
	
	public Projeto(){
		
	}

//getters and setters
	
	public String getNome_proj() {
		return nome_proj;
	}

	public void setNome_proj(String nome_proj) {
		this.nome_proj = nome_proj;
	}
	
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

	public String getData_inicio() {
		return data_inicio;
	}

	public void setData_inicio(String data_inicio) {
		this.data_inicio = data_inicio;
	}

	public String getData_final() {
		return data_final;
	}

	public void setData_final(String data_final) {
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
		return Objects.hash(data_final, data_inicio, financiador, nome_proj, numero, orcamento, pesquisador_principal);
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
				&& Objects.equals(financiador, other.financiador) && Objects.equals(nome_proj, other.nome_proj)
				&& numero == other.numero
				&& Double.doubleToLongBits(orcamento) == Double.doubleToLongBits(other.orcamento)
				&& pesquisador_principal == other.pesquisador_principal;
	}

	@Override
	public String toString() {
		return "\n" + "Nome projeto: " + nome_proj + ", Número: " + numero + ", Financiador: " + financiador
				+ ", Orçamento: " + orcamento + ", Data início: " + data_inicio + ", Data final: " + data_final
				+ ", Pesquisador Principal: " + pesquisador_principal;
	}
	
	
	
	
	
}
