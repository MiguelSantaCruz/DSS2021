package business.CentroReparacoesLN.GestEquipamentos;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import business.CentroReparacoesLN.IGestEquipamento;

public class GestEquipamentoFacade implements IGestEquipamento {

	private Map<String,FichaEquipamento> fichaEquipamentos = new HashMap<>();
	private Map<String,Equipamento> equipamentos = new HashMap<>();
	private Map<String, Cliente> clientes = new HashMap<>();
	private Map<String, Orcamento> orcamentos = new HashMap<>();

	
	
	/**
	 * Devolve a lista de equipamentos
	 * @return lista de quipamentos
	 */
	public Map<String,Equipamento> getEquipamentos(){
		return this.equipamentos;
	}

	/**
	 * Devolve a lista de equipamentos
	 * @return lista de quipamentos
	 */
	public Map<String,FichaEquipamento> getFichaEquipamentos(){
		return this.fichaEquipamentos;
	}


	/**
	 * Adiciona um cliente a lista de clientes
	 * @param cliente - cliente a adicionar
	 */
	public void adicionarCliente(Cliente cliente) {
		String key = cliente.getNif();
		clientes.put(key, cliente);
	}

	/**
	 * Adiciona um cliente à lista de clientes
	 * @param nome - O nome do cliente
	 * @param nif - O NIF do cliente
	 * @param tlmv - O número de telemóvel do cliente
	 * @param email - O endereço de correio eletrónico do cliente
	 * @return O cliente adicionado
	 */
	public Cliente adicionarCliente(String nome,String nif,String tlmv,String email){
		Cliente cliente = new Cliente(nif, tlmv, email, nome);
		this.clientes.put(nif, cliente);
		return cliente;
	}


	/**
	 * Remove um cliente da lista de clientes
	 * @param nif - o NIF do cliente a remover
	 */
	public void removerCliente(String nif) {
		if(clientes.containsKey(nif))
			clientes.remove(nif);
	}

	/**
	 * adiciona uma ficha de equipamento à lista de fichas
	 * @param fichaEquipamento - a ficha de um equipamento
	 */
	public void adicionarFichaEquipamento(FichaEquipamento fichaEquipamento) {
		String key = fichaEquipamento.getIdFicha();
		this.fichaEquipamentos.put(key, fichaEquipamento);
	}

	/**
	 * remove uma ficha de equipamento da lista de fichas
	 * @param id - id da ficha de equipamento
	 */
	public void removerFichaEquipamento(String id) {
		if(fichaEquipamentos.containsKey(id))
			fichaEquipamentos.remove(id);
	}

	/**
	 * adiciona um equipamento à lista de equipamentos
	 * @param equipamento - o equipamento a adicionar
	 */
	public void adicionarEquipamento(Equipamento equipamento) {
		String key = equipamento.getId();
		equipamentos.put(key, equipamento);
	}

	/**
	 * Regista um equipamento criando a sua ficha de equipamento e o seu pedido de orçamento em simultaneo, 
	 * adicionando às listas respetivas de cada um
	 * @param idCliente - O identificador do cliente
	 * @param nomeEquip - O nome do equipamento
	 * @param descricaoEquip - A descricao do equipamento
	 * @param nomeFicha - O nome da ficha de equipamento
	 * @param descricaoFicha - A descricao da ficha de equipamento
	 * @return A ficha de equipamento criada
	 */
	public FichaEquipamento registarEquipamento(String idCliente,String nomeEquip,String descricaoEquip,String nomeFicha,String descricaoFicha) {
		String idEquip = geraIdentificadorUnico(this.equipamentos);
		String idFicha = geraIdentificadorUnico(this.fichaEquipamentos);
		String idOrcamento = geraIdentificadorUnico(this.orcamentos);
		Orcamento orcamento = new Orcamento(idOrcamento);
		FichaEquipamento fichaDeEquipamento = new FichaEquipamento(idFicha, nomeFicha, descricaoFicha, idCliente);
		Equipamento equipamento = new Equipamento(idEquip, fichaDeEquipamento, descricaoEquip, nomeEquip);
		this.adicionarEquipamento(equipamento);
		this.adicionarFichaEquipamento(fichaDeEquipamento);
		this.adicionarOrcamento(orcamento);
		return fichaDeEquipamento;
	}

	/**
	 * remove um equipamento da lista de equipamentos
	 * @param id - id do equipamento a remover
	 */
	public void removerEquipamento(String id) {
		if(equipamentos.containsKey(id))
		equipamentos.remove(id);
	}

	/**
	 * adiciona orcamento à lista de orcamentos
	 * @param orcamento - orçamento a adicionar
	 */
	public void adicionarOrcamento(Orcamento orcamento) {
		String key = orcamento.getIdOrcamento();
		orcamentos.put(key, orcamento);
	}

	/**
	 * regista um orcamento, gerando um id unico
	 * e adiciona-o à lista de orcamentos
	 * @param valor - o valor orçamentado
	 * @param descricao - Descricao do orçamento
	 * @return O orcamento que foi registado e adicionado
	 */
	public Orcamento adicionarOrcamento(Float valor,String descricao) {
		String id = geraIdentificadorUnico(this.orcamentos);
		Orcamento orcamento = new Orcamento(id, valor,descricao);
		//this.orcamentos.put(id, orcamento);
		this.adicionarOrcamento(orcamento);
		return orcamento;
	}

