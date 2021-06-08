package model;

import java.util.Date;

import static model.RoomType.DOUBLE;
import static model.RoomType.SINGLE;

public class Tester {
    public static void main (String[]args) {
        Date date1 = new Date(2001-07-04);
        Date date2 = new Date(2001-07-05);
        Customer customer = new model.Customer("first", "second", "j@mail.com");
        FreeRoom freeRoom = new FreeRoom("2", 23, DOUBLE);
        IRoom room = new Room("1", 23, SINGLE);
        Reservation reservation = new Reservation(customer, room,  date1, date2 );
        System.out.println(
                customer.toString() +"\n"+ room.toString() +"\n"+ freeRoom.toString()+"\n"+ "Reservation: " +"\n"+ reservation.toString()
        );
    }
}
