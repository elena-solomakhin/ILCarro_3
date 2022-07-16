package tests;

import models.Car;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class AddNewCar extends BaseTest{
    @BeforeMethod
    public void preCondition(){
if (!app.getHelperUser().isLogged()){
    app.getHelperUser().login(new User().setEmail("noa@gmail.com").setPassword("Nnoa12345$"));
logger.info("user");
}

    }
    @Test
     public void addNewCarSuccess(){
        Random random= new Random();
       int i= random.nextInt(1000)+1000;
        Car car = Car.builder()
                .address("Haifa, Israel")
                .make("BMW")
                .model("M5")
                .year("2021")
                .engine("2.5")
                .fuel("Petrol")
                .gear("AT")
                .wD("AWD")
                .doors("5")
                .seats("4")
                .clasS("C")
                .fuelConsumtion("6.5")
                .carRegNumber("111-22-"+i)
                .price("65")
                .distanceIncluded("800")
                .features("type of features")
                .about("very nice car")
                .build();//create lombog
        logger.info("Contact is --->"+ car.toString());
        app.car().openCarForm();
        app.car().fillCarForm(car);
      app.car().attachPhoto("/Users/elenasolomakhina/Study/AutomatQA34/Progects/ILCarro_3/ILCarro_3/auto1.jpeg");
        app.car().submit();
        Assert.assertEquals(app.car().getMessage(),"Car added");

    }
    @AfterMethod
public void postCondition(){
    app.car().returnToHome();
    }
}
