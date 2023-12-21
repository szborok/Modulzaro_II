package be03.borok_szabolcs.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Customer {
    
    private Integer id;
    private String name;
    private Integer age;
    private Integer budget;
    private Licence licence;
    private Integer location;
    
    public static List<Customer> customers = new ArrayList<>();
    
    public Customer(Integer id, String name, Integer age, Integer budget, Licence licence, Integer location) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.budget = budget;
        this.licence = licence;
        this.location = location;
    }
    
    public Integer getId() { return id; }
    
    public String getName() { return name; }
    
    public Integer getAge() { return age; }
    
    public Integer getBudget() { return budget; }
    
    public Licence getLicence() { return licence; }
    
    public Integer getLocation() { return location; }
    
    
    //--------------------------------------------------------------
    
    public static Customer randomCustomer(List<Customer> customers) {
        int randomCustomerIndex = new Random().nextInt(0,customers.size());
        return customers.get(randomCustomerIndex);
    }
    
    public void pay(Integer price) { this.budget -= price; }
    
    
    
}
