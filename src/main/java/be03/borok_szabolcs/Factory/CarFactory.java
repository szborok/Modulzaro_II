package be03.borok_szabolcs.Factory;

import be03.borok_szabolcs.Model.Car;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CarFactory {
    
    public static void carGenerator(String path) {
        try {
            File myFile = new File(path);
            Scanner myScanner = new Scanner(myFile);
            while (myScanner.hasNextLine()) {
                String line = myScanner.nextLine();
                carSplitter(line);
            }
            
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    
    private static void carSplitter(String line) {
        String[] splitted = line.split(" ");
        //Audi  A4  50  5   true    5.5     50
        //0     1   2   3   4       5       6
        String brand = splitted[0];
        String model = splitted[1];
        Integer price = Integer.parseInt(splitted[2]);
        Integer seats = Integer.parseInt(splitted[3]);
        Boolean isAutomatic = Boolean.valueOf(splitted[4]);
        Double consumption = Double.valueOf(splitted[5]);
        Integer tankCapacity = Integer.parseInt(splitted[6]);
        
        Car currentCar = new Car(brand,model,price,seats,isAutomatic,consumption,tankCapacity);
        Car.cars.add(currentCar);
    }

}
