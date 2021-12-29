package business.CentroReparacoesLN.GestReparacao;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Reparacao implements Serializable{

	private Map<String,Peca> pecas = new HashMap<>();
	private Map<String, Passo> passos = new HashMap<>();
	private String idReparacao;
	private String descricao;
	private int horasGastas;
	private int horasPrevistas;
	private LocalDateTime date;
	private boolean concluido;
	

	public Reparacao(String idReparacao, String descricao) {
		this.pecas = new HashMap<>();
		this.passos = new HashMap<>();
		this.idReparacao = idReparacao;
		this.descricao = descricao;
		this.date = LocalDateTime.now();
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
	 * adiciona um subpasso de um passo
	 * @param passo
	 */
	public void adicionaPasso(String descricao,int horasPrevistas){
		String id;
		do {
			id = UUID.randomUUID().toString().substring(0, 8);
		} while (this.passos.containsKey(id));
		Passo passo = new Passo(id, descricao, horasPrevistas);
		this.passos.put(passo.getIdPasso(),passo);
	}
	

	/**
	 * adiciona um subpasso de um passo
	 * @param passo
	 */
	public void adicionaSubPasso(String idPasso,String descricao,int horasPrevistas){
		String id;
		do {
			id = UUID.randomUUID().toString().substring(0, 8);
		} while (this.passos.get(idPasso).existeSubpasso(id));
		Passo passo = new Passo(id, descricao, horasPrevistas);
		this.passos.get(idPasso).adicionaSubpasso(passo);
	}

	/**
	 * remove um passo
	 * @param passo
	 */
	public void removePasso(Passo passo){
		this.passos.remove(passo.getIdPasso());
	}

	/**
	 * remove um passo
	 * @param passo
	 */
	public void removePassoById(String idPasso){
		this.passos.remove(idPasso);
	}
	
	/**
	 * 
	 * @return lista de pecas da reparacao
	 */
	public Map<String,Peca> getPecas() {
		return pecas;
	}

	/**
	 * 
	 * @param peca
	 */
	public void adicionaPeca(Peca peca) {
		pecas.put(peca.getIdPeca(),peca);
	}

	/**
	 * 
	 * @param peca
	 */
	public void removePeca(Peca peca) {
		pecas.remove(peca.getIdPeca());
	}

	public LocalDateTime getDate() {
		return this.date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public boolean getConcluido() {
		return this.concluido;
	}

	public int getHorasGastas() {
		return this.horasGastas;
	}

	public void setHorasGastas(int horasGastas) {
		this.horasGastas = horasGastas;
	}

	public int getHorasPrevistas() {
		return this.horasPrevistas;
	}

	public void setHorasPrevistas(int horasPrevistas) {
		this.horasPrevistas = horasPrevistas;
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
		for (Map.Entry<String,Peca> entry : this.pecas.entrySet()) {
			valor += entry.getValue().getValor();
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


	@Override
	public String toString() {
		return "ID: "+this.getIdReparacao() +"\n"
		+ "Data: " + date.toString() + "\n"
		+ "Descrição: " + descricao + "\n" 
		+ "Horas gastas: " + horasGastas + "\n"
		+ "Horas previstas: " + horasPrevistas + "\n"
		+ "Concluida: " + concluido + "\n"
		+ "Peças: \n" + this.pecas.toString() + "\n"
		+ "Passos: \n" + this.passos.toString() + "\n";
	}

}