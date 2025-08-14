package TwoDimensionalShape;

public class Triangle extends TwoDimensionalShape {

  double base;
  double height;

  public Triangle(double base, double height) {
    this.base = base;
    this.height = height;
  }

  @Override
  public double getArea() {
    return 0.5 * (base * height);
  }

}
