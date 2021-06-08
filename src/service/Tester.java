package service;

public class Tester {
    public static void main (String[]args) {
        CustomerService.addCustomer("jone", "jansone", "j@gmail.com");
        CustomerService.getCustomer("j@gmail.com");
    }
}
