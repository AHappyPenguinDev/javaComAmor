package com.deitel.datastructures;

import java.util.Arrays;

public class MergeSort {

  public static <E extends Number> Integer[] mergeSort(E[] data) {
    Integer[] integerArray = new Integer[data.length];
    for (int i = 0; i < data.length; i++)
      integerArray[i] = (int) data[i];

    int[] intArray = Arrays.stream(integerArray).mapToInt(Integer::intValue).toArray();
    sortArray(intArray, 0, data.length - 1); // sort entire array
    return Arrays.stream(intArray).boxed().toArray(Integer[]::new);
  }

  // splits array, sorts subarrays and merges subarrays into sorted array
  private static void sortArray(int[] data, int low, int high) {
    // test base case; size of array equals 1
    if ((high - low) >= 1) { // if not base case
      int middle1 = (low + high) / 2; // calculate middle of array
      int middle2 = middle1 + 1; // calculate next element over

      // output split step
      // split array in half; sort each half (recursive calls)
      sortArray(data, low, middle1); // first half of array
      sortArray(data, middle2, high); // second half of array

      // merge two sorted arrays after split calls return
      merge(data, low, middle1, middle2, high);
    }
  }

  // merge two sorted subarrays into one sorted subarray
  private static void merge(int[] data, int left, int middle1,
      int middle2, int right) {

    int leftIndex = left; // index into left subarray
    int rightIndex = middle2; // index into right subarray
    int combinedIndex = left; // index into temporary working array
    int[] combined = new int[data.length]; // working array

    // merge arrays until reaching end of either
    while (leftIndex <= middle1 && rightIndex <= right) {
      // place smaller of two current elements into result
      // and move to next space in arrays
      if (data[leftIndex] <= data[rightIndex]) {
        combined[combinedIndex++] = data[leftIndex++];
      } else {
        combined[combinedIndex++] = data[rightIndex++];
      }
    }

    // if left array is empty
    if (leftIndex == middle2) {
      // copy in rest of right array
      while (rightIndex <= right) {
        combined[combinedIndex++] = data[rightIndex++];
      }
    } else { // right array is empty
      // copy in rest of left array
      while (leftIndex <= middle1) {
        combined[combinedIndex++] = data[leftIndex++];
      }
    }

    // copy values back into original array
    for (int i = left; i <= right; i++) {
      data[i] = combined[i];
    }

    // output merged array
  }

}
