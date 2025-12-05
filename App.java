import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.CheckBox;// checkbox for the lights. 
import javafx.scene.Node; // node. Just in case.
import java.util.Random; // Random Generator.
import java.util.Timer;
import java.util.TimerTask;

public class App extends Application {
    CheckBox[] light = {new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox() }; // creates a new checkbox 300 times. i know, its alot O_O
    HBox[] rowlight = {new HBox(), new HBox(), new HBox(), new HBox(), new HBox(), new HBox(), new HBox(), new HBox(), new HBox(), new HBox(), new HBox(), new HBox(), new HBox(), new HBox(), new HBox(), new HBox(), new HBox(), new HBox(), new HBox(), new HBox()};
    VBox lightbox = new VBox();// vbox for the light boxes.
    int randomInt; // random number to change checkbox status.
    HBox diffculty = new HBox();// hbox for the diffculties buttons.
    int time = 99; // the time for the timer.
    Label timerLabel = new Label(); // timer (does not work)
    int rowLength = 5; // length for creating lightboxes.
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) {
        // Create components to add.
        long startTime = System.currentTimeMillis();
        VBox contentBox = new VBox();
        contentBox.setAlignment(Pos.CENTER);
        diffculty.setAlignment(Pos.CENTER); // adjust difculty hbox to center.
        lightbox.setAlignment(Pos.CENTER);
        Label promptLabel = new Label(); // welcome/win text
        promptLabel.setText("Welcome to lights out!"); // sets the promptlabel text when you start.
        createlightboxes(); // creates light boxes when launched.
        
        
        TextArea messageBox = new TextArea(); // useless
        messageBox.setEditable(false);

        Button newPuzzle = new Button();
        newPuzzle.setText("New puzzle on easy");

        Button newMediumPuzzle = new Button(); // medium puzzle
        newMediumPuzzle.setText("Click me to start new medium puzzle.");

        Button newHardPuzzle = new Button();
        newHardPuzzle.setText("Click me to start a new hard puzzle.");
       
        boolean win = false;
        checkifwin(win); // method to check if user won
        // Set up reactions (aka callbacks).
        if (win == true){ // if win equals true then..
            promptLabel.setText("you win!"); // sets prompt text to you win!
            long endtime = System.currentTimeMillis() - startTime;
            timerLabel.setText("Time taken" + endtime);
        }
        // Add components to the content box.
        
        contentBox.getChildren().addAll(promptLabel, lightbox, diffculty, timerLabel);// adds all 
        diffculty.getChildren().addAll(newPuzzle, newMediumPuzzle, newHardPuzzle); // adds the buttons for dificulity
        // Set up the window and display it.
        Scene scene = new Scene(contentBox, 300, 200);
        stage.setScene(scene);
        stage.setTitle("Lights out"); // set title
        stage.show();
        newPuzzle.setOnAction(event -> { // creates a new puzzle.
            lightbox.getChildren().clear(); // clears lightboxes before creating new lightboxes
            createlightboxes();
            rowLength = 5;
        } );
        newMediumPuzzle.setOnAction(event -> {
            lightbox.getChildren().clear();
            createMediumLightBoxes(); // method to create medium light boxes
            rowLength = 10; // length for puzzle

        } 

        );

        newHardPuzzle.setOnAction(event -> {
            lightbox.getChildren().clear();
            createHardLightBoxes();
            rowLength = 15; // length for hard diffcultity
        });
        
        for ( int i =0; i < 25; i++){ // 

            int lightNum = i;
            light[i].setOnAction(event -> {
                lightClicked(lightNum); // method for when lights clicked
            });
        }

        for (int i = 0; i < 100; i++){
            int lightNum = i;
            light [i].setOnAction(event ->{
                lightClicked(lightNum);
            });
        }
        // for (int i =0; i < 225; i++){ // slashed for now... Does not work on hard (┬┬﹏┬┬)
        //     int lightNum = i;
        //     light [i].setOnAction(event ->{
        //         lightClicked(lightNum);
        //     });        
        // }


        
        
    
        


        
        

    } 

    boolean lastColumn(int i) {
        for (int j =1; j <= rowLength; j++){
            if (i == j*rowLength -1){
                return true;
            }

        }
        return false;
    }
    boolean firstColumn(int i){
        for (int j = 0; j < rowLength; j++){
            if ( i == j*rowLength ){
                return true;
            }
        }
        return false;
        
    }

    void lightClicked(int i){ // when light clicked
        int pickLight = i;
        boolean lightSetting; //= light[pickLight].isSelected();
        // light[pickLight].setSelected(!lightSetting);
        if (!lastColumn(pickLight)){ // if the column is the last  row
            lightSetting = light[pickLight+1].isSelected();
            light[pickLight+1].setSelected(!lightSetting);
            
        } 
        if (!firstColumn(pickLight)){ // if the column is the first row.
            
            lightSetting = light[pickLight-1].isSelected();
            light[pickLight-1].setSelected(!lightSetting);
        }
        
        lightSetting = light[pickLight + rowLength].isSelected();
        light[pickLight+rowLength].setSelected(!lightSetting);
        lightSetting = light[pickLight-rowLength].isSelected();
        light[pickLight-rowLength].setSelected(!lightSetting);
    }

    void createlightboxes() { // creates the light boxes.
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

    } void createMediumLightBoxes(){// creates lightboxes for medium diffculity.
        for (int i =0; i < 10; i++){
            rowlight[i] = new HBox();
            rowlight[i].setAlignment(Pos.CENTER);
            for (int j =0; j < 10; j++){
                randomGenerator();
                light[j]= new CheckBox();
                if (randomInt ==1){
                    light[i*10 + j].setSelected(true);
                }
                rowlight[i].getChildren().add(light[i * 10 + j]);

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
    boolean checkifwin(boolean win){// boolean win checker
        for (CheckBox light: light){
            if (!light.isSelected()){// checks if all lights are turned off
                 win = true;
                 return true; // returns win true
            } 

        } 
        return false; // else, return false.
        
    } 
  
    
    
    /**
     * Handle the submission of a thought.
     * @param outputBox The TextArea where the submitted thoughts are displayed.
     */
    
}
