import javafx.beans.value.ChangeListener;

import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ContactsAppController {

  private Contact contactSelected;

  @FXML
  private ListView<Contact> contactsListView;

  @FXML
  private TextField lastNameTextField;

  @FXML
  private TextField firstNameTextField;

  @FXML
  private TextField emailTextField;

  @FXML
  private TextField phoneNumberTextField;

  // store the list of Contact objects
  private final ObservableList<Contact> contacts = FXCollections.observableArrayList();

  public void initialize() {
    contactsListView.setItems(contacts);

    // display selected contact
    contactsListView.getSelectionModel().selectedItemProperty().addListener(
        new ChangeListener<Contact>() {
          @Override
          public void changed(ObservableValue<? extends Contact> ov, Contact oldValue, Contact newValue) {
            contactSelected = newValue;
            firstNameTextField.setText(newValue.getFirstName());
            lastNameTextField.setText(newValue.getLastName());
            emailTextField.setText(newValue.getEmail());
            phoneNumberTextField.setText(newValue.getPhoneNumber());
          }
        });
  }

  @FXML
  void updateContactButtonPressed(ActionEvent event) {
    try {
      contactSelected.setFirstName(firstNameTextField.getText().trim());
      contactSelected.setLastName(lastNameTextField.getText().trim());
      contactSelected.setEmail(emailTextField.getText().trim());
      contactSelected.setPhoneNumber(phoneNumberTextField.getText().trim());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @FXML
  void addContactButtonPressed(ActionEvent event) {
    try {
      String firstName = firstNameTextField.getText().trim();
      String lastName = lastNameTextField.getText().trim();
      String email = emailTextField.getText().trim();
      String phoneNumber = phoneNumberTextField.getText().trim();

      contacts.add(new Contact(firstName, lastName, email, phoneNumber));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @FXML
  void deletedContactButtonPressed(ActionEvent event) {
    contacts.remove(contactSelected);
    firstNameTextField.setText("");
    lastTextField.setText("");
    phoneNumberTextField.setText("");
    emailTextField.setText("");
  }

}
