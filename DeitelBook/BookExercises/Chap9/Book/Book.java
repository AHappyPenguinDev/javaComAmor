
public class Book {
  public final String title;
  public final int yearOfPublication;
  public final String author;

  // Initialize attributes
  public Book(String title, int yearOfPublication, String author) {
    this.title = title;
    this.yearOfPublication = yearOfPublication;
    this.author = author;
  }

  @Override
  public String toString() {
    return String.format(
      "Book title: %s%nYear of Publication: %d%nAuthor: %s",
      title, yearOfPublication, author);
  }
}
