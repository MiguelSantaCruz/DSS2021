package business.CentroReparacoesLN.GestReparacao;

public class ServicoExpresso {

	private String idServico;
	private String descricao;
	private boolean concluido;


	public ServicoExpresso() {
	}


	public ServicoExpresso(String idServico, String descricao, boolean concluido) {
		this.idServico = idServico;
		this.descricao = descricao;
		this.concluido = concluido;
	}

	public String getIdServico() {
		return this.idServico;
	}

	public void setIdServico(String idServico) {
		this.idServico = idServico;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isConcluido() {
		return this.concluido;
	}

	public boolean getConcluido() {
		return this.concluido;
	}

	public void setConcluido(boolean concluido) {
		this.concluido = concluido;
	}

}