package be03.borok_szabolcs.Factory;

import be03.borok_szabolcs.Model.Customer;
import be03.borok_szabolcs.Model.Licence;
import be03.borok_szabolcs.Model.Type;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class CustomerFactory {
    
    public static void customerGenerator(String input) {
        try {
            File myFile = new File(input);
            Scanner myScanner = new Scanner(myFile);
            while (myScanner.hasNextLine()) {
                String line = myScanner.nextLine();
                customerSplitter(line, Licence.licenses);
            }
            
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    
    private static void customerSplitter(String line, List<Licence> licenses) {
        String[] splitted = line.split(" ");
        //11657235  Ács         Anna        25      1000    100
        //0         1           2           3       4       5
        Integer id = Integer.valueOf(splitted[0]);
        String name = splitted[1] + " " + splitted[2];
        Integer age = Integer.valueOf(splitted[3]);
        Integer budget = Integer.valueOf(splitted[4]);
        Licence licence = Licence.getLicenseByCustomerID(id);
        Integer location = Integer.valueOf(splitted[5]);
        
        Customer currentCustomer = new Customer(id,name,age,budget,licence,location);
        Customer.customers.add(currentCustomer);
    }
    
    
}
