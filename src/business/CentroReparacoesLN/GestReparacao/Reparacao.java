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
	

	public Reparacao(String idReparacao, String descricao, boolean concluido) {
		this.idReparacao = idReparacao;
		this.descricao = descricao;
		this.concluido = concluido;
	}


	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean getConcluido() {
		return this.concluido;
	}

	

	public Map<String, Passo> getPasso() {
		return passos;
	}

	public void setPasso(Map<String, Passo> passos) {
		this.passos = passos;
	}

	public ArrayList<Pecas> getPecas() {
		return pecas;
	}

	public void setPecas(ArrayList<Pecas> pecas) {
		this.pecas = pecas;
	}

	public String getIdReparacao() {
		return idReparacao;
	}

	public void setIdReparacao(String idReparacao) {
		this.idReparacao = idReparacao;
	}

	public boolean isConcluido() {
		return concluido;
	}

	public void setConcluido(boolean concluido) {
		this.concluido = concluido;
	}


	public boolean exitePassoOrSubpasso(String id){
		if(this.passos.containsKey(id)) return true;
		for(Map.Entry<String, Passo> entry : this.passos.entrySet()) {
			if(entry.getValue().existeSubpasso(id)) return true;
		}
		return false;
	}

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


	/**
	 * 
	 * @param listaPassos
	 */
	public void adicionaListaPassos(Map<String, Passo> listaPassos) {
		// TODO - implement Reparacao.adicionaListaPassos
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param listaPecas
	 */
	public void adicionarListaPecas(Map<String, Pecas> listaPecas) {
		// TODO - implement Reparacao.adicionarListaPecas
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param peca
	 */
	public void adicionaPeca(Pecas peca) {
		// TODO - implement Reparacao.adicionaPeca
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param peca
	 */
	public void removePeca(Pecas peca) {
		// TODO - implement Reparacao.removePeca
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param passo
	 */
	public void adicionaPasso(Passo passo) {
		// TODO - implement Reparacao.adicionaPasso
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param passo
	 */
	public void removePasso(Passo passo) {
		// TODO - implement Reparacao.removePasso
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