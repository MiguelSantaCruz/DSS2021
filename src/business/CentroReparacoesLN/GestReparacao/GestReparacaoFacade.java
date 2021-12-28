package business.CentroReparacoesLN.GestReparacao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import business.CentroReparacoesLN.IGestReparacao;

public class GestReparacaoFacade implements IGestReparacao {

	private Map<String,Pecas> pecas = new HashMap<>();
	private Map<String,Reparacao> reparacoes = new HashMap<>();
	private Map<String,ServicoExpresso> servicos = new HashMap<>();

	/**
	 * 
	 * @param reparacao
	 */
	public void adicionaReparacoes(Reparacao reparacao) {
		reparacoes.put(reparacao.getIdReparacao(), reparacao);
	}

	/**
	 * 
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
	 * 
	 * @param idReparacao
	 * @param passo
	 */
	public void adicionarPasso(String idReparacao, Passo passo) {
		if(reparacoes.containsKey(idReparacao)){
			reparacoes.get(idReparacao).getPasso().put(getIdPasso(passo), passo);
		}
	}

	/**
	 * 
	 * @param idReparacao
	 * @param idPasso
	 */
	public void removePasso(String idReparacao, String idPasso) {
		/*if(reparacoes.containsKey(idReparacao) && reparacoes.get(idReparacao).getPasso().contains(getPasso(idReparacao, idPasso))){ 
			reparacoes.get(idReparacao).getPasso().remove(getPasso(idReparacao, idPasso));
		}*/
		
	}

	/**
	 * 
	 * @param idPasso
	 * @param idReparacao
	 */
	public void marcarPassoComoConcluido(String idPasso, String idReparacao) {
		//reparacoes.get(idReparacao).getPasso().
	}

	/**
	 * 
	 * @param servico
	 */
	public void adicionaServicoExpresso(ServicoExpresso servico) {
		// TODO - implement GestReparacaoFacade.adicionaServicoExpresso
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param servico
	 */
	public void removeServicoExpresso(ServicoExpresso servico) {
		// TODO - implement GestReparacaoFacade.removeServicoExpresso
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idReparacao
	 * @param listaPassos
	 */
	public void adicionaListaPassos(String idReparacao, Map<String, Passo> listaPassos) {
		// TODO - implement GestReparacaoFacade.adicionaListaPassos
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idReparacao
	 * @param listaPecas
	 */
	public void adicionarListaPecas(String idReparacao, Map<String, Pecas> listaPecas) {
		// TODO - implement GestReparacaoFacade.adicionarListaPecas
		throw new UnsupportedOperationException();
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
		// TODO - implement GestReparacaoFacade.getReparacao
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idServico
	 */
	public ServicoExpresso getServicoExpresso(String idServico) {
		// TODO - implement GestReparacaoFacade.getServicoExpresso
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idReparacao
	 * @param idPasso
	 */
	public Passo getPasso(String idReparacao, String idPasso) {
		// TODO - implement GestReparacaoFacade.getPasso
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idReparacao
	 * @param idPeca
	 */
	public Pecas getPeca(String idReparacao, String idPeca) {
		// TODO - implement GestReparacaoFacade.getPeca
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param reparacao
	 */
	public String reparacaoToString(Reparacao reparacao) {
		// TODO - implement GestReparacaoFacade.reparacaoToString
		throw new UnsupportedOperationException();
	}

}