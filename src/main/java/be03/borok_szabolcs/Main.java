package be03.borok_szabolcs;


import be03.borok_szabolcs.Factory.CarFactory;
import be03.borok_szabolcs.Factory.CustomerFactory;
import be03.borok_szabolcs.Factory.LicencesFactory;
import be03.borok_szabolcs.Factory.RentalCompaniesFactory;
import be03.borok_szabolcs.Logic.Logic;
import be03.borok_szabolcs.Logic.PrintTest;
import be03.borok_szabolcs.Model.Car;
import be03.borok_szabolcs.Model.Customer;
import be03.borok_szabolcs.Model.RentalCompany;


public class Main {
    public static void main(String[] args) throws Exception {
        
        LicencesFactory.licenceGenerator("licences.txt");
        CustomerFactory.customerGenerator("customers.txt");
        CarFactory.carGenerator("cars.txt");
        RentalCompaniesFactory.rentalCompanyGenerator("rentalcompanies.txt");
        
        PrintTest.richestCostumer(Customer.customers);
        PrintTest.longestRange(Car.cars);
        PrintTest.mostNumOfCars(RentalCompany.rentalCompanies);
        PrintTest.sixthWithin250(RentalCompany.rentalCompanies);
        PrintTest.rentalNearby(RentalCompany.rentalCompanies, -300);
        PrintTest.rentalNearbyUser(RentalCompany.rentalCompanies,Logic.userInput500());
        PrintTest.tenDayPrice(RentalCompany.rentalCompanies);
        //PrintTest.fiveDayRental(RentalCompany.rentalCompanies,Logic.userInput500(),Customer.customers);
        
    }
}