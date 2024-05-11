package rh;

public class Funcionario {
    String nome;
    String cargo;
    double salario;
    boolean emFerias;

    // Classe que representa um funcionário com nome, cargo, salário e status de
    // férias.
    public Funcionario(String nome, String cargo, double salario) {
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
        this.emFerias = false; // Inicialmente, o funcionário não está de férias
    }

    // Método para solicitar férias para o funcionário.
    public void solicitarFerias() {
        if (emFerias) {
            System.out.println("Este funcionário já está de férias.");
        } else {
            System.out.println("Férias solicitadas para o funcionário " + nome);
            emFerias = true;
        }
    }

    // Método para retornar o funcionário ao trabalho após as férias.
    public void retornarAoTrabalho() {
        if (!emFerias) {
            System.out.println("Este funcionário não está de férias.");
        } else {
            System.out.println("Funcionário " + nome + " retornou ao trabalho.");
            emFerias = false;
        }
    }

    // Método para obter o status de férias do funcionário.
    public String getStatusFerias() {
        return emFerias ? "De Férias" : "Trabalhando";
    }
}
