public class PrintBook extends Book {
  public final String publisher;
  public final String isbn;

  public PrintBook(String title, String author, String publisher, String isbn, int yearOfPublication) {
    super(title, yearOfPublication, author);
    this.publisher = publisher;
    this.isbn = isbn;
  }

  @Override
  public StringtoString() {
    return String.format("%s%nPublisher: %s%nISBN: %s", super.toString(), publisher, isbn);
  }
}
