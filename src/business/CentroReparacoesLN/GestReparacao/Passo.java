package business.CentroReparacoesLN.GestReparacao;

import java.util.HashMap;
import java.util.Map;

public class Passo {

	private Map<String, Passo> subpassos = new HashMap<>();
	private String idPasso;
	private String descricao;
	private boolean concluido;
	private int horasGastas;
	private int horasPrevistas;
	

	public Passo(String idPasso, String descricao, int horasPrevistas) {
		this.subpassos = new HashMap<>();
		this.idPasso = idPasso;
		this.descricao = descricao;
		this.concluido = false;
		this.horasGastas = 0;
		this.horasPrevistas = horasPrevistas;
	}


	/* Getters and Setters */


	/**
	 * 
	 * @return id do passo
	 */
	public String getIdPasso() {
		return idPasso;
	}

	/**
	 * 
	 * @param idPasso
	 */
	public void setIdPasso(String idPasso) {
		this.idPasso = idPasso;
	}

	/**
	 * 
	 * @return descricao do passo
	 */
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

	/**
	 * 
	 * @return o estado de conclusao do passo
	 */
	public boolean isConcluido() {
		return concluido;
	}

	/**
	 * 
	 * @param concluido
	 */
	public void setConcluido(boolean concluido) {
		this.concluido = concluido;
	}

	/**
	 * 
	 * @return numero de horas gastas
	 */
	public int getHorasGastas() {
		return horasGastas;
	}

	/**
	 * 
	 * @param horasGastas
	 */
	public void setHorasGastas(int horasGastas) {
		this.horasGastas = horasGastas;
	}

	/**
	 * 
	 * @return numero de horas previstas
	 */
	public int getHorasPrevistas() {
		return horasPrevistas;
	}
	
	/**
	 * 
	 * @param horasPrevistas
	 */
	public void setHorasPrevistas(int horasPrevistas) {
		this.horasPrevistas = horasPrevistas;
	}

	/**
	 * adiciona um subpasso de um passo
	 * @param passo
	 */
	public void adicionaSubpasso(Passo passo){
		this.subpassos.put(passo.getIdPasso(),passo);
	}

	/**
	 * remove um subpasso de um passo
	 * @param passo
	 */
	public void removeSubpasso(Passo passo){
		this.subpassos.remove(passo.getIdPasso());
	}

	/**
	 * 
	 * @param id do subpasso
	 * @return {@code true} se existir subpasso ou {@code false} se nao existir
	 */
	public boolean existeSubpasso(String id){
		if(this.subpassos.containsKey(id)) return true;
		else return false;
	}

	/**
	 * 
	 * @param id do subpasso
	 */
	public Passo getSubpasso(String id){
		if(!this.subpassos.containsKey(id)) return null;
		else return this.subpassos.get(id);
	}


}