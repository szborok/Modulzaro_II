package be03.borok_szabolcs.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Car {
    
    private String brand;
    private String model;
    private Integer price;
    private Integer seats;
    private Boolean isAutomatic;
    private Double consumption;
    private Integer tankCapacity;
    private Double range;
    
    public static List<Car> cars = new ArrayList<>();
    
    public Car(String brand, String model, Integer price, Integer seats, Boolean isAutomatic, Double consumption, Integer tankCapacity) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.seats = seats;
        this.isAutomatic = isAutomatic;
        this.consumption = calculateConsumption(consumption);
        this.tankCapacity = tankCapacity;
        this.range = calculateRange();
    }
    
    public String getBrand() { return brand; }
    
    public String getModel() { return model; }
    
    public Integer getPrice() { return price; }
    
    public Integer getSeats() { return seats; }
    
    public Boolean getAutomatic() { return isAutomatic; }
    
    public Double getConsumption() { return consumption; }
    
    public Integer getTankCapacity() { return tankCapacity; }
    
    public Double getRange() { return range; }
    
    
    //-----------------------------------------------------------------------------
    
    private Double calculateConsumption(Double consumption) {
        return this.isAutomatic ? consumption * 1.1 : consumption;
    }
    
    private Double calculateRange() {
        return (this.tankCapacity / this.consumption) * 100;
    }
    
    public static Car getRandomCar(List<Car> cars) {
        Random rnd = new Random();
        int randomIndex = rnd.nextInt(0,cars.size());
        return cars.get(randomIndex);
    }
    
    
    
    
    
    
    
    
    
    
    
}
