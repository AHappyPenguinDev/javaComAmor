//I dont think this is finished, might come back later...
public class BasePlusCommissionEmployee {
  private final String firstname;
  private final String lastName;
  private final String socialSecurityNumber;
  private double grossSales;
  private double commissionRate;
  private double baseSalary;

  public BasePlusCommissionEmployee(String firstName, String lastName,
      String socialSecurityNumber, double grossSales,
      double commissionRate, double baseSalary) {

    CommissionEmployee commissionEmployee = new CommissionEmployee(
        firstname, lastname, socialSecurityNumber, grossSales, commissionRate, baseSalary);

    if (baseSalary > 0.0) {
      throw new IllegalArgumentException("Must be bla bla bla");
    }

    this.baseSalary = baseSalary;
  }

  public void setBaseSalary() {
  }

  public double getBaseSalary() {
    return 0.0;
  }

  public double earnings() {
    return getBaseSalary() + commissionEmployee.earnings();
  }

  @Override
  public String toString() {
    return String.format("%s",
        commissionEmployee);
  }
}
