import java.util.List;
import java.util.Arrays;
import java.util.Collections;

public class ReverseArray {
  private static <T> T[] reverseArray(T[] array) {
    for (int i = 0; i < array.length / 2; i++) {
      T temp = array[i]; // n
      array[i] = array[array.length - 1 - i]; // t
      array[array.length - i - 1] = temp; // n
    }
    return array;
  }

  public static <T> void printReversedArray(T[] array) {
    T[] reversed = reverseArray(array);
    for (T element : reversed)
      System.out.printf("%s ", element);
    System.out.println();
  }

  public static void main(String[] args) {
    Character[] charArray = { 'n', 'u', 'a', 's', 'i', 'b', 'r', 'a', 'j', 'a', 'm', 'u', 't' };
    Integer[] intArray = { 1, 2, 3, 4, 5 };
    String[] stringArray = { "Piece", "One", "the", "is", "Where" };

    printReversedArray(charArray);
    printReversedArray(intArray);
    printReversedArray(stringArray);
  }
}
