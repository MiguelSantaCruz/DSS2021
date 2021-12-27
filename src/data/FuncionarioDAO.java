package data;


import java.io.*;
import java.util.ArrayList;


import business.CentroReparacoesLN.GestUtilizadores.Funcionario;

/**
 * Versão dummy de um DAO para Turmas
 *
 * Falta implementar persisTência.
 *
 * @author JFC
 * @version 20211002
 */
public class FuncionarioDAO  {

    // Queremos controlar nós a criação dos objectos
    private FuncionarioDAO() {}

    public static ArrayList<Funcionario> getInstance() {
        ArrayList<Funcionario> lista = new ArrayList();
     try {
       File arq = new File("funcionario");
       if (arq.exists()) {
          ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(arq));
          lista = (ArrayList<Funcionario>)objInput.readObject();
          objInput.close();
       }
     } catch(IOException erro1) {
         System.out.printf("Erro: %s", erro1.getMessage());
     } catch(ClassNotFoundException erro2) {
         System.out.printf("Erro: %s", erro2.getMessage());
     }

     return(lista);
   }
   
   public static void gravarArquivoBinario(ArrayList<Funcionario> lista) {
       File arq = new File("funcionario");
       try {
         arq.delete();
         arq.createNewFile();
 
         ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(arq));
         objOutput.writeObject(lista);
         objOutput.close();
 
       } catch(IOException erro) {
           System.out.printf("Erro: %s", erro.getMessage());
       }
     }


}