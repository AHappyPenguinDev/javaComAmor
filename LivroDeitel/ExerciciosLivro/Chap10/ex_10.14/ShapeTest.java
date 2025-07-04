import ThreeDimensionalShape.*;
import TwoDimensionalShape.*;
import Shape.*;

public class ShapeTest {
  public static void main(String[] args) {

    Shape[] shapes = new Shape[6];

    shapes[0] = new Circle(3);
    shapes[1] = new Square(3);
    shapes[2] = new Triangle(3, 2);
    shapes[3] = new Cube(3);
    shapes[4] = new Sphere(3);
    shapes[5] = new Tetrahedon(3);

    for (Shape shape : shapes) {
      if (shape instanceof TwoDimensionalShape) {
        TwoDimensionalShape twoDimensionalShape = (TwoDimensionalShape) shape;
        System.out.printf("Area of two Dimensional shape: %.2f%n", twoDimensionalShape.getArea());
      }

      if (shape instanceof ThreeDimensionalShape) {
        ThreeDimensionalShape threeDimensionalShape = (ThreeDimensionalShape) shape;
        System.out.printf("%nArea of three dimensional shape: %.2f%nVolume of three dimesional shape: %.2f%n",
            threeDimensionalShape.getArea(), threeDimensionalShape.getVolume());
      }
    }

  }
}
