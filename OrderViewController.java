
package VSBakery;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javax.swing.JOptionPane;

/**
 * The controller for the the client to order their pastry. It provides clients
 * with radio buttons for the options of pies or cakes they can purchase as well
 * as allows them to set the quantity in which they want to buy them in. 
 * 
 * @author Michael
 */
public class OrderViewController extends Controller implements Initializable {

	/**
	 * These are all the data members for this class.
	 */

	private String clientName = "";
	
	private Pastry pastry = new Pastry();

	private boolean BBP = false;

	ClientWriteToFile orderWrite = new ClientWriteToFile();

	ClientReadFile readOrder = new ClientReadFile();

	Date date = new Date();
	SimpleDateFormat dateString = new SimpleDateFormat("yyyy-MM-dd");

	@FXML
	private Pane orderView;

	@FXML
	private Label orderNumber;

	@FXML
	private DatePicker pickupDate;

	@FXML
	private ToggleGroup sizeGroup;

	@FXML
	private CheckBox cake;

	@FXML
	private RadioButton small;

	@FXML
	private RadioButton medium;

	@FXML
	private RadioButton large;

	@FXML
	private TextField cakeQTY;

	@FXML
	private ToggleGroup cakeFlaGroup;

	@FXML
	private RadioButton strawberry;

	@FXML
	private RadioButton chocolate;

	@FXML
	private RadioButton fruit;

	@FXML
	private Label cakePrice;

	@FXML
	private CheckBox pie;

	@FXML
	private ToggleGroup pieFlavour;

	@FXML
	private RadioButton blueberry;

	@FXML
	private RadioButton pumpkin;

	@FXML
	private RadioButton apple;

	@FXML
	private RadioButton pecan;

	@FXML
	private TextField pieQTY;

	@FXML
	private Label piePrice;
	
	/**
	 * Handles moving to the next pane by adding the next pane screen and then
	 * removing the current one.
	 * 
	 * @param event the ActionEvent.
	 * @throws IOException The exception that is thrown if it occurs.
	 */
	@FXML
	private void handleAddOrderAction(ActionEvent event) throws IOException {
		getManagingController().addScreen("OrderView.fxml", this);
		getManagingController().removeScreen(this);

	}

	/**
	 * Handles going back to the previous pane by adding the previous screen and 
	 * removing the current screen. 
	 * 
	 * @param event the ActionEvent.
	 * @throws IOException The exception that is thrown if it occurs.
	 */
	
	@FXML
	private void handleBackAction(ActionEvent event) throws IOException {
		getManagingController().addScreen("LoginView.fxml", this);
		getManagingController().removeScreen(this);
	}

