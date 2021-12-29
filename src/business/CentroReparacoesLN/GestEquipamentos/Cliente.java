package business.CentroReparacoesLN.GestEquipamentos;

import java.io.Serializable;

public class Cliente implements Serializable{

	private String nif;
	private String telemovel;
	private String email;
	private String nome;

	public Cliente(String nif, String telemovel, String email, String nome) {
		this.nif = nif;
		this.telemovel = telemovel;
		this.email = email;
		this.nome = nome;
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
}