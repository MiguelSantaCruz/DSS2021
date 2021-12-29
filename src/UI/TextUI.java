package UI;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Scanner;

import business.CentroReparacoesLN.IGestEquipamento;
import business.CentroReparacoesLN.IGestReparacao;
import business.CentroReparacoesLN.IGestUtilizadores;
import business.CentroReparacoesLN.GestEquipamentos.Cliente;
import business.CentroReparacoesLN.GestEquipamentos.Equipamento;
import business.CentroReparacoesLN.GestEquipamentos.FichaEquipamento;
import business.CentroReparacoesLN.GestEquipamentos.GestEquipamentoFacade;
import business.CentroReparacoesLN.GestEquipamentos.Orcamento;
import business.CentroReparacoesLN.GestReparacao.GestReparacaoFacade;
import business.CentroReparacoesLN.GestReparacao.Peca;
import business.CentroReparacoesLN.GestReparacao.Reparacao;
import business.CentroReparacoesLN.GestReparacao.ServicoExpresso;
import business.CentroReparacoesLN.GestUtilizadores.Funcionario;
import business.CentroReparacoesLN.GestUtilizadores.GestUtilizadores;
import business.CentroReparacoesLN.GestUtilizadores.Gestor;
import business.CentroReparacoesLN.GestUtilizadores.Tecnico;

/**
 * Interface em modo texto.
 *
 * @author JFC
 * @version 20210930
 */
public class TextUI implements Serializable{
    
    public enum TiposFuncionarios{
        TECNICO, FUNCIONARIO, GESTOR
    }

    public IGestEquipamento gestEquipamentos = new GestEquipamentoFacade();
    public IGestReparacao gestReparacoes = new GestReparacaoFacade();
    public IGestUtilizadores gestUtilizadores = new GestUtilizadores();
    public Tecnico tecnicoAutenticado;
    public Gestor gestorAutenticado;
    public Funcionario funcionarioAutenticado;
    public Reparacao reparacaoAtual;
    public Orcamento orcamentoAtual;
    public ServicoExpresso servicoExpressoAtual;

    //Scanner para leitura
    private transient Scanner scin;

    /**
    * Construtor.
    *
    * Cria os menus e a camada de negócio.
    */
    public TextUI() {
        scin = new Scanner(System.in);
    }

    /**
     * Executa o menu principal e invoca o método correspondente à opção seleccionada.
    */
    public void run() {
        String id = this.gestUtilizadores.adicionarGestor("Admin","12345");
        System.out.println("O identificador do gestor: " + id);
        System.out.println("Palavra chave do gestor: 12345");
        System.out.println("Centro de Reparações");
        this.menuPrincipal();
        System.out.println("Até breve...");
    }

    //Métodos auxiliares 

