package data;

import java.io.*;
import java.util.*;

import business.CentroReparacoesLN.GestUtilizadores.Gestor;

/**
 * Versão dummy de um DAO para Turmas
 *
 * Falta implementar persisTência.
 *
 * @author JFC
 * @version 20211002
 */
public class GestorDAO  {

    // Queremos controlar nós a criação dos objectos
    private GestorDAO() {}

    public static ArrayList<Gestor> getInstance() {
        ArrayList<Gestor> lista = new ArrayList();
     try {
       File arq = new File("gestor");
       if (arq.exists()) {
          ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(arq));
          lista = (ArrayList<Gestor>)objInput.readObject();
          objInput.close();
       }
     } catch(IOException erro1) {
         System.out.printf("Erro: %s", erro1.getMessage());
     } catch(ClassNotFoundException erro2) {
         System.out.printf("Erro: %s", erro2.getMessage());
     }

     return(lista);
   }
   
   public static void gravarArquivoBinario(ArrayList<Gestor> lista) {
       File arq = new File("gestor");
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