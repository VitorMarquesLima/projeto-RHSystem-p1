import java.util.ArrayList; //importar a lista
import java.util.Scanner;

class Funcionario {
    String nome;
    String cargo;
    double salario;

    Funcionario(String nome, String cargo, double salario) {
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
    }
}

public class RHSystem {
    static ArrayList<Funcionario> funcionarios = new ArrayList<>();

    public static void adicionarFuncionario() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome do funcionário: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o cargo do funcionário: ");
        String cargo = scanner.nextLine();
        System.out.print("Digite o salário do funcionário: ");
        double salario = scanner.nextDouble();

        scanner.close();

        funcionarios.add(new Funcionario(nome, cargo, salario));
        System.out.println("Funcionário adicionado com sucesso.");
    }

    public static void listarFuncionarios() {
        if (funcionarios.isEmpty()) {
            System.out.println("Não há funcionários cadastrados.");
        } else {
            System.out.println("Lista de funcionários:");
            for (int i = 0; i < funcionarios.size(); i++) {
                Funcionario funcionario = funcionarios.get(i);
                System.out.println((i + 1) + ". Nome: " + funcionario.nome + ", Cargo: " + funcionario.cargo + ", Salário: R$" + funcionario.salario);
            }
        }
    }

    public static void menu() {
        System.out.println("\n### Sistema de Recursos Humanos ###");
        System.out.println("1. Adicionar funcionário");
        System.out.println("2. Listar funcionários");
        System.out.println("3. Sair do sistema");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            menu();
            System.out.print("Digite o número da opção desejada: ");
            String escolha = scanner.nextLine();

            switch (escolha) {
                case "1":
                    adicionarFuncionario();
                    break;
                case "2":
                    listarFuncionarios();
                    break;
                case "3":
                    System.out.println("Saindo do sistema...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                    break;
            }
            
        }
    
    }
}