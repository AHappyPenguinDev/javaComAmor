
import com.deitel.datastructures.List;
import java.util.NoSuchElementException;

public class ListConcatenate {
  public static String concatenate(List<Character> l1, List<Character> l2) {
    return String.format(l1.toString() + " " + l2.toString());
  }

  public static void main(String[] args) {
    List<Character> list1 = new List<>();
    List<Character> list2 = new List<>();

    // insert integers in list
    list1.insertAtFront('H');
    list1.insertAtBack('e');
    list1.insertAtBack('l');
    list1.insertAtBack('l');
    list1.insertAtBack('o');

    list2.insertAtFront('W');
    list2.insertAtBack('o');
    list2.insertAtBack('r');
    list2.insertAtBack('l');
    list2.insertAtBack('d');

    System.out.printf("Concatenated lists: %s%n", concatenate(list1, list2));

  }
}
