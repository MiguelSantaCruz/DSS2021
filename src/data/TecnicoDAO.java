package data;

import java.io.*;
import java.util.*;
import business.CentroReparacoesLN.GestUtilizadores.Tecnico;

/**
 * Versão dummy de um DAO para Turmas
 *
 * Falta implementar persisTência.
 *
 * @author JFC
 * @version 20211002
 */
public class TecnicoDAO  {

    // Queremos controlar nós a criação dos objectos
    private TecnicoDAO() {}

    public static ArrayList<Tecnico> getInstance() {
        ArrayList<Tecnico> lista = new ArrayList();
     try {
       File arq = new File("tecnicos");
       if (arq.exists()) {
          ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(arq));
          lista = (ArrayList<Tecnico>)objInput.readObject();
          objInput.close();
       }
     } catch(IOException erro1) {
         System.out.printf("Erro: %s", erro1.getMessage());
     } catch(ClassNotFoundException erro2) {
         System.out.printf("Erro: %s", erro2.getMessage());
     }

     return(lista);
   }
   
   public static void gravarArquivoBinario(ArrayList<Object> lista) {
       File arq = new File("tecnicos");
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