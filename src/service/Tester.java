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
        Date date3 = new Date(2002-07-04);
        Date date4 = new Date(2002-07-05);
        Customer customer1 = CustomerService.getCustomer("t@gmail.com");
        Customer customer2 = CustomerService.getCustomer("j@gmail.com");
        ReservationService.addRoom( new Room("1", 100, RoomType.SINGLE));
        ReservationService.addRoom( new Room("2", 200, RoomType.SINGLE));
        ReservationService.addRoom( new Room("3", 300, RoomType.DOUBLE));
        ReservationService.addRoom( new Room("4", 400, RoomType.DOUBLE));
        //System.out.println("Roomlist after adding rooms"+"\n" +ReservationService.roomList.toString());
        //System.out.println(ReservationService.getARoom("2").toString());
        ReservationService.reserveARoom(customer1, ReservationService.getARoom("1"), date1, date2);
        //System.out.println("ReservationList after reserving room 1"+"\n" +ReservationService.reservationList.toString()+"\n"+"\n");
        ReservationService.reserveARoom(customer2, ReservationService.getARoom("2"), date1, date2);
        //ReservationService.findRooms(date1, date2);
        //ReservationService.findRooms(date3, date4);
        //ReservationService.printAllReservations();
        ReservationService.getCustomersReservation(customer1);
    }
}
