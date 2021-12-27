package business.CentroReparacoesLN.GestEquipamentos;

import java.time.LocalDateTime;

import business.CentroReparacoesLN.GestReparacao.Reparacao;

public class FichaEquipamento {

	private String nome;
	private String descricao;
	private String idEquipamento;
	private Orcamento orcamento;
	private Equipamento equipamento;
	private Reparacao reparacao;
	private LocalDateTime date;

	public String getNome() {
		return nome;
	}

	/**
	 * 
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	/**
	 * 
	 * @param descricao
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getIdEquipamento() {
		return idEquipamento;
	}

	/**
	 * 
	 * @param idEquipamento
	 */
	public void setIdEquipamento(String idEquipamento) {
		this.idEquipamento = idEquipamento;
	}

	public Orcamento getOrcamento() {
		return orcamento;
	}

	/**
	 * 
	 * @param orcamento
	 */
	public void setOrcamento(Orcamento orcamento) {
		this.orcamento = orcamento;
	}

	public Equipamento getEquipamento() {
		return equipamento;
	}

	/**
	 * 
	 * @param equipamento
	 */
	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}

	public Reparacao getReparacao() {
		return reparacao;
	}

	/**
	 * 
	 * @param reparacao
	 */
	public void setReparacao(Reparacao reparacao) {
		this.reparacao = reparacao;
	}

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


