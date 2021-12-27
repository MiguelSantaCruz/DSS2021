package business.CentroReparacoesLN.GestEquipamentos;

import java.util.ArrayList;

public class Cliente {

	private String nif;
	private String telemovel;
	private String email;
	private String nome;
	private ArrayList<Equipamento> listaEquipamento;

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

	public ArrayList<Equipamento> getListaEquipamento() {
		return listaEquipamento;
	}

	/**
	 * 
	 * @param listaEquipamento
	 */
	public void setListaEquipamento(ArrayList<Equipamento> listaEquipamento) {
		this.listaEquipamento = listaEquipamento;
	}

}