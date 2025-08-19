import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;

public class PolylineAppController {

  @FXML
  private Pane drawingAreaPane;
  @FXML
  private Polyline polyline;
  private Circle circle;

  public void initialize() {
    polyline.setVisible(true);
  }

  // Clear drawing on first click
  @FXML
  void drawingAreaMousePressed(MouseEvent e) {
    System.out.println("CLICKED");
    drawingAreaPane.getChildren().clear();
    polyline = new Polyline();
    circle = new Circle(e.getX(), e.getY(), 4, Color.BLACK);
    drawingAreaPane.getChildren().add(polyline);
  }

  @FXML
  void drawingAreaMouseDragged(MouseEvent e) {
    System.out.println("DRAGGED");
    polyline.getPoints().addAll(e.getX(), e.getY());
    polyline.getPoints().addAll(e.getX(), e.getY());
    drawingAreaPane.getChildren().remove(circle);
    circle = new Circle(e.getX(), e.getY(), 4, Color.BLACK);
    drawingAreaPane.getChildren().add(circle);
  }
}
