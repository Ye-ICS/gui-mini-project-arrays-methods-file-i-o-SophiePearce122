import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.CheckBox;// checkbox for the lights. 
import javafx.scene.Node;
import java.util.Random; // Random Generator.
import javafx.animation.Timeline;
import javafx.util.Duration;
import java.util.Timer;

public class App extends Application {
    CheckBox[] light = {new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), };
    HBox[] rowlight = {new HBox(), new HBox(), new HBox(), new HBox(), new HBox()};
    VBox lightbox = new VBox();
    int randomInt;
    HBox diffculty = new HBox();
    int time = 99;
    Timer Timer = new Timer();
    Label timer = new Label("Seconds left:" + Timer);
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) {
        // Create components to add.
        VBox contentBox = new VBox();
        contentBox.setAlignment(Pos.CENTER);
        diffculty.setAlignment(Pos.CENTER);
        lightbox.setAlignment(Pos.CENTER);
        Label promptLabel = new Label();
        promptLabel.setText("Welcome to lights out!");
        createlightboxes();
        
      
        
        TextArea messageBox = new TextArea();
        messageBox.setEditable(false);

        Button newPuzzle = new Button();
        newPuzzle.setText("New puzzle on easy");

        Button newMediumPuzzle = new Button();
        newMediumPuzzle.setText("Click me to start new medium puzzle.");

        Button newHardPuzzle = new Button();
        newHardPuzzle.setText("Click me to start a new hard puzzle.");

       
        // Set up reactions (aka callbacks).

        // Add components to the content box.
        contentBox.getChildren().addAll(promptLabel, lightbox, diffculty, timer);
        diffculty.getChildren().addAll(newPuzzle, newMediumPuzzle, newHardPuzzle);
        // Set up the window and display it.
        Scene scene = new Scene(contentBox, 300, 200);
        stage.setScene(scene);
        stage.setTitle("Amazing App 2000");
        stage.show();
        newPuzzle.setOnAction(event -> {
            lightbox.getChildren().clear();
            createlightboxes();
            
        } );
        newMediumPuzzle.setOnAction(event -> {
            lightbox.getChildren().clear();
            createMediumLightBoxes();

        } 

        );

        newHardPuzzle.setOnAction(event -> {
            lightbox.getChildren().clear();
            createHardLightBoxes();
            
        });
        for ( int i =0; i < 25; i++){

            int lightNum = i;
            light[i].setOnAction(event -> {
                lightClicked(lightNum);
        });
        }
        
        

    } 

    void lightClicked(int i){
        int pickLight = i;
        boolean lightSetting; //= light[pickLight].isSelected();
        // light[pickLight].setSelected(!lightSetting);
        lightSetting = light[pickLight+1].isSelected();
        light[pickLight+1].setSelected(!lightSetting);
        lightSetting = light[pickLight-1].isSelected();
        light[pickLight-1].setSelected(!lightSetting);
        lightSetting = light[pickLight + 5].isSelected();
        light[pickLight+5].setSelected(!lightSetting);
        lightSetting = light[pickLight-5].isSelected();
        light[pickLight-5].setSelected(!lightSetting);


    }

    void createlightboxes() {
        for (int i =0; i < 5; i++){
            rowlight[i] = new HBox();
            rowlight[i].setAlignment(Pos.CENTER);
            for (int j=0; j < 5; j++){
                randomGenerator();
                if (randomInt == 1){
                    light[i*5 + j].setSelected(true);
                }
                rowlight[i].getChildren().add(light[i*5 + j]);
            }
           lightbox.getChildren().add(rowlight[i]);
            
        } 

    } void createMediumLightBoxes(){
        for (int i =0; i < 10; i++){
            rowlight[i] = new HBox();
            rowlight[i].setAlignment(Pos.CENTER);
            for (int j =0; j < 10; j++){
                randomGenerator();
                light[j]= new CheckBox();
                if (randomInt ==1){
                    light[j].setSelected(true);
                }
                rowlight[i].getChildren().add(light[j]);

            }
            lightbox.getChildren().add(rowlight[i]);
        }

    } void createHardLightBoxes(){
        for (int i =0; i< 15; i++){
            rowlight[i] = new HBox();
            rowlight[i].setAlignment(Pos.CENTER);
            for (int j =0; j < 15; j++){
                randomGenerator();
                light[j] = new CheckBox();
                if (randomInt == 1){
                    light[j].setSelected(true);

                } rowlight[i].getChildren().add(light[j]);

            }
            lightbox.getChildren().add(rowlight[i]);
        }



    } 

    void randomGenerator(){
        int maxnum = 2;
        Random random = new Random();
        randomInt = random.nextInt(maxnum);
    }

    /**
     * Handle the submission of a thought.
     * @param outputBox The TextArea where the submitted thoughts are displayed.
     */
    
}
