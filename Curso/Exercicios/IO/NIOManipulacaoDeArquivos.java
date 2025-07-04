package Exercicios.IO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NIOManipulacaoDeArquivos {
  public static void main(String[] args) {

    String nomeArquivo = "meuarquivo.txt";
    String conteudo = "Olá, mundo! Este é um exemplo de escrita em arquivo.";

    // Escrevendo no arquivo
    escreverNoArquivo(nomeArquivo, conteudo);
    // Lendo do arquivo
    String conteudoLido = lerDoArquivo(nomeArquivo);
    System.out.println("Conteúdo lido do arquivo: " +
        conteudoLido);
  }

  public static void escreverNoArquivo(String nomeArquivo, String conteudo) {
    try {
      Path path = Paths.get(nomeArquivo);
      Files.write(path, conteudo.getBytes());
      System.out.println("Arquivo criado e texto escrito com sucesso!");
    } catch (IOException e) {
      System.out.println("Erro ao escrever no arquivo: " +
          e.getMessage());
    }
  }

  public static String lerDoArquivo(String nomeArquivo) {
    try {
      Path path = Paths.get(nomeArquivo);
      byte[] bytes = Files.readAllBytes(path);
      return new String(bytes);
    } catch (IOException e) {
      System.out.println("Erro ao ler o arquivo: " +
          e.getMessage());
      return "";
    }
  }
}
