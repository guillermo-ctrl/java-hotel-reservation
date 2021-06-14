package model;


import java.time.LocalDate;

public class Reservation {
    //variables
    public Customer customer;
    public IRoom room;
    public LocalDate checkInDate;
    public LocalDate checkOutDate;

    //constructor

    public Reservation(Customer customer, IRoom room, LocalDate checkInDate, LocalDate checkOutDate) {
        this.customer = customer;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    //override toString method
    @Override
    public String toString() {
        return "Customer: " + customer + "\n" + "Room: " + room + "\n" + "Check in date: " + checkInDate + "\n" + "Check out date: " + checkOutDate;
    }


}
