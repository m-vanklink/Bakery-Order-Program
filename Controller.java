
package VSBakery;
import javafx.scene.layout.Pane;

/**The super class of all the controllers
 *
 * @author Ray
 */
public abstract class Controller {
    private Controller parentController;
    private FXMLMainController managingController;
    private Controller childController;
    
    /**will return the managing Controller
     * 
     * @return managingController
     */
    public FXMLMainController getManagingController() {
        return managingController;
    }
    
    /**Will set the Managing Controller
     * 
     * @param managingController 
     */
    public void setManagingController(FXMLMainController managingController) {
        this.managingController = managingController;
    }
    
    /** return the parent Controller of a view controller
     * 
     * @return parentController
     */
    public Controller getParentController() {
        return parentController;
    }
    
    /** to assign a parent controller of the view controller
     * 
     * @param parentController 
     */
     public void setParentController(Controller parentController) {
        this.parentController = parentController;
    }
    
     /** to return the childController of the view controller
      * 
      * @return childController
      */
    public Controller getChildController() {
        return childController;
    }
    
    /**to assign the child controller to the view controller
     * 
     * @param childController 
     */
    public void setChildController(Controller childController) {
        this.childController = childController;
    }
    
    /**an abstract method that will return this view
     * 
     * @return view
     */
    public abstract Pane getView();

    
}
