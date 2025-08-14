
public class TransactionRecord {
  private int accountNumber;
  private double transactionAmount;

public TransactionRecord() {
    this.(0, 0.0);
 }

  public TransactionRecord(int accountNumber, double transactionAmount) {
    this.accountNumber = accountNumber;
    this.transactionAmount = transactionAmount;
  }

  public int getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(int accountNumber) {
    this.accountNumber = accountNumber;
  }

  public double getTransactionAmount() {
    return transactionAmount;
  }

  public void setTransactionAmount(double transactionAmount) {
    this.transactionAmount = transactionAmount;
  }

}
