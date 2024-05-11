package rh; 
import java.util.Scanner;

public class MenuDemissão{
    private static final Scanner scanner = new Scanner(System.in);
    public static void MenuDE() {
       
        System.out.println("                                         ");
        System.out.println("█████████████████████████████████████████");
        System.out.println("█                                       █");
        System.out.println("█             !Funcionarios!            █");
        System.out.println("█                                       █");
        System.out.println("█     1. Demitir                        █");
        System.out.println("█     2. Lista de demissões             █");
        System.out.println("█     3. Lista de funcionarios          █");
        System.out.println("█     4. Voltar                         █");
        System.out.println("█                                       █");
        System.out.println("█             !Funcionarios!            █");
        System.out.println("█                                       █");
        System.out.println("█████████████████████████████████████████");
        System.out.println("                                        ");  

        String MenuDeDemissão = scanner.nextLine();

        switch (MenuDeDemissão) {
            case "1":
            RHSystemUtils.demitirFuncionario();
            break;
            case "2":
            RHSystemUtils.listarFuncionariosDemitidos();
            break;
            case "3":
            RHSystemUtils.listarFuncionarios();
            break;
            case "4":
            RHSystem.menu();
            break;
            default:
            System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            break;  
        }
    }

}