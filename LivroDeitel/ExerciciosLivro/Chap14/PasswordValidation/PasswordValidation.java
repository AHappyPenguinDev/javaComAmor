//14.6 
//A website only lets users set a password if the password contains between 8 and 15 characters (Rule 1) 8 > String.lenght() < 15
//Starts with an alphabetical character (Rule 2) String.charAt(0).equals(a-z)
//Contains at least one uppercase letter (Rule 3) String.toCharArray() -> Loop through chars 
//Contains at least one number (Rule 4) String.toCharArray() -> Loop through chars 

// I want to validate the characters in real time as the user inserts the passwords
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidation {

  // public static String missingPasswordRule(String match) {
  // System.out.println(match);
  // }

  public static void main(String[] args) {
    String input = args[0];

    Pattern regex = Pattern.compile("^(?=[a-zA-Z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=]).{8,15}$");
    Matcher matcher = regex.matcher(input);

    while (matcher.find()) {
      // missingPasswordRule(matcher.group());
      System.out.printf("Password valid?  %s", matcher.group().isEmpty() ? "false" : "true");
    }

    // System.out.printf("The password needs to %s", missingPasswordRule());
  }

}