	/**
	 * remove um orcamento da lista de orcamento
	 * @param idOrcamento - id do orcamento a remover
	 */
	public void removerOrcamento(String idOrcamento) {
		if(orcamentos.containsKey(idOrcamento))
			orcamentos.remove(idOrcamento);
		
	}

	/**
	 * procura uma ficha de equipamento da lista pelo id
	 * @param id - id da ficha de equipamento
	 * @return ficha de equipamento se for encontrada, null se nao existir
	 * nenhuma ficha de equipamento associada ao id dado
	 */
	public FichaEquipamento getFichaEquipamento(String id) {
		if(fichaEquipamentos.containsKey(id))
			return fichaEquipamentos.get(id);
		else return null;
	}

	/**
	 * procura um equipamento da lista pelo id
	 * @param id - id do equipamento
	 * @return equipamento se for encontrado, null se nao existir
	 * nenhum equipamento associado ao id dado
	 */
	public Equipamento getEquipamento(String id) {
		if(equipamentos.containsKey(id))
			return equipamentos.get(id);
		else return null;
	}

	/**
	 * procura um cliente pelo equipamento registado
	 * @param idEquipamento - id do equipamento associado ao cliente
	 * @return cliente se for encontrado, null se nao existir
	 * nenhum cliente associado ao id de equipamento dado
	 */
	public Cliente getCliente(String idEquipamento) {
		String c = equipamentos.get(idEquipamento).getFichaDeEquimento().getIdCliente();
		if(clientes.containsKey(c))
			return clientes.get(c);
		else return null;
	}

	/**
	 * procura um cliente da lista de clientes pelo NIF
	 * @param nif - NIF do cliente a encontrar
	 * @return equipamento se for encontrado, null se nao existir
	 * nenhum equipamento associado ao id dado
	 */
	public Cliente getClienteByNIF(String nif) {
		if(clientes.containsKey(nif))
			return clientes.get(nif);
		else return clientes.get(nif);
	}


	/**
	 * procura um orcamento da lista de orcamentos
	 * @param idOrcamento - id do orcamento a encontrar
	 * @return orcamento se for encontrado, null se nao existir
	 * nenhum orcamento associado ao id dado
	 */
	public Orcamento getOrcamento(String idOrcamento) {
		if(orcamentos.containsKey(idOrcamento))
			return orcamentos.get(idOrcamento);
		else return null;
	}


	/**
	 * 
	 * @return a lista de todos os orcamentos
	 */
	public Map<String,Orcamento> getAllOrcamentos() {
		return this.orcamentos;
	}

	/**
	 * 
	 * @return a lista de todos os clientes
	 */
	public Map<String,Cliente> getAllClientes() {
		return this.clientes;
	}

	/**
	 * Calcula o orcamento aprovado mais antigo
	 * @return o orcamento aprovado mais antigo
	 */
	public Orcamento getPedidoOrcamentoMaisAntigo() {
		LocalDateTime data = LocalDateTime.now();
		String id = null;
		for(Map.Entry<String, Orcamento> entry : orcamentos.entrySet()) {
			if(!entry.getValue().getAprovado()){
				if(data.isAfter(entry.getValue().getDate())){
					data = entry.getValue().getDate();
					id = entry.getValue().getIdOrcamento();
				}
			}
		}
		return orcamentos.get(id);
	}

	

	/**
	 * Verifica se determinado identificador já está associado a uma ficha
	 * @param id - O identificador da ficha
	 * @return {@code true} se a ficha existe, {@code false} caso contrário
	 */
	public boolean fichaExiste(String id){
		if(this.fichaEquipamentos.containsKey(id)) return true;
		else return false;
	}

	/**
	 * Verifica se determinado identificador já está associado a um equipamento
	 * @param id - O identificador do equipamento
	 * @return {@code true} se o equipamento existe, {@code false} caso contrário
	 */
	public boolean equipamentoExiste(String id){
		if(this.equipamentos.containsKey(id)) return true;
		else return false;
	}

	/**
	 * Verifica se determinado identificador já está associado a um orcamento
	 * @param id - O identificador do orcamento
	 * @return {@code true} se o orcamento existe, {@code false} caso contrário
	 */
	public boolean orcamentoExiste(String id){
		if(this.orcamentos.containsKey(id)) return true;
		else return false;
	}

	/**
	 * Verifica se determinado identificador já está associado a um cliente
	 * @param nif - O numero de identificação fiscal do cliente
	 * @return {@code true} se o cliente existe, {@code false} caso contrário
	 */
	public boolean clienteExiste(String nif){
		if(this.clientes.containsKey(nif)) return true;
		else return false;
	}


	/**
	 * Gera um identificador de 8 caracteres único
	 * @param m - Map onde se pretende criar um id unico
	 * @return id gerado
	 */
	public String geraIdentificadorUnico(Map m){
		//Gerar um identificador aleatório
		String id;
		do {
			id = UUID.randomUUID().toString().substring(0, 8);
		} while (m.containsKey(id));
		return id;
	}

}