	/**
	 * If the pick up date is equal to todays date or later, and cake or pie is 
	 * selected and the quantity fields are not empty, and the quantities are
	 * between 0 and 10, then move to the next pane and fill the labels in with
	 * the appropriate information. Otherwise display the appropriate error
	 * messages. If the back button has been pressed, use the clients name data 
	 * member instead of trying to figure out how to get it from the child 
	 * directly, just pass it back as a parameter for the setter method.
	 * 
	 * @param event the ActionEvent.
	 * @throws IOException The exception that is thrown if it occurs.
	 */
	@FXML
	private void handleProcessOrderAction(ActionEvent event) throws IOException {

		//If all of this is true the customer can continue to the next page.
		if ((pickupDate.getValue() != null) && (pickupDate.getValue().toString().compareTo(dateString.format(date)) >= 0)) {
			if ((cake.isSelected() || pie.isSelected())) {
				if ((cakeQTY.getText().isEmpty() == false) && (pieQTY.getText().isEmpty() == false) ) {
					if (((Integer.parseInt(cakeQTY.getText()) > 0) && (Integer.parseInt(cakeQTY.getText()) <= 10))
						&& ((Integer.parseInt(pieQTY.getText()) > 0) && (Integer.parseInt(pieQTY.getText()) <= 10))) {

						getManagingController().addScreen("ConfirmationView.fxml", this);

						//Get the order information and write it to a file.
						orderWrite.writeOrder(orderNumber, pickupDate, sizeGroup, cakeQTY,
							cakeFlaGroup, cakePrice, pieFlavour, pieQTY, piePrice, cake, pie);

						ConfirmationViewController cv = (ConfirmationViewController) getChildController();

						Scanner input = readOrder.readOrder(orderNumber.getText());

						//If the back button on the confirm order page is not pressed.
						if (BBP == false) {
							ClientInfoViewController pc = (ClientInfoViewController) getParentController();

							cv.getName().setText(pc.getFirstName() + " " + pc.getLastName());
						} else {
							cv.getName().setText(clientName);
						}
						//Set all labels on the confirm order page.
						cv.getOrderNum().setText(input.nextLine());
						cv.getOrderDate().setText(dateString.format(date));
						cv.getPickup().setText(input.nextLine());
						cv.getItem1().setText(input.nextLine());
						cv.getSize1().setText(input.nextLine());
						cv.getFlav1().setText(input.nextLine());
						cv.getQty1().setText(input.nextLine());
						double firstPrice = input.nextDouble();
						cv.getPrice1().setText(Double.toString(firstPrice));

						double secondPrice = 0.00;

						//If the file contains pie information. 
						if (input.hasNext()) {
							cv.getItem2().setText(input.nextLine() + input.nextLine());
							cv.getSize2().setText(input.nextLine());
							cv.getFlav2().setText(input.nextLine());
							cv.getQty2().setText(input.nextLine());
							secondPrice = input.nextDouble();
							cv.getPrice2().setText(Double.toString(secondPrice));
						}

						double subTotal = firstPrice + secondPrice;
						cv.getSubTotal().setText("$" + Double.toString(subTotal));
						double hstPrice = Math.round((subTotal * 0.13) * 100.0) / 100.0;
						cv.getHST().setText("$" + Double.toString(hstPrice));
						cv.getTotal().setText("$" + Double.toString(Math.floor((subTotal + hstPrice) * 100.0) / 100.0));

						getManagingController().removeScreen(this);
					} else {
						JOptionPane.showMessageDialog(null, "Quantities must be 10 or less.");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Quantity cannot be empty.");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Please check cake or pie.");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Please select pickup date that is today or later.");
		}

	}

	/**
	 * Sets the order number, the default price and quantity values, set the
	 * listeners on the quantity fields that dynamically updates the price field.
	 * 
	 * @param url Pointer to the resource.
	 * @param rb Contains locale-specific objects.
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb) {

		//Set all the value that need to appear when the pane loads.
		try {
			orderNumber.setText(Integer.toString(readOrder.readOrderNumber()));
		} catch (FileNotFoundException ex) {
			JOptionPane.showMessageDialog(null, "File Not Found.");
		}
		cakePrice.setText(Double.toString(3.99));
		piePrice.setText(Double.toString(2.99));
		cakeQTY.setText(Integer.toString(1));
		pieQTY.setText(Integer.toString(1));

		//Listener on cake quantity field.
		cakeQTY.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue observable, String oldValue, String newValue) {
				try {
					cakePrice.setText(pastry.cakePriceCalc(cakeQTY.getText(), sizeGroup.getSelectedToggle().getUserData().toString(), cakePrice.getText()));
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Quantity has to be 10 or less.");
					cakeQTY.setText("");
				}
			}

		});

		sizeGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			@Override
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
					cakePrice.setText(pastry.cakePriceCalc(cakeQTY.getText(), sizeGroup.getSelectedToggle().getUserData().toString(), cakePrice.getText()));
			}
		});
		
		
		//Listener on pie quantity field. 
		pieQTY.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue observable, String oldValue, String newValue) {
				try {
					piePrice.setText(pastry.piePriceCalc(pieQTY.getText()));
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Quantity has to be greater than 0");
					pieQTY.setText("");
				}
			}

		});

	}

	/**
	 * A getter for the orderView Pane.
	 * 
	 * @return the orderView Pane. 
	 */
	@Override
	public Pane getView() {
		return orderView;
	}

	/**
	 * Sets if the back button has been pressed on the next pane.
	 * 
	 * @param bbp sets it to true or false. 
	 */
	public void setBBP(boolean bbp) {
		this.BBP = bbp;
	}

	/**
	 * Sets the client name from the next pane so it can be used without worrying
	 * about which child is the current child.
	 * 
	 * @param clientName the clients name value.
	 */
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	

	

}
