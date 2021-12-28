package business.CentroReparacoesLN.GestUtilizadores;

public class Gestor {

	private String id;
	private String nome;
	private String palavraPasse;

	/* Getters and setters */

	public Gestor(String id, String nome,String palavraPasse){
		this.id = id;
		this.nome = nome;
		this.palavraPasse = palavraPasse;
	}

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
	 * @param nome - Nome do técnico a adicionar
	 * @param palavraPasse - Palavra passe do técnico a adicionar
	 * @param gestUtilizadores - Classe que gere os utilizadores
	 */
	public void adicionaTecnico(String nome,String palavraPasse,GestUtilizadores gestUtilizadores) {
		gestUtilizadores.adicionarTecnico(nome,palavraPasse);
	}

	/**
	 * Adiciona um funcionário ao Map de funcionários
	 * @param nome - Nome do funcionário a adicionar
	 * @param palavraPasse - Palavra passe do funcionário a adicionar
	 * @param gestUtilizadores - Classe que gere os utilizadores
	 */
	public void adicionaFuncionario(String nome,String palavraPasse,GestUtilizadores gestUtilizadores) {
		gestUtilizadores.adicionarFuncionario(nome,palavraPasse);
	}

	/**
	 * Adiciona um gestor ao Map de gestores
	 * @param nome - Nome do gestor a adicionar
	 * @param palavraPasse - Palavra passe do gestor a adicionar
	 * @param gestUtilizadores - Classe que gere os utilizadores
	 */
	public void adicionaGestor(String nome,String palavraPasse,GestUtilizadores gestUtilizadores) {
		gestUtilizadores.adicionarGestor(nome,palavraPasse);
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