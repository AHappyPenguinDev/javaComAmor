
//import java.util.*;
//
//public class LambdaListaManipulacaoLambda {
//  public static void main(String[] args) {
//    List<String> minhaLista = new ArrayList<>();
//    minhaLista.add("maçã");
//    minhaLista.add("banana");
//    minhaLista.add("cereja");
//    minhaLista.add("abacaxi");
//
//    minhaLista.removeIf(s -> s.length() > 5);
//
//    minhaLista.add(0, "uva");
//
//    minhaLista.forEach(System.out::println);
//  }
//}
import java.util.ArrayList;
import java.util.List;

public class LambdaListaManipulacaoLambda {
  public static void main(String[] args) {
    // Passo 1: Criação da Lista
    List<String> minhaLista = new ArrayList<>();
    minhaLista.add("maça");
    minhaLista.add("banana");
    minhaLista.add("cereja");
    minhaLista.add("abacaxi");
    // Passo 2: Remoção de Elementos
    minhaLista.removeIf(s -> s.length() > 5);
    // Passo 3: Adição de Elemento
    minhaLista.add(0, "uva");
    // Passo 4: Impressão da Lista
    minhaLista.forEach(System.out::println);
  }
}
