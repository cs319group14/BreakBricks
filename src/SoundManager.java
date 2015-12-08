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
            if(clip!=null)
                if(clip.isActive())
                    clip.stop();

                File f=new File(bounceSoundAdr);
                AudioInputStream sound = AudioSystem.getAudioInputStream(f);
                clip = AudioSystem.getClip();
                clip.open(sound);
                clip.start();

        }

        else if(id==1)
        {
            //URL url = new URL(brickHitSoundAdr);
            if(clip!=null)
                if(clip.isActive())
                    clip.stop();

            File f=new File(brickHitSoundAdr);
            AudioInputStream sound = AudioSystem.getAudioInputStream(f);
            clip = AudioSystem.getClip();
            clip.open(sound);
            clip.start();
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
