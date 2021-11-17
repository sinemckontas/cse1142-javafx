import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.text.Font;

import javax.swing.*;

import static javafx.scene.text.FontWeight.BOLD;
//import javax.xml.soap.Text;


public class GameWindow extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception {

        Text text= new Text("Welcome to the game\n \n Please select action");
        text.setStyle("-fx-font-weight: bold");

      //  Label label= new Label("this is a label");

        Pane canvas = new Pane();
        VBox vbox = new VBox( 100); // spacing = 8
        vbox.setPrefSize(800, 800);
        vbox.setAlignment(Pos.CENTER);
        canvas.getChildren().add(vbox);
        canvas.setPadding(new Insets(100,100,100,100));
        vbox.setBackground(new Background(new BackgroundFill(Color.DARKOLIVEGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        vbox.getChildren().addAll(text, new Button("Attack"), new Button("Defend"), new Button("Wait"));
        vbox.setPadding(new Insets(15));
        primaryStage.setScene(new Scene(canvas, 800,800));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
