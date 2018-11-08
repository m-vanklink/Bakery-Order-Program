
package VSBakery;

import java.util.ArrayList;

/**
 * This class creates the client objects based on name, address, and their order 
 * quantity.
 * 
 * @author Michael
 */
public class Client {
	
	private String name;
	private String address;
	private int orderQTY;
	private ArrayList<Pastry> pastry = new ArrayList();
	
	/**
	 * The default client constructor to set the data members to default values.
	 */
	Client(){
		this.name = "Underfined";
		this.address ="123 Fake St.";
		this.orderQTY = 1;
	}
	
	/**
	 * The arugment constructor to set the data members to specific values.
	 * 
	 * @param name The clients name.
	 * @param address The clients address.
	 * @param qty The clients order quantity.
	 */
	Client(String name, String address, int qty){
		this.name = name;
		this.address = address;
		this.orderQTY = qty;
	}
	
	/**
	 * The method used to add the clients orders to an array list.
	 * 
	 * @param pastry The order.
	 */
	public void  purchasePastry(Pastry pastry){
		this.pastry.add(pastry);
	} 
	
	/**
	 * Makes the clients information into a string.
	 * 
	 * @return The clients information as a string.
	 */
	@Override
	public String toString(){
		return name +" "+ address + " " + orderQTY;
	}
	
	
	
}
