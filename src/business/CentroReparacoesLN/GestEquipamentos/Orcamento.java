package business.CentroReparacoesLN.GestEquipamentos;

import java.time.LocalDateTime;

public class Orcamento {

	private String idOrcamento;
	private float valor;
	private boolean aprovado;
	private LocalDateTime date;

	public Orcamento(String idOrcamento, float valor) {
		this.idOrcamento = idOrcamento;
		this.valor = valor;
		this.aprovado = false;
		this.date = LocalDateTime.now();
	}

	/**
	 * 
	 * @return id do orcamento
	 */
	public String getIdOrcamento() {
		return idOrcamento;
	}

	/**
	 * 
	 * @param idOrcamento
	 */
	public void setIdOrcamento(String idOrcamento) {
		this.idOrcamento = idOrcamento;
	}

	/**
	 * 
	 * @return valor do orcamento
	 */
	public float getValor() {
		return valor;
	}

	/**
	 * 
	 * @param valor
	 */
	public void setValor(float valor) {
		this.valor = valor;
	}

	/**
	 * 
	 * @return {@code true} se o orcamento for aprovado ou {@code false} se nao for
	 */
	public boolean isAprovado() {
		return aprovado;
	}

	/**
	 * 
	 * @param aprovado
	 */
	public void setAprovado(boolean aprovado) {
		this.aprovado = aprovado;
	}

	/**
	 * 
	 * @return data do orcamento
	 */
	public LocalDateTime getDate() {
		return date;
	}

	/**
	 * 
	 * @param date
	 */
	public void setDate(LocalDateTime date) {
		this.date = date;
	}

}