package business.CentroReparacoesLN.GestUtilizadores;

import java.util.HashMap;
import java.util.Map;

import business.CentroReparacoesLN.IGestReparacao;
import business.CentroReparacoesLN.IGestUtilizadores;
import business.CentroReparacoesLN.GestReparacao.GestReparacaoFacade;
import business.CentroReparacoesLN.GestReparacao.Reparacao;
import business.CentroReparacoesLN.GestReparacao.ServicoExpresso;

public class GestUtilizadores implements IGestUtilizadores{

	private Map<String,Gestor> gestores;
	private Map<String,Tecnico> tecnicos;
	private Map<String,Funcionario> funcionarios;

	/**
	 * Construtor vazio de GestUtilizadores
	 */
	public GestUtilizadores(){
		this.gestores = new HashMap<>();
		this.funcionarios = new HashMap<>();
		this.tecnicos = new HashMap<>();
	}

	/**
	 * Adiciona ao Map de técnicos o técnico em questão
	 * @param tecnico - O técnico a adicionar
	 */
	public void adicionarTecnico(Tecnico tecnico) {
		this.tecnicos.put(tecnico.getId(), tecnico);
	}

	/**
	 * Adiciona ao Map de funcionários o funcionário em questão
	 * @param funcionario - O funcionário a adicionar
	 */
	public void adicionarFuncionario(Funcionario funcionario) {
		this.funcionarios.put(funcionario.getId(), funcionario);
	}

	/**
	 * Adiciona ao Map de gestores o gestor em questão
	 * @param gestor - O gestor a adicionar
	 */
	public void adicionarGestor(Gestor gestor) {
		this.gestores.put(gestor.getId(), gestor);
	}

	/**
	 * Remove ao Map de técnicos o técnico em questão
	 * @param id - O identificador do técnico a remover
	 */
	public void removerTecnico(String id) {
		this.tecnicos.remove(id);
	}

	/**
	 * Remove ao Map de funcionários o funcionário em questão
	 * @param id - O identificador do funcionário a remover
	 */
	public void removerFuncionario(String id) {
		this.funcionarios.remove(id);
	}

	/**
	 * Remove ao Map de gestores o gestor em questão
	 * @param id - O identificador do gestor a remover
	 */
	public void removerGestor(String id) {
		this.gestores.remove(id);
	}


	/**
	 * Verifica se a palavra passe fornecida corresponde á palavra passe do técnico com o identificador especificado
	 * @param id - O identificador do técnico
	 * @param password - Palavra passe a verificar
	 * @return {@code true} se a password recebida como argumento estiver correta, {@code false} caso contrário
	 */
	public boolean autenticaTecnico(String id, String password) {
		boolean isCorrectPassword = false; 
		if (this.tecnicos.containsKey(id)) {
			Tecnico tecnico = this.tecnicos.get(id);
			if (tecnico.getPalavraPasse().equals(password))isCorrectPassword = true;
			else isCorrectPassword = false;
		}
		return isCorrectPassword;
	}

	/**
	 * Verifica se a palavra passe fornecida corresponde á palavra passe do funcionário com o identificador especificado
	 * @param id - O identificador do funcionário
	 * @param password - Palavra passe a verificar
	 * @return {@code true} se a password recebida como argumento estiver correta, {@code false} caso contrário
	 */
	public boolean autenticaFuncionario(String id, String password) {
		boolean isCorrectPassword = false; 
		if (this.funcionarios.containsKey(id)) {
			Funcionario funcionario = this.funcionarios.get(id);
			if (funcionario.getPalavraPasse().equals(password))isCorrectPassword = true;
			else isCorrectPassword = false;
		}
		return isCorrectPassword;
	}

	/**
	 * Verifica se a palavra passe fornecida corresponde á palavra passe do gestor com o identificador especificado
	 * @param id - Identificador do gestor
	 * @param password - Palavra passe a verificar
	 * @return {@code true} se a password recebida como argumento estiver correta, {@code false} caso contrário
	 */
	public boolean autenticaGestor(String id, String password) {
		boolean isCorrectPassword = false; 
		if (this.gestores.containsKey(id)) {
			Gestor gestor = this.gestores.get(id);
			if (gestor.getPalavraPasse().equals(password))isCorrectPassword = true;
			else isCorrectPassword = false;
		}
		return isCorrectPassword;
	}

