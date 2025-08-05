// Fig. 20.3: GenericMethodTest.java
// Printing array elements using generic method printArray.

import javax.naming.directory.InvalidSearchFilterException;

public class GenericMethodTest {
  public static void main(String[] args) {
    // create arrays of Integer, Double and Character
    Integer[] integerArray = { 1, 2, 3, 4, 5 };
    Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7 };
    Character[] characterArray = { 'H', 'E', 'L', 'L', 'O' };

    System.out.printf("Array integerArray contains: ");
    printArray(integerArray); // pass an Integer array
    System.out.printf("Array doubleArray contains: ");
    printArray(doubleArray); // pass a Double array
    System.out.printf("Array characterArray contains: ");
    printArray(characterArray); // pass a Character array

    System.out.printf("%nOverloaded printArray method:%n");
    printArray(integerArray, "Integer Array", 0, integerArray.length);
    printArray(doubleArray, "Double Array",4, 7);
    printArray(characterArray, "Char Array", 0, 4);
  }

  // generic method printArray
  public static <T> void printArray(T[] inputArray) {
    // display array elements
    for (T element : inputArray)
      System.out.printf("%s ", element);

    System.out.println();
  }

  // overloaded printArray
  // low is inclusive, high is exclusive
  public static <T> void printArray(T[] inputArray, String name, int lowSubscript, int highSubscript) {
    System.out.printf("%s from %d to %d: %n", name, lowSubscript, highSubscript-1);

    // if low or high subscript are invalid, throw exception
    if (lowSubscript > highSubscript || lowSubscript < 0 || lowSubscript > inputArray.length)
      throw new InvalidSubscriptException();
    if (highSubscript < lowSubscript || highSubscript < 0 || highSubscript > inputArray.length)
      throw new InvalidSubscriptException();

    // print part of array
    for (int i = lowSubscript; i < highSubscript; i++)
      System.out.printf("%s ", inputArray[i]);
    System.out.println();
  }
}
