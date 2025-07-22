
// Fig. 13.5: Painter.java
// Main application class that loads and displays the Painter's GUI.
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PainterAppModifications extends Application {

  @Override
  public void start(Stage stage) throws Exception {
    try {
      String fxmlPath = "PainterAppModifications.fxml";
      Parent root = FXMLLoader.load(getClass().getResource("PainterAppModifications.fxml"));
      Scene scene = new Scene(root);
      stage.setTitle("Painter App Modifications"); // displayed in window's title bar
      stage.setScene(scene);
      stage.show();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    launch(args);
  }
}
