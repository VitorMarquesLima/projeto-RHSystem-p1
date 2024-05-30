package rh; 
import java.util.Scanner;

public class MenuDemissão{
    public static void MenuDE() {
       
        System.out.println("                                         ");
        System.out.println("█████████████████████████████████████████");
        System.out.println("█                                       █");
        System.out.println("█             !Funcionarios!            █");
        System.out.println("█                                       █");
        System.out.println("█     1. Demitir                        █");
        System.out.println("█     2. Lista de demissões             █");
        System.out.println("█     3. readmitir funcionario          █");
        System.out.println("█     4. Lista de funcionarios          █");
        System.out.println("█     5. Voltar                         █");
        System.out.println("█                                       █");
        System.out.println("█             !Funcionarios!            █");
        System.out.println("█                                       █");
        System.out.println("█████████████████████████████████████████");
        System.out.println("                                        ");  

        String MenuDeDemissão = lerDados.lerTexto("Tente novamente");

        switch (MenuDeDemissão) {
            case "1":
            RHSystemUtils.demitirfuncionario();
            break;
            case "2":
            RHSystemUtils.listarDemitidos();
            break;
            case "3":
            RHSystemUtils.readmitirfuncionario();
            break;
            case "4":
            RHSystemUtils.listarFuncionarios();
            break;
            case "5":
            RHSystem.menu();
            break;
            default:
            System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            break;  
        }
    }

}