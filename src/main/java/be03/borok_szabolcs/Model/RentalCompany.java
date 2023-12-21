package be03.borok_szabolcs.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RentalCompany {
    
    private String name;
    private List<Car> garage;
    private Integer location;
    private List<Rental> rentals;
    
    public static List<RentalCompany> rentalCompanies = new ArrayList<>();
    
    public RentalCompany(String name, Integer location) {
        this.name = name;
        this.garage = new ArrayList<>();
        this.location = location;
        this.rentals = new ArrayList<>();
        //automatic garage fill up when a rental company is created
        fillUpGarage(getGarageSize(),Car.cars);
    }
    
    public String getName() { return name; }
    
    public List<Car> getGarage() { return garage; }
    
    public Integer getLocation() { return location; }
    
    public List<Rental> getRentals() { return rentals; }
    
    
    //---------------------------------------------------------------------
    
    public void addCar(Car car) {
        this.garage.add(car);
    }
    
    public void removeCar(Car car) { this.garage.remove(car); }
    
    public void removeCarByIndex(Integer index) {
        Car currentCar = this.garage.get(index);
        this.garage.remove(currentCar);
    }
    
    public void addRental(Rental rental) {
        this.rentals.add(rental);
    }
    
    public static RentalCompany getRentalCompanyByName(String companyName) {
        for (int i = 0; i < rentalCompanies.size(); i++) {
            RentalCompany currentRentalCompany = rentalCompanies.get(i);
            
            if (currentRentalCompany.getName().equals(companyName)) {
                return currentRentalCompany;
            }
        }
        //TODO handle not found company case
        return null;
    }
    
    private Integer getGarageSize() {
        int min = 0;
        int max = 0;
        int distance = Math.abs(this.location);
        
        if (distance > 400) {
            min = 0;
            max = 10;
        } else if (400 >= distance && distance > 200) {
            min = 15;
            max = 25;
        } else if (200 >= distance && distance > 100) {
            min = 25;
            max = 40;
        } else if (100 >= distance && distance >= 0) {
            min = 40;
            max = 50;
        } else {
            //TODO - handle error
            System.out.println("Error while running RentalCompaniesFactory/getGarageSize");
        }
        
        Random rnd = new Random();
        return rnd.nextInt(min,max);
    }
    
    private void fillUpGarage(Integer garageSize, List<Car> cars) {
        while (this.garage.size() < garageSize) {
            Random rnd = new Random();
            int randomCarIndex = rnd.nextInt(0,cars.size());
            Car randomCar = cars.get(randomCarIndex);
            this.garage.add(randomCar);
        }
    }
    
    public Car mostExpensiveCarInGarage() {
        int maxPrice = 0;
        int index = -1;
        
        for (int i = 0; i < this.garage.size(); i++) {
            Car currentCar = this.garage.get(i);
            if (currentCar.getPrice() > maxPrice) {
                maxPrice = currentCar.getPrice();
                index = i;
            }
        }
        return this.garage.get(index);
    }
    
    public Car getRandomCarFromGarage() {
        int randomCarIndex = new Random().nextInt(0,this.garage.size());
        return this.garage.get(randomCarIndex);
    }
    
    public static RentalCompany randomCompany(List<RentalCompany> rentalCompanies) {
        Random rnd = new Random();
        int randomIndex = rnd.nextInt(0,rentalCompanies.size());
        return rentalCompanies.get(randomIndex);
    }
    
    
    
    
    
    
    
    
    
}
