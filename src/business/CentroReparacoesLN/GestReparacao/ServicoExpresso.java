package business.CentroReparacoesLN.GestReparacao;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ServicoExpresso implements Serializable{

	private String idServico;
	private String descricao;
	private LocalDateTime date;
	private boolean concluido;

	
	public ServicoExpresso(String idServico, String descricao) {
		this.idServico = idServico;
		this.descricao = descricao;
		this.date = LocalDateTime.now();
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


	public LocalDateTime getDate() {
		return this.date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public boolean getConcluido() {
		return this.concluido;
	}


	@Override
	public String toString() {
		return ("ID: "+ getIdServico() +"\n"
				+ "Data: " + getDate() + "\n"
				+ "Descrição: " + getDescricao()+ "\n");
	}
	

}