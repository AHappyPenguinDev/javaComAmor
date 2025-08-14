import java.util.stream.LongStream;

public class CalcFactorial {

  public static long factorial(long number) {
    return LongStream.rangeClosed(1, number)
        .reduce(1, (long x, long y) -> x * y);
  }

  public static void main(String[] args) {
    for (int i = 0; i <= 20; i++) {
      System.out.printf("%d! = %d%n",
          i, factorial(i));
    }
  }
}
