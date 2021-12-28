package business.CentroReparacoesLN.GestUtilizadores;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import business.CentroReparacoesLN.GestEquipamentos.*;
import business.CentroReparacoesLN.GestReparacao.*;

public class Funcionario {

	private String id;
	private String nome;
	private String palavraPasse;
	private List<String> listaIdsFichaEquipamentosRecebidos;
	private List<String> listaIdsFichaEquipamentosLevantados;

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

	public List<String> getListaIdsFichaEquipamentosRecebidos() {
		return this.listaIdsFichaEquipamentosRecebidos;
	}

	public void setListaIdsFichaEquipamentosRecebidos(List<String> listaIdsFichaEquipamentosRecebidos) {
		this.listaIdsFichaEquipamentosRecebidos = listaIdsFichaEquipamentosRecebidos;
	}

	public List<String> getListaIdsFichaEquipamentosLevantados() {
		return this.listaIdsFichaEquipamentosLevantados;
	}

	public void setListaIdsFichaEquipamentosLevantados(List<String> listaIdsFichaEquipamentosLevantados) {
		this.listaIdsFichaEquipamentosLevantados = listaIdsFichaEquipamentosLevantados;
	}



	/**
	 * Criar uma ficha de equipamento dados diversos parametros e adicionar ao Map de fichas
	 * @param idEquip - O identificador do equipamento
	 * @param nome - Nome do equipamento
	 * @param descricao - Descrição do equipamento
	 * @param orcamento - Orcamento associado
	 * @param gestEquipamentos - Classe que gere equipamentos e fichas de equipamentos
	 * @return A ficha de equipamento criada
	 */

	public FichaEquipamento criaFichaEquipamento(String idEquip, String nome, String descricao,GestEquipamentoFacade gestEquipamentos) {
		//Gerar um identificador aleatório
		String id;
		do {
			id = UUID.randomUUID().toString().substring(0, 8);
		} while (gestEquipamentos.fichaExiste(id));
		FichaEquipamento fichaEquipamento = new FichaEquipamento(id,nome, descricao, idEquip);
		gestEquipamentos.adicionarFichaEquipamento(fichaEquipamento);
		this.adicionaFichaEquipamentoRecebida(id);
		return fichaEquipamento;
	}

	/**
	 * Registar o levantamento de um equipamento, removendo-o dos Maps existentes
	 * @param IdEquipamento - Identificador do equipamento
	 * @param gestEquipamentos - Classe que gere equipamentos e fichas de equipamentos
	 */
	public void registarLevantamento(String IdEquipamento,GestEquipamentoFacade gestEquipamentos) {
		if(!gestEquipamentos.equipamentoExiste(IdEquipamento)) return;
		Equipamento equipamento = gestEquipamentos.getEquipamento(IdEquipamento);
		FichaEquipamento fichaEquipamento = equipamento.getFichaDeEquimento();
		gestEquipamentos.removerEquipamento(IdEquipamento);
		gestEquipamentos.removerFichaEquipamento(fichaEquipamento.getIdFicha());
		adicionaFichaEquipamentoLevantada(IdEquipamento);
	}

	/**
	 * Registar o pagamento e adicionar essa informação à ficha
	 * @param idFichaEquipamento - Identificador da ficha de equipamento
	 * @param valor - valor recebido
	 */
	public void registarPagamento(String idFichaEquipamento, int valor, GestEquipamentoFacade gestEquipamentos) {
		if(!gestEquipamentos.fichaExiste(idFichaEquipamento)) return;
		FichaEquipamento fichaEquipamento = gestEquipamentos.getFichaEquipamento(idFichaEquipamento);
		fichaEquipamento.setValorPago(valor);
	}

	/**
	 * Registar um servico expresso e adicionar-lo ao Mao
	 * @param descricao - Descricao do servico
	 * @param gestReparacoes - Classe de gestao de Reparacoes
	 * @return O serviço expresso registado
	 */
	public ServicoExpresso registarServicoExpresso(String descricao,GestReparacaoFacade gestReparacoes) {
		ServicoExpresso servicoExpresso =  gestReparacoes.criarServicoExpresso(descricao);
		gestReparacoes.adicionaServicoExpresso(servicoExpresso);
		return servicoExpresso;
	}

	/**
	 * Enviar um email ao utilizador
	 * @param mensagem - Mensagem a enviar
	 * @param nifCliente - Identificador do cliente
	 * @param gestEquipamentos - Classe de gestão de equipamentos
	 */
	public void contactarClienteEmail(String mensagem, String nifCliente,GestEquipamentoFacade gestEquipamentos) {
		Cliente c = gestEquipamentos.getClienteByNIF(nifCliente);
		System.out.println(LocalDateTime.now().toString());
		System.out.println("From: Centro de reparações");
		System.out.println("To: " + c.getEmail());
		System.out.println("Message: ");
		System.out.println(mensagem);
	}

	/**
	 * Enviar um sms ao utilizador
	 * @param mensagem - Mensagem a enviar
	 * @param nifCliente - Identificador do cliente
	 * @param gestEquipamentos - Classe de gestão de equipamentos
	 */
	public void contactarClienteSMS(String mensagem, String nifCliente,GestEquipamentoFacade gestEquipamentos) {
		Cliente c = gestEquipamentos.getClienteByNIF(nifCliente);
		System.out.println(LocalDateTime.now().toString());
		System.out.println("From: +351 253000001");
		System.out.println("To: " + c.getTelemovel());
		System.out.println("Message: ");
		System.out.println(mensagem);
	}

	/**
	 * Marca o orcamento como aprovado pelo cliente
	 * @param idOrcamento - Identificador do Orcamento
	 * @param gestEquipamentos - Classe de gestão de equipamentos
	 */
	public void confirmaOrcamento(String idOrcamento,GestEquipamentoFacade gestEquipamentos) {
		if(!gestEquipamentos.orcamentoExiste(idOrcamento)) return;
		gestEquipamentos.getOrcamento(idOrcamento).setAprovado(true);
	}


	/**
	 * Devolve a lista de identificadores de equipamentos recebidos
	 */
	public List<String> getListaEquipamentosRecebidos() {
		return this.listaIdsFichaEquipamentosRecebidos;
	}

	/**
	 * Devolve a lista de identificadores de equipamentos levantados
	 */
	public List<String> getListaEquipamentosLevantados() {
		return this.listaIdsFichaEquipamentosLevantados;
	}

	/**
	 * Adiciona á lista de identificadores de equipamentos recebidos o identificador da ficha
	 */
	public void adicionaFichaEquipamentoRecebida(String id){
		this.listaIdsFichaEquipamentosRecebidos.add(id);
	}

	/**
	 * Adiciona á lista de identificadores de equipamentos levantados o identificador da ficha
	 */
	public void adicionaFichaEquipamentoLevantada(String id){
		this.listaIdsFichaEquipamentosLevantados.add(id);
	}

}