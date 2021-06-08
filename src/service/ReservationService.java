
package service;


import model.*;

import java.util.*;

public class ReservationService {

    //Arrays for rooms and reservations

    static Collection<IRoom> roomList = new HashSet<>();
    static Collection<Reservation> reservationList = new HashSet<>();

    //Add room method
    public static void addRoom(IRoom room){
        roomList.add(room);
    }

    //Get room method
    public static IRoom getARoom(String roomNumber){
        for (IRoom room : roomList) {
            if (room.getRoomNumber().equals(roomNumber))
                System.out.println(room.toString());
                return room;
        }
        return null;
        }


    public static Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        reservationList.add(new Reservation(customer, room, checkInDate, checkOutDate));
        return null;
    }
    /*
    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) {

    }
    public Collection <Reservation> getCustomersReservation(Customer customer) {

    }
    public void printAllReservation(){

    }

 */


}
