import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class FunctionalTest {
    protected static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        driver = new FirefoxDriver();

        driver = new RemoteWebDriver(new URL("https://localhost:"),new FirefoxOptions())
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void cleanUp(){
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public static void tearDown(){
        //driver.close();
    }

    public File createFile(String fileName){
        File objFile = new File(fileName);
        try{
            if (objFile.exists()){
                assert true;
            }
            else {
                assert objFile.createNewFile();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            return objFile;
        }
    }

    public void writeFile(File file, String text){
        try{
            FileWriter objWriter = new FileWriter(file);
            objWriter.write(text);
            objWriter.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
