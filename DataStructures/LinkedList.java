class Node<E> {
    public Node(E val) {
        this.val = val;
        this.next = null;
    }

    public E val;
    public Node<E> next;

}

public class LinkedList {
    public static void main(String[] args) {
        Node<Character> a = new Node<Character>('A');
        Node<Character> b = new Node<Character>('B');
        Node<Character> c = new Node<Character>('C');
        Node<Character> d = new Node<Character>('D');
        
        a.next = b;
        b.next = c;
        c.next = d;

        long start = System.nanoTime();
        printList(a); 
        long end = System.nanoTime();
        double elapsedMillis = (end-start) / 1_000_000.0;
        System.out.printf("Time elapsed: %.4f milliseconds\n", elapsedMillis);
    }

    // public static <E> void printList(Node<E> head) {
    //     Node<E> current = head;
    //     while(current != null) {
    //         System.out.println(current.val);
    //         current = current.next;
    //     }
    // } 
    //

    public static <E> void printList(Node<E> head) {
        if(head == null)
            return;

        System.out.println(head.val);
        printList(head.next);
    }

}
