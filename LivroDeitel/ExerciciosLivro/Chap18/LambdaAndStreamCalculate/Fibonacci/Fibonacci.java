import java.util.stream.Stream;

public class Fibonacci {

  public static long fibonacci(int number) {
    return Stream
        .iterate(new long[] { 0, 1 }, f -> new long[] {
            f[1], f[0] + f[1] })
        .limit(number + 1)
        .map(f -> f[0])
        .reduce((first, second) -> second)
        .orElse(0L);
  }

  public static void main(String[] args) {
    for (int i = 0; i < 20; i++) {
      System.out.printf("Fibonacci of %d is: %d%n", i,
          fibonacci(i));
    }
  }
}
