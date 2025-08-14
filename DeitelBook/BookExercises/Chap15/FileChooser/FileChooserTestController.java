
import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

public class FileChooserTestController {

  @FXML
  private BorderPane borderPane;
  @FXML
  private Button selectDirectoryButton;
  @FXML
  private Button selectFileButton;
  @FXML
  private TextArea textArea;

  @FXML
  void selectFileButtonPressed(ActionEvent event) {
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Select File");

    fileChooser.setInitialDirectory(new File("."));

    // display the FileChooser
    File file = fileChooser.showOpenDialog(borderPane.getScene().getWindow());

    if (file != null) {
      analyzePath(file.toPath());
    }
  }

  @FXML
  void selectDirectoryButtonPressed(ActionEvent event) {
    DirectoryChooser directoryChooser = new DirectoryChooser();
    directoryChooser.setTitle("Select Directory");

    directoryChooser.setInitialDirectory(new File("."));

    File file = directoryChooser.showDialog(
        borderPane.getScene().getWindow());

    if (file != null) {
      analyzePath(file.toPath());
    } else {
      textArea.setText("SelectFile or directory");
    }
  }

  // display information about file or directory user specifies
  public void analyzePath(Path path) {
    try {
      // if the file or directory exists, display its info
      if (path != null && Files.exists(path)) {
        // gather file (or directory) information
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%s:%n", path.getFileName()));
        builder.append(String.format("%s a directory%n",
            Files.isDirectory(path) ? "Is" : "Is not"));
        builder.append(String.format("%s an absolute path%n",
            path.isAbsolute() ? "Is" : "Is not"));
        builder.append(String.format("Last modified: %s%n",
            Files.getLastModifiedTime(path)));
        builder.append(String.format("Size: %s%n", Files.size(path)));
        builder.append(String.format("Path: %s%n", path));
        builder.append(String.format("Absolute path: %s%n",
            path.toAbsolutePath()));

        if (Files.isDirectory(path)) { // output directory listing
          builder.append(String.format("%nDirectory contents:%n"));

          // object for iterating through a directory's contents
          DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path);

          for (Path p : directoryStream) {
            builder.append(String.format("%s%n", p));
          }
        }

        // display file or directory info
        textArea.setText(builder.toString());
      } else { // Path does not exist
        textArea.setText("Path does not exist");
      }
    } catch (IOException ioException) {
      textArea.setText(ioException.toString());
    }
  }
}
