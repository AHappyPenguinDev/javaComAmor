
public class Bycicle implements CarbonFootprint {
  @Override
  public double getCarbonFootprint() {
    return 96.00;
  }

  @Override
  public String toString() {
    return String.format("Bycicle");
  }
}
