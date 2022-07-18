package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
@BeforeMethod
public void preCondition(){
    if (app.getHelperUser().isLogged()){
        app.getHelperUser().logout();
        logger.info("test start with logout");
    }
}
    @Test
    public void LoginASuccess()  {
logger.info("Test start with email :'noam@gmail.com'and password 'QQqq1234$'");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("noam@gmail.com","QQqq1234$");
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in");
        logger.info("Test passed");
    }

//    QQqq1234$

    @Test
    public void loginNegativeTestsWrongEmail() {

        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("noagmail.com", "45$");
        app.getHelperUser().submit();
        // 6.Assert ( is login unsuccessful?)   logout present? NOT

    }
@AfterMethod
public void postCondition() {
app.getHelperUser().clickOk();
}
}
