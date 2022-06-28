package tests;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test
    public void SuccessLogin() throws InterruptedException {

        openLoginForm();
        fillLoginForm();
        submitLogin();
    }

}
