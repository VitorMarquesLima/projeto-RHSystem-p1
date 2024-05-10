package rh;
import java.util.Scanner;


public class MenuFuncionario { 
    private static final Scanner scanner = new Scanner(System.in);

    public static void Employee() {
        System.out.println("                                         ");
        System.out.println("█████████████████████████████████████████");
        System.out.println("█                                       █");
        System.out.println("█             !Funcionarios!            █");
        System.out.println("█                                       █");
        System.out.println("█     1. Admitir Funcionário            █");
        System.out.println("█     2. Listar funcionários            █");
        System.out.println("█     3. Pedir ferias                   █");
        System.out.println("█     3. Voltar de ferias               █");
        System.out.println("█     4. Voltar                         █");
        System.out.println("█                                       █");
        System.out.println("█    !Sistema de Recursos Humanos!      █");
        System.out.println("█                                       █");
        System.out.println("█████████████████████████████████████████");
        System.out.println("                                       ");  

        
        String menuFuncionario  = scanner.nextLine();

        switch (menuFuncionario){
            case "1":
            RHSystemUtils.adicionarFuncionario();
            break;
            case "2":
            RHSystemUtils.listarFuncionarios();
            break;
            case "3":
            RHSystemUtils.solicitarFerias();
            case "4": 
            RHSystem.menu();
        }
    }
}
