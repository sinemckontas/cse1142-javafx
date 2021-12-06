import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class AudioPlay {

    private static Media mainTheme = new Media(new File("audio/theme.mp3").toURI().toString());
    private static MediaPlayer mainPlayer = new MediaPlayer(mainTheme);
    static boolean isMute = false;
    static String muteCondition;

    public static void setMuteCondition() {
        if(AudioPlay.muteCondition.equals("MUTE")){
            AudioPlay.muteCondition = "MUTE";
        }
        else{
            AudioPlay.muteCondition = "UNMUTE";
        }
    }


    private static void play(MediaPlayer playerInput){
        playerInput.play();
    }
    private static void stop(MediaPlayer playerInput) {
        playerInput.stop();
    }
   public static void mute(){
    if (!isMute){
        mainPlayer.setMute(true);
        muteCondition = "UNMUTE";
    }
    else {
        mainPlayer.setMute(false);
        muteCondition = "MUTE";
    }
    setMuteCondition();
    }
}
