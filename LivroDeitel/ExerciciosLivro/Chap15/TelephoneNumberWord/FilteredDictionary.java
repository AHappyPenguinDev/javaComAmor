//run to create a wordList.txt with only words with less than 6 letters using linux's local word list (I will put a copy in this folder)

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class FilteredDictionary {
  private String linuxLocalWordList = "linuxLocalWordList.txt";
  private String outputPath = "filteredWordList.txt";

  public void createFilteredDictionary(String[] phoneNumberMap, int[] digits) {
    try (BufferedReader reader = Files.newBufferedReader(Paths.get(linuxLocalWordList));
        BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputPath))) {

      ArrayList<Character> possibleChars = new ArrayList<>();
      for (int i = 0; i < digits.length; i++) {
        //
        // Skip 1s and 0s
        if (digits[i] < 2 || digits[i] > 9)
          continue;

        // Split 3 letters into String char array
        char[] currentLetters = phoneNumberMap[digits[i]].toCharArray();
        System.out.printf("\ncurrentLetters length: %d", currentLetters.length);
        System.out.printf("\npossibleChars length: %d", possibleChars.size());

        System.out.printf("\n\nCurrent three letters: %s", Arrays.toString(currentLetters));
        // Add char to arrayList
        for (char character : currentLetters) {
          System.out.printf("\nTo be added to possibleChars: %c", character);
          if (!possibleChars.contains(character))
            possibleChars.add(character);
        }
      }

      System.out.printf("\nPossible characters:%s ", possibleChars);

      // This is where I actually write to the file
      StringBuilder regexBuilder = new StringBuilder();
      regexBuilder.append("[");
      for (char c : possibleChars) {
        regexBuilder.append(c);
      }
      regexBuilder.append("]*"); // Match any number of the characters
      String regex = regexBuilder.toString();

      Pattern pattern = Pattern.compile(
          regex, Pattern.CASE_INSENSITIVE);

      System.out.printf("\nRegex builder: %s", regexBuilder.toString());

      String word;
      // Check if the word matches the regex
      while ((word = reader.readLine()) != null) {
        // Check if the word length is less than 7
        if (word.length() == 7) {
          Matcher matcher = pattern.matcher(word);
          // Create a regex pattern from possibleChars
          if (matcher.matches()) {
            System.out.printf("\nPossible word: %s", word);
            writer.write(word + "\n");
          }
        }
      }

    } catch (IOException e) {
      System.err.println("Error opening file");
    }
  }
}
