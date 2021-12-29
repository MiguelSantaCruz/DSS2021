package business.CentroReparacoesLN.GestReparacao;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import business.CentroReparacoesLN.IGestReparacao;

public class GestReparacaoFacade implements IGestReparacao {

	private Map<String,Peca> pecas = new HashMap<>();
	private Map<String,Reparacao> reparacoes = new HashMap<>();
	private Map<String,ServicoExpresso> servicos = new HashMap<>();

	/**
	 * adiciona uma reparacao a lista de reparacoes
	 * @param reparacao - reparacao a adicionar
	 */
	public void adicionaReparacoes(Reparacao reparacao) {
		reparacoes.put(reparacao.getIdReparacao(), reparacao);
	}

	/**
	 * regista e adiciona uma reparacao a lista de reparacoes
	 * @param descricao - Descrição da reparação
	 * @return A reparação criada
	 */
	public Reparacao adicionaReparacoes(String descricao) {
		String id;
		do {
			id = UUID.randomUUID().toString().substring(0, 8);
		} while (this.reparacoes.containsKey(id));
		Reparacao reparacao = new Reparacao(id, descricao);
		//reparacoes.put(reparacao.getIdReparacao(), reparacao);
		this.adicionaReparacoes(reparacao);
		return reparacao;
	}

	/**
	 * remove uma reparacao da lista de reparacoes
	 * @param idReparacoes - id da reparacao a remover
	 */
	public void removeReparacoes(String idReparacoes) {
		if(reparacoes.containsKey(idReparacoes))
			reparacoes.remove(idReparacoes);
	}

	/**
	 * marca a reparacao como concluida, bem como a sua lista de passos e respetivos subpassos
	 * @param idReparacao - id da reparacao a marcar como concluida
	 */
	public void marcarReparacoesComoConcluidas(String idReparacao) {
		reparacoes.get(idReparacao).marcaReparacaoComoConcluida();
	}

	/**
	 * adiciona um passo de uma lista de passos de uma reparacao
	 * @param idReparacao - id da reparacao
	 * @param passo - passo a adicionar a lista de passos da reparacao
	 */
	public void adicionarPasso(String idReparacao, Passo passo) {
		if(reparacoes.containsKey(idReparacao)){
			reparacoes.get(idReparacao).getPasso().put(passo.getIdPasso(), passo);
		}
	}

	/**
	 * remove um passo de uma lista de passos de uma reparacao
	 * @param idReparacao - id da reparacao
	 * @param idPasso - passo a remover da lista de passos da reparacao
	 */
	public void removePasso(String idReparacao, String idPasso) {
		if(reparacoes.containsKey(idReparacao) && reparacoes.get(idReparacao).getPasso().containsKey(idPasso)){ 
			reparacoes.get(idReparacao).getPasso().remove(idPasso);
		}
		
	}

	/**
	 * marca um passo de uma reparaçao como concluido 
	 * @param idPasso - passo a marcar como concluido
	 * @param idReparacao - id da reparacao
	 */
	public void marcarPassoComoConcluido(String idPasso, String idReparacao) {
		if(reparacoes.containsKey(idReparacao) && reparacoes.get(idReparacao).getPasso().containsKey(idPasso)){ 
			reparacoes.get(idReparacao).getPasso().get(idPasso).setConcluido(true);
		}
	}

	/**
	 * adiciona um serviço da lista de serviços expresso
	 * @param servico - serviço a adicionar
	 */
	public void adicionaServicoExpresso(ServicoExpresso servico) {
		servicos.put(servico.getIdServico(), servico);
	}

	/**
	 * remove um serviço da lista de serviços expresso, se este existir
	 * @param servico - serviço a remover
	 */
	public void removeServicoExpresso(ServicoExpresso servico) {
		if(servicos.containsKey(servico.getIdServico())){
			servicos.remove(servico.getIdServico());
		}
	}


	/**
	 * adiciona uma peca a lista de pecas de uma reparacao
	 * @param idReparacao - id da reparacao
	 * @param peca - peca a adicionar a lista de pecas da reparacao
	 */
	public void adicionarPecaReparacao(String idReparacao, Peca peca) {
		if(pecas.containsKey(peca.getIdPeca()) && reparacoes.containsKey(idReparacao))
			reparacoes.get(idReparacao).adicionaPeca(peca);
	}

	/**
	 * remove uma peca da lista de pecas de uma reparacao, se estas existirem
	 * @param idReparacao - id da reparacao
	 * @param peca - peca a remover da lista de pecas da reparacao
	 */
	public void removePecaReparacao(String idReparacao, Peca peca) {
		if(pecas.containsKey(peca.getIdPeca()) && reparacoes.containsKey(idReparacao))
			reparacoes.get(idReparacao).removePeca(peca);
	}

	/**
	 * adiciona peca a lista de pecas da loja
	 * @param peca - peca a adicionar
	 */
	public void adicionarPeca(Peca peca) {
		pecas.put(peca.getIdPeca(), peca);
	}

	/**
	 * remove peca da lista de pecas da loja
	 * @param idPeca - id da peca a remover
	 */
	public void removerPeca(String idPeca) {
		if(pecas.containsKey(idPeca))
			pecas.remove(idPeca);
	}

	/**
	 * verifica se uma reparacao esta concluida, ou seja se todos os passos estao concluidos
	 * @param idReparacao - id da reparacao a verificar
	 * @return {@code true} se a reparacao está concluida, {@code false} caso contrário
	 */
	public boolean verificarConclusao(String idReparacao) {
		return reparacoes.get(idReparacao).verificaConclusao();
	}

	/**
	 * devolve a lista de todos as pecas registados
	 * @return lista de pecas
	 */
	public Map<String,Peca> getAllPecas(){
		return this.pecas;
	}

