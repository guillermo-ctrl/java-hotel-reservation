package model;

import java.util.Date;

public class Reservation {
    //variables
    Customer customer;
    IRoom room;
    Date checkInDate;
    Date checkOutDate;

    //constructor

    public Reservation(Customer customer, Room room, Date i, Date i1) {
        this.customer = customer;
        this.room = room;
        this.checkInDate = i;
        this.checkOutDate = i1;
    }

    //override toString method
    @Override
    public String toString() {
        return "Customer: " + customer + "\n" + "Room: " + room + "\n" + "Check in date: " + checkInDate + "\n" + "Check out date: " + checkOutDate;
    }
}
