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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


import java.util.Arrays;

import static javafx.scene.text.FontWeight.BOLD;
//import javax.xml.soap.Text;


public class GameWindow extends Application {

Stage mainStage;

    @Override
    public void start(Stage primaryStage) throws Exception {

        FileInputStream inputstream = new FileInputStream("img/minecraft-clipart-minecraft-heart.png");
        Image hearts = new Image(inputstream);

        mainStage = primaryStage;
        primaryStage.setScene(lvl1(hearts));
        primaryStage.show();

    }

    public Scene lvl1(Image livesfull) throws FileNotFoundException {
        Scene sc;
        FileInputStream newImg = new FileInputStream("img/2NQ49.jpg");
        Image levelimg = new Image(newImg);

        String level1txt= new String("Hi Adventurer!\n You have been arrested while trespassing to a restricted area.\n The guard waiting in front of your cell has a set of keys hanging from his belt.\n You could try to convince him to let you out since you are just a harmless adventurer.\n Or maybe, you can just put your hand through the bars and steal the keys quietly. \n If you don't think you can do both, you can wait till something happens. \n\n What will you do?");

        Button button1= new Button("CONVINCE HIM");
        Button button2= new Button("STEAL THE KEYS");
        Button button3= new Button("WAIT");

        String correctoption="WAIT";

        checkCorrect(correctoption,button1, button2, button3).setOnAction(correctchoice);


        BackgroundImage levelB= new BackgroundImage(levelimg, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(700,700,false,false,true,true));
        Pane canvas = new Pane();
        levelCreation(canvas, levelB, livesfull, level1txt, button1, button2, button3);


        sc = new Scene(canvas, 700, 700);

        return sc;
    }
    public Scene lvl2(Image livesfull) throws FileNotFoundException{
        Scene sc;
        FileInputStream newImg = new FileInputStream("img/level2bgnd.jpg");
        Image levelimg = new Image(newImg);

        String level2txt= new String("this is lvl2");
        Button button1= new Button("CONVINCE 2");
        Button button2= new Button("STEAL THE 2");
        Button button3= new Button("WAIT");

        String correctoption="WAIT";

        BackgroundImage levelB= new BackgroundImage(levelimg, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(700,700,false,false,true,true));
        Pane canvas = new Pane();
        levelCreation(canvas, levelB, livesfull, level2txt,  button1, button2, button3);

        sc = new Scene(canvas, 700, 700);

        return sc;
    }
    public Scene lvl3(Stage stg, Image livesfull) throws FileNotFoundException{
        Scene sc;
        FileInputStream newImg = new FileInputStream("img/2NQ49.jpg");
        Image levelimg = new Image(newImg);

        String level3txt= new String("this is lvl3");
        Button button1= new Button("CONVINCE 3");
        Button button2= new Button("STEAL THE 3");
        Button button3= new Button("WAIT");
        String correctoption="WAIT";


        BackgroundImage levelB= new BackgroundImage(levelimg, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(700,700,false,false,true,true));
        Pane canvas = new Pane();
        levelCreation(canvas, levelB, livesfull, level3txt,  button1, button2, button3);

        sc = new Scene(canvas, 700, 700);

        return sc;
    }
    public Scene lvl4(Stage stg, Image livesfull) throws FileNotFoundException{
        Scene sc;
        FileInputStream newImg = new FileInputStream("img/2NQ49.jpg");
        Image levelimg = new Image(newImg);

        String level4txt= new String("this is lvl4");
        Button button1= new Button("CONVINCE 4");
        Button button2= new Button("STEAL THE 4");
        Button button3= new Button("WAIT");

        String correctoption="WAIT";

        BackgroundImage levelB= new BackgroundImage(levelimg, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(700,700,false,false,true,true));
        Pane canvas = new Pane();
        levelCreation(canvas, levelB, livesfull, level4txt,  button1, button2, button3);

        sc = new Scene(canvas, 700, 700);

        return sc;

    }

    public void levelCreation(Pane thepane,BackgroundImage bck, Image crntLives, String lvltxt, Button b1, Button b2, Button b3){

        thepane.setBackground(new Background(bck));
        VBox vbox = new VBox( 100); // spacing = 8
        vbox.setPrefSize(700, 700);
        vbox.setAlignment(Pos.TOP_CENTER);
        thepane.getChildren().add(vbox);
        thepane.setPadding(new Insets(100,100,100,100));
        vbox.getChildren().addAll(currentLives(3,crntLives), levelText(lvltxt), levelOptions(b1, b2, b3));
        vbox.setPadding(new Insets(15));
    }

    public Button checkCorrect (String cB,Button fB,Button sB,Button tB){
        if (cB.equalsIgnoreCase(fB.getText())){
            return fB;
        }
        else if (cB.equalsIgnoreCase(sB.getText())){
            return sB;
        }
        else if (cB.equalsIgnoreCase(tB.getText())){
            return tB;
        }
        else {
            throw new RuntimeException("Correct choice string was not found among the given buttons.");
        }
    }



    public VBox levelOptions(Button first, Button mid, Button last) {
        VBox forButtons= new VBox();
        forButtons.getChildren().addAll(first, mid, last);
        forButtons.setAlignment(Pos.CENTER);
        forButtons.setSpacing(50);

        return forButtons;
    }

    public HBox currentLives(int howmanylives, Image hearts){
        int i=0;
        ImageView[] liVes= new ImageView[howmanylives];
        for(;i<howmanylives; i++){
            liVes[i] = new ImageView(hearts);
            liVes[i].setFitHeight(30);
            liVes[i].setFitWidth(30);
        }
        HBox hBox= new HBox();
        hBox.getChildren().addAll(liVes);
        hBox.setPadding(new Insets(0, 0, 0, 200));
        hBox.setAlignment(Pos.TOP_RIGHT);
        return hBox;
    }

    public HBox levelText(String situation){
        Text text= new Text(situation);
        text.setStyle("-fx-font-weight: bold");
        HBox fortext= new HBox();
        fortext.setAlignment(Pos.TOP_CENTER);
        fortext.getChildren().add(text);
        fortext.setBackground(new Background(new BackgroundFill(Color.ANTIQUEWHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        return fortext;
    }


    EventHandler<ActionEvent> correctchoice = e -> {
        FileInputStream inputstream = null;
        try {
            inputstream = new FileInputStream("img/minecraft-clipart-minecraft-heart.png");
            Image hearts = new Image(inputstream);
            mainStage.setScene(lvl2(hearts));
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    };




    public static void main(String[] args) {
        launch(args);
    }
}
