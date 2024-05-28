package rh;

import java.util.ArrayList;
import java.util.List;

public class Funcionario {
    String nome;
    String cargo;
    double salario;
    String situacao; // Trabalhando, Férias ou Demitido

    private static final String ARQUIVO = "./rh/funcionarios.txt";

    public static final String FERIAS = "De Férias";
    public static final String TRABALHANDO = "Trabalhando";
    public static final String DEMITIDO = "Demitido";

    // Classe que representa um funcionário com nome, cargo, salário e status de
    // férias.
    public Funcionario(String nome, String cargo, double salario, String situacao) {
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
        this.situacao = situacao; //"Trabalhando"; // Inicialmente, o funcionário não está de férias
    }

    // Método para solicitar férias para o funcionário.
    public void solicitarFerias() {
        if (!situacao.equals(TRABALHANDO)) {
            System.out.println("Este funcionário não pode entrar de férias.");
        } else {
            System.out.println("Férias solicitadas para o funcionário " + nome);
            situacao = FERIAS;
        }
    }

    // Método para retornar o funcionário ao trabalho após as férias.
    public void retornarAoTrabalho() {
        if (!situacao.equals(FERIAS)) {
            System.out.println("Este funcionário não pode retornar ao trabalho.");
        } else {
            System.out.println("Funcionário " + nome + " retornou ao trabalho.");
            situacao = TRABALHANDO;
        }
    }

    // Método para demitir o funcionário.
    public void demitir() {
        if (!situacao.equals(TRABALHANDO)) {
            System.out.println("Este funcionário não pode ser demitido.");
        } else {
            System.out.println("Demissão solicitada para o funcionário " + nome);
            situacao = DEMITIDO;
        }
    }

    // Método para retornar o funcionário ao trabalho após as férias.
    public void readmitir() {
        if (!situacao.equals(DEMITIDO)) {
            System.out.println("Este funcionário não pode ser readmitido ao trabalho.");
        } else {
            System.out.println("Funcionário " + nome + " foi readmitido ao trabalho.");
            situacao = TRABALHANDO;
        }
    }

    // Método para obter o status de férias do funcionário.
    public String getSituacao() {
        return situacao;
    }

    public List<String> desconstruir() {
        return List.of(nome, cargo, "" + salario, situacao);
    }

    public static Funcionario construir(List<String> listinha) {
        if (listinha.size() != 4) throw new IllegalArgumentException();
        return new Funcionario(
                listinha.get(0),
                listinha.get(1),
                Double.parseDouble(listinha.get(2)),
                listinha.get(3)
        );
    }

    public static List<Funcionario> construirTodos(List<String> listona) {
        if (listona.size() % 4 != 0) throw new IllegalArgumentException();
        var resultado = new ArrayList<Funcionario>(listona.size() / 4);
        for (int i = 0; i < listona.size(); i += 4) {
            var listinha = listona.subList(i, i + 4);
            var elemento = construir(listinha);
            resultado.add(elemento);
        }
        return resultado;
    }

    public static List<String> desconstruirTodos(List<Funcionario> todos) {
        var listona = new ArrayList<String>(todos.size() * 4);
        for (var v : todos) {
            listona.addAll(v.desconstruir());
        }
        return listona;
    }

    public static List<Funcionario> lerTudo() {
        var listona = Arquivo.lerLinhas(ARQUIVO);
        return construirTodos(listona);
    }

    public static void salvarTudo(List<Funcionario> tudo) {
        var listona = desconstruirTodos(tudo);
        Arquivo.escreverLinhas(listona, ARQUIVO);
    }
}