	/**
	 * procura um serviço expresso na lista pelo seu id
	 * @param idReparacao - id da reparacao
	 * @return reparacao
	 */
	public Reparacao getReparacao(String idReparacao) {
		return reparacoes.get(idReparacao);
	}

	/**
	 * devolve a lista de todos os reparacoes registadas
	 * @return lista de todas as reparacoes
	 */
	public Map<String,Reparacao> getAllReparacoes() {
		return this.reparacoes;
	}

	/**
	 * procura um serviço expresso na lista pelo seu id
	 * @param idServico - id do serviço
	 * @return serviço expresso
	 */
	public ServicoExpresso getServicoExpresso(String idServico) {
		return servicos.get(idServico);
	}

	/**
	 * devolve a lista de todos os serviços expresso registados
	 * @return lista de serviços expresso
	 */
	public Map<String,ServicoExpresso> getAllServicoExpresso() {
		return this.servicos;
	}

	/**
	 * procura um passo na lista de passos de uma reparacao
	 * @param idReparacao - id da reparacao
	 * @param idPasso - id do passo a encontrar
	 * @return passo se encontrar, null se nao existir nenhum passo associado ao id fornecido
	 */
	public Passo getPasso(String idReparacao, String idPasso) {
		if(reparacoes.get(idReparacao).getPasso().containsKey(idPasso))
			return reparacoes.get(idReparacao).getPasso().get(idPasso);
		else return null;
	}

	/**
	 * procura uma peca na lista pelo seu id
	 * @param idPeca - id da peca
	 * @return peca encontrada ou null se nao encontrar nenhuma peca associada ao id
	 */
	public Peca getPeca(String idPeca) {
		if(pecas.containsKey(idPeca))
			return pecas.get(idPeca);
		else return null;
	}

	/**
	 * 
	 * @param reparacao - reparacao
	 * @return string
	 */
	public String reparacaoToString(Reparacao reparacao) {
		return reparacao.toString();
	}

	/**
	 * calcula o custo da reparacao, que corresponde ao custo das pecas utilizadas
	 * @param idReparacao - reparacao a calcular
	 * @return custo total calculado
	 */
	public float calcularCustoTotal(String idReparacao){
		return reparacoes.get(idReparacao).calcularCustoTotal();
	}

	/**
	 *  calcula o número de horas gastas da reparacao
	 * @param idReparacao - reparacao a calcular
	 * @return horas gastas totais
	 */
	public int calcularHorasGastasTotais(String idReparacao){
		return reparacoes.get(idReparacao).calcularHorasGastasTotais();
	}

	/**
	 * calcula o número de horas previstas para a conclusao de uma reparacao
	 * @param idReparacao - id da reparacao a calcular
	 * @return horas previstas totais 
	 */
	public int calcularHorasPrevistasTotais(String idReparacao){
		return reparacoes.get(idReparacao).calcularHorasPrevistasTotais();
	}

	/**
	 * 
	 * @param servicoExpresso
	 * @return string
	 */
    public String servicoToString(ServicoExpresso servicoExpresso) {
		return servicoExpresso.toString();
    }


	/**
	 * cria e adiciona um serviço expresso a lista
	 * @param descricao
	 * @return serviço criado
	 */
	public ServicoExpresso criarServicoExpresso(String descricao){
		//Gerar um identificador aleatório
		String id;
		do {
			id = UUID.randomUUID().toString().substring(0, 8);
		} while (this.servicos.containsKey(id));
		ServicoExpresso servico = new ServicoExpresso(id,descricao);
		this.adicionaServicoExpresso(servico);
		return servico;
	}

	/**
	 * cria e adiciona uma peca a lista de pecas da loja
	 * @param nome da peca
	 * @param valor da peça
	 * @param descricao da peca
	 * @return peca criada
	 */
	public Peca criarPeca(String nome, Float valor,String descricao){
		//Gerar um identificador aleatório
		String id;
		do {
			id = UUID.randomUUID().toString().substring(0, 8);
		} while (this.servicos.containsKey(id));
		Peca peca = new Peca(id,nome,descricao,valor);
		this.adicionarPeca(peca);
		return peca;
	}

	/**
	 * Verifica se um reparação existe no sistema
	 * @param idReparacao - O identificador da reparação
	 * @return {@code true} caso exista, {@code false} caso contrário
	 */
	public boolean existeReparacao(String idReparacao){
		return this.reparacoes.containsKey(idReparacao);
	}

	/**
	 * Verifica se um serviço expresso existe no sistema
	 * @param idServico - O identificador do serviço
	 * @return {@code true} caso exista, {@code false} caso contrário
	 */
	public boolean existeServico(String idServico){
		return this.servicos.containsKey(idServico);
	}


	/**
	 * Verifica se existe uma determinada peça dado o seu identificador
	 * @param idPeca - Identificador da peça
	 * @return {@code true} se existir, {@code false} caso contrário
	 */
	public boolean existePeca(String idPeca){
		return pecas.containsKey(idPeca);
	}

	/**
	 * Verifica se existe uma determinada peça dado o seu identificador
	 * @param idPeca - Identificador da peça
	 * @return a peça com o identificador especificado
	 */
	public Peca getPecaById(String idPeca){
		return pecas.get(idPeca);
	}

	/**
	 * Devolve a reparação que tem a data mais antiga
	 * @return A reparação mais antiga
	 */
	public Reparacao getReparacaoMaisAntiga(){
		LocalDateTime date = LocalDateTime.now();
		String id = null;
		for (Map.Entry<String,Reparacao> entry : this.reparacoes.entrySet()) {
			if(entry.getValue().getDate().isBefore(date)){
				id = entry.getKey();
				date = entry.getValue().getDate();
			}
		}
		return this.reparacoes.get(id);
	}
}