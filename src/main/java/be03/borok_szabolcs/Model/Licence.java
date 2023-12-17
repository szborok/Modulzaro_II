package be03.borok_szabolcs.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Licence {
    
    private Integer licenceNumber;
    private Integer customerID;
    private LocalDate validFrom;
    private LocalDate validTo;
    private Type type;
    
    public static List<Licence> licenses = new ArrayList<>();
    
    public Licence(Integer licenceNumber, Integer customerID, LocalDate validFrom, LocalDate validTo, Type type) {
        this.licenceNumber = licenceNumber;
        this.customerID = customerID;
        this.validFrom = validFrom;
        this.validTo = validTo;
        this.type = type;
    }
    
    public Integer getLicenceNumber() { return licenceNumber; }
    
    public Integer getCustomerID() { return customerID; }
    
    public LocalDate getValidFrom() { return validFrom; }
    
    public LocalDate getValidTo() { return validTo; }
    
    public Type getType() { return type; }
    
    
    //---------------------------------------------------------------------------
    
    public static Licence getLicenseByCustomerID(Integer customerID) {
        for (int i = 0; i < licenses.size(); i++) {
            Licence currentLicence = licenses.get(i);
            if (currentLicence.customerID.equals(customerID)) {
                return currentLicence;
            }
        }
        //TODO - handle lincence not found case
        System.out.println("There is no licence with this customerID.");
        return null;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}




