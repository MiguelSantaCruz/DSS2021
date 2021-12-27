package business.CentroReparacoesLN.GestUtilizadores;

import java.util.List;

import business.CentroReparacoesLN.GestEquipamentos.*;
import business.CentroReparacoesLN.GestReparacao.*;

public class Tecnico {

	private String id;
	private String nome;
	private String palavraPasse;
	private List<String> listaIdsReparacao;
	private boolean isAvailable;

	/**
	 * 
	 * @param idPasso
	 */
	public void executaPasso(String idPasso) {
		// TODO - implement Tecnico.executaPasso
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idReparacao
	 */
	public void executaReparacao(String idReparacao) {
		// TODO - implement Tecnico.executaReparacao
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idServico
	 */
	public void executaServico(String idServico) {
		// TODO - implement Tecnico.executaServico
		throw new UnsupportedOperationException();
	}

	public Orcamento escolherOrcamentoMaisAntigo() {
		// TODO - implement Tecnico.escolherOrcamentoMaisAntigo
		throw new UnsupportedOperationException();
	}

	public Reparacao escolherReparacaoMaisUrgente() {
		// TODO - implement Tecnico.escolherReparacaoMaisUrgente
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idEquipamento
	 * @param valor
	 */
	public Orcamento criarPedidoOrcamento(String idEquipamento, int valor) {
		// TODO - implement Tecnico.criarPedidoOrcamento
		throw new UnsupportedOperationException();
	}

}