import java.util.InputMismatchException;
import java.util.Scanner;

public class ComparingPortionsOfStrings {

    public static void run() {
        String choice = "";
        String s1;
        String s2;
        int s1StartingIndex;
        int s2StartingIndex;
        int characterComparedAmount;
        boolean isCaseSensitive;

        Scanner scanner = new Scanner(System.in);

        while (!choice.equals("9")) {
          try {
            System.out.println("\nInsert 1 to compare String regions, 9 to quit");
            choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.println("First string to compare");
                s1 = scanner.nextLine();
                System.out.println("Insert the starting index you want to compare in the first string [Starts at 0]");
                s1StartingIndex = Integer.parseInt(scanner.nextLine());
                System.out.println("Second string to compare");
                s2 = scanner.nextLine();
                System.out.println("Insert the starting index you want to compare in the second string [Starts at 0]");
                s2StartingIndex = Integer.parseInt(scanner.nextLine());
                System.out.println("Insert how many characters should be compared");
                characterComparedAmount = Integer.parseInt(scanner.nextLine());
                System.out.println("Ignore case? [y/n]");
                isCaseSensitive = scanner.nextLine().equals("y");
                System.out.println(isCaseSensitive);

                if (s1StartingIndex < 0 || s2StartingIndex < 0 ||
                    s1StartingIndex + characterComparedAmount > s1.length() ||
                    s2StartingIndex + characterComparedAmount > s2.length()) {
                    System.out.println("Invalid indices or character count.");
                    continue;
                }

                if (s1.regionMatches(isCaseSensitive, s1StartingIndex, s2, s2StartingIndex, characterComparedAmount)) {
                    System.out.printf("\nCharacters %s and %s match%n",
                            s1.substring(s1StartingIndex, s1StartingIndex + characterComparedAmount),
                            s2.substring(s2StartingIndex, s2StartingIndex + characterComparedAmount));
                } else {
                    System.out.printf("\nCharacters %s and %s don't match%n",
                            s1.substring(s1StartingIndex, s1StartingIndex + characterComparedAmount),
                            s2.substring(s2StartingIndex, s2StartingIndex + characterComparedAmount));
                }
            }
            } catch (InputMismatchException e) {
                System.out.println("Please insert the correct input");
                scanner.nextLine(); // Clear the invalid input
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Index out of bounds. Please check your indices.");
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        run();
    }
}

