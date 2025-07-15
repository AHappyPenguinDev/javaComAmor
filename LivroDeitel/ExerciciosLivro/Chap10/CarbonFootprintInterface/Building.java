
public class Building implements CarbonFootprint {

  public Building(double kiloWattHours) {
    this.kiloWattHours = kiloWattHours;
  }

  private double kiloWattHours;

  public double getCarbonFootprint() {
    return kiloWattHours * 0.994;
  }

  @Override
  public String toString() {
    return String.format("Building");
  }
}
