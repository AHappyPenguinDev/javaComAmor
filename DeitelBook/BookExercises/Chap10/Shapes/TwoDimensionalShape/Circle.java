package TwoDimensionalShape;

public class Circle extends TwoDimensionalShape {

  double radius;

  public Circle(double radius) {
    this.radius = radius;
  }

  public double getArea() {
    return Math.PI * Math.pow(radius, 2);
  }
}
