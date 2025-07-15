import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class DuplicateElimination {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Insert names: ");
    String input = scanner.nextLine();
    List<String> list = new ArrayList<>(Arrays.asList(input.split(" ")));

    System.out.print("Insert name to search for: ");
    String key = scanner.nextLine();

    scanner.close();

    displayNames(list, key);
  }

  private static void displayNames(List<String> list, String key) {
    System.out.printf("Names: %s%n", list);

    Collections.sort(list);

    int result = Collections.binarySearch(list, key);

    if (result >= 0) {
      System.out.printf("%s found at index: %d", key, result);
    } else {
      System.out.printf("%s not found (%d)%n", key, result);
    }
  }
}
