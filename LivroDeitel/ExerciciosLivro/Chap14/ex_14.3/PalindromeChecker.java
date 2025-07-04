// A palindrome is a word that reads the same both forward and backward, such as
// 'radar' and 'madam'. Write an application to check if a string entered by the
// user is a palindrome or not

//split sentence into tokens
//compare token with StringBuilders's reverse method

import java.util.Scanner;

public class PalindromeChecker {
  private String input;

  public PalindromeChecker(String input) {
    this.input = input;
  }

  public void treat() {
    input = input.replaceAll("\\s", "").toLowerCase();
    System.out.println("This is the \"treated\" String: " + input);
  }

  public boolean checkPalindrome() {
    StringBuilder buffer = new StringBuilder(input);
    buffer.reverse();
    String reversedInput = buffer.toString();
    System.out.println("Input = " + input);
    System.out.println("Reversed Input = " + reversedInput);
    return input.equals(reversedInput);
  }

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter a word or a sentence");
    String input = scanner.nextLine();

    PalindromeChecker palindromeChecker = new PalindromeChecker(input);
    palindromeChecker.treat(); // removes uppercase letters and spaces
    System.out.printf("%nIs the String a palindrome? %s", palindromeChecker.checkPalindrome() ? "Yes" : "No");

    // StringBuilder buffer = new StringBuilder(input.toLowerCase());
    // System.out.println("Buffer: " + buffer.toString());

    // Reverse Buffer
    // buffer.reverse();
    // String reversedInput = buffer.toString();
    // System.out.println("Buffer: " + buffer.toString());
  }
}
