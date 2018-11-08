package VSBakery;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * execution class will take the FXMLMain View
 *
 * @author Ray
 */
public class VSBakery extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("FXMLMain.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    /**
     * main method to launch the program
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
