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

    public String[] getAllScores() throws IOException {

        String[] arr= new String[3];

        File f = new File(addres);
        if(f.exists())
        {
            FileReader input = new FileReader(f);
            BufferedReader bufRead = new BufferedReader(input);

            String myLine;

            for(int i=0;i<3;i++)
            {
                arr[i]=null;
            }

            for(int i=0;(myLine = bufRead.readLine()) != null ; i++)
            {
                if(i>2)
                    break;

                arr[i]=myLine;
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

            FileWriter input = new FileWriter(f.getAbsolutePath());
            BufferedWriter bufWrite = new BufferedWriter(input);
            bufWrite.write(score+"");
            bufWrite.close();
            input.close();
        }
        else
        {
            String[] arr=getAllScores();
            String[] arrW= new String[3];

            boolean added=false;

            for(int i=0,w=0;i<3;i++)
            {
                if(arr[i]!=null)
                {
                    System.out.println("-------------"+arr[w]);
                    if(Integer.parseInt(arr[w])>score||added)
                    {
                        arrW[i]=arr[w];
                        w++;
                    }
                    else
                    {
                        added=true;
                        arrW[i]=score+"";
                    }
                }
                else if(added)
                {
                    arrW[i]=arr[w];
                    w++;
                }
                else if(!added)
                {
                    arrW[i]=score+"";
                    added=true;
                }
            }

            for(int i=0;i<3;i++)
                System.out.println("High scores: "+arrW[i]);

            FileWriter input = new FileWriter(f.getAbsolutePath());
            BufferedWriter bufWrite = new BufferedWriter(input);
            bufWrite.write(arrW[0]);
            bufWrite.newLine();
            input = new FileWriter(f.getAbsolutePath(),true);
            bufWrite.write(arrW[1]);
            bufWrite.newLine();
            bufWrite.write(arrW[2]);
            bufWrite.newLine();
            bufWrite.close();
            input.close();
        }
    }
}
