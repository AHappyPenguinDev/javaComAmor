package ThreeDimensionalShape;

public class Tetrahedon extends ThreeDimensionalShape {

  double edge;

  public Tetrahedon(double edge) {
    this.edge = edge;
  }

  @Override
  public double getArea() {
    return Math.pow(edge, 2) * Math.sqrt(3);
  }

  @Override
  public double getVolume() {
    return 1.0 / 12 * Math.sqrt(2) * Math.pow(edge, 3);
  }
}
