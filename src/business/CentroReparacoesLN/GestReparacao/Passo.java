package business.CentroReparacoesLN.GestReparacao;

import java.util.HashMap;
import java.util.Map;

public class Passo {

	private Map<String, Passo> subpassos = new HashMap<>();
	private String idPasso;
	private String descricao;
	private boolean concluido;
	private int horasGastas;
	private int horasPrevistas;

	/* Getters and Setters */

	public String getIdPasso() {
		return idPasso;
	}

	public void setIdPasso(String idPasso) {
		this.idPasso = idPasso;
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

	public void adicionaSubpasso(Passo passo){
		this.subpassos.put(passo.getIdPasso(),passo);
	}

	public void removeSubpasso(Passo passo){
		this.subpassos.remove(passo.getIdPasso());
	}

	public boolean existeSubpasso(String id){
		if(this.subpassos.containsKey(id)) return true;
		else return false;
	}

	public Passo getSubpasso(String id){
		if(!this.subpassos.containsKey(id)) return null;
		else return this.subpassos.get(id);
	}


}