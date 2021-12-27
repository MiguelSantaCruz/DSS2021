package data;

import business.CentroReparacoesLN.GestEquipamentos.Equipamento;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;

/**
 * Versão dummy de um DAO para Turmas
 *
 * Falta implementar persisTência.
 *
 * @author JFC
 * @version 20211002
 */
public class EquipamentoDAO  {

    // Queremos controlar nós a criação dos objectos
    private EquipamentoDAO() {}

    /**
     * Obter uma instância do Map de turmas. Escolhemos usar HashMap
     *
     * @return uma instância vazia do Map de turmas
     */
    public static ArrayList<Equipamento> getInstance() {
         ArrayList<Equipamento> lista = new ArrayList();
      try {
        File arq = new File("equi");
        if (arq.exists()) {
           ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(arq));
           lista = (ArrayList<Equipamento>)objInput.readObject();
           objInput.close();
        }
      } catch(IOException erro1) {
          System.out.printf("Erro: %s", erro1.getMessage());
      } catch(ClassNotFoundException erro2) {
          System.out.printf("Erro: %s", erro2.getMessage());
      }

      return(lista);
    }
    
    public static void gravarArquivoBinario(ArrayList<Equipamento> lista) {
        File arq = new File("equi");
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