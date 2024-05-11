package rh;

import java.util.Scanner;

public class RHSystem {
    private static final Scanner scanner = new Scanner(System.in);
    static java.util.ArrayList<Funcionario> funcionarios = new java.util.ArrayList<>();

    // Método principal que controla a execução do sistema.
    public static void main(String[] args) {
        while (true) {
            menu();
            System.out.print("Digite o número da opção desejada: ");
            String escolha = scanner.nextLine();

            switch (escolha) {

                case "1":
                    MenuFuncionario.Employee();
                    break; 
                case "2":
                    RHSystemUtils.FolhaDePagamentos();
                    break;
                case "3":
                    MenuDemissão.MenuDE();
                    break; 
                case "4":
                    System.out.println("Saindo do sistema...");
                    System.exit(0); 
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                    break;  
            }
        }
    }

    // Método para exibir o menu de opções do sistema.
    public static void menu() {
        System.out.println("                                       ");
        System.out.println("█████████████████████████████████████████");
        System.out.println("█                                       █");
        System.out.println("█    !Sistema de Recursos Humanos!      █");
        System.out.println("█                                       █");
        System.out.println("█     1. Funcionarios                   █");
        System.out.println("█     2. Folha de pagamento             █");
        System.out.println("█     3. Demitir Funcionário            █");
        System.out.println("█     4. Sair do Sistema                █");
        System.out.println("█                                       █");
        System.out.println("█    !Sistema de Recursos Humanos!      █");
        System.out.println("█                                       █");
        System.out.println("█████████████████████████████████████████");
        System.out.println("                                       ");
    }
}
