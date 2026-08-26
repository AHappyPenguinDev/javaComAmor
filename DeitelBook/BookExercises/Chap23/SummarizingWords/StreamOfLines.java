
// Fig. 17.22: StreamOfLines.java
// Counting word occurrences in a text file.
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.time.Duration;
import java.time.Instant;

public class StreamOfLines {
  public static void main(String[] args) throws IOException {
    // Regex that matches one or more consecutive whitespace characters
    Pattern pattern = Pattern.compile("\\s+");

    // Sequential version
    Instant sequentialStart = Instant.now();
    Map<String, Long> wordCounts = Files.lines(Paths.get("Chapter2Paragraph.txt"))
        .flatMap(line -> pattern.splitAsStream(line))
        .collect(Collectors.groupingBy(String::toLowerCase,
            TreeMap::new, Collectors.counting()));

    // display the words grouped by starting letter
    wordCounts.entrySet()
        .stream()
        .collect(
            Collectors.groupingBy(entry -> entry.getKey().charAt(0),
                TreeMap::new, Collectors.toList()))
        .forEach((letter, wordList) -> {
          System.out.printf("%n%C%n", letter);
          wordList.stream().forEach(word -> System.out.printf(
              "%13s: %d%n", word.getKey(), word.getValue()));
        });
    Instant sequentialEnd = Instant.now();
    long sequentialTime = Duration.between(sequentialStart, sequentialEnd).toMillis();

    System.out.printf("%n--------------------------------------------------------------------------%n");
    // Parallel Version
    Instant parallelStart = Instant.now();
    Map<String, Long> parallelWordCounts = Files.lines(Paths.get("Chapter2Paragraph.txt"))
        .flatMap(line -> pattern.splitAsStream(line))
        .collect(Collectors.groupingBy(String::toLowerCase,
            TreeMap::new, Collectors.counting()));

    parallelWordCounts.entrySet()
        .stream()
        .parallel()
        .collect(
            Collectors.groupingBy(entry -> entry.getKey().charAt(0),
                TreeMap::new, Collectors.toList()))
        .forEach((letter, wordList) -> {
          System.out.printf("%n%C%n", letter);
          wordList.stream().forEach(word -> System.out.printf(
              "%13s: %d%n", word.getKey(), word.getValue()));
        });
    Instant parallelEnd = Instant.now();
    long parallelTime = Duration.between(parallelStart, parallelEnd).toMillis();

    System.out.printf("%n%nSequential time in milliseconds: %d%n", sequentialTime);
    System.out.printf("Parallel time in milliseconds: %d%n", parallelTime);

    String percentage = NumberFormat.getPercentInstance()
        .format((double) (sequentialTime - parallelTime) / sequentialTime);
    System.out.printf("Sequential took %s more time than parallel%n", percentage);
  }
}
