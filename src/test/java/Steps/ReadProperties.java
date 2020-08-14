package Steps;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
    public Properties propLOGIN;
    public Properties propPUT;
    public Properties propPOST;
    public Properties propDELETEPOST;
    public Properties propPOSTPhones;
    public ReadProperties(){
        try{
            propLOGIN=new Properties();
            FileInputStream fis=new FileInputStream("C:\\Users\\katar\\IdeaProjects\\CucResFinal\\configs\\login.properties");
            propLOGIN.load(fis);

            propPUT=new Properties();
            FileInputStream fis1=new FileInputStream("C:\\Users\\katar\\IdeaProjects\\CucResFinal\\configs\\PUT.properties");
            propPUT.load(fis1);

            propPOST=new Properties();
            FileInputStream fis2=new FileInputStream("C:\\Users\\katar\\IdeaProjects\\CucResFinal\\configs\\POST.properties");
            propPOST.load(fis2);

            propDELETEPOST=new Properties();
            FileInputStream fis3=new FileInputStream("C:\\Users\\katar\\IdeaProjects\\CucResFinal\\configs\\DELETEPOST.properties");
            propDELETEPOST.load(fis3);

            propPOSTPhones=new Properties();
            FileInputStream fis4=new FileInputStream("C:\\Users\\katar\\IdeaProjects\\CucResFinal\\configs\\POSTPhones.properties");
            propPOSTPhones.load(fis4);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


    }
}
