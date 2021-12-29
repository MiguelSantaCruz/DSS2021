package business.CentroReparacoesLN;
import java.io.Serializable;
import java.util.Map;

import business.CentroReparacoesLN.GestReparacao.*;

public interface IGestReparacao extends Serializable {

    /**
	 * adiciona uma reparacao a lista de reparacoes
	 * @param reparacao
	 */
	public void adicionaReparacoes(Reparacao reparacao);

		/**
	 * adiciona uma reparacao a lista de reparacoes
	 * @param descricao - Descrição da reparação
	 * @return A reparação criada
	 */
	public Reparacao adicionaReparacoes(String descricao);

	/**
	 * remove uma reparacao da lista de reparacoes
	 * @param idReparacoes
	 */
	public void removeReparacoes(String idReparacoes);

	/**
	 * marca a reparacao como concluida, bem como a sua lista de passos e respetivos subpassos
	 * @param idReparacao
	 */
	public void marcarReparacoesComoConcluidas(String idReparacao);

	/**
	 * adiciona um passo de uma lista de passos de uma reparacao
	 * @param idReparacao
	 * @param passo
	 */
	public void adicionarPasso(String idReparacao, Passo passo);

	/**
	 * remove um passo de uma lista de passos de uma reparacao
	 * @param idReparacao
	 * @param idPasso
	 */
	public void removePasso(String idReparacao, String idPasso) ;

	/**
	 * marca um passo de uma reparaçao como concluido 
	 * @param idPasso
	 * @param idReparacao
	 */
	public void marcarPassoComoConcluido(String idPasso, String idReparacao);

	/**
	 * adiciona um serviço da lista de serviços expresso
	 * @param servico
	 */
	public void adicionaServicoExpresso(ServicoExpresso servico);

	/**
	 * remove um serviço da lista de serviços expresso, se este existir
	 * @param servico
	 */
	public void removeServicoExpresso(ServicoExpresso servico);

	/**
	 * adiciona uma peca a lista de pecas de uma reparacao
	 * @param idReparacao
	 * @param peca
	 */
	public void adicionarPecaReparacao(String idReparacao, Peca peca);

	/**
	 * remove uma peca da lista de pecas de uma reparacao, se estas existirem
	 * @param idReparacao
	 * @param peca
	 */
	public void removePecaReparacao(String idReparacao, Peca peca);

	/**
	 * adiciona peca a lista de pecas da loja
	 * @param peca
	 */
	public void adicionarPeca(Peca peca);

	/**
	 * remove peca da lista de pecas da loja
	 * @param peca
	 */
	public void removerPeca(String idPeca);

	/**
	 * verifica se uma reparacao esta concluida, ou seja se todos os passos estao concluidos
	 * @param idReparacao
	 * @return {@code true} se a reparacao está concluida, {@code false} caso contrário
	 */
	public boolean verificarConclusao(String idReparacao);

	/**
	 * 
	 * @param idReparacao
	 * @return reparacao
	 */
	public Reparacao getReparacao(String idReparacao);

	/**
	 * 
	 * @param idServico
	 * @return serviço expresso
	 */
	public ServicoExpresso getServicoExpresso(String idServico);

	/**
	 * 
	 * @param idReparacao
	 * @param idPasso
	 * @return passo
	 */
	public Passo getPasso(String idReparacao, String idPasso);

	/**
	 * 
	 * @param idPeca
	 * @return peca
	 */
	public Peca getPeca(String idPeca);

	public Map<String,Peca> getAllPecas();

	/**
	 * 
	 * @return 
	 */
	public Map<String,Reparacao> getAllReparacoes();

	/**
	 * 
	 * @return 
	 */
	public Map<String,ServicoExpresso> getAllServicoExpresso();

	/**
	 * 
	 * @param reparacao
	 * @return string
	 */
	public String reparacaoToString(Reparacao reparacao);

	/**
	 * calcula o custo da reparacao, que corresponde ao custo das pecas utilizadas
	 * @param idReparacao
	 * @return custo total
	 */
	public float calcularCustoTotal(String idReparacao);

	/**
	*  calcula o número de horas gastas da reparacao
	* @param idReparacao
	* @return horas gastas totais
	*/
	public int calcularHorasGastasTotais(String idReparacao);

	/**
	 * calcula o número de horas previstas para a conclusao da reparacao
	 * @param idReparacao
	 * @return horas previstas totais
	 */
	public int calcularHorasPrevistasTotais(String idReparacao);

	/**
	 * 
	 * @param servicoExpresso
	 * @return string
	 */
    public String servicoToString(ServicoExpresso servicoExpresso);


	/**
	 * 
	 * @param descricao
	 * @return serviço criado
	 */
	public ServicoExpresso criarServicoExpresso(String descricao);

	/**
	 * 
	 * @param descricao
	 * @return serviço criado
	 */
	public Peca criarPeca(String nome, Float valor,String descricao);


	/**
	 * 
	 * @param idReparacao
	 * @return
	 */
	public boolean existeReparacao(String idReparacao);

	/**
	 * Verifica se um serviço expresso existe no sistema
	 * @param idServico - O identificador do serviço
	 * @return {@code true} caso exista, {@code false} caso contrário
	 */
	public boolean existeServico(String idServico);

	/**
	 * Verifica se existe uma determinada peça dado o seu identificador
	 * @param idPeca - Identificador da peça
	 * @return {@code true} se existir, {@code false} caso contrário
	 */
	public boolean existePeca(String idPeca);

	/**
	 * Verifica se existe uma determinada peça dado o seu identificador
	 * @param idPeca - Identificador da peça
	 * @return a peça com o identificador especificado
	 */
	public Peca getPecaById(String idPeca);

	/**
	 * Devolve a reparação que tem a data mais antiga
	 * @return A reparação mais antiga
	 */
	public Reparacao getReparacaoMaisAntiga();
}