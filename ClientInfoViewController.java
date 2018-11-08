package VSBakery;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

/**
 * Client Info View Controller
 *
 * @author Ray
 */
public class ClientInfoViewController extends Controller implements Initializable {

    @FXML
    private Pane clientInfoView;

    @FXML
    private Label firstName;

    @FXML
    private Label lastName;

    @FXML
    private Label address;

    @FXML
    private Label phoneNum;

    @FXML
    private Label email;

    /**
     * Handler for next action, it will change the view from client info to
     * OrderView.
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void handleNextAction(ActionEvent event) throws IOException {

        getManagingController().addScreen("OrderView.fxml", this);
        getManagingController().removeScreen(this);
    }

    /**
     * handler for Go back action, will go back to login view page.
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void handleBackAction(ActionEvent event) throws IOException {
        getManagingController().addScreen("LoginView.fxml", this);
        getManagingController().removeScreen(this);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    /**
     * a method with will return Client Info View
     *
     * @return clientInfoView
     */
    @Override
    public Pane getView() {
        return clientInfoView;
    }

    /**
     * a method that will execute readClientInfo method from ClientReadFile
     * class use phoneNumber to search for files.And then read the file information
     *
     * @param phone
     */
    public void readInfo(String phone) {
        try {
            Scanner info = new ClientReadFile().readClientInfo(phone);
            info.useDelimiter(";");

            firstName.setText(info.next());
            lastName.setText(info.next());
            address.setText(info.next());
            phoneNum.setText(info.next());
            email.setText(info.next());

        } catch (FileNotFoundException ex) {
            System.out.print("File does not exsit!");
        }
    }

    /**
     * a method will return phoneNum label
     *
     * @return phoneNum
     */
    public Label getPhone() {
        return phoneNum;
    }

    /**
     * a method will return firstName content.
     *
     * @return firstName
     */
    public String getFirstName() {
        return firstName.getText();
    }

    /**
     * a method will return lastName content.
     *
     * @return lastName
     */
    public String getLastName() {
        return lastName.getText();
    }

}
