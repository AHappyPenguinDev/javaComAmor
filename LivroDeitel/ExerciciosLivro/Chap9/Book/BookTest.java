public class BookTest {
  public static void main(String args[]) {
    
    PrintBook javaBook = 
      new PrintBook("Java How To Program", "Paul Deitel", "Deitel", "9-123-345-678", 2018);
    AudioBook Orwell1984 =
      new AudioBook("1984", "George Orwell", "Random guy", 1949, 100, 10000000);

    Book[] books = new Book[2]; 

    books[0] = javaBook;
    books[1] = Orwell1984;

    System.out.printf("Books processed polymorphically:%n%n");

    for(Book currentBook : books) {
      System.out.println(currentBook);
      System.out.println();
    }
  }
}
