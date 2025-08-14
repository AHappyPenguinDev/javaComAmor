import java.util.Comparator;

public class AccountComparator implements Comparator<Account> {

  @Override
  public int compare(Account ac1, Account ac2) {
    double difference = ac1.getBalance() - ac2.getBalance();
    return (int) difference;
  }
}
