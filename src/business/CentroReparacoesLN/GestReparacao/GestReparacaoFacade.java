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
	 * @param reparacao
	 */
	public void adicionaReparacoes(Reparacao reparacao) {
		reparacoes.put(reparacao.getIdReparacao(), reparacao);
	}

	/**
	 * adiciona uma reparacao a lista de reparacoes
	 * @param descricao - Descrição da reparação
	 * @return A reparação criada
	 */
	public Reparacao adicionaReparacoes(String descricao) {
		String id;
		do {
			id = UUID.randomUUID().toString().substring(0, 8);
		} while (this.reparacoes.containsKey(id));
		Reparacao reparacao = new Reparacao(id, descricao);
		reparacoes.put(reparacao.getIdReparacao(), reparacao);
		return reparacao;
	}

	/**
	 * remove uma reparacao da lista de reparacoes
	 * @param idReparacoes
	 */
	public void removeReparacoes(String idReparacoes) {
		if(reparacoes.containsKey(idReparacoes))
			reparacoes.remove(idReparacoes);
	}

	/**
	 * marca a reparacao como concluida, bem como a sua lista de passos e respetivos subpassos
	 * @param idReparacao
	 */
	public void marcarReparacoesComoConcluidas(String idReparacao) {
		reparacoes.get(idReparacao).marcaReparacaoComoConcluida();
	}

	/**
	 * adiciona um passo de uma lista de passos de uma reparacao
	 * @param idReparacao
	 * @param passo
	 */
	public void adicionarPasso(String idReparacao, Passo passo) {
		if(reparacoes.containsKey(idReparacao)){
			reparacoes.get(idReparacao).getPasso().put(passo.getIdPasso(), passo);
		}
	}

	/**
	 * remove um passo de uma lista de passos de uma reparacao
	 * @param idReparacao
	 * @param idPasso
	 */
	public void removePasso(String idReparacao, String idPasso) {
		if(reparacoes.containsKey(idReparacao) && reparacoes.get(idReparacao).getPasso().containsKey(idPasso)){ 
			reparacoes.get(idReparacao).getPasso().remove(idPasso);
		}
		
	}

	/**
	 * marca um passo de uma reparaçao como concluido 
	 * @param idPasso
	 * @param idReparacao
	 */
	public void marcarPassoComoConcluido(String idPasso, String idReparacao) {
		if(reparacoes.containsKey(idReparacao) && reparacoes.get(idReparacao).getPasso().containsKey(idPasso)){ 
			reparacoes.get(idReparacao).getPasso().get(idPasso).setConcluido(true);
		}
	}

	/**
	 * adiciona um serviço da lista de serviços expresso
	 * @param servico
	 */
	public void adicionaServicoExpresso(ServicoExpresso servico) {
		servicos.put(servico.getIdServico(), servico);
	}

	/**
	 * remove um serviço da lista de serviços expresso, se este existir
	 * @param servico
	 */
	public void removeServicoExpresso(ServicoExpresso servico) {
		if(servicos.containsKey(servico.getIdServico())){
			servicos.remove(servico.getIdServico());
		}
	}


	/**
	 * adiciona uma peca a lista de pecas de uma reparacao
	 * @param idReparacao
	 * @param peca
	 */
	public void adicionarPecaReparacao(String idReparacao, Peca peca) {
		if(pecas.containsKey(peca.getIdPeca()) && reparacoes.containsKey(idReparacao))
			reparacoes.get(idReparacao).adicionaPeca(peca);
	}

	/**
	 * remove uma peca da lista de pecas de uma reparacao, se estas existirem
	 * @param idReparacao
	 * @param peca
	 */
	public void removePecaReparacao(String idReparacao, Peca peca) {
		if(pecas.containsKey(peca.getIdPeca()) && reparacoes.containsKey(idReparacao))
			reparacoes.get(idReparacao).removePeca(peca);
	}

	/**
	 * adiciona peca a lista de pecas da loja
	 * @param peca
	 */
	public void adicionarPeca(Peca peca) {
		pecas.put(peca.getIdPeca(), peca);
	}

	/**
	 * remove peca da lista de pecas da loja
	 * @param peca
	 */
	public void removerPeca(Peca peca) {
		if(pecas.containsKey(peca.getIdPeca()))
			pecas.remove(peca.getIdPeca());
	}

	/**
	 * verifica se uma reparacao esta concluida, ou seja se todos os passos estao concluidos
	 * @param idReparacao
	 * @return {@code true} se a reparacao está concluida, {@code false} caso contrário
	 */
	public boolean verificarConclusao(String idReparacao) {
		return reparacoes.get(idReparacao).verificaConclusao();
	}

	public Map<String,Peca> getAllPecas(){
		return this.pecas;
	}

	/**
	 * 
	 * @param idReparacao
	 * @return reparacao
	 */
	public Reparacao getReparacao(String idReparacao) {
		return reparacoes.get(idReparacao);
	}

	/**
	 * 
	 * 
	 * @return 
	 */
	public Map<String,Reparacao> getAllReparacoes() {
		return this.reparacoes;
	}

	/**
	 * 
	 * @param idServico
	 * @return serviço expresso
	 */
	public ServicoExpresso getServicoExpresso(String idServico) {
		return servicos.get(idServico);
	}

	/**
	 * 
	 * @return 
	 */
	public Map<String,ServicoExpresso> getAllServicoExpresso() {
		return this.servicos;
	}

	/**
	 * 
	 * @param idReparacao
	 * @param idPasso
	 * @return passo
	 */
	public Passo getPasso(String idReparacao, String idPasso) {
		if(reparacoes.get(idReparacao).getPasso().containsKey(idPasso))
			return reparacoes.get(idReparacao).getPasso().get(idPasso);
		else return null;
	}

	/**
	 * 
	 * @param idPeca
	 * @return peca
	 */
	public Peca getPeca(String idPeca) {
		if(pecas.containsKey(idPeca))
			return pecas.get(idPeca);
		else return null;
	}

	/**
	 * 
	 * @param reparacao
	 * @return string
	 */
	public String reparacaoToString(Reparacao reparacao) {
		return reparacao.toString();
	}

	/**
	 * calcula o custo da reparacao, que corresponde ao custo das pecas utilizadas
	 * @param idReparacao
	 * @return custo total
	 */
	public float calcularCustoTotal(String idReparacao){
		return reparacoes.get(idReparacao).calcularCustoTotal();
	}

	/**
	 *  calcula o número de horas gastas da reparacao
	 * @param idReparacao
	 * @return horas gastas totais
	 */
	public int calcularHorasGastasTotais(String idReparacao){
		return reparacoes.get(idReparacao).calcularHorasGastasTotais();
	}

	/**
	 * calcula o número de horas previstas para a conclusao da reparacao
	 * @param idReparacao
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
	 * 
	 * @param descricao
	 * @return reparacao criada
	 */
	public Reparacao criarReparacao(String descricao){
		//Gerar um identificador aleatório
		String id;
		do {
			id = UUID.randomUUID().toString().substring(0, 8);
		} while (this.reparacoes.containsKey(id));
		Reparacao reparacao = new Reparacao(id,descricao);
		return reparacao;
	}

	/**
	 * 
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
		return servico;
	}

	/**
	 * 
	 * @param 
	 * @return 
	 */
	public Peca criarPeca(String nome, Float valor,String descricao){
		//Gerar um identificador aleatório
		String id;
		do {
			id = UUID.randomUUID().toString().substring(0, 8);
		} while (this.servicos.containsKey(id));
		Peca peca = new Peca(id,nome,descricao,valor);
		return peca;
	}

	/**
	 * Verifica se um reparação existe no sistema
	 * @param idReparacao - O identificador da reparação
	 * @return {@code true} caso exista, {@code false} caso contrário
	 */
	public boolean existeReparacao(String idReparacao){
		if(this.reparacoes.containsKey(idReparacao)) return true;
		else return false;
	}

	/**
	 * Verifica se um serviço expresso existe no sistema
	 * @param idServico - O identificador do serviço
	 * @return {@code true} caso exista, {@code false} caso contrário
	 */
	public boolean existeServico(String idServico){
		if(this.servicos.containsKey(idServico)) return true;
		else return false;
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