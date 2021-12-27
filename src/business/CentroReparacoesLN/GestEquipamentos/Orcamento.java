package business.CentroReparacoesLN.GestEquipamentos;

import java.time.LocalDateTime;

public class Orcamento {

	private String idOrcamento;
	private float valor;
	private boolean aprovado;
	private LocalDateTime date;
	public String getIdOrcamento() {
		return idOrcamento;
	}
	public void setIdOrcamento(String idOrcamento) {
		this.idOrcamento = idOrcamento;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public boolean isAprovado() {
		return aprovado;
	}
	public void setAprovado(boolean aprovado) {
		this.aprovado = aprovado;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}

}