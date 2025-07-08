//Enter list of strings import java.util.Arrays;  
import java.util.List;  
import java.util.Arrays;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ManipulatingStrings {
  public static void run() {

    StringBuilder buffer = new StringBuilder();
    Scanner scanner = new Scanner(System.in);
    String input = "";
    
    //prompts user to enter their string
    while(true) {
      System.out.printf("Input a string or type # to return the strings\n");
      input = scanner.nextLine();
      
      if(input.equals("#")) {
        scanner.close();
        break;
      }

      buffer.append(input + "\n");
    }

    //create pattern and matcher classes for regex matching
    Pattern regex = Pattern.compile("[^a-zA-Z0-9]");
    Matcher matcher = regex.matcher(buffer.toString());

    //create a stringArray with buffer's split elements 
    ArrayList<String> stringArrayList = Arrays.asList(buffer.toString().split("\n"));
    System.out.println("STRING ARRAY LIST ELEMENTS: " + stringArrayList);
    ArrayList<String> specialCharactersStringArrayList = new ArrayList<>();

    for (int i = 0; i < stringArrayList.length; i++) {
      Matcher matcherStringArrayList = regex.matcher(stringArrayList);

      if(matcherStringArrayList.find()) {
        specialCharactersStringArrayList.add(matcher.group());
        System.out.println("STRING ARRAY LIST ELEMENTS: " + stringArrayList);
      }
    }
    
    
    ////print stringArray elements
    //System.out.println("StringArray Elements:");
    //for(String string : stringArray) {
    //  System.out.println(string);
    //}
    //
    ////store stringArray's elements inside of arraylist stringArray
    //ArrayList<String> stringList = new ArrayList<String>(Arrays.asList(stringArray));
    //ArrayList<String> specialStringList = new ArrayList<>();
    //
    //System.out.println("StringList Elements: "+ stringList);
    //
    //String fodase;
    //for(int i = 0; i < stringArray.length; i++) {
    //  //Foda-se
    //  fodase = stringList.get(i);
    //
    //  Matcher matcherFodase = regex.matcher(fodase);   
    //  if(matcherFodase.find()) {
    //    specialStringList.set(i, fodase.substring(0, 1).toUpperCase());
    //  }
    //
    //  if(stringArray[i].matches("[^a-zA-Z0-9]")) {
    //    specialStringList.add(stringArray[i]);
    //    System.out.println("SpecialStringList Elements: " + specialStringList);
    //    stringList.remove(i);
    //  }
    //}
    //
    //// printArrays(stringList, specialStringList);
  }

  // private void displayString(String[] rawStringArray, String noSpecialCharactersStringArray[]) {
  //   for (i = 0;  i < rawStringArray.length; i++) {
  //
  //   }
  // }
  
  public static void main(String[] args) {
    run();
  }
}
