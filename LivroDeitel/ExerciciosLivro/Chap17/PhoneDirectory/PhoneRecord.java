public class PhoneRecord {
  private String lastName;
  private String firstName;
  private String phoneNumber;

  public PhoneRecord() {
    this("", "", "");
  }

  public PhoneRecord(String lastName, String firstName, String phoneNumber) {
    this.lastName = lastName;
    this.firstName = firstName;
    this.phoneNumber = phoneNumber;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public int getPhoneNumberNoPunct() {
    return Integer.parseInt(getPhoneNumber().replaceAll("[^0-9]", ""));
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  @Override
  public String toString() {
    return String.format("(%s:%s | %s:%s | %s:%s)",
        "Last name", getLastName(), "First Name", getFirstName(), "Phone Number", getPhoneNumber());
  }

}
