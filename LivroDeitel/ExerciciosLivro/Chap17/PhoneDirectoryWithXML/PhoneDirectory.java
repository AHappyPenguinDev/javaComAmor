
//You need java 8 for this one. As from java8 onwards, javax.xml.bind has been removed
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.NoSuchElementException;

import javax.xml.bind.JAXB;

public class PhoneDirectory {
  public static void main(String[] args) {
    createPhoneDirectoryFile();
    readPhoneDirectoryFile();
  }

  public static void createPhoneDirectoryFile() {
    try (BufferedWriter output = Files.newBufferedWriter(Paths.get("phoneDirectoryRecords.xml"))) {

      PhoneRecords phoneRecords = new PhoneRecords();
      PhoneRecord[] phoneRecordsArray = {
          new PhoneRecord("Smith", "John", "956-5078"),
          new PhoneRecord("Bittencourt", "Charline", "067-3476"),
          new PhoneRecord("Pitt", "Brad", "311-2564"),
          new PhoneRecord("Kojima", "Hideo", "213-4568"),
      };

      for (PhoneRecord phoneRecord : phoneRecordsArray) {
        PhoneRecord record = phoneRecord;
        phoneRecords.getPhoneRecords().add(record);
      }
      JAXB.marshal(phoneRecords, output);

    } catch (IOException ioException) {
      System.err.println("What the heeeeeeeeeeell");
    }
  }

  // public static List<PhoneRecord[]> sortPhoneRecordsByNumbers(PhoneRecord[]
  // phoneRecordsArray) {
  // String regex = "[^0-9]";// match anything that is NOT a digit
  //
  // Arrays.asList(phoneRecordsArray).stream()
  //
  // }

  public static void readPhoneDirectoryFile() {
    try (BufferedReader input = Files.newBufferedReader(Paths.get("phoneDirectoryRecords.xml"))) {

      PhoneRecords phoneRecords = JAXB.unmarshal(input, PhoneRecords.class);

      System.out.printf("%-15s%-15s%-15s%n",
          "First Name", "Last Name", "Phone Number");

      for (PhoneRecord record : phoneRecords.getPhoneRecords()) {
        System.out.printf("%-15s%-15s%-15s%n",
            record.getFirstName(), record.getLastName(), record.getPhoneNumber());
      }
    } catch (IOException ioException) {
      System.err.println("What the dog doin");
    }
  }

}
