package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;



public class HelperSearch extends HelperBase {
    public HelperSearch(WebDriver wd) {
        super(wd);
    }

    public void searchCurrentMonth(String city, String dataFrom, String dataTo) {
        clearDates();
        typeCity(city);
        selectPeriodCurrentMonth(dataFrom,dataTo);
    }
    private void selectPeriodCurrentMonth(String dataFrom, String dataTo) {
        //     "7/25/2022"      "7/30/2022"
        click(By.id("dates"));

        String [] from = dataFrom.split("/"); // ["7"],["25"],["2022"  from[1] = "25"

        String locator  = "//div[text()=' "+from[1]+" ']";
        click(By.xpath(locator));


        //     "7/30/2022"
        String [] to = dataTo.split("/"); // ["7"],["30"],["2022"]     to[1]

        String locator2 = String.format("//div[text()=' %s ']",to[1]);

        click(By.xpath(locator2));

    }


    private void typeCity(String city) {
        type(By.id("city"), city);
        click(By.cssSelector(".pac-item"));
        pause(500);
    }

    public void searchCurrentYear(String city, String dataFrom, String dataTo) {
        typeCity(city);
        pause(500);
        selectPeriodCurrentYear(dataFrom, dataTo);

    }

//    private void selectPeriodCurrentYear2(String dataFrom, String dataTo) {
//        click(By.id("dates"));
//    }

    private void selectPeriodCurrentYear(String dataFrom, String dataTo) {

        String dataNow = "7/20/2022";
        String[] now = dataNow.split("/");
        String[] from = dataFrom.split("/");
        String[] to = dataTo.split("/");
        click(By.id("dates"));
        if (!now[0].equals(from[0])) {
            int count = Integer.parseInt(from[0]) - Integer.parseInt(now[0]);
            clickByNextMonth(count);
        }
        String locator = String.format("//div[.=' %s ']", from[1]);
        click(By.xpath(locator));
        if (Integer.parseInt(from[0]) != Integer.parseInt(to[0])) {
            int count = Integer.parseInt(to[0]) - Integer.parseInt(from[0]);
            clickByNextMonth(count);
        }
        String locator1 = String.format("//div[.=' %s ']", to[1]);
        click(By.xpath(locator1));

    }

    private void clickByNextMonth(int count) {
        for (int i = 0; i < count; i++) {
            click(By.xpath("//button[@aria-label='Next month']"));
        }
    }

    public boolean isListOfCarsAppeared() {
        return isElementPresent(By.cssSelector(".car-img-container.ng-star-inserted"));

    }

    public boolean isPageResulpAppeared() {
        String currentUrl = wd.getCurrentUrl();
        System.out.println(currentUrl);
        //or return   currentUrl.contains("https://ilcarro-1578153671498.web.app/search/results");
        return currentUrl.startsWith("https://ilcarro-1578153671498.web.app/search/results");
    }

    public void returnToHome() {
        click(By.cssSelector(".logo"));
    }

    public void searchCurrentYearLocalDate(String city, String dataFrom, String dataTo) {
        typeCity(city);
        LocalDate now = LocalDate.now();
        LocalDate from = LocalDate.parse(dataFrom, DateTimeFormatter.ofPattern("M/d/yyyy"));
        LocalDate to = LocalDate.parse(dataTo, DateTimeFormatter.ofPattern("M/d/yyyy"));
        click(By.id("dates"));
        if (now.getMonthValue() != from.getMonthValue()) {
            int count = from.getMonthValue() - now.getMonthValue();
            clickByNextMonth(count);
        }
        String locator = String.format("//div[.=' %s ']", from.getDayOfMonth());
        click(By.xpath(locator));

        if (from.getMonthValue() != to.getMonthValue()) {
            int count = to.getMonthValue() - from.getMonthValue();
            clickByNextMonth(count);
        }
        String locator1 = String.format("//div[.=' %s ']", to.getDayOfMonth());
        click(By.xpath(locator1));

    }

    public void searchAnyPeriodLocalDate2(String city, String dataFrom, String dataTo) {
        typeCity(city);
        LocalDate now = LocalDate.now();
        LocalDate from= LocalDate.parse(dataFrom, DateTimeFormatter.ofPattern("M/d/yyyy"));
        LocalDate to = LocalDate.parse(dataTo,DateTimeFormatter.ofPattern("M/d/yyyy"));
        click(By.id("dates"));

        int diffMonth = from.getYear()-now.getYear()
                ==0 ? from.getMonthValue() -now.getMonthValue() : 12-now.getMonthValue()+ from.getMonthValue();

        clickByNextMonth(diffMonth);
        String locator = String.format("//div[text()=' %s ']",from.getDayOfMonth());
        click(By.xpath(locator));

        diffMonth= to.getYear()-from.getYear()
                ==0  ?to.getMonthValue()-from.getMonthValue(): 12-from.getMonthValue()+to.getMonthValue();

        clickByNextMonth(diffMonth);
        locator=String.format("//div[text()=' %s ']",to.getDayOfMonth());
        click(By.xpath(locator));
    }



    public void searchAnyPeriodLocalDate(String city, String dataFrom, String dataTo){
            //"8/10/2022","3/20/2023")
            typeCity(city);
            LocalDate now = LocalDate.now();
            LocalDate from = LocalDate.parse(dataFrom, DateTimeFormatter.ofPattern("M/d/yyyy"));
            LocalDate to = LocalDate.parse(dataTo, DateTimeFormatter.ofPattern("M/d/yyyy"));
            click(By.id("dates"));
            int diffYear;
            int diffMonth;
            diffYear = from.getYear() - now.getYear();
            if (diffYear == 0) {
                diffMonth = from.getMonthValue() - now.getMonthValue();//8-7, when 2022 and 2022 year
            } else {
                diffMonth = 12 - now.getMonthValue() + from.getMonthValue();
            }
            clickByNextMonth(diffMonth);
            String locator = String.format("//div[.=' %s ']", from.getDayOfMonth());
            click(By.xpath(locator));
            /////********
            diffYear = to.getYear() - from.getYear();
            if (diffYear == 0) {
                diffMonth = to.getMonthValue() - from.getMonthValue();//8-7, when 2022 and 2022 year
            } else {
                diffMonth = 12 - from.getMonthValue() + to.getMonthValue();
            }
            clickByNextMonth(diffMonth);
            String locator1 = String.format("//div[.=' %s ']", from.getDayOfMonth());
            click(By.xpath(locator1));

        }

    private void clearDates() {
        wd.findElement(By.id("dates")).sendKeys(Keys.COMMAND+"a");
        wd.findElement(By.id("dates")).sendKeys(Keys.DELETE);
//        click(By.id("dates"));

    }

    }



