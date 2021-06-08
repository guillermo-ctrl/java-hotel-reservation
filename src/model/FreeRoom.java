package model;

public class FreeRoom extends model.Room {

    //constructor function changed to set price to 0
    public FreeRoom(String roomNumber, double price, model.RoomType enumeration) {
        super(roomNumber, 0, enumeration);
    }

    @Override
    public String toString() {
        return "Room number: " + roomNumber + "\n" + "Price: " + price + "\n" + "Room type: " + enumeration;
    }

}
