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
      String socialSecurityNumber, Date birthDate, Date paymentDate) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.socialSecurityNumber = socialSecurityNumber;
    this.birthDate = birthDate;
    this.paymentDate = paymentDate;
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

  public String getPaymentDate() {
    return paymentDate.getMonthAndDate();
  }

  // 1/2/2000
  // current month -> days in month + paymentMonth -> days in paymentMonth ;
  // if difference between months is greater than 1, check months in between and
  // their respective amounts of days. Then sum everything up
  //
  public int checkDaysLeftForPayment() {

      
  }

  // return String representation of Employee object
  @Override
  public String toString() {
    return String.format("%s %s%nsocial security number: %s",
        getFirstName(), getLastName(), getSocialSecurityNumber());
  }

  // abstract method must be overridden by concrete subclasses
  public abstract double earnings(); // no implementation here
}

/**************************************************************************
 * (C) Copyright 1992-2018 by Deitel & Associates, Inc. and *
 * Pearson Education, Inc. All Rights Reserved. *
 * *
 * DISCLAIMER: The authors and publisher of this book have used their *
 * best efforts in preparing the book. These efforts include the *
 * development, research, and testing of the theories and programs *
 * to determine their effectiveness. The authors and publisher make *
 * no warranty of any kind, expressed or implied, with regard to these *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or *
 * consequential damages in connection with, or arising out of, the *
 * furnishing, performance, or use of these programs. *
 *************************************************************************/
