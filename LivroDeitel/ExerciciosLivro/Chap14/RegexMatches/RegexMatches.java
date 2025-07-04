import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches {
  public static void main(String[] args) {
    // create regular expression
    // Pattern expression =
    // Pattern.compile("[jJ].*[0-3][0-35-9]-[0-3]\\d-(?:19|20)\\d{2}|\\d{2}");
    Pattern expression = Pattern.compile("[jJ].*[0-3][0-35-9]-[0-3]\\d-(?:19|20)?\\d{2}|\\b\\d{2}\\b");

    String string1 = "Jane's Birthday is 05-12-1975\n" +
        "Dave's birthday is 11-06-68\n" +
        "John's birthday is 04-28-73\n" +
        "Joe's birthday is 12-17-77";

    // match regular expression to string and print matches
    Matcher matcher = expression.matcher(string1);

    while (matcher.find()) { // find occurrence of regex pattern within given string
      System.out.println(matcher.group()); // prints value of the match
    }
  }
}
