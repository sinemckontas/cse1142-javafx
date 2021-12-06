import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class AudioPlay<muteCondition> {

    private static Media mainTheme = new Media(new File("audio/theme.mp3").toURI().toString());
     static MediaPlayer mainPlayer = new MediaPlayer(mainTheme);
    static boolean isMute = false;
    public static String muteCondition;


    public static void setMuteCondition() {
        if(AudioPlay.muteCondition.equals("MUTE")){
            AudioPlay.muteCondition = "MUTE";
        }
        else{
            AudioPlay.muteCondition = "UNMUTE";
        }
    }


     static void play(MediaPlayer playerInput){
        playerInput.play();
    }
     static void stop(MediaPlayer playerInput) {
        playerInput.stop();
    }
   public static void mute(){
    if (!isMute){
        mainPlayer.setMute(true);
        AudioPlay.muteCondition = "UNMUTE";
        AudioPlay.isMute = true;
    }
    else {
        mainPlayer.setMute(false);
        AudioPlay.muteCondition = "MUTE";
        AudioPlay.isMute = false;
    }
    setMuteCondition();
    }
}
