
package VSBakery;

import java.io.File;

/**a validation class 
 *
 * @author Ray
 */
public class Validation {
   
    /**Default Constructor with no Argument
     * 
     */
     public Validation() {
        
    }
    
    /**to check if the input is empty or not
     * 
     * @param string
     * @return 
     */
    public boolean isEmptys(String string) {
       boolean valid = string.equals("");

        return valid;
    }
    
    /** to check if it was proper phone number format
     * 
     * @param string
     * @return 
     */
    public boolean isNumber(String string) {
        
        boolean valid = string.matches("^(1\\-\\s)?[0-9]{3}\\-?\\s?[0-9]{3}\\-?\\s?[0-9]{4}$");

        return valid;
    }
    
    /** to check if the input only contain letters
     * 
     * @param string
     * @return 
     */
    public boolean isLetters(String string) {
        boolean valid = string.matches("[a-zA-Z]+");
      
        return valid;
    }
    
    /** to check if the field already exist
     * 
     * @param fileName
     * @return 
     */
    public boolean fileExist(String fileName) {
        File file = new File("..\\ClientInfo\\" + fileName + ".txt");
        boolean exist = file.exists();
        return exist;
}
    
    /**to check if the input is in correct email format
     * 
     * @param email
     * @return 
     */
    public boolean validEmail(String email) {
        boolean valid = email.matches(".*@.*\\..*");
        return valid;
    } 
    
    /**to check if the input is correct Address format
     * 
     * @param address
     * @return 
     */
    public boolean validAddress(String address) {
        boolean valid = address.split("\n").length != 3;
        return valid;
    }
}
