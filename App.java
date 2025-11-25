import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.CheckBox;
import javafx.scene.Node;


/**
 * Template JavaFX application.
 */
public class App extends Application {
    CheckBox light = new CheckBox();
    HBox rowlight;
    VBox lightbox = new VBox();
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) {
        // Create components to add.
        VBox contentBox = new VBox();
        contentBox.setAlignment(Pos.CENTER);

        Label promptLabel = new Label();
        promptLabel.setText("Welcome to lights out!");
        createlightboxes();

      
        
        TextArea messageBox = new TextArea();
        messageBox.setEditable(false);

        Button submissionBtn = new Button();
        submissionBtn.setText("Submit");

        // Set up reactions (aka callbacks).

        // Add components to the content box.
        contentBox.getChildren().add(promptLabel);
        contentBox.getChildren().add(lightbox);
        // Set up the window and display it.
        Scene scene = new Scene(contentBox, 300, 200);
        stage.setScene(scene);
        stage.setTitle("Amazing App 2000");
        stage.show();

    } 
    void createlightboxes() {
        for (int i =0; i < 5; i++){
            rowlight = new HBox();
            for (int j=0; j < 5; j++){
                light = new CheckBox();
                rowlight.getChildren().add(light);
            }
           lightbox.getChildren().add(rowlight);
            
        } 

    }

    /**
     * Handle the submission of a thought.
     * @param inputBox  The TextField where the user types their thought.
     * @param outputBox The TextArea where the submitted thoughts are displayed.
     */
    
}
