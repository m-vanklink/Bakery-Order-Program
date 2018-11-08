/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VSBakery;

import java.util.ArrayList;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * The class that creates pastry objects base on the name of the pastry and
 * the purchase price.
 * 
 * @author Michael
 */
public class Pastry {
	
	private String name;
	private double price;
	private ArrayList<Client> client = new ArrayList();
	
	/**
	 * The default pastry constructor that sets the data members to a default 
	 * value.
	 */
	Pastry(){
		this.name = "Undefined";
		this.price = 1.0;
	}
	
	/**
	 * the argument constructor that sets the data members to a specific value.
	 * 
	 * @param name The name of the pastry.
	 * @param price  The cost of the pastry.
	 */
	Pastry(String name, double price){
		this.name = name;
		this.price = price;
		this.client = client;
	}
	
	/**
	 * Sets which client is buying the pastry.
	 * 
	 * @param client The client object. 
	 */
	public void setClient(Client client){
		this.client.add(client);
	}
	
	/**
	 * Calculates the price of the cake being purchased.
	 * 
	 * @param cakeQTY The quantity of cakes the client wants.
	 * @param sizeGroup The size of the cake the client wants.
	 * @param cakePrice The price of the cake the client wants.
	 * @return the string version of the purchase price.
	 */
	public String cakePriceCalc(String cakeQTY, String sizeGroup, String cakePrice) {

		
			if (sizeGroup.equals("M")) {
				return Double.toString(Math.round((6.99 * Integer.parseInt(cakeQTY)) * 100.0) / 100.0);
			} else if (sizeGroup.equals("L")) {
				return Double.toString(Math.round((7.99 * Integer.parseInt(cakeQTY)) * 100.0) / 100.0);
			} else {
				return Double.toString(Math.round((3.99 * Integer.parseInt(cakeQTY)) * 100.0) / 100.0);
			}
	}
	
	/**
	 * The price calculator for the pie price.
	 * 
	 * @param pieQTY The number of pies the client wants.
	 * @return The string version of the purchase price.
	 */
	public String piePriceCalc(String pieQTY) {

		return Double.toString(Math.round((2.99 * Integer.parseInt(pieQTY)) * 100.0) / 100.0);

	}
	
}
