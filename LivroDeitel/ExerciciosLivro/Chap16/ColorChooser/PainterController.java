import java.util.HashMap;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import jdk.jfr.Experimental;

public class PainterController {

  private enum PenSize {
    SMALL(2),
    MEDIUM(4),
    LARGE(6);

    private final int radius;

    PenSize(int radius) {
      this.radius = radius;
    }// constructor

    public int getRadius() {
      return radius;
    }
  };

  // instance variables that refer to GUI components
  @FXML
  private TextField colorTextField;
  @FXML
  private ToggleGroup sizeToggleGroup;
  @FXML
  private RadioButton largeRadioButton;
  @FXML
  private RadioButton mediumRadioButton;
  @FXML
  private RadioButton smallRadioButton;
  @FXML
  private Button undoButton;
  @FXML
  private Button clearButton;
  @FXML
  private Pane drawingAreaPane;

  // instance variables for managin Painter state
  private PenSize radius = PenSize.MEDIUM; // radius of circle
  private Paint brushColor = Color.BLACK; // drawing color

  // set user data for the colorRadioButtons
  public void initialize() {
    // user data on a control can be any Object
    smallRadioButton.setUserData(PenSize.SMALL);
    mediumRadioButton.setUserData(PenSize.MEDIUM);
    largeRadioButton.setUserData(PenSize.LARGE);
  }

  @FXML
  private void drawingAreaMouseDragged(MouseEvent e) {
    Circle newCircle = new Circle(e.getX(), e.getY(),
        radius.getRadius(), brushColor);
    drawingAreaPane.getChildren().add(newCircle);
  }

  // Update color using colorTextField's contents
  private Color getColor(TextField colorTextField) {
    Color color = colorMap.getColor(colorTextField.getText());
    return color;
  }

  ColorHashMap colorMap = new ColorHashMap();

  @FXML
  private void updateColorButtonPressed(ActionEvent event) {
    try {
      brushColor = getColor(colorTextField);
    } catch (Exception e) {
      System.out.printf("Exception in updateColorButtonPressed: %n");
      e.printStackTrace();
    }
  }

  // handles size RadioButton's ActionEvents
  @FXML
  private void sizeRadioButtonSelected(ActionEvent e) {
    // user data for each size RadioButton is the corresponding PenSize
    radius = (PenSize) sizeToggleGroup.getSelectedToggle().getUserData();
  }

  // handles Undo Button's ActionEvents
  @FXML
  private void undoButtonPressed(ActionEvent event) {
    int count = drawingAreaPane.getChildren().size();

    // if there are any shapes remove the last one added
    if (count > 0) {
      drawingAreaPane.getChildren().remove(count - 1);
    }
  }

  // handles Clear Button's ActionEvents
  @FXML
  private void clearButtonPressed(ActionEvent event) {
    drawingAreaPane.getChildren().clear(); // clear the canvas
  }

}
