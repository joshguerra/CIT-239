/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageselector;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Josh
 */
public class ImageSelector extends Application {

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Create a border pane 
        BorderPane pane = new BorderPane();
        
        // define images
        Image bear = new Image("bear.png");
        Image picard = new Image("picard.jpg");
        Image joker = new Image("joker.jpg");
        Image scar = new Image("scar.jpg");
        // 
       

        // Place nodes in the pane
        pane.setTop(new CustomPane(new Button("^")));
        pane.setRight(new CustomPane(new Button(">")));
        pane.setBottom(new CustomPane(new Button("v")));
        pane.setLeft(new CustomPane(new Button("<")));        
        pane.setCenter(new CustomPane(new ImageView(bear)));  

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("ShowImage"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    /**
     * The main method is only needed for the IDE with limited JavaFX support.
     * Not needed for running from the command line.
     */
    public static void main() {
        launch();
    }

}

class CustomPane extends StackPane {
  public CustomPane(ImageView img) {
    getChildren().add(img);
    setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
  }
  
  public CustomPane(Button btn) {
    getChildren().add(btn);
    setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
  }
}
