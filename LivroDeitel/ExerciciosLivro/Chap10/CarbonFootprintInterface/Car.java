
public class Car implements CarbonFootprint {
  private String typeOfCar;
  private int totalDrivenMiles;
  private int milesPerGallon;

  public Car(String typeOfCar, int totalDrivenMiles, int milesPerGallon) {
    this.typeOfCar = typeOfCar;
    this.totalDrivenMiles = totalDrivenMiles;
    this.milesPerGallon = milesPerGallon;
  }

  @Override
  public double getCarbonFootprint() {
    double gallonsOfFuel = totalDrivenMiles / milesPerGallon;
    double conversionFactor = 19.6;
    return gallonsOfFuel * conversionFactor;
  }

  @Override
  public String toString() {
    return String.format("Car");
  }
}
