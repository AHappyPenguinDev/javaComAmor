
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ChoiceBox;
import javafx.collections.ObservableList;

public class BmiCalculatorController {

  ObservableList<String> unitList = FXCollections.observableArrayList("English", "Metric");

  @FXML
  private Label BmiResultLabel;

  @FXML
  private Button calculateBmiButton;

  @FXML
  private TextField heightTextField;

  @FXML
  private TextField weightTextField;

  @FXML
  private ChoiceBox<String> unitChoiceBox;

  @FXML
  private void initialize() {
    unitChoiceBox.setItems(unitList);
    unitChoiceBox.setValue("Metric");
    // Add listener to the ChoiceBox
    unitChoiceBox.setOnAction(this::unitChoiceBoxListener);
  }

  @FXML
  void calculateBmiButtonPressed(ActionEvent event) {
    String unit = unitChoiceBox.getValue();
    double bmi = calculateBmi(unit);
    String bmiResult = String.format("BMI Result: %.2f", bmi);

    BmiResultLabel.setText(bmiResult + bmiRange(bmi));

  }

  public double calculateBmi(String unitType) {
    double height = getUnit(heightTextField);
    double weight = getUnit(weightTextField);
    double heightSquared = Math.pow(height, 2);

    if (unitType.equals("Metric")) {
      double bmi = weight / heightSquared;
      return bmi;
    }

    double bmi = (weight * 703) / heightSquared;
    return 0.0;
  }

  public String bmiRange(Double bmi) {
    if(bmi == 0.00){return "(HOW ARE YOU SO SKINNY)";}
    if(bmi < 18.50){return "(Underweight)";}
    if(bmi > 18.50 && bmi < 24.99 ){return "(Normal)";}
    if(bmi > 25.00 && bmi < 29.99){return "(Overweight)";}
    if(bmi > 30.00){return "(Obese)";}
    if(bmi > 100.00){return "(SO FAT WHAT)";}
    return " Please insert a valid amount ";
  }

  public void unitChoiceBoxListener(ActionEvent event) {
    if (unitChoiceBox.getValue().equals("Metric")) {
      weightTextField.setPromptText("kg");
      heightTextField.setPromptText("meter");
    } else {
      weightTextField.setPromptText("pounds");
      heightTextField.setPromptText("inches");
    }
  }

  private double getUnit(TextField valueTextField) {
    double value = 0.0;
    try {
      value = Double.parseDouble(valueTextField.getText().trim());
    } catch (Exception e) {
      valueTextField.selectAll();
      valueTextField.requestFocus();
    }
    return value;
  }

}
