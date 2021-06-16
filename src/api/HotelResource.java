package api;

import model.Customer;
import model.IRoom;
import model.Reservation;

import java.time.LocalDate;
import java.util.Collection;

import static service.CustomerService.getCustomerService;
import static service.ReservationService.getReservationService;

public class HotelResource {
    //Static reference
    private static HotelResource hotelResource = new HotelResource();
    public static HotelResource getHotelResource() {
        if (hotelResource == null) {
            hotelResource = new HotelResource();
        }
        return hotelResource;
    }

    //Get a customer
    public Customer getCustomer(String email){
        return getCustomerService().getCustomer(email);
    }

    //Create new customer
    public static void createACustomer(String firstName, String lastName, String email) {
        getCustomerService().addCustomer(firstName, lastName, email);
    }

    //Get a room
    public static IRoom getRoom(String roomNumber) {
        return getReservationService().getARoom(roomNumber);
    }

    //Book a room
    public static void bookARoom(String customerEmail, IRoom room, LocalDate checkInDate, LocalDate checkOutDate) {
        getReservationService().reserveARoom(getCustomerService().getCustomer(customerEmail), room, checkInDate, checkOutDate);
    }
    //See all reservations of a specific customer
    public static Collection<Reservation> getCustomersReservations(String customerEmail) {
        return getReservationService().getCustomersReservation(customerEmail);
    }
    //Find an available room for a specific date
    public static Collection<IRoom> findARoom(LocalDate checkIn, LocalDate checkOut) {
        return getReservationService().findRooms(checkIn, checkOut);
    }
}