	/**
	 * Dado um identificador de um técnico devolve o técnico associado
	 * @return O técnico cujo identificador é igual ao fornecido ou {@code null} caso não exista
	 * @param id - Identificador do técnico
	 */
	public Tecnico getTecnicoById(String id) {
		if(this.tecnicos.containsKey(id)) return this.tecnicos.get(id);
		else return null;
	}

	/**
	 * Dado um identificador de um funcionario devolve o funcionario associado
	 * @return O funcionario cujo identificador é igual ao fornecido ou null caso não exista
	 * @param id - Identificador do funcionario
	 */
	public Funcionario getFuncionarioById(String id) {
		if(this.funcionarios.containsKey(id)) return this.funcionarios.get(id);
		else return null;
	}

	/**
	 * Dado um identificador de um gestor devolve o gestor associado
	 * @return O gestor cujo identificador é igual ao fornecido ou {@code null} caso não exista
	 * @param id - Identificador do gestor
	 */
	public Gestor getGestorById(String id) {
		if(this.gestores.containsKey(id)) return this.gestores.get(id);
		else return null;
	}

	/**
	 * Consultar uma listagem exaustiva, para cada técnico, de todas as intervenções (passos de reparação e reparações expresso) realizadas.
	 * @param idTecnico - Identificador do Técnico
	 */
	public void consultaDetalhesIntervencoesTecnico(String idTecnico,IGestReparacao gestReparacao){
		if(!this.tecnicos.containsKey(idTecnico)) return ;
		Tecnico tecnico = this.tecnicos.get(idTecnico);
		for (String idReparacao : tecnico.getListaIdsReparacao()) {
			Reparacao reparacao = gestReparacao.getReparacao(idReparacao);
			gestReparacao.reparacaoToString(reparacao);
		}
		for (String idServico : tecnico.getListaIdsServico()) {
			ServicoExpresso servicoExpresso = gestReparacao.getServicoExpresso(idServico);
			gestReparacao.servicoToString(servicoExpresso);
		}
	}

	/**
	 * Consultar uma listagem em que para cada técnico de reparações são indicadas estatíticas como por exemplo 
	 * o número de intervenções e horas gastas.
	 *
	 */
	public void consultaEstatisticasReparacoes(IGestReparacao gestReparacao) {
		int numeroReparacoes = 0;
		int horasGastas = 0;
		int horasPrevistas = 0;
		for(Map.Entry<String, Tecnico> entry : this.tecnicos.entrySet()) {
			Tecnico tecnico = entry.getValue();
			System.out.println("Técnico: " + tecnico.getNome() + " ID: " + tecnico.getId());
			numeroReparacoes = tecnico.getListaIdsReparacao().size();
			System.out.println("Número de reparações associadas: " + numeroReparacoes);
			for (String idReparacao : tecnico.getListaIdsReparacao()) {
				horasGastas = gestReparacao.calcularHorasGastasTotais(idReparacao);
				horasPrevistas = gestReparacao.calcularHorasPrevistasTotais(idReparacao);
				System.out.println("Horas gastas: " + horasGastas);
				System.out.println("Horas previstas: " + horasPrevistas);
			}
		}
		
	}

	/**
	 * 	Consultar uma listagem que indica, para cada funcionário de balcão, quantas recepções e entregas de equipamentos realizou.
	 * @param idFuncionario - O identificador do funcionário
	 */
	public void consultaListaEntregasFuncionario(String idFuncionario) {
		if(!this.funcionarios.containsKey(idFuncionario)) return ;
		Funcionario funcionario = this.funcionarios.get(idFuncionario);
		int equipamentosRecebidos = funcionario.getListaEquipamentosRecebidos().size();
		int equipamentosLevantados = funcionario.getListaEquipamentosLevantados().size();
		System.out.println("Equipamentos recebidos: " + equipamentosRecebidos);
		System.out.println("Equipamentos levantados: " + equipamentosLevantados);
	}


}