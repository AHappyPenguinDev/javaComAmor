package com.deitel.datastructures;

import java.util.List;

class ListNode<E extends Number> {
  // package access members; List can access these directly
  E data; // data for this node
  ListNode<E> nextNode; // reference to the next node in the list

  // constructor creates a ListNode that refers to object
  ListNode(E object) {
    this(object, null);
  }

  // constructor creates ListNode that refers to the specified
  // object and to the next ListNode
  ListNode(E object, ListNode<E> node) {
    data = object;
    nextNode = node;
  }

  // return reference to data in node
  E getData() {
    return data;
  }

  // return reference to next node in list
  ListNode<E> getNext() {
    return nextNode;
  }
}

// class List definition
public class BreakPointList<E extends Number> {
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

  // insert item at front of List
  public void insertAtFront(E insertItem) {
    if (isEmpty()) { // firstNode and lastNode refer to same object
      firstNode = lastNode = new ListNode<E>(insertItem);
    } else { // firstNode refers to new node
      firstNode = new ListNode<E>(insertItem, firstNode);
    }
  }

  // insert item at end of List
  public void insertAtBack(E insertItem) {
    if (isEmpty()) { // firstNode and lastNode refer to same object
      firstNode = lastNode = new ListNode<E>(insertItem);
    } else { // lastNode's nextNode refers to new node
      lastNode = lastNode.nextNode = new ListNode<E>(insertItem);
    }
  }

  // determine whether list is empty; returns true if so
  public boolean isEmpty() {
    return firstNode == null;
  }

  // output list contents
  public void print() {
    if (isEmpty()) {
      System.out.printf("Empty %s%n", name);
      return;
    }

    System.out.printf("The sorted %s is: [", name);
    ListNode<E> current = firstNode;

    // while not at end of list, output current node's data
    while (current != null) {
      System.out.printf("%d ", current.data);
      current = current.nextNode;
    }

    System.out.println("]");
  }

  public void breakPoint(List<E> list) {
    // Initialize linked list with list's elements
    for (int i = 0; i < list.size(); i++) {
      if (isEmpty()) {
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
        System.out.printf("Current (%d) is less than Next Current (%d)%n", current.data, nextCurrent.data);
        builder.append(current.data + ", ");
      }

      if ((Integer) current.data > (Integer) nextCurrent.data) {
        builder.append(current.data);
        break; // if not sorted, break loop
      }

      ListNode<E> temp = current.nextNode;
      current = nextCurrent;
      nextCurrent = temp.nextNode;
      System.out.printf("Assigning %d to current and %d to next current%n", nextCurrent.data, temp.data);
    }

    System.out.printf("List until breaking point: [%s] %n", builder.toString());
  }
}
