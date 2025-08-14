import java.security.SecureRandom;
import java.util.Arrays;

import com.deitel.datastructures.SortedList;

public class MergeSortedListTest {

  public static void main(String[] args) {
    SecureRandom rand = new SecureRandom();
    SortedList<Integer> list1 = new SortedList<>();
    SortedList<Integer> list2 = new SortedList<>();

    Integer[] randomIntegers1 = rand.ints(25, 0, 101).boxed().toArray(Integer[]::new);
    list1.insertSorted(randomIntegers1);

    Integer[] randomIntegers2 = rand.ints(25, 0, 101).boxed().toArray(Integer[]::new);
    list2.insertSorted(randomIntegers2);

    System.out.printf("%nList 1 before merge: %n");
    list1.print();
    System.out.println();

    System.out.printf("List 2 before merge: %n");
    list2.print();
    System.out.println();

    list1.merge(list2);

    System.out.printf("List 1 after merge: %n");
    list1.print();
  }
}
