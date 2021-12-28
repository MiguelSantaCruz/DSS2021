package business.CentroReparacoesLN;

import business.CentroReparacoesLN.GestEquipamentos.*;


public interface IGestEquipamento {


	/**
	 * 
	 * @param cliente
	 */
	public void adicionarCliente(Cliente cliente);

	/**
	 * 
	 * @param nif
	 */
	public void removerCliente(String nif);

    /**
	 * 
	 * @param equipamento
	 */
	public void adicionarFichaEquipamento(FichaEquipamento fichaEquipamento);

	/**
	 * 
	 * @param id
	 */
	public void removerFichaEquipamento(String id);

	/**
	 * 
	 * @param equipamento
	 */
	public void adicionarEquipamento(Equipamento equipamento);

	/**
	 * 
	 * @param id
	 */
	public void removerEquipamento(String id);



	/**
	 * 
	 * @param id
	 */
	public FichaEquipamento getFichaEquipamento(String id);

	/**
	 * 
	 * @param id
	 */
	public Equipamento getEquipamento(String id);



	/**
	 * 
	 * @param idEquipamento
	 */
	public Cliente getCliente(String idEquipamento);

	/**
	 * 
	 * @param nif
	 */
	public Cliente getClienteByNIF(String nif);


	/**
	 * 
	 * @param idOrcamento
	 */
	public Orcamento getOrcamento(String idOrcamento);

	public Orcamento getPedidoOrcamentoMaisAntigo();

	/**
	 * 
	 * @param orcamento
	 */
	public void adicionarOrcamento(Orcamento orcamento);

	/**
	 * 
	 * @param idOrcamento
	 */
	public void removerOrcamento(String idOrcamento);

	/**
	 * Verifica se determinado identificador já está associado a uma ficha
	 * @param id - O identificador da ficha
	 * @return {@code true} se a ficha existe, {@code false} caso contrário
	 */
	public boolean fichaExiste(String id);

	/**
	 * Verifica se determinado identificador já está associado a um equipamento
	 * @param id - O identificador do equipamento
	 * @return {@code true} se o equipamento existe, {@code false} caso contrário
	 */
	public boolean equipamentoExiste(String id);

	/**
	 * Verifica se determinado identificador já está associado a um orcamento
	 * @param id - O identificador do orcamento
	 * @return {@code true} se o orcamento existe, {@code false} caso contrário
	 */
	public boolean orcamentoExiste(String id);

	/**
	 * Verifica se determinado identificador já está associado a um cliente
	 * @param nif - O numero de identificação fiscal do cliente
	 * @return {@code true} se o cliente existe, {@code false} caso contrário
	 */
	public boolean clienteExiste(String nif);

}