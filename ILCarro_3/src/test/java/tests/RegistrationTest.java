package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {
   @BeforeMethod
   public void PreConditions(){
       System.out.println("HELLO");
       if(app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
        }
   }

    @Test
    public void registrationSuccess() {

        int i = (int) (System.currentTimeMillis()/1000)%3600;
        User user = new User().setName("Lis").setLastName("Snow").setEmail("fox" + i + "@gmail.com").setPassword("Fsgg1235$");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
//      app.getHelperUser().checkPolicyXY();
        app.getHelperUser().checkPolicy();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(),"Registered");
        app.getHelperUser().clickOk();

    }

    @Test
    public void registrationWrongPasswordFormatSize(){
       User user= new User()
               .setName("Zoya")
               .setLastName("Brown")
               .setEmail("zoya@gmail.com")
               .setPassword("lala");
       app.getHelperUser().openRegistrationForm();
       app.getHelperUser().fillRegistrationForm(user);
       app.getHelperUser().checkPolicy();
Assert.assertTrue(app.getHelperUser().isErrorPasswordFormatDisplayed());
Assert.assertTrue(app.getHelperUser().isErrorPasswordSizeDisplayed());
Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
    }
    @AfterMethod
    public void postCondition(){
       app.getHelperUser().clickOk();
    }
}
