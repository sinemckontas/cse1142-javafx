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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.Arrays;

import static javafx.scene.text.FontWeight.BOLD;
//import javax.xml.soap.Text;


public class GameWindow extends Application {

Stage mainStage;
int currentLevel = 1;
LevelInfo level1 = new LevelInfo("img/2NQ49.jpg",
        "Hi Adventurer!\n You have been arrested while trespassing to a restricted area.\n The guard waiting in front of your cell has a set of keys hanging from his belt.\n You could try to convince him to let you out since you are just a harmless adventurer.\n Or maybe, you can just put your hand through the bars and steal the keys quietly. \n If you don't think you can do both, you can wait till something happens. \n\n What will you do?",
        new String[] {"CONVINCE HIM", "STEAL THE KEYS", "WAIT"}, "WAIT");
LevelInfo level2 = new LevelInfo("img/level2bgnd.jpg",
        "This is level 2",
        new String[] {"L2O1", "L2O2", "L2O3"}, "L2O2");
LevelInfo level3 = new LevelInfo("img/level2bgnd.jpg",
        "This is level 3",
        new String[] {"L3O1", "L2O2", "L2O3"}, "L2O2");
LevelInfo level4 = new LevelInfo("img/level2bgnd.jpg",
        "This is level 4",
        new String[] {"L4O1", "L2O2", "L2O3"}, "L2O2");


    @Override
    public void start(Stage primaryStage) throws Exception {
        mainStage = primaryStage;
        primaryStage.setScene(generateLevel(currentLevel));
        primaryStage.setResizable(false);
        primaryStage.setTitle("Dungeon");
        primaryStage.show();


    }

    public Scene generateLevel(int levelNo) throws FileNotFoundException {
        LevelInfo levelInfo = getLevelInfo(levelNo);

        FileInputStream inputstream = new FileInputStream("img/minecraft-clipart-minecraft-heart.png");
        Image hearts = new Image(inputstream);

        FileInputStream imageFile = new FileInputStream(levelInfo.getBackgroundImagePath());
        Image levelImage = new Image(imageFile);
        BackgroundImage backgroundImage = new BackgroundImage(levelImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(700,700,false,false,true,true));

        Button button1 = new Button(levelInfo.getOptionTexts()[0]);
        Button button2 = new Button(levelInfo.getOptionTexts()[1]);
        Button button3 = new Button(levelInfo.getOptionTexts()[2]);

        checkCorrect(levelInfo.getCorrectOption(), button1, button2, button3).setOnAction(correctchoice);

        Pane canvas = new Pane();
        levelCreation(canvas, backgroundImage, hearts, levelInfo.getLevelText(), button1, button2, button3);
        return new Scene(canvas, 700, 700);
    }

    public LevelInfo getLevelInfo(int levelNo) {
        if (levelNo == 1) {
            return level1;
        }
        else if (levelNo == 2) {
            return level2;
        }
        else if (levelNo == 3) {
            return level3;
        }
        else if (levelNo == 4) {
            return level4;
        }

        return null;
    }



    public void levelCreation(Pane thepane,BackgroundImage bck, Image crntLives, String lvltxt, Button b1, Button b2, Button b3){
        AudioPlay.play(AudioPlay.mainPlayer);
        AudioPlay.muteCondition = "MUTE";
        Button muteButton = new Button(AudioPlay.muteCondition);
 //       muteButton.textProperty().bind(AudioPlay.muteCondition);
        muteButton.setLayoutX(20);
        muteButton.setLayoutY(20);
        muteButton.setOnMousePressed(e -> {
            AudioPlay.mute();
            muteButton.setText(AudioPlay.muteCondition);
        });


        thepane.setBackground(new Background(bck));
        thepane.setBackground(new Background(bck));
        VBox vbox = new VBox( 100);
        vbox.setPrefSize(700, 900);
        vbox.setAlignment(Pos.TOP_CENTER);
        thepane.getChildren().add(vbox);
        thepane.setPadding(new Insets(100,100,100,100));
        vbox.getChildren().addAll(currentLives(3,crntLives), levelText(lvltxt), levelOptions(b1, b2, b3),muteButton);
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
     //   text.setStyle("-fx-font-weight: bold");
        text.setFont(Font.loadFont("file:font/Welbut.ttf",11));
        HBox fortext= new HBox();
        fortext.setStyle("-fx-padding:10");
        fortext.setAlignment(Pos.CENTER);
        fortext.getChildren().add(text);
        BackgroundSize boxSize = new BackgroundSize(300, 200, true, true, false, false);
        BackgroundImage imageBackground = new BackgroundImage(new Image(new File("img/1216.png").toURI().toString()),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                boxSize);
        fortext.setBackground(new Background(imageBackground));

     //    fortext.setBackground(new Background(new BackgroundFill(Color.ANTIQUEWHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        return fortext;
    }


    EventHandler<ActionEvent> correctchoice = e -> {
        currentLevel += 1;
        try {
            mainStage.setScene(generateLevel(currentLevel));
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    };




    public static void main(String[] args) {
        launch(args);
    }
}
