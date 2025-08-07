
// Fig. 17.22: StreamOfLines.java
// Counting word occurrences in a text file.
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SummarizingCharactersInFile {
  public static void main(String[] args) throws IOException {
    // Regex that matches one or more consecutive whitespace characters
    Pattern pattern = Pattern.compile("\\s+");

    // count occurrences of each word in a Stream<String> sorted by word
    Map<Character, Long> letterCounts = Files.lines(Paths.get("SugarLyrics.txt")) // Get stream string
        .flatMap(line -> pattern.splitAsStream(line)) // Split line
        .filter(word -> !word.isEmpty()) // Filter out empty lines
        .collect(Collectors.groupingBy(string -> string.charAt(0), // Assign first index of word as map key
            TreeMap::new, Collectors.counting()));

    // Displays the characters in
    letterCounts.entrySet()
        .stream()
        .collect(Collectors.groupingBy(entry -> entry.getKey(),
            TreeMap::new, Collectors.toList()))
        .forEach((key, letterList) -> {
          System.out.printf("%n%c ", key);
          letterList.stream().forEach(letter -> System.out.printf(
              "Count: %d%n", letter.getValue()));
        });
  }
}
