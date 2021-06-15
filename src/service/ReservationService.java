
package service;


import model.*;

import java.time.LocalDate;
import java.util.*;

public class ReservationService {

    //Arrays for rooms and reservations

    public static Collection<IRoom> roomList = new HashSet<>();
    public static Collection<Reservation> reservationList = new HashSet<>();

    //Static reference
    private static ReservationService reservationService = new ReservationService();
    public static ReservationService getReservationService() {
        if (reservationService == null) {
            reservationService = new ReservationService();
        }
        return reservationService;
    }

    //Add room method
    public static void addRoom(String roomNumber,Double roomPrice,RoomType roomType){
        Room room = new Room (roomNumber,roomPrice,roomType);
        roomList.add(room);
    }

    //Get room method
    public static IRoom getARoom(String roomNumber){
        for (IRoom room : roomList) {
            if (room.getRoomNumber().equals(roomNumber))
                return room;
        }
        return null;
        }

    //Reserve a room method
    public static Reservation reserveARoom(Customer customer, IRoom room, LocalDate checkInDate, LocalDate checkOutDate) {
        reservationList.add(new Reservation(customer, room, checkInDate, checkOutDate));

        return null;
    }

    //Find a free room method
    public static Collection<IRoom> findRooms(LocalDate checkInDate, LocalDate checkOutDate) {
        Collection<IRoom> availableRooms = new HashSet<>();

        if (reservationList.size() == 0) {
            availableRooms = roomList;

            return availableRooms;
        } else {
            for (Reservation reservation : reservationList) {
                for (IRoom room : roomList) {
                    if (!room.getRoomNumber().equals(reservation.room.getRoomNumber())) {
                        availableRooms.add(room);
                    }
                    else if ((room.getRoomNumber().equals(reservation.room.getRoomNumber()))
                            && ((checkInDate.isBefore(reservation.checkInDate) && checkOutDate.isBefore(reservation.checkInDate))
                            || (checkInDate.isAfter(reservation.checkOutDate) && checkOutDate.isAfter(reservation.checkOutDate)))
                            ) {
                        availableRooms.add(room);

                    } else if (room.getRoomNumber().equals(reservation.room.getRoomNumber())) {
                        availableRooms.remove(room);

                    }
                }
            }
        }
        //System.out.println(availableRooms);
        return availableRooms;
    }

    //Get customers reservation method
    public static Collection <Reservation> getCustomersReservation(Customer customer) {
        Collection<Reservation> customersReservation = new HashSet<>();
        for (Reservation r: reservationList) {
            if (r.customer == customer) {
                System.out.println(r);
                customersReservation.add(r);

            }
        }
        return customersReservation;
    }

    //Print all reservations method
    public static void printAllReservations (){
        System.out.println(reservationList);
    }

}
