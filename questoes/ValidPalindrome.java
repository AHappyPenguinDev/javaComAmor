
// tamanho = 5 (if i = 0 {charArray[char.length - i+1;]} else {})
//0 1 2 3 4  como ir de 4 - 0 ? (4 3 2 1 0)
// char[0] = char[5 - (0+1)] (4)
// char[1] = char[5 - (1+1)] (3)
// char[2] = char[5 - (2+1)] (2)
// char[3] = char[5 - (3+1)] (1)
// char[4] = char[5 - (4+1)] (0)

import java.util.Scanner;

public class ValidPalindrome {
  private static final int minNumber = 1;
  private static final int maxNumber = (int) (2.00 * (Math.pow(10, 5)));
  public char[] charArray;

  public static String verifyInput(String inputString) {
    inputString = inputString.replaceAll("[^a-zA-Z0-9]", " ");
    return inputString;
  }

  public static void checkPalindrome(char[] charArray) {
    int x = 0;
    String word = "";
    String wordBack = "";
    final int charArrayLength = charArray.length;

    for (int i = 0; i < charArrayLength; i++) {
      x = i + 1;
      word += charArray[i];
      wordBack += charArray[charArrayLength - x];
      System.out.printf("word = %s       and%13s= %s\n", word, "wordback", wordBack);
    }
    if (word.equals(wordBack)) {
      System.out.printf("%s is equals to %s, meaning it is a palindrome!", word, wordBack);
    } else {
      System.out.printf("\n This is not a palindrome");
    }
  }

  public static void main(String args[]) {
    // get String
    // check how many chars
    // check if is between 1 and 2000000
    Scanner scanner = new Scanner(System.in);
    ValidPalindrome validPalindrome = new ValidPalindrome();
    System.out.printf("Please insert a string: ");
    String inputString = verifyInput(scanner.next());

    if (inputString.length() >= minNumber && inputString.length() <= maxNumber) {
      validPalindrome.charArray = inputString.toLowerCase().toCharArray();
      checkPalindrome(validPalindrome.charArray);
    } else {
      System.out.println("Please insert a valid string");
    }

  }
}
