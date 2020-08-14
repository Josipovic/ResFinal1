package Steps;

import Utilities.RestAssuredExtension;
import io.cucumber.java.Before;

import java.io.InputStream;
import java.util.Properties;

public class TestInitialise {


    @Before
    public void TestSetup(){
        RestAssuredExtension restAssuredExtension=new RestAssuredExtension();
        ReadProperties readProperties=new ReadProperties();

    }
}
