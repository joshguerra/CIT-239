/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basiccircles;

import java.util.List;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class BasicCircles extends Application {

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        int base = (int)(Math.random() * 75 + 25);
        int START_X = 2 * base;
        int START_Y = 2 * base;
        int RADIUS = base;
        
        List<String> fonts = Font.getFontNames();
        
        // Create a pane to nodes
        Pane pane = new Pane();
        
        // Create a circle and set its properties
        Circle circle1 = new Circle();
        circle1.setCenterX(START_X);
        circle1.setCenterY(START_Y);
        circle1.setRadius(RADIUS);
        circle1.setStroke(Color.RED);
        circle1.setFill(Color.BLACK);
        
        // Create a label and set its properties
        Label label1 = new Label("Circle 1");
        label1.setFont(Font.font(fonts.get((int)(Math.random() * fonts.size())), 
                FontWeight.BOLD, FontPosture.REGULAR, (int)(2.0/5 * RADIUS)));
        label1.setTextFill(Color.RED);
        label1.setAlignment(Pos.CENTER);
        label1.setLayoutX(START_X - 3.25/5 * RADIUS);
        label1.setLayoutY(START_Y - 1.5/5 * RADIUS);

        // Create a circle and set its properties
        Circle circle2 = new Circle();
        circle2.setCenterX(START_X + 2 * RADIUS);
        circle2.setCenterY(START_Y);
        circle2.setRadius(RADIUS);
        circle2.setStroke(Color.LIGHTGREY);
        circle2.setFill(Color.CORNFLOWERBLUE);
        
        // Create a label and set its properties
        Label label2 = new Label("Circle 2");
        label2.setFont(Font.font(fonts.get((int)(Math.random() * fonts.size())), 
                FontWeight.BOLD, FontPosture.REGULAR, (int)(2.0/5 * RADIUS)));
        label2.setTextFill(Color.LIGHTGRAY);
        label2.setAlignment(Pos.CENTER);
        label2.setLayoutX(START_X - (3.25/5 - 2) * RADIUS);
        label2.setLayoutY(START_Y - 1.5/5 * RADIUS);

        // Create a circle and set its properties
        Circle circle3 = new Circle();
        circle3.setCenterX(START_X + 4 * RADIUS);
        circle3.setCenterY(START_Y);
        circle3.setRadius(RADIUS);
        circle3.setStroke(Color.GOLD);
        circle3.setFill(Color.PURPLE);
        
        // Create a label and set its properties
        Label label3 = new Label("Circle 3");
        label3.setFont(Font.font(fonts.get((int)(Math.random() * fonts.size())), 
                FontWeight.BOLD, FontPosture.REGULAR, (int)(2.0/5 * RADIUS)));
        label3.setTextFill(Color.GOLD);
        label3.setAlignment(Pos.CENTER);
        label3.setLayoutX(START_X - (3.25/5 - 4) * RADIUS);
        label3.setLayoutY(START_Y - 1.5/5 * RADIUS);

        // Create a circle and set its properties
        Circle circle4 = new Circle();
        circle4.setCenterX(START_X + RADIUS);
        circle4.setCenterY(START_Y + 2 * RADIUS);
        circle4.setRadius(RADIUS);
        circle4.setStroke(Color.OLIVE);
        circle4.setFill(Color.DARKSEAGREEN);
        
        // Create a label and set its properties
        Label label4 = new Label("Circle 4");
        label4.setFont(Font.font(fonts.get((int)(Math.random() * fonts.size())), 
                FontWeight.BOLD, FontPosture.REGULAR, (int)(2.0/5 * RADIUS)));
        label4.setTextFill(Color.OLIVE);
        label4.setAlignment(Pos.CENTER);
        label4.setLayoutX(START_X - (3.25/5 - 1) * RADIUS);
        label4.setLayoutY(START_Y - (3.25/5 - 2) * RADIUS);
         
        // Create a line and set its properties
        Line line = new Line();
        line.setStartX(START_X - RADIUS);
        line.setStartY(START_Y + RADIUS);
        line.setEndX(START_X + 5 * RADIUS);
        line.setEndY(START_Y + RADIUS);
        line.setStroke(Color.BLACK);

        pane.getChildren().add(circle1);
        pane.getChildren().add(circle2);
        pane.getChildren().add(circle3);
        pane.getChildren().add(circle4);
        pane.getChildren().add(line);
        pane.getChildren().add(label1);
        pane.getChildren().add(label2);
        pane.getChildren().add(label3);
        pane.getChildren().add(label4);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 9 * base, 6 * base);
        primaryStage.setTitle("ShowCircle"); // Set the stage title
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
