import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BucketSort {

  public static void sort(int[] array) {
    // create arraylist of integer bucket
    int maxNumber = Arrays.stream(array).max().getAsInt(); // get largest number in array
    int maxDigits = String.valueOf(maxNumber).length(); // get amount of digits of largest number
    int digits = 1;

    @SuppressWarnings("unchecked") // this is to remove a warning when compiling
    List<List<Integer>> bucket = new ArrayList(array.length);

    // Intialize bucket with empty arraylists
    for (int i = 0; i < array.length; i++)
      bucket.add(i, new ArrayList<Integer>());

    for (int d = 0; d < maxDigits; d++) {

      // Reset bucket elements
      for (List<Integer> list : bucket)
        list.clear();

      // add each element in array its respective range in the bucket
      for (int element : array) {
        int range = (element / digits) % 10;
        bucket.get(range).add(element);
      }

      // assign values back into array
      int index = 0;
      for (int i = 0; i < bucket.size(); i++) {
        for (int j = 0; j < bucket.get(i).size(); j++) {
          try {
            array[index++] = bucket.get(i).get(j);
          } catch (Exception e) {
            e.printStackTrace();
            System.out.printf("(Index var: %s) Current size of bucket: %d -> I = %d%n", index, bucket.size(), i); // TODO:
                                                                                                                  // handle
                                                                                                                  // exception
          }
        }
      }

      digits *= 10;
    }
  }

  public static void main(String[] args) {
    int[] array = { 4, 92, 9, 1, 203, 100, 2, 10002, 49, 10, 97, 3, 13, 32 };
    int[] preSort = array.clone();

    BucketSort.sort(array);
    System.out.printf("%nArray before sort: %s%n", Arrays.toString(preSort));
    System.out.printf("Array after sort: %s%n", Arrays.toString(array));
  }
}
