package TwoDimensionalShape;

public class Square extends TwoDimensionalShape {

  double side;

  public Square(double side) {
    this.side = side;
  }

  @Override
  public double getArea() {
    return Math.pow(side, 2);
  }
}
