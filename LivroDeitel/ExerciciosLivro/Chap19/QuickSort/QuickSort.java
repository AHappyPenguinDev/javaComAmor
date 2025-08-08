import java.util.Arrays;

public class QuickSort {

  public static void quickSortHelper(int[] array, int start, int end) {
    if (start < end) { // base case if subarray has more than one element
      int partElement = quickSort(array, start, end); //

      quickSortHelper(array, start, partElement - 1);
      quickSortHelper(array, partElement + 1, end);
    }
  }

  private static int quickSort(int[] array, int start, int end) { // quickSort returns the
    int pivot = array[end]; // choose last element as the pivot
    int i = start - 1; // i represented the boundary of elements less than or equal to the pivot

    for (int j = start; j < end; j++) {
      if (array[j] <= pivot) {
        i++;

        swap(array, i, j);
      }
    }

    swap(array, i + 1, end);
    return i + 1;
  }

  private static void swap(int[] array, int left, int right) { // swap two elements
    int temp = array[left];
    array[left] = array[right];
    array[right] = temp;
  }

  public static void main(String[] args) {
    int[] array = { 37, 2, 6, 4, 89, 8, 10, 12, 68, 45 }; // create array

    System.out.printf("Array before sort: %s%n", Arrays.toString(array));
    quickSortHelper(array, 0, array.length - 1); // call quickSort helper to sort array
    System.out.printf("Array after sort: %s%n", Arrays.toString(array));
  }
}
