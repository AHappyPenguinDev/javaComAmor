import java.security.SecureRandom;
import java.util.List;
import java.util.stream.Collectors;

public class FilteringAndSorting {
  public static List<Integer> oddSortedInts(List<Integer> randomInts) {
    return randomInts.stream()
        .filter(number -> number % 2 != 0)
        .mapToInt(Integer::intValue)
        .sorted()
        .boxed()
        .collect(Collectors.toList());
  }

  public static void main(String[] args) {
    SecureRandom random = new SecureRandom();
    List<Integer> randomInts = random.ints(50, 1, 999).boxed().collect(Collectors.toList());

    System.out.printf("Odd sorted random ints 1-999:%n%s", oddSortedInts(randomInts));
  }

}
