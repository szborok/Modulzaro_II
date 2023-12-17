package be03.borok_szabolcs.Factory;

import be03.borok_szabolcs.Model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RentalCompaniesFactory {
    
    public static void rentalCompanyGenerator(String input) {
        try {
            File myFile = new File(input);
            Scanner myScanner = new Scanner(myFile);
            while (myScanner.hasNextLine()) {
                String line = myScanner.nextLine();
                rentalCompanySplitter(line);
            }
            
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    
    private static void rentalCompanySplitter(String line) {
        String[] splitted = line.split("#");
        //Hertz     100
        //0         1
        String name = splitted[0];
        Integer location = Integer.valueOf(splitted[1]);
        
        RentalCompany currentRentalCompany = new RentalCompany(name,location);
        RentalCompany.rentalCompanies.add(currentRentalCompany);
        
    }
    
    
    
    
    
}
