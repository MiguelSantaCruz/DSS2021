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

	public void setId(String id) {
		this.id = id;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}