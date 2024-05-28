package rh;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.List;

public class Arquivo{
    public static boolean arquivoExiste(String arquivo) {
        return Files.exists(Path.of(arquivo));
    }

    public static List<String> lerLinhas(String arquivo) {
        try {
            return Files.readAllLines(Path.of(arquivo));
        } catch (NoSuchFileException x) {
            return List.of();
        } catch (IOException x) {
            throw new RuntimeException(x);
        }
    }

    public static void escreverLinhas(List<String> linhas, String arquivo) {
        try {
            Files.write(Path.of(arquivo), linhas);
        } catch (IOException x) {
            throw new RuntimeException(x);
        }
    }

    public static int lerNumero(String arquivo) {
        try {
            return Integer.parseInt(Files.readString(Path.of(arquivo)).trim());
        } catch (IOException x) {
            throw new RuntimeException(x);
        }
    }

    public static int lerNumero(String arquivo, int naoAchou) {
        try {
            return Integer.parseInt(Files.readString(Path.of(arquivo)).trim());
        } catch (NoSuchFileException x) {
            return naoAchou;
        } catch (IOException x) {
            throw new RuntimeException(x);
        }
    }

    public static void escreverNumero(int valor, String arquivo) {
        try {
            Files.write(Path.of(arquivo), List.of("" + valor));
        } catch (IOException x) {
            throw new RuntimeException(x);
        }
    }
}