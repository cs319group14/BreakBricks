import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import javax.sound.sampled.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


/**
 * Created by Kaan on 08/12/15.
 */
public class SoundManager {

    public String bounceSoundAdr="sound/ballBounce.wav";
    public String brickHitSoundAdr="sound/brickHit.wav";
    public String pwrUpSoundAdr="";
    public Clip clip;

    public SoundManager() {

        System.out.println("resource: "+getClass().getResource("ballBounce.wav"));
    }
    public void playSound(int id) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        if(id==0)
        {
            stop();
            play(bounceSoundAdr);
            /*
            // Alternative
            try {
                AudioClip clip = Applet.newAudioClip(
                        new URL("file://"  +  System.getProperty("user.dir") + "/" + bounceSoundAdr));
                clip.play();
            } catch (MalformedURLException murle) {
                System.out.println(murle);
                System.out.println(System.getProperty("user.dir") + bounceSoundAdr);
            }
            */
        }
        else if(id==1)
        {
            stop();
            play(brickHitSoundAdr);

        }
        else if(id==2)
        {
            try {
                InputStream in=new FileInputStream(pwrUpSoundAdr);
                AudioStream au=new AudioStream(in);
                AudioPlayer.player.start(au);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }

    }
    private void play(String directory) throws IOException, UnsupportedAudioFileException, LineUnavailableException{
        File f=new File(directory);
        AudioInputStream sound = AudioSystem.getAudioInputStream(f);
        clip = AudioSystem.getClip();
        clip.open(sound);
        clip.start();
    }
    private void stop() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        if(clip!=null)
            if(clip.isActive())
                clip.stop();
    }
}
