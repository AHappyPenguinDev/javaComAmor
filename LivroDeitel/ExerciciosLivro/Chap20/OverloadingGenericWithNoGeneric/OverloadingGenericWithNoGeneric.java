
public class OverloadingGenericWithNoGeneric {
  public static void main(String[] args) {
    // create arrays of Integer, Double and Character
    Integer[] integerArray = { 1, 2, 3, 4, 5 };
    Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7 };
    Character[] characterArray = { 'H', 'E', 'L', 'L', 'O' };
    String[] stringArray = { "one", "two", "three", "four", "five", "six", "seven", "eight" };

    System.out.printf("Array integerArray contains: ");
    printArray(integerArray); // pass an Integer array
    System.out.printf("Array doubleArray contains: ");
    printArray(doubleArray); // pass a Double array
    System.out.printf("Array characterArray contains: ");
    printArray(characterArray); // pass a Character array
    System.out.printf("Array stringArray contains:%n");
    printArray(stringArray);
  }

  // generic method printArray
  public static <T> void printArray(T[] inputArray) {
    // display array elements
    for (T element : inputArray) {
      System.out.printf("%s ", element);
    }

    System.out.println();
  }

  public static void printArray(String[] inputArray) {
    int count = 1;
    for (String element : inputArray) {
      System.out.printf("%s%s", element, count == 4 ? "\n" : "\t");
      count++;
    }
  }
}
