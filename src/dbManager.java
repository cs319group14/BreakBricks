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

        ArrayList arr= new ArrayList();

        File f = new File(addres);
        if(f.exists())
        {
            FileReader input = new FileReader(f);
            BufferedReader bufRead = new BufferedReader(input);

            String myLine="-";

            while((myLine = bufRead.readLine()) != null)
            {
                arr.add(myLine);
            }

            for(int i=arr.size();i<3;i++)
            {
                arr.add("-");
            }
            bufRead.close();
            input.close();

            return arr;
        }
        else
        {
            System.out.println("File: " + addres + " not found, creating a new one.");
            f.createNewFile();
            return null;
        }
        //return null;
    }

    public void storeScore(int score) throws IOException {
        //writes score to the txt file
        File f=new File(addres);
        File file = new File("gameData");
        
        if (!file.exists()) {
            if (file.mkdir()) {
                System.out.println("Directory is created!");
            } else {
                System.out.println("Failed to create directory!");
            }
        }

        if(!f.exists())
        {
            f.createNewFile();
            System.out.println("File: " + addres + " not found, creating a new one.");
        }

        System.out.println("Data saved.");
        FileWriter input = new FileWriter(f.getAbsolutePath());
        BufferedWriter bufWrite = new BufferedWriter(input);
        bufWrite.newLine();
        bufWrite.write(score+"");
        bufWrite.close();
        input.close();

    }
}
