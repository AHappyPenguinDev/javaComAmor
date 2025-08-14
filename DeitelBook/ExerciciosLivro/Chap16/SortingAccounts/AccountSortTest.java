import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AccountSortTest {
  public static void main(String[] args) {
    List<Account> list = new ArrayList<>();

    list.add(new Account(143, "Alex", "Korniskus", 520.00));
    list.add(new Account(144, "João", "Maladeviagem", 380.00));
    list.add(new Account(145, "Maria", "Aspirador", 1000.00));
    list.add(new Account(146, "Gavin", "Woooow", 756.00));
    list.add(new Account(147, "Herald", "Boom", 102.00));

    System.out.printf("Unsorted array elements: %n%s%n", list);

    Collections.sort(list, new AccountComparator().reversed());

    // output List elements
    System.out.printf("Sorted list elements:%n%s%n", list);
  }
}
