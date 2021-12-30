package CentroReparacoesLN.GestEquipamentos;

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

	public Orcamento(String idOrcamento) {
		this.idOrcamento = idOrcamento;
		this.valor = 0;
		this.aprovado = false;
		this.descricao = "Aguarda descrição do técnico ";
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

	/**
	 * 
	 * @return {@code true} se o orcamento estiver aprovado, {@code false} caso contrario
	 */
	public boolean getAprovado() {
		return this.aprovado;
	}

	/**
	 * 
	 * @return descricao do orcamento
	 */
	public String getDescricao() {
		return this.descricao;
	}

	/**
	 * 
	 * @param descricao
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	@Override
	public String toString() {
		return ("ID: "+getIdOrcamento() +"\n"
				+ "Data: " + getDate() + "\n"
				+ "Descrição: " + getDescricao() + "\n" 
				+ "Valor: " +getValor()+ "\n"
				+ "Aprovado: " + getAprovado()+"\n");

	}


}