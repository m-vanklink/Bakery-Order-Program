
package VSBakery;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javax.swing.JOptionPane;

/**
 * Controller for adding new client
 *
 * @author Ray
 */
public class NewClientViewController extends Controller implements Initializable {

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextArea address;

    @FXML
    private TextField phoneNum;

    @FXML
    private TextField email;

    @FXML
    private Pane newClientView;

    /** a add new client action handler, if all client meet all the condition
     * the client information will be add to a file and show in client info view page.
     * @param event
     * @throws IOException
     * @throws FileNotFoundException 
     */
    @FXML
    private void handleAddAction(ActionEvent event) throws IOException, FileNotFoundException {

        //check if all input file is empty
        if (firstName.getText().isEmpty() || lastName.getText().isEmpty()
                || phoneNum.getText().isEmpty() || address.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Please fill out all fields");

            //check if first name only contain letter  
        } else if (!new Validation().isLetters(firstName.getText())) {
            JOptionPane.showMessageDialog(null,
                    "First Name can only contain Letter!");

            //check if last name only contain letter
        } else if (!new Validation().isLetters(lastName.getText())) {
            JOptionPane.showMessageDialog(null,
                    "Last Name can only contain Letter!");

            //check if phone number only contain numbers
        } else if (!new Validation().isNumber(phoneNum.getText())) {
            JOptionPane.showMessageDialog(null,
                    "Phone Number can not contain letters and special character!");

            //check if address format is correct
        } else if (new Validation().validAddress(address.getText())) {
            JOptionPane.showMessageDialog(null,
                    "Please Enter: Street \n City, Province \n  Postal Code");

            //check if the phoneNum is alreay exist
        } else if (new Validation().fileExist(phoneNum.getText())) {
            JOptionPane.showMessageDialog(null,
                    "The Phone Number Already exist!");

            //to check if the email if in correct format
        } else if (!new Validation().validEmail(email.getText())) {
            JOptionPane.showMessageDialog(null,
                    "The email address is not invalid format.");

            //if above condition is correct, input new client info to a file
        } else {

            new ClientWriteToFile().recordClientInfo(firstName.getText(),
                    lastName.getText(), address.getText(), phoneNum.getText(), email.getText());

            getManagingController().addScreen("ClientInfoView.fxml", this);
            getManagingController().removeScreen(this);

            //pass the phone Number from this class to it's child class as a reference to 
            //fine the file
            ClientInfoViewController cv = (ClientInfoViewController) getChildController();
            cv.readInfo(phoneNum.getText());
        }
    }

    /** a Cancel button action handler, if the user cancel adding the 
     * new client, it will return to Login View page.
     * @param event
     * @throws IOException 
     */
    @FXML
    private void handleCancelAction(ActionEvent event) throws IOException {
        getManagingController().addScreen("LoginView.fxml", this);
        getManagingController().removeScreen(this);
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    /**a method return the new client view
     * 
     * @return newClientView
     */
    @Override
    public Pane getView() {
        return newClientView;
    }

    /**return the value of First Name
     * 
     * @return firstName
     */
    public String getFName() {
        return firstName.getText();
    }

}
