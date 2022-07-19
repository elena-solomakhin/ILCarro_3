package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTests  extends BaseTest{
    @Test
    public void searchCurrentMonth(){
        app.search().searchCurrentMonth("Tel Aviv","7/27/2022","7/28/2022");
        app.search().submit();
//        Assert.assertTrue(app.search().isListOfCarsAppeared());//
    }
    @Test
    public void searchCurrentYear(){
        app.search().searchCurrentYear("Tel Aviv","8/10/2022","10/20/2022");
        app.search().submit();
    }
}
