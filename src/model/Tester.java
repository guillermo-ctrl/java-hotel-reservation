package model;

import java.time.LocalDate;
import java.util.Date;

import static model.RoomType.DOUBLE;
import static model.RoomType.SINGLE;

public class Tester {
    public static void main (String[]args) {
        LocalDate date1 = LocalDate.of(2001,07,04);
        LocalDate date2 = LocalDate.of(2001,07,05);
        Customer customer = new model.Customer("first", "second", "j@mail.com");
        Customer customer2 = new model.Customer("first", "second", "j@mail.com");
        Customer customer4 = new model.Customer("first", "second", "j@mail.com");
        Customer customer3 = new model.Customer("sec", "second", "j@mail.com");
        FreeRoom freeRoom = new FreeRoom("2", 23, DOUBLE);
        IRoom room = new Room("1", 23, SINGLE);
        Reservation reservation = new Reservation(customer, room,  date1, date2 );
        System.out.println(
                customer.toString() +"\n"+ room.toString() +"\n"+ freeRoom.toString()+"\n"+ "Reservation: " +"\n"+ reservation.toString()
                        +"\n"+"\n"+"\n"+"\n"+"\n"+"\n"
        );
        /*

         */

        System.out.println("USERCHECK");
        User user1 = new User("mkyong", 35, "111222333");
        User user2 = new User("mkyong", 35, "111222333");

        System.out.println(user1.equals(user2)); // true

        Customer c1 = new model.Customer("asd", "asd", "asd@mail.com");
        Customer c2 = new model.Customer("asd", "asd", "asd@mail.com");
        Customer c3 = new model.Customer("qwe", "qwe", "qwe@mail.com");

        System.out.println("CUSTOMERCHECK");
        System.out.println(c1.equals(c2)); // Should be true
        System.out.println(c1.equals(c3));  // Should be false



    }
}
