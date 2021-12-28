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
	 * @return {@code true} se o passo ou subpasso existe, {@code false} caso contrário
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
	 * verifica se o passo está concluido
	 * @param idPasso
	 * @return {@code true} se o passo está concluido, {@code false} caso contrário
	 */
	public boolean verificaConclusaoPasso(String idPasso) {
		return passos.get(idPasso).verificaConclusaoSubpassos();
	}

	/**
	 * verifica se a reparacao está concluida, ou seja se todos os passos estao concluidos
	 * @return {@code true} se a reparacao está concluida, {@code false} caso contrário
	 */
	public boolean verificaConclusao() {
		for(Map.Entry<String, Passo> entry : this.passos.entrySet()) {
			if (!entry.getValue().verificaConclusaoSubpassos())
				return false;
		}
		return true;
	}

	/**
	 * marca a reparacao, o passo e respetivos subpassos como concluidos
	 */
	public void marcaReparacaoComoConcluida() {
		for(Map.Entry<String, Passo> entry : this.passos.entrySet()) {
			entry.getValue().marcaPassoComoConcluido();
		}
		this.setConcluido(true);
	}

	/**
	 * calcula o custo da reparacao, que corresponde ao custo das pecas utilizadas
	 * @return o valor do custo total
	 */
	public float calcularCustoTotal() {
		float valor = 0;
		for(Pecas p : pecas){
			valor += p.getValor();
		}
		return valor;
	}

	/**
	 * calcula o número de horas gastas da reparacao
	 * @return horas gastas totais
	 */
	public int calcularHorasGastasTotais() {
		int horas = 0;
		for(Map.Entry<String, Passo> entry : passos.entrySet()) {
			horas += entry.getValue().calculaHorasGastas();
		}

		return horas;
	}

	/**
	 * calcula o número de horas previstas para a conclusao da reparacao
	 * @return horas previstas totais
	 */
	public int calcularHorasPrevistasTotais() {
		int horas = 0;
		for(Map.Entry<String, Passo> entry : passos.entrySet()) {
			horas += entry.getValue().calculaHorasPrevistas();
		}

		return horas;
	}

}