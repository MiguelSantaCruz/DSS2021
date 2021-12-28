package business.CentroReparacoesLN.GestEquipamentos;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import business.CentroReparacoesLN.IGestEquipamento;

public class GestEquipamentoFacade implements IGestEquipamento {

	private Map<String,FichaEquipamento> fichaEquipamentos = new HashMap<>();
	private Map<String,Equipamento> equipamentos = new HashMap<>();
	private Map<String, Cliente> clientes = new HashMap<>();
	private Map<String, Orcamento> orcamentos = new HashMap<>();

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
	 * 
	 * @param id
	 */
	public void removerEquipamento(String id) {
		if(equipamentos.containsKey(id))
		equipamentos.remove(id);
	}

	/**
	 * adiciona orcamento a lista de orcamentos
	 * @param orcamento
	 */
	public void adicionarOrcamento(Orcamento orcamento) {
		String key = orcamento.getIdOrcamento();
		orcamentos.put(key, orcamento);
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

}