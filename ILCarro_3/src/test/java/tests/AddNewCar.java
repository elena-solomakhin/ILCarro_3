package tests;

import models.Car;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewCar extends BaseTest{
    @BeforeMethod
    public void preCondition(){
        //logged?

    }
    @Test
     public void addNewCarSuccess(){

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
                .carRegNumber("1111-22-33")
                .price("65")
                .distanceIncluded("800")
                .features("type of features")
                .about("very nice car")
                .build();//create lombog
        app.car().openCarForm();
        app.car().fillCarForm(car);
        app.car().attachPhoto("");
        app.car().submit();

    }
}
