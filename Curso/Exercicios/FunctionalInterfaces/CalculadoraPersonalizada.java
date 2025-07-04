
package Exercicios.FunctionalInterfaces;

@FunctionalInterface
interface OperacaoMatematica {
  double executar(double a, double b);
}

public class CalculadoraPersonalizada {
  public static OperacaoMatematica potenciacao = (a, b) -> Math.pow(a, b);
  public static OperacaoMatematica raizQuadrada = (a, b) -> Math.sqrt(a + b);

  public static void main(String[] args) {

    System.out.printf("CalculadoraPersonalizada: %nPotenciação: %.2f %nRaiz Quadrada: %.2f",
        potenciacao.executar(2, 3), raizQuadrada.executar(10, 5));
  }
}
