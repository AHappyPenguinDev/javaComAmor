
// Fig. 18.20: FractalController.java
// Drawing the "Lo feather fractal" using recursion.
import java.util.HashMap;
import java.util.Map;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.ChoiceBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class FractalController {
  // constants
  private static final int MIN_LEVEL = 0;
  private static final int MAX_LEVEL = 15;

  // instance variables that refer to GUI components
  @FXML
  private Canvas canvas;
  @FXML
  private ColorPicker colorPicker;
  @FXML
  private Label levelLabel;
  @FXML
  private ChoiceBox<String> fractalArmChoiceBox;

  // other instance variables
  private Color currentColor = Color.BLUE;
  private int level = MIN_LEVEL; // initial fractal level
  private GraphicsContext gc; // used to draw on Canvas
  private String[] armIds = { "1", "2", "3", "4", "5" };
  Map<Integer, Color> fractalArmMap = new HashMap<>(); // Map with Arm id key and color value

  // initialize the controller
  public void initialize() {
    levelLabel.setText("Level: " + level);
    fractalArmChoiceBox.getItems().addAll(armIds);
    // Default colors for each arm {
    // Starts with default of purple gradient
    fractalArmMap.put(1, Color.web("#ca5cdd"));
    fractalArmMap.put(2, Color.web("#be2ed6"));
    fractalArmMap.put(3, Color.web("#b100cd"));
    fractalArmMap.put(4, Color.web("#a000c8"));
    fractalArmMap.put(5, Color.web("#8a00c2"));
    // }
    colorPicker.setValue(currentColor); // start with purple
    gc = canvas.getGraphicsContext2D(); // get the GraphicsContext
    drawFractal();
  }

  // sets currentColor when user chooses a new Color
  @FXML
  void colorSelected(ActionEvent event) {
    currentColor = colorPicker.getValue(); // get new Color
    int arm = Integer.parseInt(fractalArmChoiceBox.getValue());
    fractalArmMap.put(arm, currentColor);
    drawFractal();
  }

  // decrease level and redraw fractal
  @FXML
  void decreaseLevelButtonPressed(ActionEvent event) {
    if (level > MIN_LEVEL) {
      --level;
      levelLabel.setText("Level: " + level);
      drawFractal();
    }
  }

  // increase level and redraw fractal
  @FXML
  void increaseLevelButtonPressed(ActionEvent event) {
    if (level < MAX_LEVEL) {
      ++level;
      levelLabel.setText("Level: " + level);
      drawFractal();
    }
  }

  // clear Canvas, set drawing color and draw the fractal
  private void drawFractal() {
    gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    // Loop over each key in the map, adding the current color for current key
    for (int key : fractalArmMap.keySet()) {
      currentColor = fractalArmMap.get(key);
      switch (key) {
        case 1:
          drawFractal(level, 400 / 2, 480 / 2, (400 / 2) + 80, (480 / 2) - 90, currentColor, gc);
          break;
        case 2:
          drawFractal(level, 400 / 2, 480 / 2, (400 / 2) + 120, (480 / 2) + 20, currentColor, gc);
          break;
        case 3:
          drawFractal(level, 400 / 2, 480 / 2, (400 / 2), (480 / 2) + 100, currentColor, gc);
          break;
        case 4:
          drawFractal(level, 400 / 2, 480 / 2, (400 / 2) - 120, (480 / 2) + 20, currentColor, gc);
          break;
        case 5:
          drawFractal(level, 400 / 2, 480 / 2, (400 / 2) - 80, (480 / 2) - 90, currentColor, gc);
          break;
      }
    }
  }

  // draw fractal recursively
  public void drawFractal(int level, int xA, int yA, int xB, int yB, Color color, GraphicsContext gc) {
    // base case: draw a line connecting two given points
    if (level == 0) {
      gc.setStroke(color);
      gc.strokeLine(xA, yA, xB, yB);
    } else { // recursion step: determine new points, draw next level
      // calculate midpoint between (xA, yA) and (xB, yB)
      int xC = (xA + xB) / 2;
      int yC = (yA + yB) / 2;

      // calculate the fourth point (xD, yD) which forms an
      // isosceles right triangle between (xA, yA) and (xC, yC)
      // where the right angle is at (xD, yD)
      int xD = xA + (xC - xA) / 2 - (yC - yA) / 2;
      int yD = yA + (yC - yA) / 2 + (xC - xA) / 2;

      // recursively draw the Fractal
      drawFractal(level - 1, xD, yD, xA, yA, color, gc);
      drawFractal(level - 1, xD, yD, xC, yC, color, gc);
      drawFractal(level - 1, xD, yD, xB, yB, color, gc);
    }
  }

}

/**************************************************************************
 * (C) Copyright 1992-2018 by Deitel & Associates, Inc. and *
 * Pearson Education, Inc. All Rights Reserved. *
 * *
 * DISCLAIMER: The authors and publisher of this book have used their *
 * best efforts in preparing the book. These efforts include the *
 * development, research, and testing of the theories and programs *
 * to determine their effectiveness. The authors and publisher make *
 * no warranty of any kind, expressed or implied, with regard to these *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or *
 * consequential damages in connection with, or arising out of, the *
 * furnishing, performance, or use of these programs. *
 *************************************************************************/
