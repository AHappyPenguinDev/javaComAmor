import java.security.SecureRandom;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//Average of numbers, average of even numbers and average of odd numbers
public class AverageOddAndEven {

  public static Predicate<Integer> isOdd = isOdd = i -> !(i % 2 == 0);
  public static Predicate<Integer> isEven = isEven = i -> (i % 2 == 0);

  public static List<Integer> oddInts(List<Integer> randomInts) {
    return randomInts.stream()
        .filter(isOdd)
        .collect(Collectors.toList());
  }

  public static List<Integer> evenInts(List<Integer> randomInts) {
    return randomInts.stream()
        .filter(isEven)
        .collect(Collectors.toList());
  }

  public static double averageInts(List<Integer> randomInts) {
    return randomInts.stream()
        .mapToInt(Integer::intValue)
        .average()
        .orElse(0.0);
  }

  public static double averageEvenInts(List<Integer> randomInts) {
    return randomInts.stream()
        .filter(isEven)
        .mapToDouble(Integer::intValue)
        .average()
        .orElse(0.0);
  }

  public static double averageOddInts(List<Integer> randomInts) {
    return randomInts.stream()
        .filter(isOdd)
        .mapToInt(Integer::intValue)
        .average()
        .orElse(0.0);
  }

  public static void main(String[] args) {
    SecureRandom random = new SecureRandom();
    List<Integer> randomInts = random.ints(10, 0, 1000).boxed().collect(Collectors.toList());

    System.out.printf("%nOdd numbers:%s", oddInts(randomInts));
    System.out.printf("%nEven numbers:%s", evenInts(randomInts));
    System.out.printf("%nAverage random ints:%n%.2f", averageInts(randomInts));
    System.out.printf("%nAverage random even ints:%n%.2f", averageEvenInts(randomInts));
    System.out.printf("%nAverage random odd ints:%n%.2f", averageOddInts(randomInts));

    // averageOddInts(randomsInts);
    // averageEvenInts(randomsInts);
  }
}
