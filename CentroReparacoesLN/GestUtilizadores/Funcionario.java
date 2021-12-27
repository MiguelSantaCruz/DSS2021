package CentroReparacoesLN.GestUtilizadores;

import CentroReparacoesLN.GestEquipamentos.*;
import CentroReparacoesLN.GestReparacao.*;

public class Funcionario {

	private String id;
	private String nome;
	private String palavraPasse;
	private List<String> listaIdsFichaEquipamentosRecebidos;
	private List<String> listaIdsFichaEquipamentosLevantados;

	/**
	 * 
	 * @param idEquip
	 * @param nome
	 * @param descricao
	 * @param orcamento
	 */
	public FichaEquipamento criaFichaEquipamento(String idEquip, String nome, String descricao, Orcamento orcamento) {
		// TODO - implement Funcionario.criaFichaEquipamento
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param IdEquipamento
	 */
	public void registarLevantamento(String IdEquipamento) {
		// TODO - implement Funcionario.registarLevantamento
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idFichaEquipamento
	 * @param valor
	 */
	public void registarPagamento(String idFichaEquipamento, int valor) {
		// TODO - implement Funcionario.registarPagamento
		throw new UnsupportedOperationException();
	}

	public ServicoExpresso registarServicoExpresso() {
		// TODO - implement Funcionario.registarServicoExpresso
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param mensagem
	 * @param idCliente
	 */
	public void contactarClienteEmail(String mensagem, String idCliente) {
		// TODO - implement Funcionario.contactarClienteEmail
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param mensagem
	 * @param idCliente
	 */
	public void contactarClienteSMS(String mensagem, String idCliente) {
		// TODO - implement Funcionario.contactarClienteSMS
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idOrcamento
	 */
	public void confirmaOrcamento(String idOrcamento) {
		// TODO - implement Funcionario.confirmaOrcamento
		throw new UnsupportedOperationException();
	}

	public List<String> getListaEquipamentosRecebidos() {
		// TODO - implement Funcionario.getListaEquipamentosRecebidos
		throw new UnsupportedOperationException();
	}

	public List<String> getListaEquipamentosLevantados() {
		// TODO - implement Funcionario.getListaEquipamentosLevantados
		throw new UnsupportedOperationException();
	}

}