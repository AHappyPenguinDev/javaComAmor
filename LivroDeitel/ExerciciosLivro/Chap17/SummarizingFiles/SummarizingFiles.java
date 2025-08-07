import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class SummarizingFiles {
  public static void summarizeFiles(String path) {
    Pattern pattern = Pattern.compile("^.*?(?<=\\.)"); //matches everything before the dot

    try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(path))) {
      System.out.printf("Files in %s:%n ", path);
      Stream<Path> stream = StreamSupport.stream(directoryStream.spliterator(), false);

      // contains something like map<"txt", 1>
      Map<String, Long> fileTypeCounts = stream.flatMap(file -> pattern.splitAsStream(file.toString()))
          .collect(Collectors.groupingBy(String::toLowerCase,
              TreeMap::new, Collectors.counting()));

      fileTypeCounts.entrySet() // create set to create stream, produces obj of type Set<Map.Entry<String,long>>
          .stream() // create stream of set, produces obj of type Stream<Map.Entry<String, long>>
                            // (You can use stream.skip(1) to skip the first iteration so that something
                            // like . count = 5 doesn't show up, but I decided to keep it like this)
          .collect(Collectors.groupingBy(entry -> entry.getKey(), // Gets key. That is, the file type name
              TreeMap::new, Collectors.toList())) // Back to map, but this time: Map<String, List<Map.entry<String, Long>>>
          .forEach((fileType, letterList) -> { // String key and List value
            System.out.printf("%n.%s count: ", fileType);
            letterList.stream().forEach(letter -> System.out.printf(
                "%d", letter.getValue()));
          });

      // letterCounts.entrySet()
      // .stream()
      // .collect(Collectors.groupingBy(entry -> entry.getKey(),
      // TreeMap::new, Collectors.toList()))
      // .forEach((key, letterList) -> {
      // System.out.printf("%n%c ", key);
      // letterList.stream().forEach(letter -> System.out.printf(
      // "Count: %d%n", letter.getValue()));
      // });

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.printf("Current Directory: %s",
        System.getProperty("user.dir"));

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
