public class VisualizingRecursion {
  public static long factorial(int number) {
    return factorial(number, 0);
  }

  // private helper method so I can indent the steps
  private static long factorial(long number, int indent) {
    String spaces = "  ".repeat(indent);
    System.out.printf("%n%sEntering factorial(%d)%n", spaces, number);
    if (number <= 1) { // test for base case
      System.out.printf("%n%sBase case reached -> factorial(%d) = 1%n", spaces, number);
      return 1; // base cases: 0! = 1 and 1! = 1
    } else { // recursion step
      indent++;
      System.out.printf("%sComputing: %d * factorial(%d)", spaces, number, number - 1);
      long recursiveResult = number * factorial(number - 1, indent + 1); // calc factorial and increase indent by one
      System.out.printf("%n%sReturning: factorial(%d) = %d * %d", spaces, number, number, recursiveResult); // when method starts returning, 
      // indent goes back to what it was on the previous method call, that's where the magic lies. 
      return recursiveResult;
    }
  }

  public static void main(String[] args) {
    String bar = "----------------------------------------------------------";
    for (int counter = 0; counter <= 20; counter++) {
      System.out.printf("%s%n%s%d:|%n", bar, "Factorial of ", counter);
      System.out.printf("%17s%n%17s%n%17s%n", "|", "|", "V"); // print arrow because it's cool
      System.out.printf("%n%d! = %d%n", counter, factorial(counter));
    }
    System.out.printf("%n%s", bar);
  }
}
