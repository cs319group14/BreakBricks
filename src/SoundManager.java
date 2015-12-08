import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.rmi.rmic.Main;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Kaan on 08/12/15.
 */
public class SoundManager {

    public String bounceSoundAdr="https://raw.githubusercontent.com/cs319group14/BreakBricks/master/sound/ballBounce.wav";
    public String brickHitSoundAdr="https://raw.githubusercontent.com/cs319group14/BreakBricks/master/sound/brickHit.wav";
    public String pwrUpSoundAdr="";
    public Clip clip;

    public SoundManager(){
    }

    public void playSound(int id) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        if(id==0)
        {
            URL url = new URL(bounceSoundAdr);
            if(clip!=null)
                if(clip.isActive())
                    clip.stop();

                AudioInputStream sound = AudioSystem.getAudioInputStream(url);
                clip = AudioSystem.getClip();
                clip.open(sound);
                clip.start();

        }

        else if(id==1)
        {
            if(clip!=null)
                if(clip.isActive())
                    clip.stop();

            File file = new File(brickHitSoundAdr);
            if (file.exists()) {
                AudioInputStream sound = AudioSystem.getAudioInputStream(file);
                clip = AudioSystem.getClip();
                clip.open(sound);
                clip.start();
            } else
                System.out.print("Voice file not found.");

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
}
