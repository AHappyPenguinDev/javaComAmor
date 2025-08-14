
public class CarbonFootprintTest {

  public static void main(String[] args) {

    CarbonFootprint[] carbonFootprint = new CarbonFootprint[] {
        new Car("medium", 8000, 40),
        new Bycicle(),
        new Building(4)
    };

    for (CarbonFootprint footprint : carbonFootprint) {
      if (footprint instanceof Building) {
        System.out.printf("%nThing: %s %nCarbon foot print: %.2flbs%n", footprint, footprint.getCarbonFootprint());
        continue;
      }
      System.out.printf("%nThing: %s %nCarbon foot print: %.2fKg%n", footprint, footprint.getCarbonFootprint());
    }
  }
}
