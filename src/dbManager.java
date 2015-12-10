import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

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

    public ArrayList<Integer> getAllScores() throws IOException {

        ArrayList<Integer> arr= new ArrayList();

        File f = new File(addres);
        if(f.exists())
        {
            FileReader input = new FileReader(f);
            BufferedReader bufRead = new BufferedReader(input);

            String myLine;

            while((myLine=bufRead.readLine())!=null)
            {
                arr.add(Integer.parseInt(myLine));
            }
            Collections.sort(arr);

            for(int i=0;i<arr.size();i++)
            {
                System.out.println("sorted array: "+arr.get(i));
            }

            return arr;
        }
        else
        {
            f.createNewFile();
            storeScore(0);
        }
        return null;
    }

    public void storeScore(int score) throws IOException {
        //writes score to the txt file
        System.out.println("score: "+score);
        File f=new File(addres);
        File file = new File("gameData");

        if (!file.exists()) {
            if (file.mkdir()) {
                System.out.println("Directory is created!");

                FileWriter input = new FileWriter(f.getAbsolutePath());
                input = new FileWriter(f.getAbsolutePath(),true);
                BufferedWriter bufWrite = new BufferedWriter(input);
                bufWrite.write(""+score);
                bufWrite.newLine();
                bufWrite.write(""+0);
                bufWrite.newLine();
                bufWrite.write(""+0);
                bufWrite.newLine();
                bufWrite.close();
                input.close();

            } else {
                System.out.println("Failed to create directory!");
            }
        }
        else
        {
            ArrayList<Integer> arr1= getAllScores();
            arr1.add(score);

            while(arr1.size()<3)
            {
                arr1.add(0);
                System.out.print("Filling 0's.");
            }

            Collections.sort(arr1);

            FileWriter input = new FileWriter(f.getAbsolutePath());
            BufferedWriter bufWrite = new BufferedWriter(input);
            bufWrite.write(""+arr1.get(arr1.size()-1));
            bufWrite.newLine();
            input = new FileWriter(f.getAbsolutePath(),true);
            bufWrite.write(""+arr1.get(arr1.size()-2));
            bufWrite.newLine();
            bufWrite.write(""+arr1.get(arr1.size()-3));
            bufWrite.newLine();
            bufWrite.close();
            input.close();
        }
    }
}
