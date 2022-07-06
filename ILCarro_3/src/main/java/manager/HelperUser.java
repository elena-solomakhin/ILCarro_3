package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class HelperUser extends HelperBase {

    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm(){

        click(By.cssSelector("[href='/login?url=%2Fsearch']"));
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

    public void openRegistrationForm() {
        click(By.xpath("//a[text()=' Sign up ']"));
    }

    public void fillRegistrationForm(User user) {
     type(By.id("name"),user.getName());
     type(By.id("lastName"),user.getLastName());
        type(By.id("email"),user.getEmail());
        type(By.id("password"),user.getPassword());

    }

    public void checkPolicy() {
        click(By.cssSelector("label[for='terms-of-use']"));

    }
    public void checkPolicyXY() {
       WebElement label=wd.findElement(By.cssSelector("label[for='terms-of-use']"));
       Rectangle rect=label.getRect();
       int xOffSet=rect.getWidth()/2;
       int yOffSet=rect.getHeight()/2;

       Actions actions= new Actions(wd);//do complains methods
    actions.moveToElement(label).release().perform();// cursor see on the middle of label
        actions.moveByOffset(-xOffSet,-yOffSet).click().release().perform();

    }

    public void clickOk() {
        click(By.xpath("//button[text()='Ok']"));
    }
}
