import java.util.Scanner;

public class SentenceWordsReversed {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Input text to be reversed: ");
    String input = scanner.nextLine();
    scanner.close();

    String[] wordArray = input.split("\\s");
    for (int i = 0; i < wordArray.length; i++) {
      StringBuilder buffer = new StringBuilder(wordArray[i]);
      buffer.reverse();
      System.out.print(buffer.toString() + " ");
    }
  }
}
