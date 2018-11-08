
package VSBakery;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

/**
 * FXML Main Controller class
 *
 * @author Ray
 */
public class FXMLMainController implements Initializable {

    @FXML
    StackPane mainPage;
    @FXML
    LoginViewController loginViewController;

    
    /**to made the login view as the first view of the program
     * 
     * @param url
     * @param rb 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loginViewController.setManagingController(this);
    }   
    
    /**a method that will add the screen when user made the action to go next view.
     * it will set the new page as child and current page as parent.
     * @param fxmlFile
     * @param sender
     * @throws IOException 
     */
    public void addScreen(String fxmlFile, Controller sender) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        Parent view = loader.load();
	Controller newController = loader.getController(); 
        mainPage.getChildren().add(view);
        
          
        newController.setParentController(sender);
        sender.setChildController(newController);
        newController.setManagingController(this); 
        
       
    }
    /**a method that will remove the current view, if use made the action to go 
     * either next or previous page view.
     * @param sender 
     */
    public void removeScreen(Controller sender) {
        mainPage.getChildren().remove(sender.getView());
    }
    
}
