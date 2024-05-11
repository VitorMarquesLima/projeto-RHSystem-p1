package rh;

import java.util.ArrayList;
import java.util.Scanner;

public class RHSystemUtils {
    private static final Scanner scanner = new Scanner(System.in);
    private static ArrayList<Funcionario> funcionariosDemitidos = new ArrayList<>();

    // Método para adicionar um novo funcionário ao sistema.
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

        RHSystem.funcionarios.add(new Funcionario(nome, cargo, salario));
        System.out.println("Funcionário adicionado com sucesso.");
    }

    // Método para listar todos os funcionários cadastrados no sistema.
    public static void listarFuncionarios() {
        if (RHSystem.funcionarios.isEmpty()) {
            System.out.println("Não há funcionários cadastrados.");
        } else {
            System.out.println("Lista de funcionários:");
            for (int i = 0; i < RHSystem.funcionarios.size(); i++) {
                Funcionario funcionario = RHSystem.funcionarios.get(i);
                System.out.println((i + 1) + ". Nome: " + funcionario.nome + ", Cargo: " + funcionario.cargo
                        + ", Salário: R$" + funcionario.salario + ", Status: " + funcionario.getStatusFerias());
            }
        }
    }

    // Método para solicitar férias para um funcionário específico.
    public static void solicitarFerias() {
        System.out.print("Digite o número do funcionário que deseja solicitar férias: ");
        int index = scanner.nextInt();
        if (index >= 1 && index <= RHSystem.funcionarios.size()) {
            RHSystem.funcionarios.get(index - 1).solicitarFerias();
        } else {
            System.out.println("Funcionário não encontrado.");
        }
    }

    // Método para retornar ao trabalho um funcionário que estava de férias.
    public static void retornarAoTrabalho() {
        System.out.print("Digite o número do funcionário que deseja retornar ao trabalho: ");
        int index = scanner.nextInt();
        if (index >= 1 && index <= RHSystem.funcionarios.size()) {
            RHSystem.funcionarios.get(index - 1).retornarAoTrabalho();
        } else {
            System.out.println("Funcionário não encontrado.");
        }
    }

    // Método para demitir um funcionário.
    public static void demitirFuncionario() {
        if (RHSystem.funcionarios.isEmpty()) {
            System.out.println("Não há funcionários cadastrados para demitir.");
        }

        String input;

        // Loop para garantir uma entrada válida
        System.out.print("Digite o número do funcionario que deseja demitir: ");
        input = scanner.nextLine();

        // Verifica se a entrada é um número válido
        if (!input.trim().isEmpty() && input.matches("\\d+")) {
            int index = Integer.parseInt(input);

            // Verifica se o número do funcionário está dentro do intervalo válido
            if (index >= 1 && index <= RHSystem.funcionarios.size()) {
                // Demite o funcionário
                Funcionario demitido = RHSystem.funcionarios.remove(index - 1);
                funcionariosDemitidos.add(demitido);
                System.out.println("Funcionário demitido com sucesso.");
                return;
            }
        }
    }

    public static void listarFuncionariosDemitidos() {
        if (funcionariosDemitidos.isEmpty()) {
            System.out.println("Não há funcionarios demitidos.");
        } else {
            System.out.println("Lista de Funcionários demitidos:");
            for (int i = 0; i < funcionariosDemitidos.size(); i++) {
                Funcionario funcionario = funcionariosDemitidos.get(i);
                System.out.println((i + 1) + ". NOME: " + funcionario.nome + ", CARGO: " + funcionario.cargo
                        + ", Salario: R$" + funcionario.salario + ", Status: Demitido");
            }
        }
    }

    public static void FolhaDePagamentos() {

        double custoTotal = 0.0;

        if (RHSystem.funcionarios.isEmpty()) {
            System.out.println("Não há funcionários cadastrados.");
        } else {
            System.out.println("O custo da folha de pagamento é: ");
            for (int i = 0; i < RHSystem.funcionarios.size(); i++) {
                Funcionario funcionario = RHSystem.funcionarios.get(i);
                System.out.println((i + 1) + " Nome: " + funcionario.nome + ", Salário: R$" + funcionario.salario);

                custoTotal += funcionario.salario;
            }

            System.out.println("o custo da folha de pagamento é: " + custoTotal );
            
        }
        return;
    }
}
