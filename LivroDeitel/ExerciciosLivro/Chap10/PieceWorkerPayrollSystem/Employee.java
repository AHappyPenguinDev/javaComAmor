// 10.13 Modify the payroll system of Fig 10.4-10.9 to include private instance
// variable birthDate in class Employee. Use class Date of Fig 8.7 to represent an employee's birthday. Add get methods to class Date. Assume that payroll is processed once per month. 
// Create an array of Employee variables to store references to the various
// employee objects. In a loop, calculate the payroll for each Employee
// Polymorphically, and add a $100.00 bonus to the person's payroll amount if
// the current month is the one in which the Employee's birthday occurs 

// Fig. 10.4: Employee.java
// Employee abstract superclass.

public abstract class Employee {
  private final String firstName;
  private final String lastName;
  private final String socialSecurityNumber;
  private final Date birthDate;
  private Date paymentDate;

  // constructor
  public Employee(String firstName, String lastName,
      String socialSecurityNumber, Date birthDate) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.socialSecurityNumber = socialSecurityNumber;
    this.birthDate = birthDate;
  }

  // return first name
  public String getFirstName() {
    return firstName;
  }

  // return last name
  public String getLastName() {
    return lastName;
  }

  // return social security number
  public String getSocialSecurityNumber() {
    return socialSecurityNumber;
  }

  public Date getBirthDate() {
    return birthDate;
  }

  public boolean isBirthday(Date currentDate, Date birthDate) {
    if (currentDate.getDay() == birthDate.getDay() &&
        currentDate.getMonth() == birthDate.getMonth())
      return true;

    return false;
  }

  // return String representation of Employee object
  @Override
  public String toString() {
    return String.format("%s %s%nSocial security number: %s",
        getFirstName(), getLastName(), getSocialSecurityNumber());
  }

  // abstract method must be overridden by concrete subclasses
  public abstract double earnings(); // no implementation here

}
