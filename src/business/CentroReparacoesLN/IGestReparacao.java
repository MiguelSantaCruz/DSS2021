package business.CentroReparacoesLN;

import java.util.Map;

import business.CentroReparacoesLN.GestReparacao.*;

public interface IGestReparacao {
    	/**
	 * 
	 * @param reparacao
	 */
	public void adicionaReparacoes(Reparacao reparacao);

	/**
	 * 
	 * @param idReparacoes
	 */
	public void removeReparacoes(String idReparacoes);

	/**
	 * 
	 * @param idReparacao
	 */
	public void marcarReparacoesComoConcluidas(String idReparacao);

	/**
	 * 
	 * @param idReparacao
	 * @param passo
	 */
	public void adicionarPasso(String idReparacao, Passo passo);

	/**
	 * 
	 * @param idReparacao
	 * @param idPasso
	 */
	public void removePasso(String idReparacao, String idPasso) ;

	/**
	 * 
	 * @param idPasso
	 * @param idReparacao
	 */
	public void marcarPassoComoConcluido(String idPasso, String idReparacao);

	/**
	 * 
	 * @param servico
	 */
	public void adicionaServicoExpresso(ServicoExpresso servico);

	/**
	 * 
	 * @param servico
	 */
	public void removeServicoExpresso(ServicoExpresso servico);

	/**
	 * 
	 * @param idReparacao
	 * @param listaPassos
	 */
	public void adicionaListaPassos(String idReparacao, Map<String, Passo> listaPassos);

	/**
	 * 
	 * @param idReparacao
	 * @param listaPecas
	 */
	public void adicionarListaPecas(String idReparacao, Map<String, Pecas> listaPecas);

	/**
	 * 
	 * @param idReparacao
	 */
	public boolean verificarConclusao(String idReparacao);

	/**
	 * 
	 * @param idReparacao
	 */
	public Reparacao getReparacao(String idReparacao);

	/**
	 * 
	 * @param idServico
	 */
	public ServicoExpresso getServicoExpresso(String idServico);

	/**
	 * 
	 * @param idReparacao
	 * @param idPasso
	 */
	public Passo getPasso(String idReparacao, String idPasso);

	/**
	 * 
	 * @param idReparacao
	 * @param idPeca
	 */
	public Pecas getPeca(String idReparacao, String idPeca);

	/**
	 * 
	 * @param reparacao
	 */
	public String reparacaoToString(Reparacao reparacao);

	/**
	 * 
	 * @param idReparacao
	 */
	public float calcularCustoTotal(String idReparacao);

	/**
	 * 
	 * @param idReparacaoGastas
	 */
	public int calcularHorasGastasTotais(String idReparacao);

	/**
	 * 
	 * @param idReparacao
	 */
	public int calcularHorasPrevistasTotais(String idReparacao);

	/**
	 * 
	 * @param servicoExpresso
	 */
    public void servicoToString(ServicoExpresso servicoExpresso);

	/**
	 * 
	 * @param descricao
	 * @return
	 */
	public Reparacao criarReparacao(String descricao);

	/**
	 * 
	 * @param descricao
	 * @return
	 */
	public ServicoExpresso criarServicoExpresso(String descricao);

	/**
	 * 
	 * @param idReparacao
	 * @return
	 */
	public boolean existeReparacao(String idReparacao);
}