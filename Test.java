import CentroReparacoesLN.GestEquipamentos.FichaEquipamento;

public class Test {
    public static void main(String[] args) {
        FichaEquipamento fichaEquipamento = new FichaEquipamento("12", "Ficha", "descricao", "1");
        System.out.println(fichaEquipamento.toString());
    }
    
}
