package CentroReparacoesLN.GestReparacao;

import java.io.Serializable;

public class Peca implements Serializable{

	private String idPeca;
	private String nome;
	private String descricao;
	private float valor;


	public Peca(String idPeca, String nome, String descricao, float valor) {
		this.idPeca = idPeca;
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
	}
	

	/* Getters and Setters*/	

	/**
	 * 
	 * @return valor da peca
	 */
	public float getValor() {
		return this.valor;
	}

	/**
	 * 
	 * @param valor
	 */
	public void setValor(float valor) {
		this.valor = valor;
	}

	/**
	 * 
	 * @return id da peca
	 */
	public String getIdPeca() {
		return idPeca;
	}

	/**
	 * 
	 * @param idPeca
	 */
	public void setIdPeca(String idPeca) {
		this.idPeca = idPeca;
	}


	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	@Override
	public String toString() {
		return ("ID: "+getIdPeca() + "\n" +
                "Descrição: " +getDescricao() +"\n" +
                "Nome: " +getNome() +"\n" +
                "Valor: " +getValor() + "\n");
	}

}