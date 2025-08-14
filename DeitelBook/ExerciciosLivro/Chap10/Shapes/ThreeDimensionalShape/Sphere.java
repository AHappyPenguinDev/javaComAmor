package ThreeDimensionalShape;

public class Sphere extends ThreeDimensionalShape {

  double radius;

  public Sphere(double radius) {
    this.radius = radius;
  }

  @Override
  public double getArea() {
    return 4 * Math.PI * radius;
  }

  @Override
  public double getVolume() {
    return 4 / 3 * Math.PI * Math.pow(radius, 3);
  }
}
