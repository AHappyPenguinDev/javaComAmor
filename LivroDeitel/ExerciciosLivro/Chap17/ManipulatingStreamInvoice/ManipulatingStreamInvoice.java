import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class ManipulatingStreamInvoice {

  public static void sortByPartDescription(List<Invoice> list) {
    Function<Invoice, String> byPartDescription = Invoice::getPartDescription;
    System.out.printf("%nSorted by Part description:%n");
    list.stream() // Stream<Invoice>
        .sorted(Comparator.comparing(byPartDescription))
        .forEach(System.out::println);
  }

  public static void sortByPartNumber(List<Invoice> list) {
    Function<Invoice, Integer> byPartNumber = Invoice::getPartNumber;
    System.out.printf("%nSorted by Part number:%n");
    list.stream() // Stream<Invoice>
        .sorted(Comparator.comparing(byPartNumber))
        .forEach(System.out::println);
  }

  public static void sortByQuantity(Invoice[] invoices) {
    Function<Invoice, Integer> byQuantity = Invoice::getQuantity;
    System.out.printf("%nSorted by quantity:%n");
    Arrays.stream(invoices)
        .sorted(Comparator.comparing(byQuantity))
        .map(invoice -> String.format("%s: %d", invoice.getPartDescription(), invoice.getQuantity()))
        .forEach(System.out::println);
  }

  public static void sortByInvoiceValue(Invoice[] invoices) { // Need to map to payment amount and quantity, then sort
    Function<Invoice, Double> byPaymentAmount = Invoice::getPaymentAmount;
    Predicate<Invoice> range = i -> (i.getPaymentAmount() >= 200.00 && i.getPaymentAmount() <= 500.00);

    System.out.printf("%nSorted by invoice value:%n");
    Arrays.stream(invoices)
        .sorted(Comparator.comparing(byPaymentAmount))
        .filter(range)
        .map(invoice -> String.format("%s: %.2f", invoice.getPartDescription(), invoice.getPaymentAmount()))
        .forEach(System.out::println);
  }

  public static void findSaw(Invoice[] invoices) {
    Predicate<Invoice> containsSaw = invoice -> (invoice.getPartDescription().toLowerCase().contains("saw"));
    System.out.printf("%nInvoice(s) that contain the word \"saw\":%n");

    Arrays.stream(invoices)
        .filter(containsSaw)
        .sorted(Comparator.comparing(Invoice::getPartDescription))
        .forEach(System.out::println);
  }

  public static void main(String[] args) {
    Invoice[] invoices = {
        new Invoice(83, "Electric sander", 7, 7.98),
        new Invoice(24, "Power saw", 18, 99.99),
        new Invoice(7, "Sledge hammer", 11, 21.50),
        new Invoice(77, "Hammer", 76, 11.99),
        new Invoice(39, "Lawn mower", 3, 79.50),
        new Invoice(68, "Screw driver", 106, 6.99),
        new Invoice(56, "Jig saw", 21, 11.00),
        new Invoice(3, "Wrench", 34, 7.50)
    };

    List<Invoice> list = Arrays.asList(invoices);

    sortByPartDescription(list);
    sortByPartNumber(list);
    sortByQuantity(invoices);
    sortByInvoiceValue(invoices);
    findSaw(invoices);
  }
}
