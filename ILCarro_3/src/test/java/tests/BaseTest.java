package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class BaseTest {
    WebDriver wd;
    @BeforeMethod
    public void setUp() {
        wd = new ChromeDriver();
        wd.navigate().to("https://ilcarro-1578153671498.web.app/search");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterMethod
    public void tearDown() {
        wd.quit();
    }
    public void openLoginForm() {
        click(By.cssSelector("[href='/login?url=%2Fsearch']"));
    }
    //all methods
    public void click(By locator) {
        wd.findElement(locator).click();

    }
    public void fillLoginForm() throws InterruptedException {
        type(By.cssSelector("#email"),"noam@gmail.com");
        Thread.sleep(2000);
        type(By.cssSelector("#password"),"QQqq1234$");
    }
    public void type(By locator, String text){
        if(text != null){
            click(locator);
            wd.findElement(locator).clear();
            wd.findElement(locator).sendKeys(text);
        }}
    public void submitLogin() {

        click(By.xpath("//button[@type='submit']"));
    }

}
