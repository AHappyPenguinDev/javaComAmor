import java.util.HashMap;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ChoiceBox;
import javafx.scene.canvas.GraphicsContext;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.paint.CycleMethod;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;

public class UsingGradientsController {

  private enum ColorNum {
    ONE,
    TWO;
  }

  private String[] gradTypeArray = { "Linear", "Radial" };

  // color chooser additions
  @FXML
  private Canvas drawingCanvas;
  @FXML
  private Slider redSlider;
  @FXML
  private Slider greenSlider;
  @FXML
  private Slider blueSlider;
  @FXML
  private Slider alphaSlider;
  @FXML
  private TextField redTextField;
  @FXML
  private TextField greenTextField;
  @FXML
  private TextField blueTextField;
  @FXML
  private TextField alphaTextField;
  @FXML
  private Rectangle colorRectangle;
  @FXML
  private ChoiceBox<String> gradientChoiceBox;
  @FXML
  private RadioButton colorOneRadioButton;
  @FXML
  private RadioButton colorTwoRadioButton;
  @FXML
  private Rectangle rectangle;
  @FXML
  private ToggleGroup colorToggleGroup;

  private int red = 0;
  private int green = 0;
  private int blue = 0;
  private double alpha = 1.0;
  private ColorNum colorNum = ColorNum.ONE;

  // Default colors and default gradient
  Color c1 = Color.BLUE;
  Color c2 = Color.ORANGE;
  String gradType = "Linear";

  // HashMaps for storing the colors of each color object
  HashMap<String, Double> c1Colors = new HashMap<String, Double>();
  HashMap<String, Double> c2Colors = new HashMap<String, Double>();

  // set user data for the colorRadioButtons
  public void initialize() {

    // color chooser binds
    redTextField.textProperty().bind(
        redSlider.valueProperty().asString("%.0f"));
    greenTextField.textProperty().bind(
        greenSlider.valueProperty().asString("%.0f"));
    blueTextField.textProperty().bind(
        blueSlider.valueProperty().asString("%.0f"));
    alphaTextField.textProperty().bind(
        alphaSlider.valueProperty().asString("%.2f"));

    // User data color radio buttons
    colorOneRadioButton.setUserData(ColorNum.ONE);
    colorTwoRadioButton.setUserData(ColorNum.TWO);

    // Adds values to choicebox, sets default and sets action method
    gradientChoiceBox.getItems().addAll(gradTypeArray);
    gradientChoiceBox.setValue("Linear");
    gradientChoiceBox.setOnAction(this::setGradient);

    // Initialize hashmap with c1 and c2's rgb values
    c1Colors.put("Red", c1.getRed() * 255);
    c1Colors.put("Green", c1.getGreen() * 255);
    c1Colors.put("Blue", c1.getBlue() * 255);

    c2Colors.put("Red", c2.getRed() * 255);
    c2Colors.put("Green", c2.getGreen() * 255);
    c2Colors.put("Blue", c2.getBlue() * 255);

    // Once I change the color, the sliders' values should update to be those of the
    // current color
    // I need to keep track of the colors stored in each color number

    // listeners that set Rectangle's fill based on Slider changes
    redSlider.valueProperty().addListener(
        new ChangeListener<Number>() {
          public void changed(ObservableValue<? extends Number> ov,
              Number oldValue, Number newValue) {
            red = newValue.intValue();
            colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
            if (colorNum == ColorNum.ONE) {
              System.out.printf("Inside Color 1");
              changeColor(1, Color.rgb(red, green, blue, alpha));
            } else if (colorNum == ColorNum.TWO) {
              System.out.printf("Inside Color 2");
              changeColor(2, Color.rgb(red, green, blue, alpha));
            }
            fillRectangle(c1, c2, gradType);
          }
        });

    greenSlider.valueProperty().addListener(
        new ChangeListener<Number>() {
          @Override
          public void changed(ObservableValue<? extends Number> ov,
              Number oldValue, Number newValue) {
            green = newValue.intValue();
            colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
            if (colorNum == ColorNum.ONE) {
              changeColor(1, Color.rgb(red, green, blue, alpha));
            } else if (colorNum == ColorNum.TWO) {
              changeColor(2, Color.rgb(red, green, blue, alpha));
            }
            fillRectangle(c1, c2, gradType);
          }
        });

    blueSlider.valueProperty().addListener(
        new ChangeListener<Number>() {
          @Override
          public void changed(ObservableValue<? extends Number> ov,
              Number oldValue, Number newValue) {
            blue = newValue.intValue();
            colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
            if (colorNum == ColorNum.ONE) {
              changeColor(1, Color.rgb(red, green, blue, alpha));
            } else if (colorNum == ColorNum.TWO) {
              changeColor(2, Color.rgb(red, green, blue, alpha));
            }
            fillRectangle(c1, c2, gradType);
          }
        });

    alphaSlider.valueProperty().addListener(
        new ChangeListener<Number>() {
          @Override
          public void changed(ObservableValue<? extends Number> ov,
              Number oldValue, Number newValue) {
            alpha = newValue.doubleValue();
            colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
            if (colorNum == ColorNum.ONE) {
              changeColor(1, Color.rgb(red, green, blue, alpha));
            } else if (colorNum == ColorNum.TWO) {
              changeColor(2, Color.rgb(red, green, blue, alpha));
            }
            fillRectangle(c1, c2, gradType);
          }
        });
  }

  @FXML
  private void colorRadioButtonSelected(ActionEvent e) {
    colorNum = (ColorNum) colorToggleGroup.getSelectedToggle().getUserData();

    c1Colors.put("Red", c1.getRed() * 255);
    c1Colors.put("Green", c1.getGreen() * 255);
    c1Colors.put("Blue", c1.getBlue() * 255);

    c2Colors.put("Red", c2.getRed() * 255);
    c2Colors.put("Green", c2.getGreen() * 255);
    c2Colors.put("Blue", c2.getBlue() * 255);

    if (colorNum == ColorNum.ONE) {
      redSlider.setValue(c1Colors.get("Red"));
      greenSlider.setValue(c1Colors.get("Green"));
      blueSlider.setValue(c1Colors.get("Blue"));
    } else if (colorNum == ColorNum.TWO) {
      redSlider.setValue(c2Colors.get("Red"));
      greenSlider.setValue(c2Colors.get("Green"));
      blueSlider.setValue(c2Colors.get("Blue"));
    }
  }

  private void changeColor(int colorNum, Color colorValue) {
    if (colorNum == 1) {
      c1 = colorValue;
    } else if (colorNum == 2) {
      c2 = colorValue;
    }
  }

  private void setGradient(ActionEvent e) {
    gradType = gradientChoiceBox.getValue();
    fillRectangle(c1, c2, gradType);
  }

  private void fillRectangle(Color c1, Color c2, String gradType) {
    GraphicsContext gc = drawingCanvas.getGraphicsContext2D();

    if (gradType == "Linear") {
      Stop[] stops = { new Stop(0, c1), new Stop(1, c2) };
      LinearGradient gradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);
      gc.setFill(gradient);
    } else if (gradType == "Radial") {
      Stop[] stops = { new Stop(0, c1), new Stop(1, c2) };
      RadialGradient gradient = new RadialGradient(0, 0, 0.5, 0.5,
          0.6, true, CycleMethod.NO_CYCLE, stops);
      gc.setFill(gradient);
    }

    gc.setStroke(Color.BLACK);
    gc.fillRoundRect(0, 0, 300, 200, 10, 10);
    gc.strokeRoundRect(0, 0, 300, 200, 10, 10);
  }
}
