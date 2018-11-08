/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VSBakery;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import javafx.scene.control.Label;
import javax.swing.JOptionPane;

/**
 * This class is used to read information from a file.
 * @author Michael
 */
public class ClientReadFile {

    private ClientWriteToFile writer = new ClientWriteToFile();


    /**method will read the order from the file
     * 
     * @param orderNum The orders number
     * @return input Returns the reading scanner.
		 * 
     * @author Michael
     */
    public Scanner readOrder(String orderNum) {

        File orderFile = new File("..\\Orders\\" + orderNum + ".txt");

        Scanner input = null;
        try {
            input = new Scanner(orderFile);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Order File Not Found.");
        }

        return input;
    }

    /**a method will read the correct order number
     * 
     * @return orderNum The current order number
     * @throws FileNotFoundException  The exception that is thrown if it is 
		 * caused.
     * @author Michael
     */
    public int readOrderNumber() throws FileNotFoundException {
        //Set the current line to retrieve.
        int currentLine = 0;

        File orderNumbers = new File("..\\Orders\\orderNumbers.txt");
        Scanner input = new Scanner(orderNumbers);

        while (input.hasNext()) {
            //set current line to the value in the line.
            currentLine = Integer.parseInt(input.nextLine());
        }

        //Write the current line to the file.
        writer.writeToOrderNumbers(currentLine);

        //Set value to return that is 1 more than the value of the last line.
        int orderNum = currentLine + 1;

        return orderNum;
    }

    /**
     * read the client information from the file for existing client.
     *
     * @param phone The clients phone number.
     * @return input The reading scanner.
     * @throws FileNotFoundException The exception that is thrown if it is 
		 * caused.
     * @author Rong
     */
    public Scanner readClientInfo(String phone) throws FileNotFoundException {

        File file = new File("..\\ClientInfo\\" + phone + ".txt");

        Scanner info = new Scanner(file);

        return info;
       
    }

}
