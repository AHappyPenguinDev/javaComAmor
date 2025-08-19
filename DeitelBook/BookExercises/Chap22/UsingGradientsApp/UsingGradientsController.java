import javafx.scene.canvas.Canvas;
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

  private enum GradType {
    LINEAR,
    RADIAL;
  }

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
  private RadioButton linearGradientRadioButton;
  @FXML
  private RadioButton radialGradientRadioButton;
  @FXML
  private Rectangle rectangle;
  @FXML
  private ToggleGroup gradientToggleGroup;

  private int red = 0;
  private int green = 0;
  private int blue = 0;
  private double alpha = 1.0;
  private GradType gradType = GradType.LINEAR;

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

    linearGradientRadioButton.setUserData(GradType.LINEAR);
    radialGradientRadioButton.setUserData(GradType.RADIAL);

    // listeners that set Rectangle's fill based on Slider changes
    redSlider.valueProperty().addListener(
        new ChangeListener<Number>() {
          @Override
          public void changed(ObservableValue<? extends Number> ov,
              Number oldValue, Number newValue) {
            red = newValue.intValue();
            colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
            fillRectangle(Color.rgb(red, green, blue, alpha), gradType);
          }
        });

    greenSlider.valueProperty().addListener(
        new ChangeListener<Number>() {
          @Override
          public void changed(ObservableValue<? extends Number> ov,
              Number oldValue, Number newValue) {
            green = newValue.intValue();
            colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
            fillRectangle(Color.rgb(red, green, blue, alpha), gradType);
          }
        });

    blueSlider.valueProperty().addListener(
        new ChangeListener<Number>() {
          @Override
          public void changed(ObservableValue<? extends Number> ov,
              Number oldValue, Number newValue) {
            blue = newValue.intValue();
            colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
            fillRectangle(Color.rgb(red, green, blue, alpha), gradType);
          }
        });

    alphaSlider.valueProperty().addListener(
        new ChangeListener<Number>() {
          @Override
          public void changed(ObservableValue<? extends Number> ov,
              Number oldValue, Number newValue) {
            alpha = newValue.doubleValue();
            colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
            fillRectangle(Color.rgb(red, green, blue, alpha), gradType);
          }
        });
  }

  @FXML
  private void gradientRadioButtonSelected(ActionEvent e) {
    gradType = (GradType) gradientToggleGroup.getSelectedToggle().getUserData();
  }

  private void fillRectangle(Color c, GradType gradType) {
    GraphicsContext gc = drawingCanvas.getGraphicsContext2D();

    if (gradType == GradType.LINEAR) {
      Stop[] stops = { new Stop(0, c), new Stop(1, c) };
      LinearGradient gradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);
      gc.setFill(gradient);
    } else if (gradType == GradType.RADIAL) {
      Stop[] stops = { new Stop(0, c), new Stop(1, c) };
      RadialGradient gradient = new RadialGradient(0, 0, 0.5, 0.5,
          0.6, true, CycleMethod.NO_CYCLE, stops);
      gc.setFill(gradient);
    }

    gc.setStroke(Color.BLACK);
    gc.fillRoundRect(47, 132, 300, 200, 10, 10);
    gc.strokeRoundRect(47, 132, 300, 200, 10, 10);
  }
}
