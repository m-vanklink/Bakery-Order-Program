
package VSBakery;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javax.swing.JOptionPane;

/**
 * Controller for login view
 *
 * @author Ray
 */
public class LoginViewController extends Controller implements Initializable {

   
    @FXML
    private Pane loginView;
    @FXML
    private TextField phoneNum;

    /** The submit Button handler move to ClientInfomation page
     * if the user enter correct client phone number, or if the the 
     * client information does not exist.
     * 
     * @param event
     * @throws IOException 
     */
    @FXML
    private void handleSubmitAction(ActionEvent event) throws IOException {
        
        //to check if the input field is empty or not
        if(new Validation().isEmptys(phoneNum.getText())) {
             JOptionPane.showMessageDialog(null, 
                     "Please Input the Phone Number");
        
             //to check if the input only contain number
        } else if (!new Validation().isNumber(phoneNum.getText())) {
             JOptionPane.showMessageDialog(null, 
                     "Phone number have to be 10-11 digit!");
           
             //to check if the file exist or not
        } else if(!new Validation().fileExist(phoneNum.getText())) {
          JOptionPane.showMessageDialog(null, 
          "Phone Number Not Found! Please check the phone number, or add new Client");
            
        } else {
            
            
            getManagingController().addScreen("ClientInfoView.fxml", this);
            getManagingController().removeScreen(this);
            
            //pass the phone number from this class to it's child class
            ClientInfoViewController cv = (ClientInfoViewController) getChildController();
            cv.readInfo(phoneNum.getText());
        }
    } 
    
    /**The Button action handler will add a client 
     * 
     * @param event
     * @throws IOException 
     */
    @FXML
    private void handleNewClientAction(ActionEvent event) throws IOException {
        getManagingController().addScreen("NewClientView.fxml", this);
        getManagingController().removeScreen(this);
 
    }
    
    /**the button action handler that will exit the program
     * 
     * @param event
     * @throws IOException 
     */
     @FXML
    private void exitButtonHandler(ActionEvent event) throws IOException {
        Platform.exit();
    }
    
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    /**a method will return the loginView
     * 
     * @return loginView
     */
    @Override
    public Pane getView() {
       return loginView;
    }

    
}
