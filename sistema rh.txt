import java.util.ArrayList;
import java.util.Scanner;

class Funcionario {
    String nome;
    String cargo;
    double salario;
    boolean emFerias;

    Funcionario(String nome, String cargo, double salario) {
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
        this.emFerias = false; // Inicialmente, o funcionário não está de férias
    }

    void solicitarFerias() {
        if (emFerias) {
            System.out.println("Este funcionário já está de férias.");
        } else {
            System.out.println("Férias solicitadas para o funcionário " + nome);
            emFerias = true;
        }
    }

    void retornarAoTrabalho() {
        if (!emFerias) {
            System.out.println("Este funcionário não está de férias.");
        } else {
            System.out.println("Funcionário " + nome + " retornou ao trabalho.");
            emFerias = false;
        }
    }

    String getStatusFerias() {
        return emFerias ? "de férias" : "trabalhando";
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
                System.out.println((i + 1) + ". Nome: " + funcionario.nome + ", Cargo: " + funcionario.cargo + ", Salário: R$" + funcionario.salario + ", Status: " + funcionario.getStatusFerias());
            }
        }
    }

    public static void menu() {
        System.out.println("\n### Sistema de Recursos Humanos ###");
        System.out.println("1. Adicionar funcionário");
        System.out.println("2. Listar funcionários");
        System.out.println("3. Solicitar férias");
        System.out.println("4. Retornar ao trabalho");
        System.out.println("5. Sair do sistema");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            menu();
            System.out.print("Digite o número da opção desejada: ");
            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    adicionarFuncionario();
                    break;
                case 2:
                    listarFuncionarios();
                    break;
                case 3:
                    solicitarFerias();
                    break;
                case 4:
                    retornarAoTrabalho();
                    break;
                case 5:
                    System.out.println("Saindo do sistema...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                    break;
            }
        }
    }

    public static void solicitarFerias() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número do funcionário que deseja solicitar férias: ");
        int index = scanner.nextInt();
        if (index >= 1 && index <= funcionarios.size()) {
            funcionarios.get(index - 1).solicitarFerias();
        } else {
            System.out.println("Funcionário não encontrado.");
        }
    }

    public static void retornarAoTrabalho() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número do funcionário que deseja retornar ao trabalho: ");
        int index = scanner.nextInt();
        if (index >= 1 && index <= funcionarios.size()) {
            funcionarios.get(index - 1).retornarAoTrabalho();
        } else {
            System.out.println("Funcionário não encontrado.");
        }
    }
}
