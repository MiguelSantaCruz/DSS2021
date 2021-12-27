package CentroReparacoesLN.GestUtilizadores;

import CentroReparacoesLN.GestEquipamentos.*;

public class GestUtilizadoresFacade implements IGestUtilizadoresFacade {

	private Gestor Gestores;
	private Tecnico Tecnicos;
	private Funcionario Funcionarios;

	/**
	 * 
	 * @param tecnico
	 */
	public void adicionarTecnico(Tecnico tecnico) {
		// TODO - implement GestUtilizadoresFacade.adicionarTecnico
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param funcionario
	 */
	public void adicionarFuncionario(Funcionario funcionario) {
		// TODO - implement GestUtilizadoresFacade.adicionarFuncionario
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param gestor
	 */
	public void adicionarGestor(Gestor gestor) {
		// TODO - implement GestUtilizadoresFacade.adicionarGestor
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 */
	public void removerTecnico(String id) {
		// TODO - implement GestUtilizadoresFacade.removerTecnico
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 */
	public void removerFuncionario(String id) {
		// TODO - implement GestUtilizadoresFacade.removerFuncionario
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 */
	public void removerGestor(String id) {
		// TODO - implement GestUtilizadoresFacade.removerGestor
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idFuncionario
	 * @param id
	 * @param nome
	 * @param descricao
	 * @param idCliente
	 * @param orcamento
	 */
	public FichaEquipamento criaFichaEquipamento(String idFuncionario, String id, String nome, String descricao, String idCliente, Orcamento orcamento) {
		// TODO - implement GestUtilizadoresFacade.criaFichaEquipamento
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 * @param password
	 */
	public boolean autenticaTecnico(String id, String password) {
		// TODO - implement GestUtilizadoresFacade.autenticaTecnico
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 * @param password
	 */
	public boolean autenticaFuncionario(String id, String password) {
		// TODO - implement GestUtilizadoresFacade.autenticaFuncionario
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 * @param password
	 */
	public boolean autenticaGestor(String id, String password) {
		// TODO - implement GestUtilizadoresFacade.autenticaGestor
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 */
	public Tecnico getTecnicoById(String id) {
		// TODO - implement GestUtilizadoresFacade.getTecnicoById
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 */
	public Funcionario getFuncionarioById(String id) {
		// TODO - implement GestUtilizadoresFacade.getFuncionarioById
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 */
	public Gestor getGestorById(String id) {
		// TODO - implement GestUtilizadoresFacade.getGestorById
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idTecnico
	 */
	public void consultaListaReparacoesTecnico(String idTecnico) {
		// TODO - implement GestUtilizadoresFacade.consultaListaReparacoesTecnico
		throw new UnsupportedOperationException();
	}

	public void consultaListaReparacoes() {
		// TODO - implement GestUtilizadoresFacade.consultaListaReparacoes
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idFuncionario
	 */
	public void consultaListaEntregasFuncionario(String idFuncionario) {
		// TODO - implement GestUtilizadoresFacade.consultaListaEntregasFuncionario
		throw new UnsupportedOperationException();
	}

	public void consultaListaEntregas() {
		// TODO - implement GestUtilizadoresFacade.consultaListaEntregas
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idTecnico
	 */
	public void consultaEstatisticasTecnico(String idTecnico) {
		// TODO - implement GestUtilizadoresFacade.consultaEstatisticasTecnico
		throw new UnsupportedOperationException();
	}

	public void consultaEstatisticasTecnicos() {
		// TODO - implement GestUtilizadoresFacade.consultaEstatisticasTecnicos
		throw new UnsupportedOperationException();
	}

}