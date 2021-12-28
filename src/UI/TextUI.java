package UI;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import business.CentroReparacoesLN.IGestEquipamento;
import business.CentroReparacoesLN.IGestReparacao;
import business.CentroReparacoesLN.IGestUtilizadores;
import business.CentroReparacoesLN.GestEquipamentos.Equipamento;
import business.CentroReparacoesLN.GestEquipamentos.FichaEquipamento;
import business.CentroReparacoesLN.GestEquipamentos.GestEquipamentoFacade;
import business.CentroReparacoesLN.GestEquipamentos.Orcamento;
import business.CentroReparacoesLN.GestReparacao.GestReparacaoFacade;
import business.CentroReparacoesLN.GestReparacao.Pecas;
import business.CentroReparacoesLN.GestReparacao.Reparacao;
import business.CentroReparacoesLN.GestUtilizadores.GestUtilizadores;

/**
 * Interface em modo texto.
 *
 * @author JFC
 * @version 20210930
 */
public class TextUI {
    
    public enum TiposFuncionarios{
        TECNICO, FUNCIONARIO, GESTOR
    }

    public enum SearchableById{
        EQUIPAMENTO, FICHA_EQUIPAMENTO, PECA, ORCAMENTO, REPARACAO
    }
    public IGestEquipamento gestEquipamentos = new GestEquipamentoFacade();
    public IGestReparacao gestReparacoes = new GestReparacaoFacade();
    public IGestUtilizadores gestUtilizadores = new GestUtilizadores();

    //Scanner para leitura
    private Scanner scin;

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
        });

        //Registar pré-condições das transições
        menu.setPreCondition(1, ()->this.gestUtilizadores.existemTecnicos());
        menu.setPreCondition(2, ()->this.gestUtilizadores.existemFuncionarios());

        //Registar os handlers das transições
        menu.setHandler(1,() -> autenticaFuncionarios(TiposFuncionarios.TECNICO));
        menu.setHandler(2,() -> autenticaFuncionarios(TiposFuncionarios.FUNCIONARIO));
        menu.setHandler(3,() -> autenticaFuncionarios(TiposFuncionarios.GESTOR));

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
                    menuFuncionario();
                }
                else {
                    System.out.println("Palavra passe incorreta ou funcionário não existente");
                }
                break;
            case TECNICO:
                if(this.gestUtilizadores.autenticaTecnico(id, password)){
                    System.out.println("--------- Bem vindo " + this.gestUtilizadores.getTecnicoById(id).getNome()+ "----------");
                    menuTecnico();
                }else{
                    System.out.println("Palavra passe incorreta ou técnico não existente");
                }
                break;
            case GESTOR:
                if(this.gestUtilizadores.autenticaGestor(id, password)){
                    System.out.println("--------- Bem vindo " + this.gestUtilizadores.getGestorById(id).getNome() + "----------");
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
                "Procurar Equipamento",
                "Procurar Ficha de Equipamento",
                "Procurar Cliente",
                "Procurar Orçamento",
        });
        menu.setTitulo("Funcionário - Área autenticada");
        menu.run();
    }

    private void menuTecnico() {
        Menu menu = new Menu(new String[]{
                "Procurar Equipamento",
                "Procurar Ficha de Equipamento",
                "Procurar Peça",
                "Procurar Orçamento",
                "Procurar Reparação",
        });
        menu.setTitulo("Técnico - Área autenticada");
        menu.run();
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
            Pecas pecas = this.gestReparacoes.getPecaById(id);
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
