/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VSBakery;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javax.swing.JOptionPane;

/**
 * This classed is used to write client and order information to a file.
 * 
 * @author Michael
 */
public class ClientWriteToFile {

    
    /**method to write the order info into a file
     * 
     * @param orderNumber The current order number.
     * @param pickupDate The date the client wants to pick up their order.
     * @param sizeGroup The size of the cake they ordered.
     * @param cakeQTY The quantity of cake they ordered.
     * @param cakeFlavour The flavour of cake.
     * @param cakePrice The price of the ordered cake.
     * @param pieFlavour The pie flavour.
     * @param pieQTY The quantity of pie ordered.
     * @param piePrice The price of the pie ordered.
     * @param cake Written if cake is selected.
     * @param pie Written if pie is selected.
     * @throws FileNotFoundException 
     * @author Michael
     */
    public void writeOrder(Label orderNumber, DatePicker pickupDate, ToggleGroup sizeGroup,
            TextField cakeQTY, ToggleGroup cakeFlavour, Label cakePrice,
            ToggleGroup pieFlavour, TextField pieQTY, Label piePrice, CheckBox cake,
            CheckBox pie) throws FileNotFoundException {

        File file = new File("..\\Orders\\" + orderNumber.getText() + ".txt");

        try (PrintWriter output = new PrintWriter(file)) {

            output.println(orderNumber.getText());
            output.println(pickupDate.getValue());

            //Only print to file if cake is checked.
            if (cake.isSelected()) {
                output.println("Cake");

                //if one of the the size radio buttons is selected.
                if (sizeGroup.getSelectedToggle() != null) {
                    output.println(sizeGroup.getSelectedToggle().getUserData().toString());
                } else {
                    JOptionPane.showMessageDialog(null, "Please select cake size.");
                }

                //if one of the cake flavour radio buttons is selected.
                if (cakeFlavour.getSelectedToggle() != null) {
                    output.println(cakeFlavour.getSelectedToggle().getUserData().toString());
                } else {
                    JOptionPane.showMessageDialog(null, "Please select cake flavour.");
                }

                output.println(cakeQTY.getText());

                output.println(cakePrice.getText());
            }

            //If pie is checked.
            if (pie.isSelected()) {
                output.println("Pie");
                output.println("N/A");

                //if a pie flavour radio button is selected.
                if (pieFlavour.getSelectedToggle() != null) {
                    output.println(pieFlavour.getSelectedToggle().getUserData().toString());
                } else {
                    JOptionPane.showMessageDialog(null, "Please select pie flavour.");
                }

                output.println(pieQTY.getText());
                output.println(piePrice.getText());
            }

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Order File Not Found.");
        }

    }

    /**method to write the order number
     * 
     * @param currentOrderNum the current order number.
     * @throws FileNotFoundException  Thrown if the exception occurs.
     * @author Michael
     */
    public void writeToOrderNumbers(int currentOrderNum) throws FileNotFoundException {

        File file = new File("..\\Orders\\orderNumbers.txt");

        try (PrintWriter orderNumber = new PrintWriter(file)) {
            orderNumber.println(currentOrderNum + 1);
        }

    }

    /**
     * method to record the new client information into a file.
     *
     * @param firstName The first name of the client.
     * @param lastName The last name of the client.
     * @param address The address of the client.
     * @param phoneNum The phone number of the client.
     * @param email The email of the client.
     * @throws FileNotFoundException Thrown if the exception occurs.
     * @author Rong
     */
    public void recordClientInfo(String firstName, String lastName, String address,
            String phoneNum, String email) throws FileNotFoundException {

        File file = new File("..\\ClientInfo\\" + phoneNum + ".txt");

        try (PrintWriter output = new PrintWriter(file)) {
            output.print(firstName);
            output.print(";");
            output.print(lastName);
           output.print(";");
            output.print(address);
          output.print(";");
            output.print(phoneNum);
          output.print(";");
            output.print(email);
        }
    }

}
