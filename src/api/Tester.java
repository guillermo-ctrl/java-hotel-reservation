package api;

import model.Customer;
import model.IRoom;
import model.RoomType;
import service.CustomerService;
import service.ReservationService;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class Tester {
    public static void main (String[]args) {

        HotelResource.createACustomer( "joam", "jarsno", "asd@asd.com");
        System.out.println(HotelResource.getCustomer("asd@asd.com"));
        HotelResource.getRoom("2");
        HotelResource.bookARoom("asd@asd.com", HotelResource.getRoom("2"), LocalDate.of(2010,05,05), LocalDate.of(2010, 06,06));
        HotelResource.getCustomersReservations("asd@asd.com");
        HotelResource.findARoom(LocalDate.of(2010,05,05), LocalDate.of(2010,06,06));

        AdminResource.getCustomer("asd@asd.com");
        AdminResource.addRoom("10", 300.00, RoomType.DOUBLE);
        AdminResource.getAllRooms();
        AdminResource.getAllCustomers();
        AdminResource.getAllReservations();
    }
}
