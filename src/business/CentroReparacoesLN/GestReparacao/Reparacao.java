package business.CentroReparacoesLN.GestReparacao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Reparacao {

	private ArrayList<Pecas> pecas = new ArrayList<>();
	private Map<String, Passo> passos = new HashMap<>();
	private String idReparacao;
	private String descricao;
	private boolean concluido;
	

	public Reparacao(String idReparacao, String descricao) {
		this.pecas = new ArrayList<>();
		this.passos = new HashMap<>();
		this.idReparacao = idReparacao;
		this.descricao = descricao;
		this.concluido = false;
	}

	/* Getters and Setters*/

	/**
	 * 
	 * @return id da reparacao
	 */
	public String getIdReparacao() {
		return idReparacao;
	}

	/**
	 * 
	 * @param idReparacao
	 */
	public void setIdReparacao(String idReparacao) {
		this.idReparacao = idReparacao;
	}

	/**
	 * 
	 * @return descricao da reparacao
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
	 * @return o estado de conclusao da reparacao
	 */
	public boolean isConcluido() {
		return this.concluido;
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
	 * @return lista de passos da reparacao
	 */
	public Map<String, Passo> getPasso() {
		return passos;
	}

	/**
	 * adiciona um subpasso de um passo
	 * @param passo
	 */
	public void adicionaPasso(Passo passo){
		this.passos.put(passo.getIdPasso(),passo);
	}

	/**
	 * remove um subpasso de um passo
	 * @param passo
	 */
	public void removePasso(Passo passo){
		this.passos.remove(passo.getIdPasso());
	}

	/**
	 * 
	 * @return lista de pecas da reparacao
	 */
	public ArrayList<Pecas> getPecas() {
		return pecas;
	}

	/**
	 * 
	 * @param peca
	 */
	public void adicionaPeca(Pecas peca) {
		pecas.add(peca);
	}

	/**
	 * 
	 * @param peca
	 */
	public void removePeca(Pecas peca) {
		pecas.remove(peca);
	}

	


	

	/**
	 * verifica se um passo ou subpasso existe da lista de passos da reparacao
	 * @param id
	 * @return lista de passos da reparacao
	 */
	public boolean existePassoOrSubpasso(String id){
		if(this.passos.containsKey(id)) return true;
		for(Map.Entry<String, Passo> entry : this.passos.entrySet()) {
			if(entry.getValue().existeSubpasso(id)) return true;
		}
		return false;
	}

	/**
	 * procura um passo ou subpasso pelo id
	 * @param id
	 * @return passo ou subpasso encontrado
	 */
	public Passo getPassoOrSubpassoByID(String id){
		if(this.passos.containsKey(id)) return this.passos.get(id);
		for(Map.Entry<String, Passo> entry : this.passos.entrySet()) {
			if(entry.getValue().existeSubpasso(id)) return entry.getValue().getSubpasso(id);
		}
		return null;
	}

	/**
	 * 
	 * @param idPasso
	 */
	public boolean verificaConclusaoPasso(String idPasso) {
		// TODO - implement Reparacao.verificaConclusaoPasso
		throw new UnsupportedOperationException();
	}

	public float calcularCustoTotal() {
		// TODO - implement Reparacao.calcularCustoTotal
		throw new UnsupportedOperationException();
	}

	public int calcularHorasGastasTotais() {
		// TODO - implement Reparacao.calcularHorasGastasTotais
		throw new UnsupportedOperationException();
	}

	public int calcularHorasPrevistasTotais() {
		// TODO - implement Reparacao.calcularHorasPrevistasTotais
		throw new UnsupportedOperationException();
	}

}