public class IsEqual {
  public static <T> boolean isEqual(T arg1, T arg2) {
    System.out.printf("%s %s to %s%n", arg1, arg1.equals(arg2) ? "is equal" : "is not equal", arg2);
    return arg1.equals(arg2);
  }

  public static void main(String[] args) {
    Integer one = 1;

    isEqual(1, 1);
    isEqual(1, "1");
    isEqual(1, one);
  }
}
