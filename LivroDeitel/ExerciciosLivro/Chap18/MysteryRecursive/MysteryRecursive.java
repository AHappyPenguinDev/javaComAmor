
public class MysteryRecursive {
  public static int mystery(int x) {
    if (x <= 1)
      return 1;

    int sum = x + mystery(x - 1);
    return sum;
  }

  public static void main(String[] args) {
    int number = 3;
    System.out.printf("Sum of all integers before %d: %d", number, mystery(number));
  }
}