    private void menuPrincipal() {
        Menu menu = new Menu(new String[]{
                "Autenticar Técnico",
                "Autenticar Funcionário",
                "Autenticar Gestor",
                "Consultar Lista de Técnicos",
                "Consultar Lista de Funcionários",
                "Consultar Lista de Gestores",
                "Guardar estado",
                "Ler estado"
        });

        //Registar pré-condições das transições
        menu.setPreCondition(1, ()->this.gestUtilizadores.existemTecnicos());
        menu.setPreCondition(2, ()->this.gestUtilizadores.existemFuncionarios());
        menu.setPreCondition(4, ()->this.gestUtilizadores.existemTecnicos());
        menu.setPreCondition(5, ()->this.gestUtilizadores.existemFuncionarios());

        //Registar os handlers das transições
        menu.setHandler(1,() -> autenticaFuncionarios(TiposFuncionarios.TECNICO));
        menu.setHandler(2,() -> autenticaFuncionarios(TiposFuncionarios.FUNCIONARIO));
        menu.setHandler(3,() -> autenticaFuncionarios(TiposFuncionarios.GESTOR));
        menu.setHandler(4,() -> consultarListaTecnicos());
        menu.setHandler(5,() -> consultarListaFuncionarios());
        menu.setHandler(6,() -> consultarListaGestores());
        menu.setHandler(7,() -> {
            try {
                guardaBin(this);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        menu.setHandler(8,() -> {
            try {
                readBin();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        });

        //Executar o menu
        menu.run();
    }

    private void autenticaFuncionarios(TiposFuncionarios funcionario){
        System.out.println("Insira o seu identificador:");
        System.out.print("> ");
        String id = this.scin.nextLine();
        System.out.println("Insira a sua palavra chave:");
        System.out.print("> ");
        String password = this.scin.nextLine();
        switch (funcionario) {
            case FUNCIONARIO:
                if(this.gestUtilizadores.autenticaFuncionario(id, password)){
                    System.out.println("--------- Bem vindo " + this.gestUtilizadores.getFuncionarioById(id).getNome()+ "----------");
                    this.funcionarioAutenticado = this.gestUtilizadores.getFuncionarioById(id);
                    menuFuncionario();
                }
                else {
                    System.out.println("Palavra passe incorreta ou funcionário não existente");
                }
                break;
            case TECNICO:
                if(this.gestUtilizadores.autenticaTecnico(id, password)){
                    System.out.println("--------- Bem vindo " + this.gestUtilizadores.getTecnicoById(id).getNome()+ "----------");
                    this.tecnicoAutenticado = this.gestUtilizadores.getTecnicoById(id);
                    menuTecnico();
                }else{
                    System.out.println("Palavra passe incorreta ou técnico não existente");
                }
                break;
            case GESTOR:
                if(this.gestUtilizadores.autenticaGestor(id, password)){
                    System.out.println("--------- Bem vindo " + this.gestUtilizadores.getGestorById(id).getNome() + "----------");
                    this.gestorAutenticado = this.gestUtilizadores.getGestorById(id);
                    menuGestor(); 
                }else{
                    System.out.println("Palavra passe incorreta ou gestor não existente");
                }
                break;
            default:
                break;
        }
    }

    private void menuFuncionario() {
        Menu menu = new Menu(new String[]{
                "Registar Recebimento",
                "Registar Levantamento",
                "Registar Pagamento",
                "Registar Serviço Expresso",
                "Contactar Cliente por SMS",
                "Contactar Cliente por email",
                "Confirmar orçamento",
                "Procurar Equipamento",
                "Procurar Ficha de Equipamento",
                "Procurar Cliente",
                "Procurar Orçamento",
                "Ver Listagens"
        });
        menu.setTitulo("Funcionário - Área autenticada");
        menu.setHandler(1, () -> registarRecebimento());
        menu.setHandler(2, () -> registarLevantamento());
        menu.setHandler(3, () -> registarPagamento());
        menu.setHandler(4, () -> registarServico());
        menu.setHandler(5, () -> contactarClienteSMS());
        menu.setHandler(6, () -> contactarClienteEmail());
        menu.setHandler(7, () -> confirmarOrcamento());
        menu.setHandler(8, () -> procurarEquipamentoPorId());
        menu.setHandler(9, () -> procurarFichaEquipamentoPorId());
        menu.setHandler(10, () -> procurarClientePorId());
        menu.setHandler(11, () -> procurarOrcamentoPorId());
        menu.setHandler(12, () -> menuListagens());
        menu.run();
    }

    public void registarLevantamento(){
        System.out.println("Insira o ID do equipamento:");
        System.out.print("> ");
        String id= scin.nextLine();
        if(!this.gestEquipamentos.equipamentoExiste(id)){
            System.out.println("Equipamento inexistente");
            return;
        }
        this.funcionarioAutenticado.registarLevantamento(id, this.gestEquipamentos);
    }

    public void registarRecebimento(){
        System.out.println("Insira o NIF do cliente:");
        System.out.print("> ");
        String nif = scin.nextLine();
        System.out.println("Insira o nome do cliente:");
        System.out.print("> ");
        String nome = scin.nextLine();
        System.out.println("Insira o nº telemóvel do cliente:");
        System.out.print("> ");
        String tlmv = scin.nextLine();
        System.out.println("Insira o email do cliente:");
        System.out.print("> ");
        String email = scin.nextLine();
        this.gestEquipamentos.adicionarCliente(nome, nif, tlmv, email);
        System.out.println("Insira o nome do equipamento:");
        System.out.print("> ");
        String nomeEquip= scin.nextLine();
        System.out.println("Insira a descrição do equipamento:");
        System.out.print("> ");
        String descricaoEquip = scin.nextLine();
        System.out.println("Insira o nome da ficha do equipamento:");
        System.out.print("> ");
        String nomeFicha = scin.nextLine();
        System.out.println("Insira a descrição da ficha do equipamento:");
        System.out.print("> ");
        String descricaoFicha = scin.nextLine();
        FichaEquipamento fichaEquipamento = this.gestEquipamentos.registarEquipamento(nif, nomeEquip, descricaoEquip, nomeFicha, descricaoFicha);
        this.funcionarioAutenticado.adicionaFichaEquipamentoRecebida(fichaEquipamento.getIdFicha());
    }

    public void registarPagamento(){
        System.out.println("Insira o ID da ficha do equipamento:");
        System.out.print("> ");
        String id = scin.nextLine();
        System.out.println("Insira o valor pago:");
        System.out.print("> ");
        float valor = Float.valueOf(scin.nextLine());
        this.funcionarioAutenticado.registarPagamento(id, valor, this.gestEquipamentos);
    }

    public void registarServico(){
        System.out.println("Insira uma descrição do serviço:");
        System.out.print("> ");
        String descricao = scin.nextLine();
        this.funcionarioAutenticado.registarServicoExpresso(descricao, gestReparacoes);
    }

    public void contactarClienteSMS(){
        System.out.println("Insira o NIF do cliente a contactar:");
        System.out.print("> ");
        String nif = scin.nextLine();
        if(!this.gestEquipamentos.clienteExiste(nif)){
            System.out.println("Cliente não existe");
            return;
        }
        System.out.println("Insira uma mensagem:");
        System.out.print("> ");
        String mensagem = scin.nextLine();
        this.funcionarioAutenticado.contactarClienteSMS(mensagem, nif, this.gestEquipamentos);
    }

    public void contactarClienteEmail(){
        System.out.println("Insira o NIF do cliente a contactar:");
        System.out.print("> ");
        String nif = scin.nextLine();
        if(!this.gestEquipamentos.clienteExiste(nif)){
            System.out.println("Cliente não existe");
            return;
        }
        System.out.println("Insira uma mensagem:");
        System.out.print("> ");
        String mensagem = scin.nextLine();
        this.funcionarioAutenticado.contactarClienteEmail(mensagem, nif, this.gestEquipamentos);
    }

    public void confirmarOrcamento(){
        System.out.println("Insira o ID do orçamento:");
        System.out.print("> ");
        String id = scin.nextLine();
        if(!this.gestEquipamentos.orcamentoExiste(id)){
            System.out.println("Orçamento não existe");
            return;
        }
        System.out.println("Insira a descrição da reparação do equipamento:");
        System.out.print("> ");
        String descricaoRep = scin.nextLine();
        this.gestReparacoes.adicionaReparacoes(descricaoRep);
        this.funcionarioAutenticado.confirmaOrcamento(id, this.gestEquipamentos);
    }


    private void menuTecnico() {
        Menu menu = new Menu(new String[]{
                "Operacoes sobre reparacões",
                "Operações sobre orçamentos",
                "Operações sobre serviços expressos",
                "Ver reparação mais urgente",
                "Consultar listagens",
        });

        menu.setHandler(1, ()-> operacoesSobreReparacoes());
        menu.setHandler(2, ()-> operacoesSobreOrcamento());
        menu.setHandler(3, ()-> operacoesSobreServicos());
        menu.setHandler(4, ()-> VerReparacaoUrgente());
        menu.setHandler(5, ()-> menuListagens());
        menu.setTitulo("Técnico - Área autenticada");   
        menu.run();
    }

    private void operacoesSobreReparacoes(){
        System.out.println("Insira o ID da reparação");
        System.out.print("> ");
        String id = scin.nextLine();
        if(!this.gestReparacoes.existeReparacao(id)) {
            System.out.println("Reparação não existente");
            return;
        }
        this.reparacaoAtual = this.gestReparacoes.getReparacao(id);
        menuReparacao();
    }

    private void operacoesSobreOrcamento(){
        System.out.println("Insira o ID do orçamento: ");
        System.out.print("> ");
        String id = scin.nextLine();
        if(!this.gestEquipamentos.equipamentoExiste(id)) {
            System.out.println("Orçamento não existente");
            return;
        }
        this.orcamentoAtual = this.gestEquipamentos.getOrcamento(id);
        menuOrcamento();
    }

    private void operacoesSobreServicos(){
        System.out.println("Insira o ID do serviço expresso: ");
        System.out.print("> ");
        String id = scin.nextLine();
        if(!this.gestReparacoes.existeServico(id)) {
            System.out.println("Serviço expresso não existente");
            return;
        }
        this.servicoExpressoAtual = this.gestReparacoes.getServicoExpresso(id);
        menuServico();
    }
    
    private void menuReparacao(){
        System.out.println("Reparação atual:");
        this.gestReparacoes.reparacaoToString(this.reparacaoAtual);
        Menu menu = new Menu(new String[]{                        
        "Adicionar peça à reparação",
        "Adicionar horas previstas à reparação",
        "Adicionar horas gastas à reparação",
        "Adicionar passos à reparação",
        "Adicionar subpassos à reparação",
        "Adicionar horas gastas aos passos",
        "Executar Reparação",
        "Executar Passo",

        });
        menu.setTitulo("Operações sobre reparações - Área autenticada");  
        menu.setHandler(1, () -> adicionarPeca());
        menu.setHandler(2, () -> adicionarHorasPrevistas());
        menu.setHandler(3, () -> adicionarHorasGastas());
        menu.setHandler(4, () -> adicionarPassos());
        menu.setHandler(5, () -> adicionaSubpassos());
        menu.setHandler(6, () -> adicionaHorasGastasPassos());
        menu.setHandler(7, () -> executaReparacao());
        menu.setHandler(8, () -> executaPasso());
        menu.run();
        
    }

     /**
     * 
     *  
     * 
     */
    public void adicionarPeca(){
        System.out.println("Insira o nome da peça:");
        System.out.print("> ");
        String nome = scin.nextLine();
        System.out.println("Insira o valor da peça:");
        System.out.print("> ");
        Float valor = Float.valueOf(scin.nextLine());
        System.out.println("Insira uma descrição:");
        System.out.print("> ");
        String descricao = scin.nextLine();
        Peca peca = this.gestReparacoes.criarPeca(nome, valor, descricao);
        this.gestReparacoes.adicionarPecaReparacao(this.reparacaoAtual.getIdReparacao(), peca);
    }

    public void adicionarHorasPrevistas(){
        System.out.println("Insira as horas necessesárias: ");
        System.out.print("> ");
        int horas = Integer.valueOf(scin.nextLine());
        this.gestReparacoes.getReparacao(this.reparacaoAtual.getIdReparacao()).setHorasPrevistas(horas);
    }

    public void adicionarHorasGastas(){   
        System.out.println("Insira o número de horas gastas: ");
        System.out.print("> ");
        int horasGastas = Integer.valueOf(scin.nextLine());
        this.gestReparacoes.getReparacao(this.reparacaoAtual.getIdReparacao()).setHorasGastas(horasGastas);
    }

    public void adicionarPassos(){
        System.out.println("Insira a Descrição do Passo: ");
        System.out.print("> ");
        String descricao = scin.nextLine();
        System.out.println("Insira as horas previstas: ");
        System.out.print("> ");
        int horasPrevistas = Integer.valueOf(scin.nextLine());
        this.gestReparacoes.getReparacao(this.reparacaoAtual.getIdReparacao()).adicionaPasso(descricao, horasPrevistas);
    }

    public void adicionaSubpassos(){
        System.out.println("Insira o ID do Passo:");
        System.out.print("> ");
        String id = scin.nextLine();
        if(this.gestReparacoes.getReparacao(this.reparacaoAtual.getIdReparacao()).existePassoOrSubpasso(id)){
            System.out.println("Passo inexistente");
            return;
        }
        System.out.println("Insira a Descrição do Passo: ");
        System.out.print("> ");
        String descricao = scin.nextLine();
        System.out.println("Insira as horas previstas: ");
        System.out.print("> ");
        int horasPrevistas = Integer.valueOf(scin.nextLine());
        this.gestReparacoes.getReparacao(this.reparacaoAtual.getIdReparacao()).adicionaSubPasso(id, descricao, horasPrevistas);
    }

    public void adicionaHorasGastasPassos(){
        System.out.println("Insira o ID do Passo:");
        System.out.print("> ");
        String idPasso= scin.nextLine();
        System.out.println("Insira as horas Gastas: ");
        System.out.print("> ");
        int horasGastas = Integer.valueOf(scin.nextLine());
        if(this.gestReparacoes.getReparacao(this.reparacaoAtual.getIdReparacao()).getPassoOrSubpassoByID(idPasso) == null) System.out.println("Passo inexistente");
        else this.gestReparacoes.getReparacao(this.reparacaoAtual.getIdReparacao()).getPassoOrSubpassoByID(idPasso).setHorasGastas(horasGastas);
    }

    public void executaReparacao(){
        this.gestReparacoes.getReparacao(this.reparacaoAtual.getIdReparacao()).setConcluido(true);
    }

    public void executaPasso(){
        System.out.println("Insira o ID do Passo:");
        System.out.print("> ");
        String idPasso= scin.nextLine();
        if(this.gestReparacoes.getReparacao(this.reparacaoAtual.getIdReparacao()).getPassoOrSubpassoByID(idPasso) == null) System.out.println("Passo inexistente");
        else this.gestReparacoes.getReparacao(this.reparacaoAtual.getIdReparacao()).getPassoOrSubpassoByID(idPasso).setConcluido(true);
    }

    public void VerReparacaoUrgente(){
        System.out.println(this.gestReparacoes.getReparacaoMaisAntiga().toString());

    }
    

    private void menuOrcamento(){
        Menu menu = new Menu(new String[]{                        
        "Criar pedido de orçamento",
        "Ver pedido de orçamento mais antigo",
        });
        menu.setTitulo(" Menu orçamento - Área autenticada");

    }

    private void menuServico(){
        Menu menu = new Menu(new String[]{                        
            "Executar Serviço",
        });
        menu.setTitulo(" Menu serviços expressos - Área autenticada");
        menu.setHandler(1, ()->executaServico());
        menu.run();
    }
    
    public void executaServico(){
        this.gestReparacoes.getServicoExpresso(this.servicoExpressoAtual.getIdServico()).setConcluido(true);
    }

    private void menuListagens(){
        Menu menu = new Menu(new String[]{ 
        "Ver lista de todos os equipamentos",
        "Ver lista de todas as fichas de equipamentos",
        "Ver lista de todas as pecas",
        "Ver lista de todos os orcamentos",                
        "Ver lista de todas as reparações",
        "Ver lista de todos os serviços expressos",
        });
        menu.setTitulo("Menu Equipamentos - Área autenticada");
        menu.setHandler(1, () -> listarEquipamentos());
        menu.setHandler(2, () -> listarFichasEquipamentos());
        menu.setHandler(3, () -> listarPecas());
        menu.setHandler(4, () -> listarOrcamentos());
        menu.setHandler(5, () -> listarReparacoes());
        menu.setHandler(6, () -> listarServicos());
        menu.run();
    }

     
    public void listarEquipamentos(){
        
        for(Map.Entry<String, Equipamento> entry : this.gestEquipamentos.getEquipamentos().entrySet()) {
			String idEquipamento = entry.getKey();
            String descricao = entry.getValue().getDescricao();
            String nome = entry.getValue().getNome();
            System.out.println("ID: "+idEquipamento + "\n" + " Descrição: " +descricao + "\n" + " Nome: " +nome);
		}
    }

    public void listarFichasEquipamentos(){
        
        for(Map.Entry<String,FichaEquipamento> entry : this.gestEquipamentos.getFichaEquipamentos().entrySet()) {
			String idFicha = entry.getKey();
            String descricaoFicha = entry.getValue().getDescricao();
            String nome = entry.getValue().getNome();
            float valorOrcamento = entry.getValue().getOrcamento().getValor();
            String idOrcamento = entry.getValue().getOrcamento().getIdOrcamento();
            String idEquipamento = entry.getValue().getEquipamento().getId();
            String nomeEquipamento = entry.getValue().getEquipamento().getNome();
            String idReparação = entry.getValue().getReparacao().getIdReparacao();
            LocalDateTime date = entry.getValue().getDate();
	        String idCliente = entry.getValue().getIdCliente();
	        float valorPago = entry.getValue().getValorPago();
            System.out.println("---------------------------------------------------------");
            System.out.println("ID: "+idFicha+ "\n" +
                               " Descrição: " +descricaoFicha + "\n" +
                               " Nome: " +nome + "\n" +
                               " Valor do Orçamento: " +valorOrcamento + "\n" +
                               " ID do Orçamento: " +idOrcamento + "\n" +
                               " ID do Equipamento: " +idEquipamento + "\n" +
                               " Nome do Equipamento: " +nomeEquipamento + "\n" +
                               " ID da Reparação: " +idReparação + "\n" +
                               " Data: " + date + "\n" +
                               " ID do Cliente: " +idCliente + "\n" +
                               " Valor: " +valorPago + "\n" 
                               );                 
		}
    }

    public void listarPecas(){
        for(Map.Entry<String,Peca> entry : this.gestReparacoes.getAllPecas().entrySet()){
			String id = entry.getKey();
            String descricao = entry.getValue().getDescricao();
            String nome = entry.getValue().getNome();
            float valor = Float.valueOf(entry.getValue().getValor());
            System.out.println("----------------------------------------");
            System.out.println("ID: "+id +" Descrição: " +descricao +" Nome: " +nome +" Valor: " +valor);
		}
    }

    public void listarOrcamentos(){
        for(Map.Entry<String,Orcamento> entry : this.gestEquipamentos.getAllOrcamentos().entrySet()){
			String id = entry.getKey();
            LocalDateTime date = entry.getValue().getDate();
            String descricao = entry.getValue().getDescricao();
            float valor = Float.valueOf(entry.getValue().getValor());
            System.out.println("--------------------------------------");
            System.out.println("ID: "+id +"\n"
                                + "Data: " + date.toString() + "\n"
                                + "Descrição: " + descricao + "\n" 
                                + "Valor: " +valor);
		}
    }

    public void listarReparacoes(){
        for(Map.Entry<String,Reparacao> entry : this.gestReparacoes.getAllReparacoes().entrySet()){
			String id = entry.getKey();
            LocalDateTime date = entry.getValue().getDate();
            String descricao = entry.getValue().getDescricao();
            int horasGastas = Integer.valueOf(entry.getValue().getHorasGastas());
            int horasPrevistas = Integer.valueOf(entry.getValue().getHorasPrevistas());

            System.out.println("--------------------------------------");
            System.out.println("ID: "+id +"\n"
                                + "Data: " + date.toString() + "\n"
                                + "Descrição: " + descricao + "\n" 
                                + "Horas gastas: " + horasGastas + "\n"
                                + "Horas previstas: " + horasPrevistas + "\n"
                                + "Peças: " + entry.getValue().getPecas().toString() + "\n"
                                + "Subpassos: " + entry.getValue().getPasso().toString());
		}
    }

    public void listarServicos(){
        for(Map.Entry<String,ServicoExpresso> entry : this.gestReparacoes.getAllServicoExpresso().entrySet()){
			String id = entry.getKey();
            LocalDateTime date = entry.getValue().getDate();
            String descricao = entry.getValue().getDescricao();
            System.out.println("--------------------------------------");
            System.out.println("ID: "+id +"\n"
                                + "Data: " + date.toString() + "\n"
                                + "Descrição: " + descricao);
		}
    }

    private void menuGestor() {
        Menu menu = new Menu(new String[]{
                "Adicionar Técnico",
                "Adicionar Funcionário",
                "Adicionar Gestor",
                "Procurar Equipamento",
                "Procurar Ficha de Equipamento",
                "Procurar Peça",
                "Procurar Orçamento",
                "Procurar Reparação",
        });
        menu.setTitulo("Gestor - Área autenticada");
        menu.setHandler(1, () -> adicionarFuncionario(TiposFuncionarios.TECNICO));
        menu.setHandler(2, () -> adicionarFuncionario(TiposFuncionarios.FUNCIONARIO));
        menu.setHandler(3, () -> adicionarFuncionario(TiposFuncionarios.GESTOR));
        menu.setHandler(4, () -> procurarEquipamentoPorId());
        menu.setHandler(5, () -> procurarFichaEquipamentoPorId());
        menu.setHandler(6, () -> procurarPecaPorId());       
        menu.setHandler(7, () -> procurarOrcamentoPorId());
        menu.setHandler(8, () -> procurarReparacaoPorId());
        menu.run();
    }

    public void adicionarFuncionario(TiposFuncionarios funcionario){
        System.out.println("Insira o nome: ");
        System.out.print("> ");
        String nome = scin.nextLine();
        System.out.println("Insira a palavra passe: ");
        System.out.print("> ");
        String palavraPasse= scin.nextLine();
        String id = "";
        switch (funcionario) {
            case TECNICO:
                id = this.gestUtilizadores.adicionarTecnico(nome, palavraPasse);
                System.out.print("Adicionado técnico com id: ");
                break;
            case FUNCIONARIO:
                id = this.gestUtilizadores.adicionarFuncionario(nome, palavraPasse);
                System.out.print("Adicionado funcionário com id: ");
                break;
            case GESTOR:
                id = this.gestUtilizadores.adicionarGestor(nome, palavraPasse);
                System.out.print("Adicionado gestor com id: ");
                break;
            default:
                break;
        }
        System.out.println(id+"");
    }

    public void procurarOrcamentoPorId(){
        System.out.println("Insira identificador do orçamento:");
        System.out.print("> ");
        String id = scin.nextLine();
        if(this.gestEquipamentos.orcamentoExiste(id)){
            Orcamento orcamento = this.gestEquipamentos.getOrcamento(id);
            orcamento.toString();
        }else System.out.println("Orçamento não encontrado");
    }

    public void procurarFichaEquipamentoPorId(){
        System.out.println("Insira identificador da ficha de equipamento:");
        System.out.print("> ");
        String id = scin.nextLine();
        if(this.gestEquipamentos.fichaExiste(id)){
           FichaEquipamento fichaEquipamento = this.gestEquipamentos.getFichaEquipamento(id);
            fichaEquipamento.toString();
        }else System.out.println("ficha de equipamento não encontrada");
    }

    public void procurarEquipamentoPorId(){
        System.out.println("Insira identificador do equipamento:");
        System.out.print("> ");
        String id = scin.nextLine();
        if(this.gestEquipamentos.equipamentoExiste(id)){
            Equipamento equipamento = this.gestEquipamentos.getEquipamento(id);
            equipamento.toString();
        }else System.out.println("Equipamento não encontrada");
    }

    public void procurarPecaPorId(){
        System.out.println("Insira identificador da peça:");
        System.out.print("> ");
        String id = scin.nextLine();
        if(this.gestReparacoes.existePeca(id)){
            Peca pecas = this.gestReparacoes.getPecaById(id);
            pecas.toString();
        }else System.out.println("Peça não encontrada");
    }

    public void procurarReparacaoPorId(){
        System.out.println("Insira identificador da reparacao:");
        System.out.print("> ");
        String id = scin.nextLine();
        if(this.gestReparacoes.existeReparacao(id)){
            Reparacao reparacao = this.gestReparacoes.getReparacao(id);
            reparacao.toString();
        }else System.out.println("Reparação não encontrada");
    }

    public void procurarClientePorId(){
        System.out.println("Insira o NIF do cliente:");
        System.out.print("> ");
        String nif = scin.nextLine();
        if(this.gestEquipamentos.clienteExiste(nif)){
            Cliente cliente = this.gestEquipamentos.getClienteByNIF(nif);
            cliente.toString();
        }else System.out.println("Cliente não encontrado");
    }


    public void consultarListaFuncionarios(){
        System.out.println(" *** Lista de Funcionários registados ***");
        Map<String,String> detalhes = this.gestUtilizadores.getAllNamesAndIdsFuncionarios();
        for (Map.Entry<String,String> entry : detalhes.entrySet()) {
            System.out.println("Nome: " + entry.getValue() + " | ID: " + entry.getKey());
        }
    }

    public void consultarListaTecnicos(){
        System.out.println(" *** Lista de Técnicos registados ***");
        Map<String,String> detalhes = this.gestUtilizadores.getAllNamesAndIdsTecnicos();
        for (Map.Entry<String,String> entry : detalhes.entrySet()) {
            System.out.println("Nome: " + entry.getValue() + " | ID: " + entry.getKey());
        }
    }

    public void consultarListaGestores(){
        System.out.println(" *** Lista de Gestores registados ***");
        Map<String,String> detalhes = this.gestUtilizadores.getAllNamesAndIdsGestores();
        for (Map.Entry<String,String> entry : detalhes.entrySet()) {
            System.out.println("Nome: " + entry.getValue() + " | ID: " + entry.getKey());
        }
    }



    /**
     * Cria um pedido de orçamento
     */
    public void criarPedidoOrcamento(){
        System.out.println("Insira o identificador da ficha:");
        System.out.print("> ");
        String idFicha = scin.nextLine();
        System.out.println("Insira o valor estimado:");
        System.out.print("> ");
        Float valor = Float.valueOf(scin.nextLine());
        System.out.println("Insira uma descrição:");
        System.out.print("> ");
        String descricao = scin.nextLine();
        this.tecnicoAutenticado.criarPedidoOrcamento(idFicha, descricao, valor, this.gestEquipamentos);
    }


 

    public void guardaBin(TextUI model) throws FileNotFoundException, IOException {
        FileOutputStream bf = new FileOutputStream("estado");
        ObjectOutputStream oos = new ObjectOutputStream(bf);
        oos.writeObject(model);
        oos.flush();
        oos.close();
    }

    /**
     * Função que permite ler um ficheiro binário com um estado da aplicação 
     */
    public TextUI readBin() throws IOException, ClassNotFoundException{
        FileInputStream bf = new FileInputStream("estado");
        ObjectInputStream ois = new ObjectInputStream(bf);
        TextUI m = (TextUI) ois.readObject();
        ois.close();
        return m;
    }

}
