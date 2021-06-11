package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;

public class HotelResource {
    //Get a customer
    public static Customer getCustomer(String email){
        return CustomerService.getCustomer(email);
    }

    //Create new customer
    public static void createACustomer(String firstName, String lastName, String email) {
        CustomerService.addCustomer(firstName, lastName, email);
    }

    //Get a room
    public static IRoom getRoom(String roomNumber) {
        return ReservationService.getARoom(roomNumber);
    }

    //Book a room
    public static void bookARoom(String customerEmail, IRoom room, LocalDate checkInDate, LocalDate checkOutDate) {
        ReservationService.reserveARoom(CustomerService.getCustomer(customerEmail), room, checkInDate, checkOutDate);
    }
    //See all reservations of a specific customer
    public static Collection<Reservation> getCustomersReservations(String customerEmail) {
        return ReservationService.getCustomersReservation(CustomerService.getCustomer(customerEmail));
    }
    //Find an available room for a specific date
    public static Collection<IRoom> findARoom(LocalDate checkIn, LocalDate checkOut) {
        return ReservationService.findRooms(checkIn, checkOut);
    }
}
