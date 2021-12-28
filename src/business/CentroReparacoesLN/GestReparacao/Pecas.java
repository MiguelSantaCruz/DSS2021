package business.CentroReparacoesLN.GestReparacao;

public class Pecas {

	private ServicoExpresso pecas;
	private String idPeca;
	private float valor;

	public float getValor() {
		return this.valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public ServicoExpresso getPecas() {
		return pecas;
	}

	public void setPecas(ServicoExpresso pecas) {
		this.pecas = pecas;
	}

	public String getIdPeca() {
		return idPeca;
	}

	public void setIdPeca(String idPeca) {
		this.idPeca = idPeca;
	}

}