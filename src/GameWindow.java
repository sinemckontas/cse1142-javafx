import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;


public class GameWindow extends Application {





    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane canvas = new Pane();
        VBox vbox = new VBox(30); // spacing = 8
        canvas.getChildren().add(vbox);
        canvas.setPadding(new Insets(100,100,100,100));
        vbox.setBackground(new Background(new BackgroundFill(Color.CRIMSON, CornerRadii.EMPTY, Insets.EMPTY)));
        vbox.getChildren().addAll(new Button("1"), new Button("2"), new Button("3"));
        primaryStage.setScene(new Scene(canvas, 300,300));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
