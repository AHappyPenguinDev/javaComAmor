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

  public void initialize() {
    polyline.setVisible(true);
  }

  @FXML
  void drawingAreaMouseDragged(MouseEvent e) {
    Circle newCircle = new Circle(e.getX(), e.getY(),
        4, Color.BLACK);
    drawingAreaPane.getChildren().add(newCircle);
    polyline.getPoints().addAll(e.getX(), e.getY());

  }

}
