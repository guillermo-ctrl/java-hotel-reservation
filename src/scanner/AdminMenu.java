package scanner;

import api.AdminResource;
import api.HotelResource;
import model.RoomType;

import java.time.LocalDate;

public class AdminMenu {
    //Method to check if an account exists
    private static boolean checkAccount() {
        if (AdminResource.getAllCustomers().size() == 0) {
            return false;
        }
        return true;
    }

    //Main method
    public static void start () {

        //Scanner switch
        boolean keepRunning = true;

        try (java.util.Scanner scanner = new java.util.Scanner(System.in)) {

            //Used scanner switch
            while (keepRunning) {

                try {
                    System.out.println("Admin menu");
                    System.out.println("1. See all customers");
                    System.out.println("2. See all rooms");
                    System.out.println("3. See all reservations");
                    System.out.println("4. Add a room");
                    System.out.println("5. Back to main menu");
                    int selection = Integer.parseInt(scanner.nextLine());

                    //See all customers
                    if (selection == 1) {
                        if (checkAccount() == false) {
                            throw new Exception("There are no customers");
                        }
                        System.out.println(AdminResource.getAllCustomers());
                    }

                    //See all rooms
                    else if (selection == 2) {
                        if (AdminResource.getAllRooms().size() == 0) {
                            throw new Exception("There are no rooms");
                        }
                        System.out.println(AdminResource.getAllRooms());
                    }

                    //See all reservations
                    else if (selection == 3) {
                        if (AdminResource.getAllReservations().size() == 0) {
                            throw new Exception("There are no reservations");
                        }
                        System.out.println(AdminResource.getAllReservations());
                    }

                    //Add a room
                    else if (selection == 4) {
                        System.out.println("Please, enter a room number");
                        String number = new String(scanner.nextLine());
                        System.out.println("Please, enter the room price");
                        int intPrice = Integer.parseInt(scanner.nextLine());
                        double price = intPrice;
                        System.out.println("Please, enter the room type: SINGLE or DOUBLE");
                        String typeString = scanner.nextLine();
                        RoomType type = RoomType.DOUBLE;
                        for (RoomType roomType : RoomType.values()) {
                            if (roomType.name().equals(typeString)) {
                                type = roomType;
                            }
                        }
                        AdminResource.addRoom(number, price, type);
                        System.out.println("Room created: "+ HotelResource.getRoom(number));

                    }

                    //Back to main menu
                    else if (selection == 5) {
                        MainMenu.start();
                        keepRunning = false;
                    }

                    else {
                        throw new Exception("choose a number between 1 and 5");
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }

    }
}
