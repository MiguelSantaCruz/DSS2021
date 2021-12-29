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

	public Map<String,Equipamento> getEquipamentos(){
		return this.equipamentos;
	}
	public Map<String,FichaEquipamento> getFichaEquipamentos(){
		return this.fichaEquipamentos;
	}


	/**
	 * 
	 * @param cliente
	 */
	public void adicionarCliente(Cliente cliente) {
		String key = cliente.getNif();
		clientes.put(key, cliente);
	}

	/**
	 * Adiciona um cliente
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
	 * 
	 * @param nif
	 */
	public void removerCliente(String nif) {
		if(clientes.containsKey(nif))
			clientes.remove(nif);
	}

	/**
	 * 
	 * @param equipamento
	 */
	public void adicionarFichaEquipamento(FichaEquipamento fichaEquipamento) {
		String key = fichaEquipamento.getIdFicha();
		fichaEquipamentos.put(key, fichaEquipamento);
	}

	/**
	 * 
	 * @param id
	 */
	public void removerFichaEquipamento(String id) {
		if(fichaEquipamentos.containsKey(id))
			fichaEquipamentos.remove(id);
	}

	/**
	 * 
	 * @param equipamento
	 */
	public void adicionarEquipamento(Equipamento equipamento) {
		String key = equipamento.getId();
		equipamentos.put(key, equipamento);
	}

	/**
	 * Regista um equipamento criando a sua ficha de equipamento em simultaneo
	 * @param idCliente - O identificador do cliente
	 * @param nomeEquip - O nome do equipamento
	 * @param descricaoEquip - A descricao do equipamento
	 * @param nomeFicha - O nome da ficha de equipamento
	 * @param descricaoFicha - A descricao da ficha de equipamento
	 */
	public FichaEquipamento registarEquipamento(String idCliente,String nomeEquip,String descricaoEquip,String nomeFicha,String descricaoFicha) {
		String idEquip = geraIdentificadorUnico(this.equipamentos);
		String idFicha = geraIdentificadorUnico(this.fichaEquipamentos);
		FichaEquipamento fichaDeEquimento = new FichaEquipamento(idFicha, nomeFicha, descricaoFicha, idCliente);
		Equipamento equipamento = new Equipamento(idEquip, fichaDeEquimento, descricaoEquip, nomeEquip);
		this.fichaEquipamentos.put(fichaDeEquimento.getIdFicha(), fichaDeEquimento);
		this.equipamentos.put(equipamento.getId(), equipamento);
		return fichaDeEquimento;
	}

	/**
	 * 
	 * @param id
	 */
	public void removerEquipamento(String id) {
		if(equipamentos.containsKey(id))
		equipamentos.remove(id);
	}

	/**
	 * adiciona orcamento à lista de orcamentos
	 * @param orcamento
	 */
	public void adicionarOrcamento(Orcamento orcamento) {
		String key = orcamento.getIdOrcamento();
		orcamentos.put(key, orcamento);
	}

	/**
	 * adiciona um orcamento à lista de orcamentos
	 * @param valor - o valor orçamentado
	 * @param descricao - Descricao do orçamento
	 * @return O orcamento que foi adicionado
	 */
	public Orcamento adicionarOrcamento(Float valor,String descricao) {
		String id = geraIdentificadorUnico(this.orcamentos);
		Orcamento orcamento = new Orcamento(id, valor,descricao);
		this.orcamentos.put(id, orcamento);
		return orcamento;
	}

	/**
	 * 
	 * @param idOrcamento
	 */
	public void removerOrcamento(String idOrcamento) {
		if(orcamentos.containsKey(idOrcamento))
			orcamentos.remove(idOrcamento);
		
	}

	/**
	 * 
	 * @param id
	 */
	public FichaEquipamento getFichaEquipamento(String id) {
		if(fichaEquipamentos.containsKey(id))
			return fichaEquipamentos.get(id);
		else return null;
	}

	/**
	 * 
	 * @param id
	 */
	public Equipamento getEquipamento(String id) {
		if(equipamentos.containsKey(id))
			return equipamentos.get(id);
		else return null;
	}

	/**
	 * 
	 * @param idEquipamento
	 */
	public Cliente getCliente(String idEquipamento) {
		String c = equipamentos.get(idEquipamento).getFichaDeEquimento().getIdCliente();
		if(clientes.containsKey(c))
			return clientes.get(c);
		else return null;
	}

	/**
	 * 
	 * @param nif
	 */
	public Cliente getClienteByNIF(String nif) {
		if(clientes.containsKey(nif))
			return clientes.get(nif);
		else return clientes.get(nif);
	}


	/**
	 * 
	 * @param idOrcamento
	 */
	public Orcamento getOrcamento(String idOrcamento) {
		if(orcamentos.containsKey(idOrcamento))
			return orcamentos.get(idOrcamento);
		else return null;
	}


	/**
	 * 
	 * 
	 */
	public Map<String,Orcamento> getAllOrcamentos() {
		return this.orcamentos;
	}

	/**
	 * Calcula o orcamento aprovado mais antigo
	 * @return o orcamento aprovado mais antigo
	 */
	public Orcamento getPedidoOrcamentoMaisAntigo() {
		LocalDateTime data = LocalDateTime.now();
		String id = null;
		for(Map.Entry<String, Orcamento> entry : orcamentos.entrySet()) {
			if(entry.getValue().isAprovado()){
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