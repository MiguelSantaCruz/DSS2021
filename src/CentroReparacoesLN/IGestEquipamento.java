package CentroReparacoesLN;

import java.io.Serializable;
import java.util.Map;

import CentroReparacoesLN.GestEquipamentos.*;


public interface IGestEquipamento extends Serializable {


	/**
	 * 
	 * @param cliente
	 */
	public void adicionarCliente(Cliente cliente);

	/**
	 * Adiciona um cliente
	 * @param nome - O nome do cliente
	 * @param nif - O NIF do cliente
	 * @param tlmv - O número de telemóvel do cliente
	 * @param email - O endereço de correio eletrónico do cliente
	 * @return O cliente adicionado
	 */
	public Cliente adicionarCliente(String nome,String nif,String tlmv,String email);

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
	 * Regista um equipamento criando a sua ficha de equipamento em simultaneo, 
	 * adicionando às listas respetivas de cada um
	 * @param idCliente - O identificador do cliente
	 * @param nomeEquip - O nome do equipamento
	 * @param descricaoEquip - A descricao do equipamento
	 * @param nomeFicha - O nome da ficha de equipamento
	 * @param descricaoFicha - A descricao da ficha de equipamento
	 * @return A ficha de equipamento criada
	 */
	public FichaEquipamento registarEquipamento(String idCliente,String nomeEquip,String descricaoEquip,String nomeFicha,String descricaoFicha);

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

	
	public Map<String,Equipamento> getEquipamentos();

	public Map<String,FichaEquipamento> getFichaEquipamentos();

	/**
	 * 
	 * @param idEquipamento
	 */
	public Cliente getCliente(String idEquipamento);

	/**
	 * 
	 * @param id
	 */
	public Cliente getClienteByNIF(String nif);


	/**
	 * 
	 * @param idOrcamento
	 */
	public Orcamento getOrcamento(String idOrcamento);

	public Map<String,Orcamento> getAllOrcamentos();


	/**
	 * 
	 * @return a lista de todos os clientes
	 */
	public Map<String,Cliente> getAllClientes();

	public Orcamento getPedidoOrcamentoMaisAntigo();

	/**
	 * 
	 * @param orcamento
	 */
	public void adicionarOrcamento(Orcamento orcamento);

	/**
	 * adiciona um orcamento à lista de orcamentos
	 * @param valor - o valor orçamentado
	 * @param descricao - Descricao do orçamento
	 * @return 
	 */
	public Orcamento adicionarOrcamento(Float valor,String descricao);

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