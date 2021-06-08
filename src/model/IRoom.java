package model;

public interface IRoom {
    public String getRoomNumber();
    public Double getRoomPrice();
    public model.RoomType getRoomType();
    public boolean isFree();
}