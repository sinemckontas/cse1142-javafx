import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.image.ImageView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class GameWindow extends Application {

    //PUTTING IN TEXTS, OPTIONS AND BACKGROUNDS OF LEVELS
Stage mainStage;
int currentLevel = 1;
int noOfLives=3;
boolean wrongTxt=false;
LevelInfo level1 = new LevelInfo("img/2NQ49.jpg",
        "Hi Adventurer!\n You have been arrested while trespassing in a restricted area.\n The guard waiting in front of your cell has a set of keys hanging from his belt.\n You could try to convince him to let you out since you are just a harmless adventurer.\n Or maybe, you can just put your hand through the bars and steal the keys quietly. \n If you don't think you can do both, you can wait till something happens. \n\n What will you do?",
        new String[] {"CONVINCE HIM", "STEAL THE KEYS", "WAIT"}, "STEAL THE KEYS");
LevelInfo level2 = new LevelInfo("img/river2.jpg",
        "You escaped from the cell and reached the river.\nYou have to cross this cold and rough river. \nYou can use the bridge, try to swim across or build a raft.\n\nWhat will you do?",
        new String[] {"USE THE BRIDGE", "SWIM ACROSS", "BUILD RAFT"}, "USE THE BRIDGE");
LevelInfo level3 = new LevelInfo("img/cm2.jpg",
        "You have crossed the river, but the danger has not passed.\nThere is a big cemetery and a forest in front of you.\nYou can hide in the cemetery and wait for things to calm down,\nyou can hide in the forest and continue at night,\nor you can continue through the forest.\n\nWhat will you do?",
        new String[] {"HIDE IN THE CEMETERY", "HIDE IN THE FOREST", "GO THROUGH THE FOREST"}, "HIDE IN THE FOREST");
LevelInfo level4 = new LevelInfo("img/sehir.jpg",
        "You have reached the dark city and you must cross this city to reach your freedom.\nBe careful! Bad things are said about the people of this city.\nYou can wait for the morning to continue,\nask someone in the city for help,\nor you can disguise and continue on your way.\n\nWhat will you do?",
        new String[] {"WAIT TILL THE MORNING", "ASK FOR HELP", "DISGUISE & CONTINUE"}, "DISGUISE & CONTINUE");


    @Override
    public void start(Stage primaryStage) throws Exception {
        mainStage = primaryStage;
        primaryStage.setScene(generateLevel(currentLevel));
        primaryStage.setResizable(false);
        primaryStage.setTitle("Little Adventure");
        primaryStage.show();

    }

    //SETTING UP THE LEVEL GUI

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

        button1.setFont(Font.loadFont("file:font/OldNewspaperTypes.ttf",15));
        button2.setFont(Font.loadFont("file:font/OldNewspaperTypes.ttf",15));
        button3.setFont(Font.loadFont("file:font/OldNewspaperTypes.ttf",15));

        button1.setOnAction(wrongChoice);
        button2.setOnAction(wrongChoice);
        button3.setOnAction(wrongChoice);
        checkCorrect(levelInfo.getCorrectOption(), button1, button2, button3).setOnAction(correctchoice);

        Pane canvas = new Pane();
        levelCreation(canvas, backgroundImage, hearts, levelInfo.getLevelText(), button1, button2, button3);
        return new Scene(canvas, 700, 700);
    }

    //WINNING SCREEN

    public Scene winner() throws FileNotFoundException {
        FileInputStream imageFile = new FileInputStream("img/win.jpg");
        Image levelImage = new Image(imageFile);
        BackgroundImage backgroundImage = new BackgroundImage(levelImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(700,700,false,false,true,true));
        Text text= new Text("FINALLY! FREEDOM!\nYou made the right choices and you're no longer in danger.\nNow you can live far from this land, seeing the sunlight.\nEnjoy your freedom!");
        text.setFont(Font.loadFont("file:font/OldNewspaperTypes.ttf",20));
        text.setFill(Color.BLACK);
        // text.setStyle("-fx-font-weight: bold");
        text.setTextAlignment(TextAlignment.CENTER);

        StackPane spane= new StackPane();
        spane.setBackground(new Background(backgroundImage));
        spane.setAlignment(Pos.CENTER);
        spane.getChildren().add(text);

        return new Scene(spane, 700, 700);
    }

    //LOSING SCREEN

    public Scene loser() throws FileNotFoundException {
        FileInputStream imageFile = new FileInputStream("img/youdied.png");
        Image levelImage = new Image(imageFile);
        BackgroundImage backgroundImage = new BackgroundImage(levelImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(700,700,false,false,true,true));
        StackPane spane= new StackPane();
        spane.setBackground(new Background(backgroundImage));
        spane.setAlignment(Pos.CENTER);

        return new Scene(spane, 700, 700);
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


    //PLACING ELEMENTS ON LEVEL SCREEN

    public void levelCreation(Pane thepane,BackgroundImage bck, Image crntLives, String lvltxt, Button b1, Button b2, Button b3){
        AudioPlay.play(AudioPlay.mainPlayer);
        AudioPlay.muteCondition = "MUTE";
        Button muteButton = new Button(AudioPlay.muteCondition);
        //muteButton.textProperty().bind(AudioPlay.muteCondition);
        muteButton.setLayoutX(20);
        muteButton.setLayoutY(20);
        muteButton.setFont(Font.loadFont("file:font/OldNewspaperTypes.ttf",15));
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
        vbox.getChildren().addAll(currentLives(noOfLives,crntLives), levelText(lvltxt), levelOptions(b1, b2, b3, muteButton));
        vbox.setPadding(new Insets(15));
    }


    //CHECK IF THE BUTTON PRESSED INVOLVES THE CORRECT ANSWER

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



    //ARRANGING OPTIONS BUTTONS (MUTE BUTTON IS PUT HERE WITH THE OPTIONS IN ORDER TO ACHIEVE A TIDIER SCREEN)

    public VBox levelOptions(Button first, Button mid, Button last, Button mute) {
        VBox forButtons= new VBox();
        forButtons.getChildren().addAll(first, mid, last, mute);
        forButtons.setAlignment(Pos.CENTER);
        forButtons.setSpacing(30);

        return forButtons;
    }

    //PLACING LIVES ON THE TOP RIGHT CORNER OF THE SCREEN

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

    //CREATING THE TEXT BOX IN LEVELS

    public HBox levelText(String situation){
        FileInputStream boxfile = null;
        try {
            boxfile = new FileInputStream("img/ppr.jpg");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image tbbg = new Image(boxfile);
        BackgroundImage bg = new BackgroundImage(tbbg,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT, new BackgroundSize(700,700,false,false,true,true) );
        Text text= new Text(situation);
        text.setFont(Font.loadFont("file:font/OldNewspaperTypes.ttf",15));
        text.setFill(Color.BLACK);
        HBox fortext= new HBox();
        fortext.setStyle("-fx-padding:10");
        fortext.setAlignment(Pos.CENTER);
        fortext.getChildren().add(text);
        fortext.setBackground(new Background(bg));
        return fortext;
    }

    //EVENT HANDLER FOR WHEN PLAYER PICKS THE CORRECT CHOICE

    EventHandler<ActionEvent> correctchoice = e -> {
        wrongTxt=false;
        if(currentLevel!=4){
            currentLevel += 1;
            try {
                mainStage.setScene(generateLevel(currentLevel));
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        }
        else {
            try {
                mainStage.setScene(winner());
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        }

    };

    //EVENT HANDLER FOR WHEN PLAYER PICKS THE WRONG CHOICE

    EventHandler<ActionEvent> wrongChoice = e -> {
        if (noOfLives>1 ){
            if(!wrongTxt){
                getLevelInfo(currentLevel).setLevelText(getLevelInfo(currentLevel).getLevelText()+"\n\n THAT WAS THE WRONG CHOICE. YOU LOST A LIFE.");
                wrongTxt= true;
            }
            try {
                noOfLives--;
                mainStage.setScene(generateLevel(currentLevel));
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        }
        else{
            try {
                mainStage.setScene(loser());
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }

        }


    };




    public static void main(String[] args) {
        launch(args);
    }
}
