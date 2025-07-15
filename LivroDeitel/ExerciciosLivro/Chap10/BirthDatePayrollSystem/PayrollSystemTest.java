// Fig. 10.9: PayrollSystemTest.java
// Employee hierarchy test program.

public class PayrollSystemTest {
  public static void main(String[] args) {

    // create subclass objects
    SalariedEmployee salariedEmployee = new SalariedEmployee(
        "John", "Smith", "111-11-1111", 800.00, new Date(1, 2, 2000));
    HourlyEmployee hourlyEmployee = new HourlyEmployee(
        "Karen", "Price", "222-22-2222", 16.75, 40, new Date(3, 8, 1985));
    CommissionEmployee commissionEmployee = new CommissionEmployee(
        "Sue", "Jones", "333-33-3333", 10000, .06, new Date(5, 10, 1999));
    BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee(
        "Bob", "Lewis", "444-44-4444", 5000.00, .04, 300.00, new Date(1, 25, 2001));

    // create four-element Employee array
    Employee[] employees = new Employee[4];
    employees[0] = salariedEmployee;
    employees[1] = hourlyEmployee;
    employees[2] = commissionEmployee;
    employees[3] = basePlusCommissionEmployee;

    // initialize current date to check if is payment date
    Date currentDate = new Date(5, 10, 2025);

    // generically process each element in array employees
    for (Employee currentEmployee : employees) {
      System.out.println(currentEmployee); // invokes toString
      //
      // determine whether element is a BasePlusCommissionEmployee
      if (currentEmployee instanceof BasePlusCommissionEmployee) {
        // downcast Employee reference to
        // BasePlusCommissionEmployee reference
        BasePlusCommissionEmployee employee = (BasePlusCommissionEmployee) currentEmployee;
        employee.setBaseSalary(1.10 * employee.getBaseSalary());

        System.out.printf(
            "New base salary with 10%% increase is: $%,.2f%n",
            employee.getBaseSalary());
      }

      double earnings = currentEmployee.earnings();

      // Check for birthday bonus
      if (currentEmployee.isBirthday(currentDate, currentEmployee.getBirthDate())) {
        System.out.printf("***BIRTHDAY BONUS: $100.00***%n");
        earnings += 100.00;
      }

      System.out.printf("Earned: $%,.2f%n%n", earnings);
    }

    // get type name of each object in employees array
    for (int j = 0; j < employees.length; j++) {
      System.out.printf("Employee %d is a %s%n", j,
          employees[j].getClass().getName());
    }
  }
}
