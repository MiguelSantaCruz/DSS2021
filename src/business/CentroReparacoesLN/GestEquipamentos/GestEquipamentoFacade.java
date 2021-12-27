package business.CentroReparacoesLN.GestEquipamentos;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class GestEquipamentoFacade implements IGestEquipamento {

	private Map<String,FichaEquipamento> equipamentos = new HashMap<>();
	private Map<String, Cliente> clientes = new HashMap<>();
	private Map<String, Orcamento> orcamentos = new HashMap<>();

	/**
	 * 
	 * @param equipamento
	 */
	public void adicionarFichaEquipamento(FichaEquipamento equipamento) {
		String key = equipamento.getIdEquipamento();
		equipamentos.put(key, equipamento);
	}

	/**
	 * 
	 * @param id
	 */
	public void removerFichaEquipamento(String id) {
		if(equipamentos.containsKey(id))
			equipamentos.remove(id);
	}

	/**
	 * 
	 * @param id
	 */
	public FichaEquipamento getFichaEquipamento(String id) {
		if(equipamentos.containsKey(id))
			return equipamentos.get(id);
		else return null;
	}

	/**
	 * 
	 * @param idEquipamento
	 */
	public Cliente getCliente(String idEquipamento) {
		String c = equipamentos.get(idEquipamento).getEquipamento().getIdCliente();
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
	 * 
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

}