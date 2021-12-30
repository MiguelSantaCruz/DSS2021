package CentroReparacoesLN.GestUtilizadores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import CentroReparacoesLN.IGestEquipamento;
import CentroReparacoesLN.IGestReparacao;
import CentroReparacoesLN.GestEquipamentos.*;
import CentroReparacoesLN.GestReparacao.*;

public class Tecnico implements Serializable{

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
		if(!reparacao.existePassoOrSubpasso(id)) return;
		reparacao.getPassoOrSubpassoByID(id).setConcluido(true);
	}

	/**
	 * Método que marca uma reparação como concluída
	 * @param idReparacao - O identificador da reparação
	 * @param gestReparacao - A classe que gere reparacoes
	 */
	public void executaReparacao(String idReparacao, IGestReparacao gestReparacao) {
		if(!gestReparacao.existeReparacao(idReparacao)) return;
		gestReparacao.getReparacao(idReparacao).setConcluido(true);
	}

	/**
	 * Método que marca um serviço expresso como concluído
	 * @param idServico - Identificador do serviço
	 * @param gestReparacao - A classe que gere reparacoes
	 */
	public void executaServico(String idServico, IGestReparacao gestReparacao) {
		if(!gestReparacao.existeServico(idServico)) return;
		gestReparacao.getServicoExpresso(idServico).setConcluido(true);
	}

	/**
	 * Aceder á lista de orçamentos e escolher o mais antigo
	 * @param gestEquipamentos - Classe de gestão de equipamentos e orçamentos
	 * @return O orcamento mais antigo
	 */
	public Orcamento escolherOrcamentoMaisAntigo(IGestEquipamento gestEquipamentos) {
		return gestEquipamentos.getPedidoOrcamentoMaisAntigo();
	}

	/**
	 * Aceder á lista de reparações e escolher a mais antiga
	 * @param gestReparacao - Classe de gestão de reparações
	 * @return A reparação mais antiga
	 */
	public Reparacao escolherReparacaoMaisUrgente(IGestReparacao gestReparacao) {
		return gestReparacao.getReparacaoMaisAntiga();
	}

	/**
	 * Cria um novo pedido de orçamento
	 * @param idFicha - O identificador da ficha de equipamento
	 * @param valor - O valor estimado
	 * @param descricao -  Descrição do orçamento
	 * @param gestEquipamento - Classe de gestão de equipamentos e orçamentos
	 */
	public Orcamento criarPedidoOrcamento(String idFicha,String descricao, float valor,IGestEquipamento gestEquipamento) {
		if(!gestEquipamento.fichaExiste(idFicha)) return null;
		Orcamento orcamento = gestEquipamento.adicionarOrcamento(valor,descricao);
		gestEquipamento.getFichaEquipamento(idFicha).setOrcamento(orcamento);
		return orcamento;
	}

	/**
	 * Adiciona uma reparação associada
	 * @param id - O identificador da reparação
	 */
	public void adicionarReparacaoAssociada(String id){
		this.listaIdsReparacao.add(id);
	}


	/**
	 * Adiciona um serviço associado
	 * @param id - O identificador do serviço
	 */
	public void adicionarServicoAssociado(String id){
		this.ListaIdsServico.add(id);
	}

}