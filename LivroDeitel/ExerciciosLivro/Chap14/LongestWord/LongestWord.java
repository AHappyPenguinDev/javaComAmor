import java.util.Scanner;

public class LongestWord {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Insert sentence so that the longest word can be displayed: ");
    String sentence = scanner.nextLine();
    scanner.close();

    String[] wordArray = sentence.split("\\s+");
    String longestWord = "";

    // if sentence and array are not empty, find longestword
    if (!sentence.isEmpty() && wordArray.length > 0) {
      for (int i = 0; i < wordArray.length; i++) {
        if (wordArray[i].length() > longestWord.length()) {
          longestWord = wordArray[i];
        }
      }
      System.out.printf("\nThe longest word in the sentence is: %s", longestWord);
    } else {
      System.out.printf("No words were inserted");
    }
  }
}
