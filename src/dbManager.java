import java.io.*;
import java.util.ArrayList;

/**
 * Created by Kaan on 28/10/15.
 */
//Reads text file and writes to text file

public class dbManager {
    String addres;
    public dbManager(String addr)
    {

        addres=addr;

    }

    public ArrayList getAllScores() throws IOException {

        File f = new File(addres);
        if(f.exists())
        {
            FileReader input = new FileReader(f);
            BufferedReader bufRead = new BufferedReader(input);
        }
        else
        {
            System.out.println("File: " + addres + " not found, creating a new one.");
            f.createNewFile();

        }
        return null;
    }

    public void storeScore(int score) throws IOException {
        //writes score to the txt file

        File f=new File(addres);
        if(!f.exists())
        {
            f.createNewFile();
            System.out.println("File: " + addres + " not found, creating a new one.");
        }
        System.out.println("Data saved.");

        FileWriter input = new FileWriter(f);
        BufferedWriter bufRead = new BufferedWriter(input);
        bufRead.newLine();
        bufRead.write(score);


    }
}
