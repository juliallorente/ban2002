package dados;

import java.util.Objects;

import org.bson.types.ObjectId;

public class Projeto {
	
	private ObjectId id;
	private int numero;
	private String nome_proj;
	private String financiador;
	private int orcamento;
	private String data_inicio;
	private String data_final;
	private Professor pesquisador_principal; //professor que comanda o projeto
	
	
	public Projeto(ObjectId id, int numero, String nome_proj, String financiador, int orcamento, String data_inicio, String data_final, Professor pesquisador_principal) {
        this.id = id;
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
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }
    
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

	public int getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(int orcamento) {
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

	public Professor getPesquisador_principal() {
		return pesquisador_principal;
	}

	public void setPesquisador_principal(Professor pesquisador_principal) {
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
				+ ", Pesquisador Principal: " + pesquisador_principal.getNome();
	}
	
	
	
	
	
}
