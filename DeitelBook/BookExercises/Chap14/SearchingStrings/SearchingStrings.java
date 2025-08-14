import java.util.Scanner;

public class SearchingStrings {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Insert sentence: ");
    String sentence = scanner.nextLine();

    System.out.print("Insert character to search: ");
    char searchCharacter = scanner.next().charAt(0);

    int counter = 0;
    for (int i = 0; i < sentence.length(); i++) {
      if (sentence.indexOf(searchCharacter, i) == -1) {
        break;
      } 
      else {
        counter++;
        i = sentence.indexOf(searchCharacter, i);
      }
    }

    System.out.printf("There are %d occurrences of %c in the sentence", counter, searchCharacter);
  }
}
