import java.util.Arrays;

public class RecursiveMinimum {
  public static int recursiveMinimum(int[] array, int smallest, int index) {
    if (index == array.length)
      return smallest;

    if (smallest > array[index])
      smallest = array[index];
    return recursiveMinimum(array, smallest, index + 1);
  }

  public static void main(String[] args) {
    int[] array = { 10, 11, 23, 43 };
    System.out.printf("Minimum value in array %s: %d%n", Arrays.toString(array), recursiveMinimum(array, array[0], 0));
  }
}
