import java.security.SecureRandom;
import java.util.Arrays;

//Sorted list contains method insertSorted which just takes an Integer[], does a LOT of type conversions which I don't fully understand
//
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
