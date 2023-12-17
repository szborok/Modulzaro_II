package be03.borok_szabolcs.Model;

import java.time.LocalDate;

public class Rental {
    
    private Customer renter;
    private Car rentedCar;
    private LocalDate from;
    private LocalDate to;
    private Integer deposit;
    private Boolean isActive;
    
    public Rental(Customer renter, Car rentedCar, LocalDate from, LocalDate to, Integer deposit, Boolean isActive) {
        this.renter = renter;
        this.rentedCar = rentedCar;
        this.from = from;
        this.to = to;
        this.deposit = deposit;
        this.isActive = isActive;
    }
    
    public Customer getRenter() { return renter; }
    
    public Car getRentedCar() { return rentedCar; }
    
    public LocalDate getFrom() { return from; }
    
    public LocalDate getTo() { return to; }
    
    public Integer getDeposit() { return deposit; }
    
    public Boolean getActive() { return isActive; }
    
    
    //---------------------------------------------------------------------------------
    
    
    
    
    
}
