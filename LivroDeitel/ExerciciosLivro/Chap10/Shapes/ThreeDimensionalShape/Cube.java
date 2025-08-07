package ThreeDimensionalShape;

public class Cube extends ThreeDimensionalShape {

  double x;

  public Cube(double x) {
    this.x = x;
  }

  @Override
  public double getArea() {
    return 6 * Math.pow(x, 2);
  }

  @Override
  public double getVolume() {
    return Math.pow(x, 3);
  }
}
