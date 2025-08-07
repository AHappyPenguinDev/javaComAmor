import java.util.Arrays;

public class QuickSort {

  public static void quickSort(int[] array) {
    quickSort(array, 0, array.length - 1);
  }

  private static void quickSort(int[] array, int start, int end) {
    for (int i = end; i > 0; i--) {
      if (array[start] <= array[end]) {
        int temp = array[start];
        array[start] = array[end];
        array[end] = temp;
      }
    }
  }

  public static void main(String[] args) {
    int[] array = { 85, 3, 10, 5, 653, 23, 48 };
    int[] preSort = array.clone();

    quickSort(array);
    System.out.printf("Array before sort: %s%n", Arrays.toString(preSort));
    System.out.printf("Array after sort: %s%n", Arrays.toString(array));
  }
}
