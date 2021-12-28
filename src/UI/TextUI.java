package UI;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.Scanner;

/**
 * Exemplo de interface em modo texto.
 *
 * @author JFC
 * @version 20210930
 */
public class TextUI {

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
        System.out.println("Centro de Reparações");
        this.menuPrincipal();
        System.out.println("Até breve...");
    }

    //Métodos auxiliares - Estados da UI

    /**
     * Estado - Menu Principal
    *
    * Transições para:
    *      Operações sobre Alunos
    *      Operações sobre Turmas
    *      Adicionar Aluno a Turma
    *      Remover Aluno de Turma
    *      Listar Alunos de Turma
    */
    private void menuPrincipal() {
        Menu menu = new Menu(new String[]{
                "Autenticar Técnico",
                "Autenticar Funcionário",
                "Autenticar Gestor",
        });

        //Registar pré-condições das transições
        //Exemplo menu.setPreCondition(3, ()->this.model.haAlunos() && this.model.haTurmas());

        //Registar os handlers das transições
        //menu.setHandler(1, ()->gestaoDeAlunos());

        //Executar o menu
        menu.run();
    }

    private void menuProcuraFuncionario() {
        Menu menu = new Menu(new String[]{
                "Procurar Equipamento",
                "Procurar Ficha de Equipamento",
                "Procurar Cliente",
                "Procurar Orçamento",
        });
        menu.run();
    }

    private void menuProcuraTecnico() {
        Menu menu = new Menu(new String[]{
                "Procurar Equipamento",
                "Procurar Ficha de Equipamento",
                "Procurar Peça",
                "Procurar Orçamento",
                "Procurar Reparação",
        });
        menu.run();
    }

    public void autenticaTecnico(){

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
