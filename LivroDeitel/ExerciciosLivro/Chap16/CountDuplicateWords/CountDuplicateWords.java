import java.util.HashMap;
import java.util.Map;

public class CountDuplicateWords {
  public static void main(String[] args) {
    String[] words = { "João", "Max", "Kiran", "Bobby", "Pittoli", "Max", "Pittoli" };
    Map<String, Integer> map = new HashMap<>();

    for (String word : words) {
      // No punctuation, case insensitive search
      String filteredWord = word.replaceAll("\\p{Punct}", "").toLowerCase();
      if (map.containsKey(word)) {
        int count = map.get(word);
        map.put(word, count + 1);
      } else {
        map.put(word, 1);
      }
    }

    System.out.printf("%nMap contains:%nKey\t\tValue%n");
    map.forEach(
        (word, value) -> System.out.printf("%-15s%10s%n", word, map.get(word)));
  }
}
