//This is a version of Summarizing that sorts the files by their count, not alphabetical order.
//I put it on a different file because I could not make this myself, I had to use AI to help me change
//the summarize files method. Anyways I still think it is cool, and better than the original which I made myself

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import java.util.regex.Pattern;

public class SummarizingFilesSorted {
  public static void summarizeFiles(String path) {
    Pattern pattern = Pattern.compile("^.*?(?<=\\.)"); // matches everything before the dot

    try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(path))) {
      System.out.printf("Files in %s:%n ", path);
      Stream<Path> stream = StreamSupport.stream(directoryStream.spliterator(), false);

      // Collect the file type counts into a Map
      Map<String, Long> fileTypeCounts = stream.flatMap(file -> pattern.splitAsStream(file.toString()))
          .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));

      // Sort by count and then by file type (if needed)
      List<Map.Entry<String, Long>> sortedEntries = fileTypeCounts.entrySet()
          .stream()
          .sorted((entry1, entry2) -> {
            // Sort by count descending
            int countComparison = Long.compare(entry2.getValue(), entry1.getValue());
            // If counts are the same, sort by filename alphabetically
            return countComparison != 0 ? countComparison : entry1.getKey().compareTo(entry2.getKey());
          })
          .collect(Collectors.toList());

      // Print the sorted results
      sortedEntries.forEach(entry -> {
        System.out.printf("%n.%s count: %d", entry.getKey(), entry.getValue());
      });

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.printf("Current Directory: %s", System.getProperty("user.dir"));

    while (true) {
      System.out.println("\nEnter directory path: ");
      Path path = Paths.get(scanner.nextLine());

      if (Files.isDirectory(path)) {
        System.out.println("Summarizing files:\n");
        summarizeFiles(path.toString());
        break;
      }
    }
    scanner.close();
  }
}
