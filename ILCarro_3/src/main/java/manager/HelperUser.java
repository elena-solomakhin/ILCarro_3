package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class HelperUser extends HelperBase {

    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm(){
     click(By.cssSelector("[href='/login?url=%2Fsearch']"));
}
    public void submitLogin() {
        click(By.xpath("//button[@type='submit']"));

    }
    public void fillLoginForm(String email,String password){
        type(By.cssSelector("#email"),email);
        type(By.cssSelector("#password"),password);

    }
    public boolean isLogged(){
        List<WebElement> list =wd.findElements(By.xpath("//a[text()=' Logout ']"));
        return list.size()>0;
    }
    public void logout(){
        click(By.xpath("//a[text()=' Logout ']"));
    }
}
