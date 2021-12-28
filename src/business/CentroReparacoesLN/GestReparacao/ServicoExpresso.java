package business.CentroReparacoesLN.GestReparacao;

public class ServicoExpresso {

	private String idServico;
	private String descricao;
	private boolean concluido;

	
	public ServicoExpresso(String idServico, String descricao) {
		this.idServico = idServico;
		this.descricao = descricao;
		this.concluido = false;
	}

	/* Getters and Setters*/

	/**
	 * 
	 * @return id do serviço
	 */
	public String getIdServico() {
		return this.idServico;
	}

	/**
	 * 
	 * @param idServico
	 */
	public void setIdServico(String idServico) {
		this.idServico = idServico;
	}

	/**
	 * 
	 * @return id do serviço
	 */
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

	/**
	 * 
	 * @return o estado de conclusao do serviço
	 */
	public boolean isConcluido() {
		return this.concluido;
	}

	/**
	 * 
	 * @param concluido
	 */
	public void setConcluido(boolean concluido) {
		this.concluido = concluido;
	}

}