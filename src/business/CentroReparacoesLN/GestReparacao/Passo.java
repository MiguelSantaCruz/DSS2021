package business.CentroReparacoesLN.GestReparacao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Passo {

	private Map<String, Passo> passo = new HashMap<>();
	private String idPasso;
	private Passo listaPassos;
	private String descricao;
	private boolean concluido;
	private int horasGastas;
	private int horasPrevistas;

	

	public Map<String, Passo> getPasso() {
		return passo;
	}

	public void setPasso(Map<String, Passo> passo) {
		this.passo = passo;
	}

	public String getIdPasso() {
		return idPasso;
	}

	public void setIdPasso(String idPasso) {
		this.idPasso = idPasso;
	}

	public Passo getListaPassos() {
		return listaPassos;
	}

	public void setListaPassos(Passo listaPassos) {
		this.listaPassos = listaPassos;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isConcluido() {
		return concluido;
	}

	public void setConcluido(boolean concluido) {
		this.concluido = concluido;
	}

	public int getHorasGastas() {
		return horasGastas;
	}

	public void setHorasGastas(int horasGastas) {
		this.horasGastas = horasGastas;
	}

	public int getHorasPrevistas() {
		return horasPrevistas;
	}
	
	public void setHorasPrevistas(int horasPrevistas) {
		this.horasPrevistas = horasPrevistas;
	}

}