package service;

import model.Customer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CustomerService {

    //Array of customers
    private static Map<String, Customer> mapOfCustomers = new HashMap<>();
    private static final ArrayList <Customer> customers = new ArrayList<Customer>();

    //Static reference
    private static CustomerService customerService = new CustomerService();
    public static CustomerService getCustomerService() {
        if (customerService == null) {
            customerService = new CustomerService();
        }
        return customerService;
    }

    //Add customer method
    public static void addCustomer(String firstName, String lastName, String email) {
        customers.add(new Customer (firstName, lastName, email));
        for (Customer customer : customers) {
            mapOfCustomers.put(customer.eMail, customer);
        }
    }

    //Get single customer method
    public static Customer getCustomer(String customerEmail) {
        return mapOfCustomers.get(customerEmail);
     }

    //Get all customers method
    public static Collection<Customer> getAllCustomers(){
        for (Customer customer : customers) {

        }
        return customers;
    }

    //Get the email of a customer
    public static String getCustomerEmail(Customer customer){
        return customer.eMail;
    }

}
