package business.CentroReparacoesLN.GestUtilizadores;

import java.util.ArrayList;
import java.util.List;

import business.CentroReparacoesLN.GestEquipamentos.*;
import business.CentroReparacoesLN.GestReparacao.*;

public class Tecnico {

	private String id;
	private String nome;
	private String palavraPasse;
	private List<String> listaIdsReparacao = new ArrayList<>();
	public List<String> ListaIdsServico = new ArrayList<>();
	private boolean isAvailable;
	

	public Tecnico(String id, String nome, String palavraPasse) {
		this.id = id;
		this.nome = nome;
		this.palavraPasse = palavraPasse;
		this.isAvailable = true;
	}


	/* Getters and Setters */

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPalavraPasse() {
		return this.palavraPasse;
	}

	public void setPalavraPasse(String palavraPasse) {
		this.palavraPasse = palavraPasse;
	}

	public List<String> getListaIdsReparacao() {
		return this.listaIdsReparacao;
	}

	public void setListaIdsReparacao(List<String> listaIdsReparacao) {
		this.listaIdsReparacao = listaIdsReparacao;
	}

	public List<String> getListaIdsServico() {
		return this.ListaIdsServico;
	}

	public void setListaIdsServico(List<String> listaIdsServico) {
		this.ListaIdsServico = listaIdsServico;
	}

	public boolean isIsAvailable() {
		return this.isAvailable;
	}

	public boolean getIsAvailable() {
		return this.isAvailable;
	}

	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}



	/**
	 * Marcar um passo como concluído
	 * @param idPasso - Identificador do passo
	 * @param idReparacao - Identificador da reparacao
	 * @param gestReparacoes - Classe de gestão de reparações
	 */
	public void executaPasso(String idPasso, String idReparacao, GestReparacaoFacade gestReparacoes) {
		if(!gestReparacoes.existeReparacao(idReparacao)) return;
		Reparacao reparacao = gestReparacoes.getReparacao(idReparacao);
		if(!reparacao.exitePassoOrSubpasso(id)) return;
		reparacao.getPassoOrSubpassoByID(id).setConcluido(true);
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