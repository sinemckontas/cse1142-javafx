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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.swing.*;

import static javafx.scene.text.FontWeight.BOLD;
//import javax.xml.soap.Text;


public class GameWindow extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception {

        FileInputStream inputstream = new FileInputStream("img/minecraft-clipart-minecraft-heart.png");
        Image livesfull = new Image(inputstream);


        ImageView viewLivesFull = new ImageView(livesfull);
        ImageView viewLivesFull2= new ImageView(livesfull);
        ImageView viewLivesFull3= new ImageView(livesfull);



        viewLivesFull.setFitHeight(30);
        viewLivesFull.setFitWidth(30);
        viewLivesFull2.setFitHeight(30);
        viewLivesFull2.setFitWidth(30);
        viewLivesFull3.setFitHeight(30);
        viewLivesFull3.setFitWidth(30);


        Button loadbutton= new Button("Load Previous Game");
        loadbutton.setPadding(new Insets(0, 200, 0, 0));


        HBox hBox1= new HBox();
        HBox hBox= new HBox();

        hBox.getChildren().addAll(viewLivesFull, viewLivesFull2, viewLivesFull3);
        hBox.setPadding(new Insets(0, 0, 0, 200));


        hBox1.getChildren().addAll(loadbutton, hBox);
        hBox1.setAlignment(Pos.TOP_CENTER);

        Text text= new Text("Welcome to the game\n \n Please select action");
        text.setStyle("-fx-font-weight: bold");




      //  Label label= new Label("this is a label");


        Pane canvas = new Pane();
        VBox vbox = new VBox( 100); // spacing = 8
        vbox.setPrefSize(700, 700);
        vbox.setAlignment(Pos.TOP_CENTER);
        canvas.getChildren().add(vbox);
        canvas.setPadding(new Insets(100,100,100,100));
        vbox.setBackground(new Background(new BackgroundFill(Color.DARKOLIVEGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        vbox.getChildren().addAll(hBox1, text, new Button("Attack"), new Button("Defend"), new Button("Wait"));
        vbox.setPadding(new Insets(15));
        primaryStage.setScene(new Scene(canvas, 700,700));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
