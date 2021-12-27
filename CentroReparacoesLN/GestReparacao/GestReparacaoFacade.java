package CentroReparacoesLN.GestReparacao;

public class GestReparacaoFacade implements IGestReparacao {

	private Pecas pecas;
	private Reparacao reparacoes;

	/**
	 * 
	 * @param reparacao
	 */
	public void adicionaReparacoes(Reparacao reparacao) {
		// TODO - implement GestReparacaoFacade.adicionaReparacoes
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idReparacoes
	 */
	public void removeReparacoes(String idReparacoes) {
		// TODO - implement GestReparacaoFacade.removeReparacoes
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idReparacao
	 */
	public void marcarReparacoesComoConcluidas(String idReparacao) {
		// TODO - implement GestReparacaoFacade.marcarReparacoesComoConcluidas
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idReparacao
	 * @param passo
	 */
	public void adicionarPasso(String idReparacao, Passo passo) {
		// TODO - implement GestReparacaoFacade.adicionarPasso
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idReparacao
	 * @param idPasso
	 */
	public void removePasso(String idReparacao, String idPasso) {
		// TODO - implement GestReparacaoFacade.removePasso
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idPasso
	 * @param idReparacao
	 */
	public void marcarPassoComoConcluido(String idPasso, String idReparacao) {
		// TODO - implement GestReparacaoFacade.marcarPassoComoConcluido
		throw new UnsupportedOperationException();
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