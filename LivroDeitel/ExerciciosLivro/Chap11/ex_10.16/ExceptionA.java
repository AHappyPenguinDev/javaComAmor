public class ExceptionA extends Exception {

  public ExceptionA(String message) {
    super("Exception A");
    super(message);
  }
}
