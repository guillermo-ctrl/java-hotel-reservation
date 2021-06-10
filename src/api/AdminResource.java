package api;

import model.Customer;
import model.IRoom;
import model.Room;
import model.RoomType;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.List;

public class AdminResource {

    public static Customer getCustomer(String email){
        return CustomerService.getCustomer(email);
    }
    public static void addRoom (String roomNumber, Double roomPrice, RoomType roomType){
        ReservationService.addRoom(roomNumber, roomPrice, roomType);
    }
    public static Collection <IRoom> getAllRooms(){
        return ReservationService.roomList;
    }
    public static Collection <Customer> getAllCustomers(){
        return CustomerService.getAllCustomers();
    }
    public static void displayAllReservations(){
        System.out.println(ReservationService.reservationList);
    }
}
