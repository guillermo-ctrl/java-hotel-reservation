package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import model.RoomType;
import service.CustomerService;
import service.ReservationService;
import java.util.Collection;

import static service.ReservationService.reservationList;

public class AdminResource {

    //Get a customer
    public static Customer getCustomer(String email){
        return CustomerService.getCustomer(email);
    }

    //Add a room
    public static void addRoom (String roomNumber, Double roomPrice, RoomType roomType){
        ReservationService.addRoom(roomNumber, roomPrice, roomType);
    }

    //See all rooms
    public static Collection <IRoom> getAllRooms(){
        return ReservationService.roomList;
    }

    //See all customers
    public static Collection <Customer> getAllCustomers(){
        return CustomerService.getAllCustomers();
    }

    //See all reservations
    public static Collection <Reservation> getAllReservations(){
        return ReservationService.reservationList;
    }
}
