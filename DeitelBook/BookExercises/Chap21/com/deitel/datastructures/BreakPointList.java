package com.deitel.datastructures;

import java.util.List;

// class List definition
public class BreakPointList<E extends Number> extends SortedList<E> {
  private ListNode<E> firstNode;
  private ListNode<E> lastNode;
  private String name; // string like "list" used in printing

  // constructor creates empty List with "list" as the name
  public BreakPointList() {
    this("list");
  }

  // constructor creates an empty List with a name
  public BreakPointList(String listName) {
    name = listName;
    firstNode = lastNode = null;
  }

  public void breakPoint(List<E> list) {
    // Initialize linked list with list's elements
    for (int i = 0; i < list.size(); i++) {
      if (isEmpty()) {
        System.out.printf("List: %s%n", list);
        firstNode = lastNode = new ListNode<E>(list.get(i));
      } else {
        lastNode = lastNode.nextNode = new ListNode<E>(list.get(i));
      }
    }

    ListNode<E> current = firstNode;
    ListNode<E> nextCurrent = current.nextNode;
    StringBuilder builder = new StringBuilder();

    // Find break point of ascending sort
    while (nextCurrent != null) {
      // if current is greater than previous, then it's ascending
      if ((Integer) current.data <= (Integer) nextCurrent.data) {
        System.out.printf("Current (%d) is less than next(%d)%n", current.data, nextCurrent.data);
        builder.append(current.data + ", ");
      }

      if ((Integer) current.data > (Integer) nextCurrent.data) {
        builder.append(current.data);
        break; // if not sorted, break loop
      }

      ListNode<E> temp = current.nextNode;
      current = nextCurrent;
      nextCurrent = temp.nextNode;
      System.out.printf("Assigning %d to current and %d to next%n", nextCurrent.data, temp.data);
    }

    System.out.printf("List until breaking point: [%s] %n", builder.toString());
  }
}
