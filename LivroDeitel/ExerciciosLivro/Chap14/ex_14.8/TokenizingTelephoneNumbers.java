import java.util.Scanner;

public class TokenizingTelephoneNumbers {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Insert telephone number in the form (555) 555-5555: ");
    String telephoneNumber = scanner.nextLine();
    scanner.close();

    String[] tokenizedTelephoneNumber = telephoneNumber.split("[()\\s\\-]");

    for (int i = 0; i < tokenizedTelephoneNumber.length; i++)
      System.out.print(tokenizedTelephoneNumber[i]);
  }
}
