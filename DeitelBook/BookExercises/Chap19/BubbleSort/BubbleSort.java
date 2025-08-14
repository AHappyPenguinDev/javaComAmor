import java.util.Arrays;

public class BubbleSort {
  public static void bubbleSort(int[] array) {
    for (int i = 0; i < array.length - 1; i++) {
      System.out.printf("%nPass %d:%n", i);
      for (int j = 0; j < array.length - 1; j++) {
        System.out.printf("\tSwap number %d: %s%s", j, Arrays.toString(array), j % 2 == 0 ? "\t" : "\n");
        if (array[j] > array[j + 1]) {
          int temp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temp;
        }
      }
    }
  }

  public static void main(String[] args) {
    int[] array = { 5, 3, 7, 0, 1, 3, 4, 9 };
    int[] sorted = array.clone();

    bubbleSort(sorted);
    System.out.printf("%n%nArray before sort: %s%n", Arrays.toString(array));
    System.out.printf("Array after sort: %s%n", Arrays.toString(sorted));
  }
}

// Explain why this algorithm is O(n²)
// R: This algorithm is O(n²) because for each element in the array, you must
// loop over the array again.
// That is, for n elements, you need n loops. n*n = n²
