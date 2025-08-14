
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AdditionController {

  @FXML
  private Button calculateButton;

  @FXML
  private TextField numberOneTextField;

  @FXML
  private TextField numberTwoTextField;

  @FXML
  private Label resultLabel;

  @FXML
  void calculateButtonPressed(ActionEvent event) {
    
    double numberOne = getNumber(numberOneTextField);
    double numberTwo = getNumber(numberTwoTextField);

    double sum = numberOne+numberTwo;
    resultLabel.setText(String.format("%.2f", sum));
  }

  private double getNumber(TextField numberTextField) {
    double number = 0.0;

    try {
      number = Double.parseDouble(numberTextField.getText().trim());
    } 
    catch (NumberFormatException e) {
      numberTextField.setText("Enter a number");
      numberTextField.selectAll();
      numberTextField.requestFocus();
    }

    return number;
  }

}

//
// import javafx.event.ActionEvent;
// import javafx.fxml.FXML;
// import javafx.scene.control.Label;
// import javafx.scene.control.TextField;
//
// public class AdditionController {
//
// @FXML
// private Label resultLabel;
//
// @FXML
// private TextField numberOneTextField;
//
// @FXML
// private TextField numberTwoTextField;
//
// @FXML
// void calculateButtonPressed(ActionEvent event) {
// int number1 = getNumber(numberOneTextField);
// int number2 = getNumber(numberTwoTextField);
// int sum = number1 + number2;
// resultLabel.setText(String.valueOf(sum));
// }
//
// private int getNumber(TextField numberTextField) {
// int number = 0;
//
// try {
// number = Integer.parseInt(numberTextField.getText().trim());
// }
// catch (NumberFormatException e) {
// numberTextField.setText("Enter an integer");
// numberTextField.selectAll();
// numberTextField.requestFocus();
// }
//
// return number;
// }
// }
