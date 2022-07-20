package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperSearch extends HelperBase{
    public HelperSearch(WebDriver wd) {
        super(wd);
    }

    public void searchCurrentMonth(String city, String dataFrom, String dataTo) {
    typeCity(city);
    selectPeriodCurrentMonth(dataFrom,dataTo);

    }

    private void selectPeriodCurrentMonth(String dataFrom, String dataTo) {
    //7/25/2025
        //click fill dates
        click(By.id("dates"));
        String [] from=dataFrom.split("/"); //[7],[25],[2022], we need index 1
        String locator ="//div[text()=' "+from[1]+" ']";
        click(By.xpath(locator));
//7/31/2022
        String [] to= dataTo.split("/");
        String locator2=String.format("//div[text()=' %s ']",to[1]);
        click(By.xpath(locator2));
    }

    private void typeCity(String city) {
        type(By.id("city"),city);
        click(By.cssSelector(".pac-itemm"));
        //change
        pause(500);
    }
    public void searchCurrentYear(String city, String dataFrom, String dataTo) {
        typeCity(city);
        selectPeriodCurrentYear(dataFrom,dataTo);

        }

    private void selectPeriodCurrentYear(String dataFrom, String dataTo) {
        click(By.id("dates"));
        String now="7/17/2022";
        String [] today= now.split("/");
        int now_month= Integer.getInteger(today[0]);//7
        String [] from= dataFrom.split("/");
        int from_month= Integer.getInteger(from[0]);
        String [] to = dataTo.split("/");
        int to_month= Integer.getInteger(to[0]);
        int count = from_month-now_month;//9-7=2
        while (count>0){
            click(By.xpath("//button[@aria-label='Next month']"));
            count--;
        }
        if (count==0) {
            String locator = String.format("//div[.=' %s ']", from[0]);
            click(By.xpath(locator));
        }
        int count2 = to_month-from_month;//12-9=3
        while (count2>0){
            click(By.xpath("//button[@aria-label='Next month']"));
            count2--;
        }
        if (count2==0) {
            String locator2=String.format("//div[.=' %s ']",to[0]);
            click(By.xpath(locator2));

        }

    }

}
