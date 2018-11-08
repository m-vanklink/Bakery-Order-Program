/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VSBakery;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class. This class is for the order confirmation. It displays
 * the name of the client, their order date, pick up date, and their order info.
 * Allows the client to check out or go back to redo their purchase.
 *
 * @author Michael
 */
public class ConfirmationViewController extends Controller implements Initializable {

    @FXML
    private Pane confirmationView;

    @FXML
    private Label customerName;

    @FXML
    private Label orderNumber;

    @FXML
    private Label orderDate;

    @FXML
    private Label pickupDate;

    @FXML
    private Label item1;

    @FXML
    private Label item2;

    @FXML
    private Label size1;

    @FXML
    private Label size2;

    @FXML
    private Label flavour1;

    @FXML
    private Label flavour2;

    @FXML
    private Label qty1;

    @FXML
    private Label qty2;

    @FXML
    private Label price1;

    @FXML
    private Label price2;

    @FXML
    private Label subTotal;

    @FXML
    private Label hstTax;

    @FXML
    private Label total;

		/**
		 * This method controls the back function. When clicked the user goes back
		 * to the previous pane. It sets the data member for if the button had been
		 * pushed on this pane to true and passes the clients name back to that pane.
		 * 
		 * @param event the ActionEvent. 
		 * @throws IOException The exception that is thrown if it occurs.
		 */
    @FXML
    public void handleBackAction(ActionEvent event) throws IOException {

        getManagingController().addScreen("OrderView.fxml", this);
        getManagingController().removeScreen(this);
        OrderViewController bbp = (OrderViewController) getChildController();
        bbp.setBBP(true);
        bbp.setClientName(customerName.getText());
    }
		
		/**
		 * This method is handling the transition to the final pane where the user
		 * receives a thank you for ordering, the ability to place a second order 
		 * or exit the program.
		 * 
		 * @param event the ActionEvent.
		 * @throws IOException The exception that is thrown if it occurs.
		 */
    @FXML
    public void handlePayAction(ActionEvent event) throws IOException {
        getManagingController().addScreen("ExitView.fxml", this);
        getManagingController().removeScreen(this);
        ExitViewController message = (ExitViewController) getChildController();
        message.setMessage(orderDate.getText(), customerName.getText());
    }
		
	
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
		
		/**
		 * These are all the getters. They get and return the data members.
		 * @return the data members.
		 */
    @Override
    public Pane getView() {
        return confirmationView;
    }

    public Label getName() {
        return customerName;
    }

    public Label getOrderNum() {
        return orderNumber;
    }

    public Label getOrderDate() {
        return orderDate;
    }

    public Label getPickup() {
        return pickupDate;
    }

    public Label getItem1() {
        return item1;
    }

    public Label getItem2() {
        return item2;
    }

    public Label getSize1() {
        return size1;
    }

    public Label getSize2() {
        return size2;
    }

    public Label getFlav1() {
        return flavour1;
    }

    public Label getFlav2() {
        return flavour2;
    }

    public Label getQty1() {
        return qty1;
    }

    public Label getQty2() {
        return qty2;
    }

    public Label getPrice1() {
        return price1;
    }

    public Label getPrice2() {
        return price2;
    }

    public Label getSubTotal() {
        return subTotal;
    }

    public Label getHST() {
        return hstTax;
    }

    public Label getTotal() {
        return total;
    }

}
