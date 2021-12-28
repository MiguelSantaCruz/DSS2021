package business.CentroReparacoesLN.GestReparacao;

public class Pecas {

	private String idPeca;
	private float valor;

	

	public Pecas(String idPeca, float valor) {
		this.idPeca = idPeca;
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

}