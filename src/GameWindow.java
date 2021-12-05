import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
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


import java.util.Arrays;

import static javafx.scene.text.FontWeight.BOLD;
//import javax.xml.soap.Text;


public class GameWindow extends Application {
    final int WIDTH = 640;
    final int HEIGHT = 480;





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





        HBox hBox= new HBox();

        hBox.getChildren().addAll(viewLivesFull, viewLivesFull2, viewLivesFull3);
        hBox.setPadding(new Insets(0, 0, 0, 200));
        hBox.setAlignment(Pos.TOP_RIGHT);

        Text text= new Text("Hi Adventurer!\n You have been arrested while trespassing to a restricted area.\n The guard waiting in front of your cell has a set of keys hanging from his belt.\n You could try to convince him to let you out since you are just a harmless adventurer.\n Or maybe, you can just put your hand through the bars and steal the keys quietly. \n If you don't think you can do both, you can wait till something happens. \n\n What will you do?");
        text.setStyle("-fx-font-weight: bold");
        HBox fortext= new HBox();
        fortext.setAlignment(Pos.TOP_CENTER);
        fortext.getChildren().add(text);
        fortext.setBackground(new Background(new BackgroundFill(Color.ANTIQUEWHITE, CornerRadii.EMPTY, Insets.EMPTY)));








      //  Label label= new Label("this is a label");
        FileInputStream newImg = new FileInputStream("img/2NQ49.jpg");
        Image level1b = new Image(newImg);


        BackgroundImage level1Back= new BackgroundImage(level1b, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(700,700,false,false,true,true));

        Pane canvas = new Pane();
        canvas.setBackground(new Background(level1Back));
        VBox vbox = new VBox( 100); // spacing = 8
        vbox.setPrefSize(WIDTH, HEIGHT);
        vbox.setAlignment(Pos.TOP_CENTER);
        canvas.getChildren().add(vbox);
        canvas.setPadding(new Insets(100,100,100,100));
        //vbox.setBackground(new Background(new BackgroundFill(Color.DARKOLIVEGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        vbox.getChildren().addAll(hBox, fortext, new Button("CONVINCE HIM"), new Button("STEAL THE KEYS"), new Button("WAIT"));
        vbox.setPadding(new Insets(15));
        primaryStage.setScene(new Scene(canvas, WIDTH,HEIGHT));
        primaryStage.show();
        addBackground(canvas,primaryStage,"background.jpg");


    }
    private void addBackground(Pane pane,Stage stage, String fileName){
        ImageView imageView = new ImageView(new Image(getClass().getResource(fileName).toExternalForm()));
        imageView.fitWidthProperty().bind(stage.widthProperty());

        pane.getChildren().add(imageView);

    }

    public static void main(String[] args) {
        launch(args);
    }
}
