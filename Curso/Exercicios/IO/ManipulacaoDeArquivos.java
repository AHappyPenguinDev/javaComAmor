//package Exercicios.IO;
//
//import java.io.*;
//
//public class ManipulacaoDeArquivos implements FileOperation {
//
//  String nomeArquivo = "";
//
//  public ManipulacaoDeArquivos(String nomeArquivo) {
//    this.nomeArquivo = nomeArquivo;
//  }
//
//  
//  private void executeWithHandling(FileOperation operation){
//    try {
//      operation.execute(); 
//    }
//    catch(IOException e) {
//      System.err.printf("IOException: %s Stack Trace: %s", e.getMessage(), "Hi");
//    }
//  }
//  
//  public void escreverNoArquivo(String conteudo) throws IOException{
//      
//  executeWithHandling(() -> {
//      FileWriter writer = new FileWriter(nomeArquivo);
//      writer.write(conteudo);
//      
//      writer.close();
//    )}
//  }
//
//
//  public void lerDoArquivo() {
//    executeWithHandling(() -> {
//      FileReader reader = new FileReader(nomeArquivo); 
//      
//      int data = 0;
//      while(data != -1) {
//        data = reader.read();
//        System.out.print((char) data);
//      }
//      
//      reader.close();
//    )}
//  }
//
//  
//
//  public static void main(String[] args) {
//    ManipulacaoDeArquivos arquivo = new ManipulacaoDeArquivos("teste.txt");
//
//    System.out.printf("Arquivo antes da alteração: %s\n", arquivo.lerDoArquivo()); 
//    arquivo.escreverNoArquivo("Chupa LSP!");
//    System.out.printf("Arquivo depois da alteração: %s\n", arquivo.lerDoArquivo()); 
//       
//  }
//}

package Exercicios.IO;

import java.io.*;

public class ManipulacaoDeArquivos {

    String nomeArquivo = "";

    public ManipulacaoDeArquivos(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    // Functional interface for file operations
    @FunctionalInterface
    interface FileOperation {
        void execute() throws IOException;
    }

    // Method to handle file operations with try-catch
    private void executeWithHandling(FileOperation operation) {
        try {
            operation.execute();
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    public void escreverNoArquivo(String conteudo) {
        executeWithHandling(() -> {
            FileWriter writer = new FileWriter(nomeArquivo);
            writer.write(conteudo);
            writer.close();
        });
    }

    public void lerDoArquivo() {
        executeWithHandling(() -> {
            FileReader reader = new FileReader(nomeArquivo);
            int data;
            while ((data = reader.read()) != -1) {
                System.out.print((char) data);
            }
            reader.close();
        });
    }

    public static void main(String[] args) {
        ManipulacaoDeArquivos arquivo = new ManipulacaoDeArquivos("teste.txt");

        System.out.printf("Arquivo antes da alteração: ");
        arquivo.lerDoArquivo();
        System.out.println(); 

        arquivo.escreverNoArquivo("Chupa LSP!");
        System.out.printf("Arquivo depois da alteração: ");
        arquivo.lerDoArquivo();
    }
}
