import java.util.Arrays;
import java.util.*;

public class LambdaComCollection {
  public static void main(String[] args) {
    List<Integer> listaDeNumeros = Arrays.asList(1, 2, 3, 4, 5);
    List<Integer> numerosPares = new ArrayList<>();

    listaDeNumeros.forEach((numero) -> System.out.println(numero));
  }
}
