package service;

import model.Customer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CustomerService {

    //Array of customers
    public static Map<String, Customer> mapOfCustomers = new HashMap<>();
    private static final ArrayList <Customer> customers = new ArrayList<Customer>();

    //Add customer method
    public static void addCustomer(String firstName, String lastName, String email) {
        customers.add(new model.Customer (firstName, lastName, email));
        for (Customer customer : customers) {
            mapOfCustomers.put(customer.eMail, customer);
        }
    }
    //Get single customer method

    public static Customer getCustomer(String customerEmail) {
        //System.out.println(mapOfCustomers.get(customerEmail).toString());
        return mapOfCustomers.get(customerEmail);
     }

    //Get all customers method
    public static Collection<Customer> getAllCustomers(){
        for (Customer customer : customers) {

        }
        return customers;
    }

    //Static reference
}
