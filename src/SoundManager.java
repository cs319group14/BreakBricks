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
    public String glassHitSoundAdr="sound/glassHit.wav";
    public String steelHitSoundAdr="sound/steelHit.wav";
    public String fireballPwrUpAdr="sound/fireballPwrUp.wav";
    public String pwrUpSoundAdr="";
    public Clip clip;

    public SoundManager() {

    }
    public void playSound(int id) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        if(id==0)
        {
            stop();
            play(bounceSoundAdr);
        }
        else if(id==1)
        {
            stop();
            play(brickHitSoundAdr);

        }
        else if(id==2)
        {
            stop();
            play(glassHitSoundAdr);
        }
        else if(id==3)
        {
            stop();
            play(steelHitSoundAdr);
        }
        else if(id==4)
        {
            play(fireballPwrUpAdr);
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
