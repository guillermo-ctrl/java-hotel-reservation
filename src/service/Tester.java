package service;

import model.Customer;
import model.IRoom;
import model.Room;
import model.RoomType;

import java.util.Date;

public class Tester {
    public static void main (String[]args) {
        CustomerService.addCustomer("jone", "jansone", "j@gmail.com");
        CustomerService.addCustomer("tune", "jansne", "t@gmail.com");
        /*
        CustomerService.getCustomer("j@gmail.com");
        CustomerService.getCustomer("t@gmail.com");
        CustomerService.getAllCustomers();
         */

        Date date1 = new Date(2001-07-04);
        Date date2 = new Date(2001-07-05);

        ReservationService.addRoom( new Room("2", 100, RoomType.SINGLE));
        ReservationService.getARoom("2");
        ReservationService.reserveARoom(CustomerService.getCustomer("t@gmail.com"), ReservationService.getARoom("2"), date1, date2);
    }
}
