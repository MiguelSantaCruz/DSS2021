package business.CentroReparacoesLN.GestEquipamentos;

import java.time.LocalDateTime;

import business.CentroReparacoesLN.GestReparacao.Reparacao;

public class FichaEquipamento {

	private String nome;
	private String descricao;
	private String idFicha;
	private Orcamento orcamento;
	private Equipamento equipamento;
	private Reparacao reparacao;
	private LocalDateTime date;
	private String idCliente;
	private int valorPago;


	public FichaEquipamento(String nome, String descricao, String idFicha, Orcamento orcamento, Equipamento equipamento, Reparacao reparacao, LocalDateTime date, String idCliente, int valorPago) {
		this.nome = nome;
		this.descricao = descricao;
		this.idFicha = idFicha;
		this.orcamento = orcamento;
		this.equipamento = equipamento;
		this.reparacao = reparacao;
		this.date = date;
		this.idCliente = idCliente;
		this.valorPago = 0;
	}

	public FichaEquipamento(String idFicha, String nome, String descricao,String idCliente) {
		this.nome = nome;
		this.descricao = descricao;
		this.idFicha = idFicha;
		this.orcamento = null;
		this.equipamento = null;
		this.reparacao = null;
		this.date = LocalDateTime.now();
		this.idCliente = idCliente;
		this.valorPago = 0;
	}


	

	/* Getters and Setters */

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

	public String getIdFicha() {
		return idFicha;
	}

	/**
	 * 
	 * @param idFicha
	 */
	public void setIdFicha(String idFicha) {
		this.idFicha = idFicha;
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

	public int getValorPago(){
		return this.valorPago;
	}

	/**
	 * 
	 * @param valor
	 */
	public void setValorPago(int valor) {
		this.valorPago = valor;
	}

	public String getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}



}


