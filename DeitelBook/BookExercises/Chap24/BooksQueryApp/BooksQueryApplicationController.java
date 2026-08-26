
//REQUIREMENTS FOR EXERCISE
// select all authors
// all books for specific author sorted by last name then first
// all authors for specific book

import java.sql.SQLException;
import java.util.regex.PatternSyntaxException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.embed.swing.SwingNode;
import javafx.event.ActionEvent;
import java.sql.PreparedStatement;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class BooksQueryApplicationController {

  @FXML
  private BorderPane borderPane;

  @FXML
  private ComboBox<PreparedStatement> predefinedQueriesComboBox;

  @FXML
  private TextField queryTextField;

  private static final String URL = "jdbc:derby:books";
  private static final String USERNAME = "deitel";
  private static final String PASSWORD = "deitel";

  private BooksTableModel booksTableModel;
  private TableRowSorter<TableModel> sorter;

  public void initialize() {
    try {
      // Initialize values in choice box, set "Select all"" as default value
      String[] comboBoxItems = { "Select all", "Select books from Author", "Select Authors by book" };
      predefinedQueriesComboBox.getItems().addAll(comboBoxItems);
      predefinedQueriesComboBox.getSelectionModel().selectFirst();

      // Action listener for comboBox, sets textfield text to the PreparedStatement's
      // query
      predefinedQueriesComboBox.setOnAction(event -> {
        queryTextField.setText(getSelectedPredefinedQuery());

      });

      booksTableModel = new BooksTableModel(URL, USERNAME, PASSWORD);

      JTable resultTable = new JTable(booksTableModel);

      sorter = new TableRowSorter<TableModel>(booksTableModel); // create sorter to sort JTable rows
      resultTable.setRowSorter(sorter); // set sorter for JTable

      // Programatically insert JScrollPane based on JTable resultTable into
      // borderPane's center
      SwingNode swingNode = new SwingNode();
      swingNode.setContent(new JScrollPane(resultTable));
      borderPane.setCenter(swingNode);
    } catch (SQLException sqlException) {
      // show error popup message
      // displayAlert(AlertType.ERROR, "Database Error",
      sqlException.getMessage();
      booksTableModel.disconnectFromDatabase();
      System.exit(1);
    }
  }

  @FXML
  void submitQueryButtonPressed(ActionEvent event) {
    // Get text from queryTextField and execute
  }

  private PreparedStatement getSelectedPredefinedQuery() {
    String selected = predefinedQueriesComboBox.getValue();
    switch (selected) {
      case "Select All":
    }
  }
}
