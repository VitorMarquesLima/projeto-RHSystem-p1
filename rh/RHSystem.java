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
                    RHSystemUtils.adicionarFuncionario();
                    break;
                case "2":
                    RHSystemUtils.listarFuncionarios();
                    break;
                case "3":
                    RHSystemUtils.solicitarFerias();
                    break;
                case "4":
                    RHSystemUtils.retornarAoTrabalho();
                    break;
                case "5":
                    RHSystemUtils.demitirFuncionario();
                    break;
                case "6":
                    RHSystemUtils.listarFuncionariosDemitidos();
                    break;
                case "7":
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
        System.out.println("█     1. Admitir Funcionário            █");
        System.out.println("█     2. Listar funcionários            █");
        System.out.println("█     3. Solicitar férias               █");
        System.out.println("█     4. Retornar ao trabalho           █");
        System.out.println("█     5. Demitir Funcionário            █");
        System.out.println("█     6. Listar funcionários demitidos  █");
        System.out.println("█     7. Sair do Sistema                █");
        System.out.println("█                                       █");
        System.out.println("█    !Sistema de Recursos Humanos!      █");
        System.out.println("█                                       █");
        System.out.println("█████████████████████████████████████████");
        System.out.println("                                       ");
    }
}
