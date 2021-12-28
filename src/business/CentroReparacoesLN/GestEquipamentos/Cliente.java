package business.CentroReparacoesLN.GestEquipamentos;

import java.util.ArrayList;

public class Cliente {

	private String nif;
	private String telemovel;
	private String email;
	private String nome;
	private ArrayList<Equipamento> listaEquipamento;

	public Cliente(String nif, String telemovel, String email, String nome, ArrayList<Equipamento> listaEquipamento) {
		this.nif = nif;
		this.telemovel = telemovel;
		this.email = email;
		this.nome = nome;
		this.listaEquipamento = listaEquipamento;
	}


	/* Getters and Setters */

	/**
	 * 
	 * @return NIF do cliente
	 */
	public String getNif() {
		return nif;
	}

	/**
	 * 
	 * @param nif
	 */
	public void setNif(String nif) {
		this.nif = nif;
	}

	/**
	 * 
	 * @return telemovel do cliente
	 */
	public String getTelemovel() {
		return telemovel;
	}

	/**
	 * 
	 * @param telemovel
	 */
	public void setTelemovel(String telemovel) {
		this.telemovel = telemovel;
	}

	/**
	 * 
	 * @return email do cliente
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * 
	 * @return nome do cliente
	 */
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

	/**
	 * 
	 * @return lista de equipamentos do cliente
	 */
	public ArrayList<Equipamento> getListaEquipamento() {
		return listaEquipamento;
	}

	/**
	 * adiciona um equipamento à lista de equipamentos do cliente
	 * @param equip
	 */
	public void adicionarEquipamento(Equipamento equip){
		listaEquipamento.add(equip);
	}

	/**
	 * Remove um equipamento da lista de equipamentos do cliente, se este existir
	 * @param equip
	 */
	public void removerEquipamento(Equipamento equip){
		if(listaEquipamento.contains(equip))
			listaEquipamento.remove(equip);
	}

}