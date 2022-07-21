package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class SearchTests  extends BaseTest{
    @Test
    public void searchCurrentMonth(){
        app.search().searchCurrentMonth("Tel Aviv","7/27/2022","7/28/2022");
        app.search().submit();
        Assert.assertTrue(app.search().isListOfCarsAppeared());
    }
    @Test
    public void searchPeriodPast(){
        //h/w sendKeys - to type date
    }

    @Test
    public void searchCurrentYear(){
        app.search().searchCurrentYear("Haifa","8/10/2022","10/20/2022");
        app.search().submit();
        Assert.assertTrue(app.search().isListOfCarsAppeared());
   Assert.assertTrue(app.search().isPageResulpAppeared());

    }


    @Test
    public void searchCurrentYearLocalDate(){
        app.search().searchCurrentYearLocalDate("Haifa","8/10/2022","10/20/2022");
        app.search().submit();
        Assert.assertTrue(app.search().isListOfCarsAppeared());

    }
@Test
public void searchAnyPeriod(){
    app.search().searchAnyPeriodLocalDate2("Haifa" ,"1/10/2023","5/25/2023");
    app.search().submit();
    Assert.assertTrue(app.search().isListOfCarsAppeared());
}
    @AfterMethod
    public void returnToHome(){
        app.search().returnToHome();
    }
}
