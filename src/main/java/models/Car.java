package models;

import lombok.*;// swich on lybriary in gradle

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder // create exsempliars
public class Car {
    private String address;
    private String make;
    private String model;
    private String year;
    private String engine;
    private String fuel;
    private String gear;
    private String wD;
    private String doors;
    private String seats;
    private String clasS;
    private String fuelConsumtion;
    private String carRegNumber;
    private String price;
    private String distanceIncluded;
    private String features;
    private String about;


}
