package tests;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchTests extends BaseTest {

    @Test(enabled = false)
    public void searchCurrentMonth() {
        app.search().searchCurrentMonth("Tel Aviv", "7/29/2022", "7/30/2022");
        app.search().submit();
        Assert.assertTrue(app.search().isListOfCarsAppeared());
       app.search().takeScreenShots("/Users/elenasolomakhina/Study/AutomatQA34/Progects/ILCarro_3/ILCarro_3/src/test/ScreenShots/screen6.png");

    }
    @Test
    public void searchNextMonth() {
        app.search().searchNextMonth("Tel Aviv -Jaffo", "8/28/2022", "8/27/2022");
        app.search().submit();
        Assert.assertTrue(app.search().isListOfCarsAppeared());
        app.search().takeScreenShots("/Users/elenasolomakhina/Study/AutomatQA34/Progects/ILCarro_3/ILCarro_3/src/test/ScreenShots/screen5.png");

    }


    @Test
    public void searchPeriodPast(){
        app.search().searchPeriodPast("Rehovot","2/10/2022","3/15/2022");
        app.search().submitWithoutWait();
        Assert.assertTrue(app.search().isYallaButtonNotActive());
        Assert.assertTrue(app.search().isPeriodInPast());

    }

    @Test
    public void searchCurrentYear() {
        app.search().searchCurrentYear("Haifa", "8/10/2022", "8/20/2022");
        app.search().submit();
        Assert.assertTrue(app.search().isListOfCarsAppeared());
        Assert.assertTrue(app.search().isPageResultAppeared());
        app.search().takeScreenShots("/Users/elenasolomakhina/Study/AutomatQA34/Progects/ILCarro_3/ILCarro_3/src/test/ScreenShots/screen4.png");
    }

    @Test
    public void searchCurrentYearLocalDate(){
        app.search().searchCurrentYearLocalDate("Jerusalem", "8/10/2022", "10/20/2022");
        app.search().submit();
        Assert.assertTrue(app.search().isListOfCarsAppeared());
        app.search().takeScreenShots("/Users/elenasolomakhina/Study/AutomatQA34/Progects/ILCarro_3/ILCarro_3/src/test/ScreenShots/screen3.png");
    }
    @Test(groups = {"web"})
    public void searchAnyPeriod(){
        app.search().searchAnyPeriodLocalDate2("Haifa", "6/10/2023", "7/15/2023");
        app.search().submit();
        Assert.assertTrue(app.search().isListOfCarsAppeared());
        app.search().takeScreenShots("/Users/elenasolomakhina/Study/AutomatQA34/Progects/ILCarro_3/ILCarro_3/src/test/ScreenShots/screen2.png");
    }


    @BeforeMethod (alwaysRun = true)
    public void returnToHome(){
        app.search().returnToHome();
    }
}