
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
                return room;
        }
        return null;
        }

    //Reserve a room method
    public static Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        reservationList.add(new Reservation(customer, room, checkInDate, checkOutDate));

        return null;
    }

    //Find a free room method
    public static Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) {
        Collection<IRoom> availableRooms = new HashSet<>();

        if (reservationList.size() == 0) {
            availableRooms = roomList;

            return availableRooms;
        } else {
            for (Reservation reservation : reservationList) {
                for (IRoom room : roomList) {
                    //at this point all rooms are in the room list
                    if (!room.getRoomNumber().equals(reservation.room.getRoomNumber())) {
                        availableRooms.add(room);

                    }
                    else if ((room.getRoomNumber().equals(reservation.room.getRoomNumber()))
                            && ((checkInDate.before(reservation.checkInDate) && checkOutDate.before(reservation.checkInDate))
                            || (checkInDate.after(reservation.checkOutDate) && checkOutDate.after(reservation.checkOutDate)))
                            ) {
                        availableRooms.add(room);

                    } else if (room.getRoomNumber().equals(reservation.room.getRoomNumber())) {
                        availableRooms.remove(room);

                    }
                }
            }
        }
        System.out.println(availableRooms);
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
