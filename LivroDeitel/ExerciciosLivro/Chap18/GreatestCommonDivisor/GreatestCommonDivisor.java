
public class GreatestCommonDivisor {
  private static int gcd(int x, int y) {
    if (y == 0)
      return x;

    int result = gcd(y, x % y);
    return result;
  }

  public static void main(String[] args) {
    int x = 8;
    int y = 12;
    System.out.printf("GCD of %d and %d: %d", x, y, gcd(x, y));
  }
}
