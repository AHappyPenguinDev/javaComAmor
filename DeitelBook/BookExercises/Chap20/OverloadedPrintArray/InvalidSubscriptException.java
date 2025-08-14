//If I had extended Expcetion I would need to use try catch, so I extended RuntimeException

public class InvalidSubscriptException extends RuntimeException {
  // default message
  public InvalidSubscriptException() {
    this("Invalid Subscript Exception");
  }

  // optional message
  public InvalidSubscriptException(String m) {
    super(m);
  }
}
