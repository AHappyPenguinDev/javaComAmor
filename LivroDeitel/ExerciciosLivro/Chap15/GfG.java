
// Java implementation to print all possible
// letter combinations using recursion
import java.util.ArrayList;

class GfG {

  // Recursive function to generate combinations
  static void possibleWordsRec(int[] arr, int index, StringBuilder prefix,
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
      possibleWordsRec(arr, index + 1, prefix, padMap, res);
      return;
    }

    // Place all possible letters for this digit
    for (char ch : padMap[digit].toCharArray()) {
      prefix.append(ch);
      possibleWordsRec(arr, index + 1, prefix, padMap, res);
      prefix.deleteCharAt(prefix.length() - 1);
    }
  }

  // Function to find all possible letter combinations
  static ArrayList<String> possibleWords(int[] arr) {
    ArrayList<String> res = new ArrayList<>();
    String[] padMap = { "", "", "abc", "def", "ghi", "jkl",
        "mno", "pqrs", "tuv", "wxyz" };

    StringBuilder prefix = new StringBuilder();

    possibleWordsRec(arr, 0, prefix, padMap, res);
    return res;
  }

  public static void main(String[] args) {
    int[] arr = { 2, 3 };
    ArrayList<String> words = possibleWords(arr);

    for (String word : words)
      System.out.print(word + " ");
  }
}
