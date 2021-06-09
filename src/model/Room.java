package model;

public class Room implements model.IRoom {

    //variables
    public String roomNumber;
    public double price;
    public model.RoomType enumeration;


    //Constructor function
    public Room (String roomNumber, double price, model.RoomType enumeration) {
        this.roomNumber = roomNumber;
        this.price = price;
        this.enumeration = enumeration;
    }


    //override toString for better description
    @Override
    public String toString() {
        return "Room number: " + roomNumber + "\n" + "Price: " + price + "\n" + "Room type: " + enumeration;
    }

    //Interface IRoom methods
    @Override
    public String getRoomNumber() {
        return roomNumber;
    }

    @Override
    public Double getRoomPrice() {
        return price;
    }

    @Override
    public RoomType getRoomType() {
        return enumeration;
    }

    @Override
    public boolean isFree() {
        return false;
    }
}
