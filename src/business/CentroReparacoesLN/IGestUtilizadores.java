package business.CentroReparacoesLN;

import business.CentroReparacoesLN.GestUtilizadores.*;

public interface IGestUtilizadores {

	/**
	 * Adiciona ao Map de técnicos o técnico em questão
	 * @param tecnico - O técnico a adicionar
	 */
	public void adicionarTecnico(Tecnico tecnico);

	/**
	 * Adiciona ao Map de funcionários o funcionário em questão
	 * @param funcionario - O funcionário a adicionar
	 */
	public void adicionarFuncionario(Funcionario funcionario);

	/**
	 * Adiciona ao Map de gestores o gestor em questão
	 * @param gestor - O gestor a adicionar
	 */
	public void adicionarGestor(Gestor gestor);

	/**
	 * Remove ao Map de técnicos o técnico em questão
	 * @param id - O identificador do técnico a remover
	 */
	public void removerTecnico(String id);

	/**
	 * Remove ao Map de funcionários o funcionário em questão
	 * @param id - O identificador do funcionário a remover
	 */
	public void removerFuncionario(String id);

	/**
	 * Remove ao Map de gestores o gestor em questão
	 * @param id - O identificador do gestor a remover
	 */
	public void removerGestor(String id);


	/**
	 * Verifica se a palavra passe fornecida corresponde á palavra passe do técnico com o identificador especificado
	 * @param id - O identificador do técnico
	 * @param password - Palavra passe a verificar
	 * @return {@code true} se a password recebida como argumento estiver correta, {@code false} caso contrário
	 */
	public boolean autenticaTecnico(String id, String password);

	/**
	 * Verifica se a palavra passe fornecida corresponde á palavra passe do funcionário com o identificador especificado
	 * @param id - O identificador do funcionário
	 * @param password - Palavra passe a verificar
	 * @return {@code true} se a password recebida como argumento estiver correta, {@code false} caso contrário
	 */
	public boolean autenticaFuncionario(String id, String password);

	/**
	 * Verifica se a palavra passe fornecida corresponde á palavra passe do gestor com o identificador especificado
	 * @param id - Identificador do gestor
	 * @param password - Palavra passe a verificar
	 * @return {@code true} se a password recebida como argumento estiver correta, {@code false} caso contrário
	 */
	public boolean autenticaGestor(String id, String password);

	/**
	 * Dado um identificador de um técnico devolve o técnico associado
	 * @return O técnico cujo identificador é igual ao fornecido ou {@code null} caso não exista
	 * @param id - Identificador do técnico
	 */
	public Tecnico getTecnicoById(String id);

	/**
	 * Dado um identificador de um funcionario devolve o funcionario associado
	 * @return O funcionario cujo identificador é igual ao fornecido ou null caso não exista
	 * @param id - Identificador do funcionario
	 */
	public Funcionario getFuncionarioById(String id);

	/**
	 * Dado um identificador de um gestor devolve o gestor associado
	 * @return O gestor cujo identificador é igual ao fornecido ou {@code null} caso não exista
	 * @param id - Identificador do gestor
	 */
	public Gestor getGestorById(String id);

	/**
	 * Consultar uma listagem exaustiva, para cada técnico, de todas as intervenções (passos de reparação e reparações expresso) realizadas.
	 * @param idTecnico - Identificador do Técnico
	 */
	public void consultaDetalhesIntervencoesTecnico(String idTecnico,IGestReparacao gestReparacao);

	/**
	 * Consultar uma listagem em que para cada técnico de reparações são indicadas estatíticas como por exemplo 
	 * o número de intervenções e horas gastas.
	 *
	 */
	public void consultaEstatisticasReparacoes(IGestReparacao gestReparacao);

	/**
	 * 	Consultar uma listagem que indica, para cada funcionário de balcão, quantas recepções e entregas de equipamentos realizou.
	 * @param idFuncionario - O identificador do funcionário
	 */
	public void consultaListaEntregasFuncionario(String idFuncionario);


}