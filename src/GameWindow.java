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



    @Override
    public void start(Stage primaryStage) throws Exception {

        FileInputStream inputstream = new FileInputStream("img/minecraft-clipart-minecraft-heart.png");
        Image hearts = new Image(inputstream);

        lvl1(primaryStage, hearts);

    }

    public void lvl1(Stage stg, Image livesfull) throws FileNotFoundException {
        FileInputStream newImg = new FileInputStream("img/2NQ49.jpg");
        Image levelimg = new Image(newImg);

        String level1txt= new String("Hi Adventurer!\n You have been arrested while trespassing to a restricted area.\n The guard waiting in front of your cell has a set of keys hanging from his belt.\n You could try to convince him to let you out since you are just a harmless adventurer.\n Or maybe, you can just put your hand through the bars and steal the keys quietly. \n If you don't think you can do both, you can wait till something happens. \n\n What will you do?");
        String[] options= new String[3];
        options[0]= "CONVINCE HIM";
        options[1]="STEAL THE KEYS";
        options[2]="WAIT";

        BackgroundImage levelB= new BackgroundImage(levelimg, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(700,700,false,false,true,true));
        Pane canvas = new Pane();
        levelCreation(canvas, levelB, livesfull, level1txt, options);

        stg.setScene(new Scene(canvas, 700,700));
        stg.show();
    }
    public void lvl2(Stage stg, Image livesfull) throws FileNotFoundException{
        FileInputStream newImg = new FileInputStream("img/level2bgnd.jpg");
        Image levelimg = new Image(newImg);

        String level2txt= new String("this is lvl2");
        String[] options= new String[3];
        options[0]= "CONVINCE 2";
        options[1]="STEAL THE 2";
        options[2]="WAIT2";

        BackgroundImage levelB= new BackgroundImage(levelimg, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(700,700,false,false,true,true));
        Pane canvas = new Pane();
        levelCreation(canvas, levelB, livesfull, level2txt, options);

        stg.setScene(new Scene(canvas, 700,700));
        stg.show();
    }
    public void lvl3(Stage stg, Image livesfull) throws FileNotFoundException{
        FileInputStream newImg = new FileInputStream("img/2NQ49.jpg");
        Image levelimg = new Image(newImg);

        String level3txt= new String("this is lvl3");
        String[] options= new String[3];
        options[0]= "CONVINCE 3";
        options[1]="STEAL THE KEYS3";
        options[2]="WAIT3";

        BackgroundImage levelB= new BackgroundImage(levelimg, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(700,700,false,false,true,true));
        Pane canvas = new Pane();
        levelCreation(canvas, levelB, livesfull, level3txt, options);

        stg.setScene(new Scene(canvas, 700,700));
        stg.show();
    }
    public void lvl4(Stage stg, Image livesfull) throws FileNotFoundException{
        FileInputStream newImg = new FileInputStream("img/2NQ49.jpg");
        Image levelimg = new Image(newImg);

        String level4txt= new String("this is lvl4");
        String[] options= new String[3];
        options[0]= "CONVINCE 4";
        options[1]="STEAL THE KEYS4";
        options[2]="WAIT4";

        BackgroundImage levelB= new BackgroundImage(levelimg, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(700,700,false,false,true,true));
        Pane canvas = new Pane();
        levelCreation(canvas, levelB, livesfull, level4txt, options);

        stg.setScene(new Scene(canvas, 700,700));
        stg.show();
    }

    public void levelCreation(Pane thepane,BackgroundImage bck, Image crntLives, String lvltxt, String[] optns){

        thepane.setBackground(new Background(bck));
        VBox vbox = new VBox( 100); // spacing = 8
        vbox.setPrefSize(700, 700);
        vbox.setAlignment(Pos.TOP_CENTER);
        thepane.getChildren().add(vbox);
        thepane.setPadding(new Insets(100,100,100,100));
        vbox.getChildren().addAll(currentLives(3,crntLives), levelText(lvltxt), levelOptions(optns[0], optns[1], optns[2]));
        vbox.setPadding(new Insets(15));
    }



    public VBox levelOptions(String first, String second, String third) {
        VBox forButtons= new VBox();
        Button one= new Button(first);
        Button two= new Button(second);
        Button three= new Button(third);
        forButtons.getChildren().addAll(one, two, three);
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


    public static void main(String[] args) {
        launch(args);
    }
}
