package business.CentroReparacoesLN.GestEquipamentos;

public class Equipamento {

	private String id;
	private FichaEquipamento fichaDeEquimento;
	private String descricao;
	private String nome;
	private String idCliente;

	public String getId() {
		return this.id;
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	public String getDescricao() {
		return this.descricao;
	}

	/**
	 * 
	 * @param descricao
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() {
		return this.nome;
	}

	/**
	 * 
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	public FichaEquipamento getFichaDeEquimento() {
		return fichaDeEquimento;
	}

	/**
	 * 
	 * @param fichaDeEquipamento
	 */
	public void setFichaDeEquimento(FichaEquipamento fichaDeEquimento) {
		this.fichaDeEquimento = fichaDeEquimento;
	}

	public String getIdCliente() {
		return idCliente;
	}

	/**
	 * 
	 * @param idCliente
	 */
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

}