package be03.borok_szabolcs.Logic;

import be03.borok_szabolcs.Model.Car;
import be03.borok_szabolcs.Model.Customer;
import be03.borok_szabolcs.Model.Rental;
import be03.borok_szabolcs.Model.RentalCompany;

import java.util.ArrayList;
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
                "The price for 5 days with 150k/day with a random car from the closest rental company with 20x deposit will cost " + result.toString() + "."
        );
        System.out.println("---");
    }
    
    public static void rentals(List<RentalCompany> companies, List<Customer> customers) {
        Logic.rentals(companies,customers);
        
        //get companies with rentals
        List<RentalCompany> rentalCompanyList = companies;
        List<Integer> indexes = new ArrayList<>();
        
        for (int i = 0; i < rentalCompanyList.size(); i++) {
            RentalCompany currentRentalCompany = rentalCompanyList.get(i);
            if (!currentRentalCompany.getRentals().isEmpty()) {
                indexes.add(i);
            }
        }
        int cnt = 1;
        for (int i = 0; i < indexes.size(); i++) {
            RentalCompany currentRentalCompany = rentalCompanyList.get(indexes.get(i));
            
            for (int j = 0; j < currentRentalCompany.getRentals().size(); j++) {
                System.out.println("Rental No." + (cnt));
                System.out.println("Company name: " + currentRentalCompany.getName());
                Rental currentRental = currentRentalCompany.getRentals().get(j);
                System.out.println("Renter: " + currentRental.getRenter().getName());
                System.out.println("Rented car: " + currentRental.getRentedCar().getBrand() + " - " + currentRental.getRentedCar().getModel());
                System.out.println("From: " + currentRental.getFrom());
                System.out.println("To: " + currentRental.getTo());
                System.out.println("Deposit: " + currentRental.getDeposit());
                System.out.println("Is the rent ongoing: " + currentRental.getActive());
                System.out.println("---");
                cnt++;
            }
        }
    }
    
    public static void expiredLicence(List<RentalCompany> companies) {
        Boolean answer = Logic.expiredLicence(companies);
        
        if (answer) {
            System.out.println("There is a person's licence expired from the renters.");
        } else {
            System.out.println("Everybody's licence is valid who rented a car.");
        }
    }
    
    public static void newCars(List<RentalCompany> companies, List<Car> cars) {
        List<RentalCompany> beforeDonation = List.copyOf(companies);
        Logic.newCars(companies,cars);
        
        for (int i = 0; i < companies.size(); i++) {
            List<Car> carsAfter = companies.get(i).getGarage();
            List<Car> carsBefore = beforeDonation.get(i).getGarage();
            
            if (carsBefore.size() != carsAfter.size()) {
                for (int j = 0; j < carsAfter.size(); j++) {
                    if (!carsBefore.contains(carsAfter.get(j))) {
                        String company = companies.get(i).getName();
                        String brand = companies.get(i).getGarage().get(j).getBrand();
                        String model = companies.get(i).getGarage().get(j).getModel();
                        System.out.println(company + " has got a new " + brand + " - " + model + ".");
                    }
                }
            }
        }
    }
    
    
    
    
    public static void simulateRental(List<RentalCompany> rentalCompanies, List<Customer> customers) {
        //Create the 8 rentals to have data for simulation
        Logic.rentals(rentalCompanies,customers);
        
        Logic.simulateRental(rentalCompanies);
        
        System.out.println("---");
        
    }
    
    
}
