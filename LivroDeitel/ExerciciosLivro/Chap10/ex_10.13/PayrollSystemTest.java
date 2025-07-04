// Fig. 10.9: PayrollSystemTest.java
// Employee hierarchy test program.

public class PayrollSystemTest {
  public static void main(String[] args) {

    // create subclass objects
    SalariedEmployee salariedEmployee = new SalariedEmployee(
        "John", "Smith", "111-11-1111", 800.00, new Date(1, 2, 2000), new Date(5, 10, 2025));
    HourlyEmployee hourlyEmployee = new HourlyEmployee(
        "Karen", "Price", "222-22-2222", 16.75, 40, new Date(3, 8, 1985), new Date(2, 5, 2025));
    CommissionEmployee commissionEmployee = new CommissionEmployee(
        "Sue", "Jones", "333-33-3333", 10000, .06, new Date(9, 4, 1999), new Date(5, 31, 2025));
    BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee(
        "Bob", "Lewis", "444-44-4444", 5000.00, .04, 300.00, new Date(1, 25, 2001), new Date(12, 3, 2025));

    // create four-element Employee array
    Employee[] employees = new Employee[4];

    // initialize array with Employees
    employees[0] = salariedEmployee;
    employees[1] = hourlyEmployee;
    employees[2] = commissionEmployee;
    employees[3] = basePlusCommissionEmployee;

    // initialize current date to check if is payment date
    public static Date currentDate = new Date(5, 10, 2025);

    // generically process each element in array employees
    for (Employee currentEmployee : employees) {

      // check if it's payday
      if (currentEmployee.checkDaysLeftForPayment() == 0) {
        System.out.println(currentEmployee); // invokes toString
        //
        // determine whether element is a BasePlusCommissionEmployee
        if (currentEmployee instanceof BasePlusCommissionEmployee) {
          // downcast Employee reference to
          // BasePlusCommissionEmployee reference
          BasePlusCommissionEmployee employee = (BasePlusCommissionEmployee) currentEmployee;
          employee.setBaseSalary(1.10 * employee.getBaseSalary());

          System.out.printf(
              "new base salary with 10%% increase is: $%,.2f%n",
              employee.getBaseSalary());
        }

        System.out.printf("earned $%,.2f%n%n",
            currentEmployee.earnings());
      } else {
        System.out.printf("Days left until payment: %s",
            currentEmployee.checkDaysLeftForPayment());
      }

    }

    // get type name of each object in employees array
    for (int j = 0; j < employees.length; j++) {
      System.out.printf("Employee %d is a %s%n", j,
          employees[j].getClass().getName());
    }
  }
}

// **************************************************************************
// * (C) Copyright 1992-2018 by Deitel & Associates, Inc. and *
// * Pearson Education, Inc. All Rights Reserved. *
// * *
// * DISCLAIMER: The authors and publisher of this book have used their *
// * best efforts in preparing the book. These efforts include the *
// * development, research, and testing of the theories and programs *
// * to determine their effectiveness. The authors and publisher make *
// * no warranty of any kind, expressed or implied, with regard to these *
// * programs or to the documentation contained in these books. The authors *
// * and publisher shall not be liable in any event for incidental or *
// * consequential damages in connection with, or arising out of, the *
// * f
