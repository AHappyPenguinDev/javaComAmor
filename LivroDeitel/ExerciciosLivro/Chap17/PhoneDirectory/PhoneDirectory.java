import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PhoneDirectory {
  public static void main(String[] args) {
    createPhoneDirectoryFile();
    readPhoneDirectoryFile();
  }

  public static void createPhoneDirectoryFile() {
    try (BufferedWriter outputNumber = Files.newBufferedWriter(Paths.get("recordsByNumber.txt"));
        BufferedWriter outputName = Files.newBufferedWriter(Paths.get("recordsByName.txt"))) {

      // List<PhoneRecord> phoneRecordsNumber = new ArrayList<>();
      // List<PhoneRecord> phoneRecordsName = new ArrayList<>(); // this was Records

      PhoneRecord[] phoneRecordsArray = {
          new PhoneRecord("Smith", "John", "956-5078"),
          new PhoneRecord("Bittencourt", "Charline", "067-3476"),
          new PhoneRecord("Aquino", "João", "999-9999"),
          new PhoneRecord("Pitt", "Brad", "311-2564"),
          new PhoneRecord("Kojima", "Hideo", "213-4568"),
          new PhoneRecord("Carvalho", "Olavo", "011-9973")
      };

      PhoneRecord[] sortedByNumber = sortPhoneRecordsByNumber(phoneRecordsArray);
      PhoneRecord[] sortedByName = sortPhoneRecordsByName(phoneRecordsArray);

      for (PhoneRecord phoneRecord : sortedByNumber) {
        outputNumber.write(String.format("%s %s %s %n",
            phoneRecord.getLastName(), phoneRecord.getFirstName(), phoneRecord.getPhoneNumber()));
      }

      for (PhoneRecord phoneRecord : sortedByName) {
        outputName.write(String.format("%s %s %s %n",
            phoneRecord.getLastName(), phoneRecord.getFirstName(), phoneRecord.getPhoneNumber()));
      }
    } catch (IOException ioException) {

      System.err.println("What the heeeeeeeeeeell");
    }
  }

  public static PhoneRecord[] sortPhoneRecordsByNumber(PhoneRecord[] phoneRecordArray) {
    Function<PhoneRecord, Integer> byPhoneNumber = PhoneRecord::getPhoneNumberNoPunct; // returns phoneN as int so it
                                                                                       // can be sorted
    Comparator<PhoneRecord> compareByPhoneNumber = Comparator.comparing(byPhoneNumber);

    // Set has no duplicates
    Set<PhoneRecord> phoneRecordsSet = new HashSet<>(Arrays.asList(phoneRecordArray));
    List<PhoneRecord> list = phoneRecordsSet.stream().sorted(compareByPhoneNumber).collect(Collectors.toList());

    return list.toArray(new PhoneRecord[0]);
  }

  public static PhoneRecord[] sortPhoneRecordsByName(PhoneRecord[] phoneRecordArray) {
    Function<PhoneRecord, String> byFirstName = PhoneRecord::getFirstName;
    Function<PhoneRecord, String> byLastName = PhoneRecord::getLastName;

    Comparator<PhoneRecord> lastThenFirst = Comparator.comparing(byLastName).thenComparing(byFirstName);

    Set<PhoneRecord> phoneRecordsSet = new HashSet<>(Arrays.asList(phoneRecordArray));
    List<PhoneRecord> list = phoneRecordsSet.stream().sorted(lastThenFirst).collect(Collectors.toList());

    return list.toArray(new PhoneRecord[0]);
  }

  public static void readPhoneDirectoryFile() {
    try (BufferedReader inputByNumber = Files.newBufferedReader(Paths.get("recordsByNumber.txt"));
        BufferedReader inputByName = Files.newBufferedReader(Paths.get("recordsByName.txt"))) {

      List<PhoneRecord> phoneRecordsNumber = new ArrayList<>();
      List<PhoneRecord> phoneRecordsName = new ArrayList<>();

      Path pathNumber = Paths.get("recordsByNumber.txt");
      Path pathName = Paths.get("recordsByName.txt");

      try (Stream<String> lines = Files.lines(pathNumber)) {
        lines.forEachOrdered(line -> {
          String[] parts = line.split(" ");
          PhoneRecord record = new PhoneRecord(parts[0], parts[1], parts[2]);
          phoneRecordsNumber.add(record);
        });
      } catch (IOException e) {
        e.printStackTrace();
      }

      try (Stream<String> lines = Files.lines(pathName)) {
        lines.forEachOrdered(line -> {
          String[] parts = line.split(" ");
          PhoneRecord record = new PhoneRecord(parts[0], parts[1], parts[2]);
          phoneRecordsName.add(record);
        });
      } catch (IOException e) {
        e.printStackTrace();
      }

      System.out.printf("%nRecords sorted by Phone Number%n%-15s%-15s%-15s%n",
          "First Name", "Last Name", "Phone Number");

      for (PhoneRecord record : phoneRecordsNumber) {
        System.out.printf("%-15s%-15s%-15s%n",
            record.getFirstName(), record.getLastName(), record.getPhoneNumber());
      }

      System.out.printf("%nRecords sorted by Last and then first Name%n%-15s%-15s%-15s%n",
          "Last Name", "First Name", "Phone Number");
      for (PhoneRecord record : phoneRecordsName) {
        System.out.printf("%-15s%-15s%-15s%n",
            record.getLastName(), record.getFirstName(), record.getPhoneNumber());
      }
    } catch (IOException ioException) {
      System.err.println("What the dog doin");
    }
  }

}
