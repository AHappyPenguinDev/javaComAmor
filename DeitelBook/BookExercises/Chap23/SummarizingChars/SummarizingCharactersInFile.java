
// Fig. 17.22: StreamOfLines.java
// Counting word occurrences in a text file.
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.Duration;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SummarizingCharactersInFile {
  public static void method1(Pattern pattern) {
    try {
      Map<Character, Long> letterCounts = Files.lines(Paths.get("Lyrics.txt")) // Get stream string
          .flatMap(line -> pattern.splitAsStream(line)) // Split line
          .filter(word -> !word.isEmpty()) // Filter out empty lines
          .collect(Collectors.groupingBy(string -> string.charAt(0), // Assign first index of word as map key
              TreeMap::new, Collectors.counting()));
      System.out.printf("\tmethod1 finished counting.\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void method2(Pattern pattern) {
    try {
      Map<Character, Long> letterCounts = Files.lines(Paths.get("Lyrics.txt")) // Get stream string
          .flatMap(line -> pattern.splitAsStream(line)) // Split line
          .filter(word -> !word.isEmpty()) // Filter out empty lines
          .collect(Collectors.groupingBy(string -> string.charAt(0), // Assign first index of word as map key
              TreeMap::new, Collectors.counting()));
      System.out.printf("\tmethod2 finished counting.\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) throws IOException {
    // Regex that matches one or more consecutive whitespace characters

    Pattern pattern = Pattern.compile("\\s+");

    System.out.println("Starting method1 count...");
    Instant start1 = Instant.now();
    method1(pattern);
    Instant end1 = Instant.now();

    Duration d1 = Duration.between(start1, end1);
    System.out.printf("\tmethod1 counting time: %d milliseconds", d1.toMillis());

    System.out.printf("\n--------------------------------------------------------------------------------\n");

    System.out.println("Starting method2 count...");
    Instant start2 = Instant.now();
    method2(pattern);
    Instant end2 = Instant.now();

    Duration d2 = Duration.between(start2, end2);
    System.out.printf("\tmethod 2 counting time: %d milliseconds%n", d2.toMillis());
  }
}
