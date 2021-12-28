package business.CentroReparacoesLN.GestUtilizadores;

public class Gestor {

	private String id;
	private String nome;
	private String palavraPasse;

	/* Getters and setters */

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


	/**
	 * Adiciona um técnico ao Map de técnicos
	 * @param tecnico - Técnico a adicionar
	 * @param gestUtilizadores - Classe que gere os utilizadores
	 */
	public void adicionaTecnico(Tecnico tecnico,GestUtilizadores gestUtilizadores) {
		gestUtilizadores.adicionarTecnico(tecnico);
	}

	/**
	 * Adiciona um funcionário ao Map de funcionários
	 * @param funcionario - funcionśrio a adicionar
	 * @param gestUtilizadores - Classe que gere os utilizadores
	 */
	public void adicionaFuncionario(Funcionario funcionario,GestUtilizadores gestUtilizadores) {
		gestUtilizadores.adicionarFuncionario(funcionario);
	}

	/**
	 * Remove um técnico do Map de técnicos
	 * @param idTecnico - Identificador do técnico a remover
	 * @param gestUtilizadores - Classe que gere os utilizadores
	 */
	public void removeTecnico(String idTecnico,GestUtilizadores gestUtilizadores) {
		gestUtilizadores.removerTecnico(idTecnico);
	}

	/**
	 * Remove um funcionário do Map de funcionários
	 * @param idFuncionario - Identificador do funcionário a remover
	 * @param gestUtilizadores - Classe que gere os utilizadores
	 */
	public void removeFuncionario(String idFuncionario, GestUtilizadores gestUtilizadores) {
		gestUtilizadores.removerFuncionario(idFuncionario);
	}

}