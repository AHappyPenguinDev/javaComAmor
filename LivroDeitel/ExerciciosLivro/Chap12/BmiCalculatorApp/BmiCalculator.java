import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BmiCalculator extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) throws Exception {
      Parent root = FXMLLoader.load(getClass().getResource("BmiCalculator.fxml"));
      Scene scene = new Scene(root);
      stage.setTitle("BMI Calculator");
      stage.setScene(scene);
      stage.show();
  }
}
