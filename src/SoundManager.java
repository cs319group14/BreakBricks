import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.rmi.rmic.Main;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by Kaan on 08/12/15.
 */
public class SoundManager {

    public String bounceSoundAdr="/Users/Kaan/Desktop/ballBounce.wav";
    public String brickHitSoundAdr="";
    public String pwrUpSoundAdr="";

    public SoundManager()
    {
    }

    public void playSound(int id)
    {
        if(id==0)
        {
            try {
                /*JFileChooser openf= new JFileChooser();
                Component j=null;
                openf.showOpenDialog(j);
                File fl=openf.getSelectedFile();
                */
                InputStream in=new FileInputStream(bounceSoundAdr);
                AudioStream au=new AudioStream(in);
                AudioPlayer.player.start(au);
                } catch (Exception e) {
                System.err.println(e.getMessage());
                }
        }

        else if(id==1)
        {

        }
        else if(id==2)
        {

        }

    }
}
