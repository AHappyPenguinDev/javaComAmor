
//Test if array letters changes when the list is reversed
//Yes, it changes. That is very weird

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Algorithms1 {

  private static void output(List<Character> listRef) {
    System.out.print("The list is: ");

    for (Character element : listRef) {
      System.out.printf("%s ", element);
    }

    System.out.printf("%nMax: %s", Collections.max(listRef));
    System.out.printf("%nMin: %s", Collections.min(listRef));
  }

  public static void main(String[] args) {
    // create and display a List<Character>
    Character[] letters = { 'P', 'C', 'M' };
    List<Character> list = Arrays.asList(letters); // get list
    System.out.println("list contains: ");
    output(list);

    // reverse and display the List<Character>
    Collections.reverse(list); // reverse order the elements
    System.out.printf("%nAfter calling reverse, list contains:%n");
    output(list);

    System.out.printf("%nLetters array after list calling reverse: %n");
    for (char letter : letters) {
      System.out.printf("%s, ", letter);
    }

    // output List information
  }
}
