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
    private static final Scanner scanner = new Scanner(System.in);
    static ArrayList<Funcionario> funcionarios = new ArrayList<>();

    public static void adicionarFuncionario() {
        System.out.print("Digite o nome do funcionário: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o cargo do funcionário: ");
        String cargo = scanner.nextLine();

        double salario;
        while (true) {
            System.out.print("Digite o salário do funcionário: ");
            if (scanner.hasNextDouble()) {
                salario = scanner.nextDouble();
                break;
            } else {
                System.out.println("Por favor, insira um valor numérico para o salário.");
                scanner.next();
            }
        }

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
                System.out.println((i + 1) + ". Nome: " + funcionario.nome + ", Cargo: " + funcionario.cargo
                        + ", Salário: R$" + funcionario.salario + ", Status: " + funcionario.getStatusFerias());
            }
        }
    }

    public static void menu() {
        System.out.println("                                       ");
        System.out.println("█ █ █ █ █ █ █ █ █ █ █ █ █ █ █ █ █ █ █ █");
        System.out.println("█                                     █");
        System.out.println("█    !Sistema de Recursos Humanos!    █");
        System.out.println("█                                     █");
        System.out.println("█     1. Admitir Funcionário          █");
        System.out.println("█     2. Listar funcionários          █");
        System.out.println("█     3. Solicitar férias             █");
        System.out.println("█     4. Retornar ao trabalho         █");
        System.out.println("█     5. Demitir Funcionário          █");
        System.out.println("█     6. Sair do Sistema              █");
        System.out.println("█                                     █");
        System.out.println("█    !Sistema de Recursos Humanos!    █");
        System.out.println("█                                     █");
        System.out.println("█ █ █ █ █ █ █ █ █ █ █ █ █ █ █ █ █ █ █ █");
        System.out.println("                                       ");
    }

    public static void main(String[] args) {
        while (true) {
            menu();
            System.out.print("                                   \n" +
                    "Digite o número da opção desejada:  ");
            String escolha = scanner.nextLine();

            switch (escolha) {
                case "1":
                    adicionarFuncionario();
                    break;
                case "2":
                    listarFuncionarios();
                    break;
                case "3":
                    solicitarFerias();
                    break;
                case "4":
                    retornarAoTrabalho();
                    break;
                case "5":
                    System.out.println("Saindo do sistema...\n" +
                            "                      ");
                    System.exit(0);
                    break;
                //case "6":
                    //DemitirFuncionario();
                    //break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.\n" +
                            "                                                     ");
                    break;
            }
        }
    }

    public static void solicitarFerias() {
        System.out.print("Digite o número do funcionário que deseja solicitar férias: ");
        int index = scanner.nextInt();
        if (index >= 1 && index <= funcionarios.size()) {
            funcionarios.get(index - 1).solicitarFerias();
        } else {
            System.out.println("Funcionário não encontrado.");
        }
    }

    public static void retornarAoTrabalho() {
        System.out.print("Digite o número do funcionário que deseja retornar ao trabalho: ");
        int index = scanner.nextInt();
        if (index >= 1 && index <= funcionarios.size()) {
            funcionarios.get(index - 1).retornarAoTrabalho();
        } else {
            System.out.println("Funcionário não encontrado.");
        }
    }
}


    /*public static void DemitirFuncionario(){
        System.out.println("Digite o número do funcionário que deseja desligar: ");
        String index = scanner.nextLine();
        if(index <= 0 && index < funcionarios.size()){
            funcionarios.remove(index);
            System.out.println("Funcionário desligado com sucesso.");
        } else {System.out.println("Funcionário invalido, selecione outro número.");}

    }*/
