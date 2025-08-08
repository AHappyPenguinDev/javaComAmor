// Fig. 21.3: List.java
// ListNode and List class declarations.
package com.deitel.datastructures;

import java.util.NoSuchElementException;

// class to represent one node in a list
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
public class SortedList<E extends Number> {
  private ListNode<E> firstNode;
  private ListNode<E> lastNode;
  private String name; // string like "list" used in printing

  // constructor creates empty List with "list" as the name
  public SortedList() {
    this("list");
  }

  // constructor creates an empty List with a name
  public SortedList(String listName) {
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

  public void insertSorted(E[] insertItemsArray) {
    // keep sorted array, loop through and then insert at back for each
    Integer[] sortedIntegerArray = MergeSort.mergeSort(insertItemsArray);
    for (Integer integer : sortedIntegerArray)
      insertAtBack((E) integer);
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

}
