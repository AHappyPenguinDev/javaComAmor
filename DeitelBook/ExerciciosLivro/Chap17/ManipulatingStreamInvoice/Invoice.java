// Fig. 10.12: Invoice.java
// Invoice class that implements Payable.

public class Invoice {
  private final int partNumber;
  private final String partDescription;
  private final int quantity;
  private final double pricePerItem;

  // constructor
  public Invoice(int partNumber, String partDescription, int quantity,
      double pricePerItem) {
    if (quantity < 0) { // validate quantity
      throw new IllegalArgumentException("Quantity must be >= 0");
    }

    if (pricePerItem < 0.0) { // validate pricePerItem
      throw new IllegalArgumentException(
          "Price per item must be >= 0");
    }

    this.quantity = quantity;
    this.partNumber = partNumber;
    this.partDescription = partDescription;
    this.pricePerItem = pricePerItem;
  }

  // get part number
  public int getPartNumber() {
    return partNumber;
  }

  // get description
  public String getPartDescription() {
    return partDescription;
  }

  // get quantity
  public int getQuantity() {
    return quantity;
  }

  // get price per item
  public double getPricePerItem() {
    return pricePerItem;
  }

  // return String representation of Invoice object
  @Override
  public String toString() {
    return String.format("%s(Part number: %d | Quantity: %d | Price per item: $%,.2f)",
        getPartDescription(), getPartNumber(), getQuantity(), getPricePerItem());
  }

  // method required to carry out contract with interface Payable
  public double getPaymentAmount() {
    return getQuantity() * getPricePerItem(); // calculate total cost
  }
}
