/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VSBakery;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

/**
 * Controller for Exit View
 *
 * @author Ray
 */
public class ExitViewController extends Controller implements Initializable {

    @FXML
    private Pane exitView;
    @FXML
    private Label message;

    /**a exit action handler if user click on the exit button, program will be close.
     * 
     * @param event
     * @throws IOException 
     */
    @FXML
    private void exitHandler(ActionEvent event) throws IOException {
        Platform.exit();
    }

    /**a new order action handler, will return to login page if user click
     * on new order button.
     * 
     * @param event
     * @throws IOException 
     */
    @FXML
    private void newOrderHandler(ActionEvent event) throws IOException {
        getManagingController().addScreen("LoginView.fxml", this);
        getManagingController().removeScreen(this);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    /**a method return the exit view
     * 
     * @return exitView
     */
    @Override
    public Pane getView() {
        return exitView;
    }
    
    /**a method will return the message of client name and pick date
     * 
     * @param date
     * @param name 
     */
    public void setMessage(String date, String name) {
        message.setText("Order for " + name + " will be ready for pickup at " 
                + date);
    }

}
