package be03.borok_szabolcs.Factory;

import be03.borok_szabolcs.Model.Car;
import be03.borok_szabolcs.Model.Licence;
import be03.borok_szabolcs.Model.Type;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;

public class LicencesFactory {
    
    public static void licenceGenerator(String path) {
        try {
            File myFile = new File(path);
            Scanner myScanner = new Scanner(myFile);
            while (myScanner.hasNextLine()) {
                String line = myScanner.nextLine();
                licensesSplitter(line);
            }
            
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    
    private static void licensesSplitter(String line) {
        String[] splitted = line.split(" ");
        //10561778  11657235    2022-06-30  2026-01-07  Normal
        //0         1           2           3           4
        Integer licenceNumber = Integer.valueOf(splitted[0]);
        Integer customerID = Integer.valueOf(splitted[1]);
        LocalDate validFrom = LocalDate.parse(splitted[2]);
        LocalDate validTo = LocalDate.parse(splitted[3]);
        Type type = Type.valueOf(splitted[4]);
        
        Licence currentLicence = new Licence(licenceNumber,customerID,validFrom,validTo,type);
        Licence.licenses.add(currentLicence);
    }
    
    
}
