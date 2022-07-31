package tests;

import manager.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Browser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.time.Duration;

public class BaseTest {
    Logger logger= LoggerFactory.getLogger(BaseTest.class);
   static ApplicationManager app= new ApplicationManager(System.getProperty("browser", Browser.CHROME.browserName()));

   @BeforeMethod
   public void startLogger(Method m){
       logger.info("Start test with name --->"+ m.getName());
   }
   @BeforeSuite(alwaysRun = true)

    public void setUp() {

        app.init();
        }
    @AfterSuite (alwaysRun = true)
    public void tearDown() {
        app.stop();
    }


}
