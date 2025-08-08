import java.security.SecureRandom;
import java.util.Arrays;

import com.deitel.datastructures.SortedList;
import com.deitel.datastructures.MergeSort;

public class SortedListTest {

  public static void main(String[] args) {
    SecureRandom rand = new SecureRandom();
    SortedList<Integer> list = new SortedList<>();
    Integer[] randomIntegers = rand.ints(25, 0, 101).boxed().toArray(Integer[]::new);
    list.insertSorted(randomIntegers);
    System.out.printf("Unsorted random ints from 0-100: %s%n", Arrays.toString(randomIntegers));
    list.print();
  }
}
