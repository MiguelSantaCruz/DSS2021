package business.CentroReparacoesLN.GestReparacao;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import business.CentroReparacoesLN.IGestReparacao;

public class GestReparacaoFacade implements IGestReparacao {

	private Map<String,Pecas> pecas = new HashMap<>();
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
	 * remove uma reparacao da lista de reparacoes
	 * @param idReparacoes
	 */
	public void removeReparacoes(String idReparacoes) {
		if(reparacoes.containsKey(idReparacoes))
			reparacoes.remove(idReparacoes);
	}

	/**
	 * 
	 * @param idReparacao
	 */
	public void marcarReparacoesComoConcluidas(String idReparacao) {
		//ArrayList<Passo> passos = reparacoes.get(idReparacao).getPasso();
		//falta percorrer a lista de passos aqui e marcar true;
		reparacoes.get(idReparacao).setConcluido(true);
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
	public void adicionarPecaReparacao(String idReparacao, Pecas peca) {
		if(pecas.containsKey(peca.getIdPeca()) && reparacoes.containsKey(idReparacao))
			reparacoes.get(idReparacao).adicionaPeca(peca);
	}

	/**
	 * remove uma peca da lista de pecas de uma reparacao, se estas existirem
	 * @param idReparacao
	 * @param peca
	 */
	public void removePecaReparacao(String idReparacao, Pecas peca) {
		if(pecas.containsKey(peca.getIdPeca()) && reparacoes.containsKey(idReparacao))
			reparacoes.get(idReparacao).removePeca(peca);
	}

	/**
	 * adiciona peca a lista de pecas da loja
	 * @param peca
	 */
	public void adicionarPeca(Pecas peca) {
		pecas.put(peca.getIdPeca(), peca);
	}

	/**
	 * remove peca da lista de pecas da loja
	 * @param peca
	 */
	public void removerPeca(Pecas peca) {
		if(pecas.containsKey(peca.getIdPeca()))
			pecas.remove(peca.getIdPeca());
	}

	/**
	 * 
	 * @param idReparacao
	 */
	public boolean verificarConclusao(String idReparacao) {
		// TODO - implement GestReparacaoFacade.verificarConclusao
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idReparacao
	 */
	public Reparacao getReparacao(String idReparacao) {
		return reparacoes.get(idReparacao);
	}

	/**
	 * 
	 * @param idServico
	 */
	public ServicoExpresso getServicoExpresso(String idServico) {
		return servicos.get(idServico);
	}

	/**
	 * 
	 * @param idReparacao
	 * @param idPasso
	 */
	public Passo getPasso(String idReparacao, String idPasso) {
		if(reparacoes.get(idReparacao).getPasso().containsKey(idPasso))
			return reparacoes.get(idReparacao).getPasso().get(idPasso);
		else return null;
	}

	/**
	 * 
	 * @param idPeca
	 */
	public Pecas getPeca(String idPeca) {
		if(pecas.containsKey(idPeca))
			return pecas.get(idPeca);
		else return null;
	}

	/**
	 * 
	 * @param reparacao
	 */
	public String reparacaoToString(Reparacao reparacao) {
		// TODO - implement GestReparacaoFacade.reparacaoToString
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idReparacao
	 */
	public float calcularCustoTotal(String idReparacao){
		// TODO - implement GestReparacaoFacade.reparacaoToString
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idReparacaoGastas
	 */
	public int calcularHorasGastasTotais(String idReparacao){
		// TODO - implement GestReparacaoFacade.reparacaoToString
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idReparacao
	 */
	public int calcularHorasPrevistasTotais(String idReparacao){
		// TODO - implement GestReparacaoFacade.reparacaoToString
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param servicoExpresso
	 */
    public void servicoToString(ServicoExpresso servicoExpresso) {
		//TODO
    }

	/**
	 * 
	 * @param descricao
	 * @return
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
	 * @return
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
	 * @param idReparacao
	 * @return
	 */
	public boolean existeReparacao(String idReparacao){
		if(this.reparacoes.containsKey(idReparacao)) return true;
		else return false;
	}
}