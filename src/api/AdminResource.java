package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import model.RoomType;
import java.util.Collection;

import static service.CustomerService.getCustomerService;
import static service.ReservationService.getReservationService;

public class AdminResource {

    //Static reference
    private static AdminResource adminResource = new AdminResource();
    public static AdminResource getAdminResource() {
        if (adminResource == null) {
            adminResource = new AdminResource();
        }
        return adminResource;
    }

    //Get a customer
    public static Customer getCustomer(String email){
        return getCustomerService().getCustomer(email);
    }

    //Add a room
    public static void addRoom (String roomNumber, Double roomPrice, RoomType roomType){
        getReservationService().addRoom(roomNumber, roomPrice, roomType);
    }

    //See all rooms
    public static Collection <IRoom> getAllRooms(){
        return getReservationService().roomList;
    }

    //See all customers
    public static Collection <Customer> getAllCustomers(){
        return getCustomerService().getAllCustomers();
    }

    //See all reservations
    public static Collection <Reservation> getAllReservations(){
        return getReservationService().reservationList;
    }
}
