import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Formatter;

public class PhoneNumberWordGenerator {

  // I need to take the fucking input (7 digit string)
  // and for each digit, i need to compare it to the phoneNumberChart, and for
  // it's corresponding char code,
  // append to a stringbuilder one of its values
  // but i don't need the three chars. I need one

  // .
  // .:;:.
  // .:;;;;;:.
  // ;;;;;
  // ;;;;;
  // ;;;;;
  // ;;;;; nevermind the rage please
  //
  // I went a bit over the task on this one, but I liked the recursive approach
  // much
  // more than having 20 thousand for loops like some other solutions
  // I got this solution from:
  // https://www.geeksforgeeks.org/dsa/find-possible-words-phone-digits/
  // If anyone ever sees this, try the combination 7364737 :)

  private static final String[] phoneNumberChars = { "", "", "ABC", "DEF", "GHI", "JKL", "MNO",
      "PRS", "TUV", "WXY" };

  public static String[] getPhoneNumberChars() {
    return phoneNumberChars;
  }

  static void generatePhoneNumberWordsRec(int[] arr, int index, StringBuilder prefix,
      String[] padMap, ArrayList<String> res) {
    // Base case: if the prefix length matches arr size
    if (index == arr.length) {
      res.add(prefix.toString());
      return;
    }

    // Get the corresponding digit
    int digit = arr[index];

    // Skip invalid digits
    if (digit < 2 || digit > 9) {
      generatePhoneNumberWordsRec(arr, index + 1, prefix, padMap, res);
      return;
    }

    // Place all possible letters for this digit
    for (char ch : padMap[digit].toCharArray()) {
      prefix.append(ch);
      generatePhoneNumberWordsRec(arr, index + 1, prefix, padMap, res);
      prefix.deleteCharAt(prefix.length() - 1);
    }
  }

  static ArrayList<String> generatePhoneNumberWords(String input, Scanner scanner) {
    // make digit string into int Array

    int[] arr = new int[input.length()];
    for (int i = 0; i < input.length(); i++) {
      arr[i] = Character.getNumericValue(input.charAt(i));
    }

    StringBuilder prefix = new StringBuilder();
    ArrayList<String> res = new ArrayList<>();

    generatePhoneNumberWordsRec(arr, 0, prefix, phoneNumberChars, res);

    System.out.printf("Would you like to search for any english words in the file? [y/n]\n");
    if (scanner.next().charAt(0) == 'y') {
      FilteredDictionary filteredDictionary = new FilteredDictionary();
      filteredDictionary.createFilteredDictionary(phoneNumberChars, arr);
    }
    return res;
  }

  static void generatePhoneNumberWordsFile(String path) {
    try (Scanner scanner = new Scanner(System.in);
        Formatter output = new Formatter(path);) {

      // Optional chart to visualize letters
      System.out.println("Would you like to print a phone keypad letters chart? [y/n]");
      char choice = scanner.next().charAt(0);

      if (choice == 'y') {
        System.out.printf("Printing chart\n");
        for (int i = 2; i < phoneNumberChars.length - 2; i++) {
          System.out.printf(" %d   ", i);
        }

        System.out.println();

        for (int i = 2; i < phoneNumberChars.length - 2; i++) {
          System.out.printf("%s  ", phoneNumberChars[i].replaceAll(" ", ""));
        }
      }

      // Input phone number
      System.out.printf("\nEnter a seven digit phone number that does not include 0 or 1 (Those will be ignored): ");

      while (true) {
        String input = scanner.next();

        if (input.matches("\\d{7}")) {
          ArrayList<String> phoneNumberFileContent = generatePhoneNumberWords(input, scanner);
          output.format("%s", phoneNumberFileContent);
          System.out.printf("\nPrinting content to be output to %s... \n\nOutput Written to %s Successfully!\n",
              path, path);

          break;
        }
        System.out.printf("Incorrect input, please try again: \n");
        continue;
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // public static void searchForWords(String phoneNumberFileContent) {
  // try (BufferedReader reader =
  // Files.newBufferedReader(Paths.get(linuxLocalWordList));) {
  // do {
  // String word = reader.readLine();
  // if (word.matches(""))
  // writer.write(word + "\n");
  // } while (reader.readLine() != null);
  // } catch (IOException e) {
  // System.err.println("Error opening file");
  // }
  // System.out.println(phoneNumberFileContent);
  // }

  // public static int generateFile(Path path) {
  // try (Formatter output = new Formatter(path);) {
  // return -1;
  // }
  // }

  public static void main(String[] args) {
    String path = "phoneNumber.txt";
    PhoneNumberWordGenerator.generatePhoneNumberWordsFile(path);

  }
}
