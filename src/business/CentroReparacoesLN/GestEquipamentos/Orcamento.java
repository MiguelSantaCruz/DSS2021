package business.CentroReparacoesLN.GestEquipamentos;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Orcamento implements Serializable{

	private String idOrcamento;
	private float valor;
	private boolean aprovado;
	private String descricao;
	private LocalDateTime date;

	public Orcamento(String idOrcamento, float valor, String descricao) {
		this.idOrcamento = idOrcamento;
		this.valor = valor;
		this.aprovado = false;
		this.descricao = descricao;
		this.date = LocalDateTime.now();
	}

	/* Getters and Setters*/

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


	public boolean getAprovado() {
		return this.aprovado;
	}


	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	@Override
	public String toString() {
		return " Identificador: " + getIdOrcamento() + "\n" +
			"Data: " + getDate() + "\n" +
			"Valor: " + getValor() + "\n"  +
			"Aprovado pelo cliente" + isAprovado() + "\n"  +
			"Descrição:\n" + getDescricao() + "\n";
	}


}