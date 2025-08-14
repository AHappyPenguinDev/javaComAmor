import java.math.BigInteger;
import java.util.stream.LongStream;

public class BigDecimalCalcFactorial {

  public static BigInteger factorial(BigInteger number) {
    long n = number.longValue();
    return LongStream.rangeClosed(1, n)
        .mapToObj(BigInteger::valueOf)
        .reduce(BigInteger.ONE, BigInteger::multiply);
  }

  public static void main(String[] args) {
    for (int i = 0; i <= 100; i++) {
      System.out.printf("%d! = %d%n%n%n%n",
          i, factorial(BigInteger.valueOf(i)));
    }
  }
}
