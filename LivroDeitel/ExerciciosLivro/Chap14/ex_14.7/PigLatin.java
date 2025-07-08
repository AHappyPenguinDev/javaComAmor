import java.util.Scanner;

public class PigLatin {

  public static void makePigLatin() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Insert the sentence");
    String sentence = scanner.nextLine();
    scanner.close();

    if (sentence != null && !sentence.trim().isEmpty()) {
      String[] wordArray = sentence.split("\\s");
      System.out.printf("\nPig Latin sentence split by space:\n");
      for (String word : wordArray) {
        StringBuilder buffer = new StringBuilder(word);
        buffer.append(buffer.charAt(0));
        buffer.append("ay ");
        buffer.deleteCharAt(0);
        String pigLatinWord = buffer.toString();
        printPigLatinWord(pigLatinWord);
      }
    }
  }

  private static void printPigLatinWord(String pigLatinWord) {
    System.out.printf("%s\n", pigLatinWord);
  }

  public static void main(String[] args) {
    makePigLatin();
  }
}
