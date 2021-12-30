package CentroReparacoesLN.GestEquipamentos;

import java.io.Serializable;

public class Equipamento implements Serializable{

	private String id;
	private FichaEquipamento fichaDeEquimento;
	private String descricao;
	private String nome;

	public Equipamento(String id, FichaEquipamento fichaDeEquimento, String descricao, String nome) {
		this.id = id;
		this.fichaDeEquimento = fichaDeEquimento;
		this.descricao = descricao;
		this.nome = nome;
	}


	/* Getters and Setters */

	/**
	 * 
	 * @return id do equipamento
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 
	 * @return descricao do equipamento
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

	/**
	 * 
	 * @return nome do equipamento
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * 
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * 
	 * @return ficha de equipamento
	 */
	public FichaEquipamento getFichaDeEquimento() {
		return fichaDeEquimento;
	}

	/**
	 * 
	 * @param fichaDeEquipamento
	 */
	public void setFichaDeEquimento(FichaEquipamento fichaDeEquimento) {
		this.fichaDeEquimento = fichaDeEquimento;
	}


	@Override
	public String toString() {
		return ("ID: "+getId() + "\n" +
				"Descrição: " +getDescricao() + "\n" + 
				"Nome: " +getNome() + "\n");
	}

}