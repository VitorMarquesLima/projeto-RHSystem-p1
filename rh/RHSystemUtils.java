package rh;

import java.util.ArrayList;
import java.util.List;

public class RHSystemUtils {
    private static void salvarFuncionariosNoArquivo(List<Funcionario> todos) {
        Funcionario.salvarTudo(todos);
    }

    private static List<Funcionario> listarFuncionariosDoArquivo() {
        return Funcionario.lerTudo();
    }

    //private static ArrayList<Funcionario> funcionariosDemitidos = new ArrayList<>(); //deletar para evitar problemas na hora de salvar

    public static void adicionarFuncionario() {
        System.out.print("Digite o nome do funcionário: ");
        String nome = lerDados.lerTexto("Tente novamente");

        System.out.print("Digite o cargo do funcionário: ");
        String cargo = lerDados.lerTexto("Tente novamente");

        System.out.print("Digite o salário do funcionário: ");
        var salario = lerDados.lerDouble("Por favor, insira um valor numérico para o salário.");

        var todoMundo = listarFuncionariosDoArquivo();
        todoMundo.add(new Funcionario(nome, cargo, salario, Funcionario.TRABALHANDO));
        System.out.println("Funcionário adicionado com sucesso.");
        salvarFuncionariosNoArquivo(todoMundo);
    }

    // Método para listar todos os funcionários cadastrados no sistema.
    public static void listarFuncionarios() {
        var todoMundo = listarFuncionariosDoArquivo();
        if (todoMundo.isEmpty()) {
            System.out.println("Não há funcionários cadastrados.");
        } else {
            System.out.println("Lista de funcionários:");
            int i = 0;
            for (Funcionario funcionario : todoMundo) {
                System.out.println((i + 1) + ". Nome: " + funcionario.nome + ", Cargo: " + funcionario.cargo
                        + ", Salário: R$" + funcionario.salario + ", Status: " + funcionario.situacao);
                i++;
            }
        }
    }

    // Método para solicitar férias para um funcionário específico.
    public static void solicitarFerias() {
        var todoMundo = listarFuncionariosDoArquivo();
        System.out.print("Digite o número do funcionário que deseja solicitar férias: ");
        int index = lerDados.lerInt("insira um numero valido");
        if (index >= 1 && index <= todoMundo.size()) {
            todoMundo.get(index - 1).solicitarFerias();
        } else {
            System.out.println("Funcionário não encontrado.");
        }
        salvarFuncionariosNoArquivo(todoMundo);
    }

    // Método para retornar ao trabalho um funcionário que estava de férias.


    /* // Método para demitir um funcionário.
    public static void demitirFuncionario() {
        var todoMundo = listarFuncionariosDoArquivo();
        if (todoMundo.isEmpty()) {
            System.out.println("Não há funcionários cadastrados para demitir.");
            return;
        }

        // Loop para garantir uma entrada válida
        System.out.print("Digite o número do funcionario que deseja demitir: ");
        String input = lerDados.lerTexto("tente novamente");

        // Verifica se a entrada é um número válido
        if (input.trim().isEmpty() && input.matches("\\d+")) {
            return;
        }
        int index = Integer.parseInt(input);

        // Verifica se o número do funcionário está dentro do intervalo válido
        if (index < 1 || index > todoMundo.size()) {
            return;
        }

        // Demite o funcionário
        Funcionario demitido = todoMundo.remove(index - 1);
        funcionariosDemitidos.add(demitido);
        System.out.println("Funcionário demitido com sucesso.");
        salvarFuncionariosNoArquivo(todoMundo);
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
        } \*
    } */

    public static void FolhaDePagamentos() {
        var todoMundo = listarFuncionariosDoArquivo();

        double custoTotal = 0.0;

        if (todoMundo.isEmpty()) {
            System.out.println("Não há funcionários cadastrados.");
        } else {
            System.out.println("O custo da folha de pagamento é: ");
            for (int i = 0; i < todoMundo.size(); i++) {
                Funcionario funcionario = todoMundo.get(i);
                System.out.println((i + 1) + " Nome: " + funcionario.nome + ", Salário: R$" + funcionario.salario);

                custoTotal += funcionario.salario;
            }

            System.out.println("o custo da folha de pagamento é: " + custoTotal );
            
        }
        return;
    }
    public static void demitirfuncionario() {
        var todoMundo = listarFuncionariosDoArquivo();
        System.out.print("Digite o número do funcionário que deseja demitir: ");
        int index = lerDados.lerInt("insira um numero valido");
        if (index >= 1 && index <= todoMundo.size()) {
            todoMundo.get(index - 1).demitir();
        } else {
            System.out.println("Funcionário não encontrado.");
        }
        salvarFuncionariosNoArquivo(todoMundo);
    }
    public static void readmitirfuncionario() {
        var todoMundo = listarFuncionariosDoArquivo();
        System.out.print("Digite o número do funcionário que deseja solicitar férias: ");
        int index = lerDados.lerInt("insira um numero valido");
        if (index >= 1 && index <= todoMundo.size()) {
            todoMundo.get(index - 1).readmitir();
        } else {
            System.out.println("Funcionário não encontrado.");
        }
        salvarFuncionariosNoArquivo(todoMundo);
    }
    public static void retornarAoTrabalho() {
        var todoMundo = listarFuncionariosDoArquivo();
        System.out.print("Digite o número do funcionário que deseja retornar ao trabalho: ");
        int index =  lerDados.lerInt("insira um numero valido");
        if (index >= 1 && index <= todoMundo.size()) {
            todoMundo.get(index - 1).retornarAoTrabalho();
        } else {
            System.out.println("Funcionário não encontrado.");
        }
        salvarFuncionariosNoArquivo(todoMundo);
    }
}
