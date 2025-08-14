
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Addition extends Application {

  @Override
  public void start(Stage stage) throws Exception {
    try {
      Parent root = FXMLLoader.load(getClass().getResource("Addition.fxml"));
      Scene scene = new Scene(root);
      stage.setTitle("Add numbers!");
      stage.setScene(scene);
      stage.show();
    } catch (Exception e) {
      e.printStackTrace(); // Print the stack trace for debugging
    }
  } 
  
  public static void main(String[] args) {
    launch(args);
  }
}

// import java.io.IOException;
//
// import javafx.application.Application;
// import javafx.fxml.FXMLLoader;
// import javafx.scene.Parent;
// import javafx.scene.Scene;
// import javafx.stage.Stage;
//
// public class Addition extends Application {
//
// @Override
// public void start(Stage stage) throws IOException {
// Parent root =
// FXMLLoader.load(getClass().getClassLoader().getResource("Addition.fxml"));
//
// Scene scene = new Scene(root);
// stage.setTitle("Addition");
// stage.setScene(scene);
// stage.show();
// }
//
// public static void main(String[] args) {
// launch(args);
// }
// }
