package business.CentroReparacoesLN.GestReparacao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Reparacao {

	private ArrayList<Pecas> pecas;
	private Map<String, Passo> passo = new HashMap<>();
	private String idReparacao;
	private boolean concluido;
	

	

	public Map<String, Passo> getPasso() {
		return passo;
	}

	public void setPasso(Map<String, Passo> passo) {
		this.passo = passo;
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