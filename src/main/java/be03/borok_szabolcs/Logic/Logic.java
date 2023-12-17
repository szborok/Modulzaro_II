package be03.borok_szabolcs.Logic;

import be03.borok_szabolcs.Model.Car;
import be03.borok_szabolcs.Model.Customer;
import be03.borok_szabolcs.Model.RentalCompany;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Logic {
    
    public static Customer richestCostumer(List<Customer> customerList) {
        //1. Keresse meg a leggazdagabb ügyfelet. Térjen vissza az ügyfél példányával.
        
        int maxMoney = 0;
        int index = -1;
        
        for (int i = 0; i < customerList.size(); i++) {
            Customer currentCustomer = customerList.get(i);
            
            if (currentCustomer.getBudget() > maxMoney) {
                maxMoney = currentCustomer.getBudget();
                index = i;
            }
        }
        return customerList.get(index);
    }
    
    public static Car longestRange(List<Car> carList) {
        //2. Keresse meg azt az autót, amelyik teli tankkal a legnagyobb hatótávot tudja megtenni.
        
        Double maxDistance = 0.0;
        int index = -1;
        
        for (int i = 0; i < carList.size(); i++) {
            Car currentCar = carList.get(i);
            
            if (currentCar.getRange() > maxDistance) {
                maxDistance = currentCar.getRange();
                index = i;
            }
        }
        return carList.get(index);
    }
    
    public static String mostNumOfCars (List<RentalCompany> companies) {
        //3. Melyik kereskedő cég rendelkezik a legtöbb autóval? Adja vissza a nevét
        
        int maxCars = 0;
        int index = -1;
        
        for (int i = 0; i < companies.size(); i++) {
            RentalCompany currentRentalCompany = companies.get(i);
            
            if (currentRentalCompany.getGarage().size() > maxCars) {
                maxCars = currentRentalCompany.getGarage().size();
                index = i;
            }
        }
        return companies.get(index).getName();
    }
    
    public static Integer sixthWithin250(List<RentalCompany> companies) {
        //4. Hány autója van a Sixt cégnek 250 távolságon belül, akkor ha a helyzetünk -200?
        
        String chosenRentalCompany = "Sixt";
        int startRange = -450;
        int endRange = 50;
        int counter = 0;
        
        for (int i = 0; i < companies.size(); i++) {
            RentalCompany currentRentalCompany = companies.get(i);
            
            if (currentRentalCompany.getName().equals(chosenRentalCompany)) {
                Integer currentLocation = currentRentalCompany.getLocation();;
                if (currentLocation >= startRange && currentLocation <= endRange) {
                    counter++;
                }
            }
        }
        return counter;
    }
    
    public static RentalCompany rentalNearby(List<RentalCompany> companies, Integer ourPosition) {
        //5. Ha a helyzetünk -300, akkor melyik cégtől rendeljünk kocsit?
        
        int distance = Integer.MAX_VALUE;
        int index = -1;
        
        for (int i = 0; i < companies.size(); i++) {
            RentalCompany currentRentalCompany = companies.get(i);
            Integer currentLocation = currentRentalCompany.getLocation();
            int diff = ourPosition - currentLocation;
            //-300  -   -500 = 200  |   -300   -    -10 = 290
            //-300  -    500 = 800  |   -300   -     10 = 310
            
            if (diff < distance) {
                distance = diff;
                index = i;
            }
        }
        return companies.get(index);
    }
    
    public static RentalCompany rentalNearbyUser(List<RentalCompany> companies, Integer position) throws Exception {
        //6. Kérjen be a felhasználótól egy helyet -500 és +500 között.
        // Amennyiben rossz értéket ad meg, akkor egy egyedi kivételt dobjon a program.
        // Adja meg mely bérlőcég van hozzánk a legközelebb.
        
        return rentalNearby(companies, position);
    }
    
    public static Integer userInput500() {
        while (true) {
            try {
                System.out.println("Enter a number between -500 and 500.");
                Scanner myScanner = new Scanner(System.in);
                int input = myScanner.nextInt();
                
                try {
                    if (input < 500 && input > -500) {
                        myScanner.close();
                        return input;
                    } else {
                        throw new Exception();
                    }
                    
                } catch (Exception e) {
                    System.out.println("Something went wrong, let's try that again.");
                    myScanner.next();
                }
            } catch (Exception e) {
                System.out.println("Input was not an Integer.");;
            }
        }
    }
    
    public static Integer tenDayPrice(List<RentalCompany> companies) {
        //7. Mennyibe kerülne a bérlés 10 napra, ha -100-hoz legközelebbi bérlő cégnél kivennénk a legdrágább autót?
        int days = 10;
        int position = -100;
        RentalCompany closestRentalCompany = Logic.rentalNearby(companies, position);
        Car mostExpensiveCar = closestRentalCompany.mostExpensiveCarInGarage();
        
        return days * mostExpensiveCar.getPrice();
    }
    
    public static Integer fiveDayRental(List<RentalCompany> companies,Integer position, List<Customer> customers) throws Exception {
        //8. Készítsen metódust, amely felhasználja a felhasználótól bekérő metódust
        //és megkeresi újra a hozzánk legközelebbi bérlő céget. Ettől a cégtől
        //kibérlünk egy véletlenszerű autót 5 napra. Mennyibe fog kerülni az összes
        //költségünk, ha a bérléskor a kocsi napi bérlésének 20x -át kell letenni és
        //naponta 150 kilómétert teszünk meg. A bérlés végén vissza kell tankolni
        //az elfogyasztott üzemanyagot, az üzemanyag literenkénti ára: 580Ft.
        //Amennyiben a bérlő 35 év alatti, akkor a teljes összes 10%-át még
        //felszámolják.
        
        Random rnd = new Random();
        int days = 5;
        int dailyKm = 150;
        int fuelPricePerLiter = 580;
        
        RentalCompany closestRentalCompany = Logic.rentalNearbyUser(companies,position);
        List<Car> garage = closestRentalCompany.getGarage();
        int randomCarIndex = rnd.nextInt(0,garage.size());
        Car chosenCar = garage.get(randomCarIndex);
        
        int randomCustomerIndex = rnd.nextInt(0,customers.size());
        Customer chosenCustomer = customers.get(randomCustomerIndex);
        int chosenCustomersAge = chosenCustomer.getAge();
        double multiplier = chosenCustomersAge < 35 ? 1.1 : 1;
        
        int deposit = chosenCar.getPrice() * days;
        double fuelCost = days * dailyKm * chosenCar.getConsumption() * fuelPricePerLiter;
        
        double fullCost = (deposit + fuelCost) * multiplier;
        
        return (int)fullCost;
    }
    
    
    
    
    
    
    
    
    
    
    
}
