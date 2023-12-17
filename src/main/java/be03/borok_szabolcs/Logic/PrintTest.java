package be03.borok_szabolcs.Logic;

import be03.borok_szabolcs.Model.Car;
import be03.borok_szabolcs.Model.Customer;
import be03.borok_szabolcs.Model.RentalCompany;

import java.util.List;

public class PrintTest {
    
    public static void richestCostumer(List<Customer> customerList) {
        Customer result = Logic.richestCostumer(customerList);
        
        System.out.println(result.getName() + " is the richest.");
        System.out.println("---");
    }
    
    public static void longestRange(List<Car> carList) {
        Car result = Logic.longestRange(carList);
        
        System.out.println(result.getBrand() + " - " + result.getModel() + " can ride for the longest distance without refill.");
        System.out.println("---");
    }
    
    public static void mostNumOfCars (List<RentalCompany> companies) {
        String result = Logic.mostNumOfCars(companies);
        
        System.out.println(result + " have the most cars.");
        System.out.println("---");
    }
    
    public static void sixthWithin250(List<RentalCompany> companies) {
        Integer result = Logic.sixthWithin250(companies);
        
        System.out.println("Company 'Sixt' have " + result + " cars in the distance of 250 if we are at -200.");
        System.out.println("---");
    }
    
    public static void rentalNearby(List<RentalCompany> companies, Integer ourPosition) {
        RentalCompany result = Logic.rentalNearby(companies, ourPosition);
        
        System.out.println(result.getName() + " is the closest rental company to us if we are at position " + ourPosition + ".");
        System.out.println("---");
    }
    
    public static void rentalNearbyUser(List<RentalCompany> companies, Integer position) throws Exception {
        RentalCompany result = Logic.rentalNearbyUser(companies, position);
        
        System.out.println("The closest rental company is " + result.getName() + " if our position is " + position + ".");
        System.out.println("---");
    }
    
    public static void tenDayPrice(List<RentalCompany> companies) {
        Integer result = Logic.tenDayPrice(companies);
        
        System.out.println("The price of the most expensive car is " + result + " for 10 days, if our position is -100.");
        System.out.println("---");
    }
    
    public static void fiveDayRental(List<RentalCompany> companies,Integer position, List<Customer> customers) throws Exception {
        Integer result = Logic.fiveDayRental(companies,position,customers);
        
        System.out.println(
                "The price for 5 days with 150k/day with a random car from the closest rental company with 20x deposit will cost" + result.toString() + "."
        );
        System.out.println("---");
    }
    
    
    
    
    
}
