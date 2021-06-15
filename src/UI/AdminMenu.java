package UI;
import model.RoomType;

import static api.AdminResource.getAdminResource;
import static api.HotelResource.getHotelResource;

public class AdminMenu {
    //Method to check if an account exists
    private static boolean checkAccount() {
        if (getAdminResource().getAllCustomers().size() == 0) {
            return false;
        }
        return true;
    }

    //Main method
    public static void start () {

        //Scanner switch
        boolean keepRunning = true;

        try (java.util.Scanner scanner = new java.util.Scanner(System.in)) {

            //Used UI switch
            while (keepRunning) {

                try {
                    System.out.println("Admin menu");
                    System.out.println("1. See all customers");
                    System.out.println("2. See all rooms");
                    System.out.println("3. See all reservations");
                    System.out.println("4. Add a room");
                    System.out.println("5. Back to main menu");
                    int selection = Integer.parseInt(scanner.nextLine());
                    switch (selection) {
                        case 1:
                            if (checkAccount() == false) {
                                throw new Exception("There are no customers");
                            }
                            System.out.println(getAdminResource().getAllCustomers());
                            break;
                        case 2:
                            if (getAdminResource().getAllRooms().size() == 0) {
                                throw new Exception("There are no rooms");
                            }
                            System.out.println(getAdminResource().getAllRooms());
                            break;
                        case 3:
                            if (getAdminResource().getAllReservations().size() == 0) {
                                throw new Exception("There are no reservations");
                            }
                            System.out.println(getAdminResource().getAllReservations());
                            break;
                        case 4:
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
                            getAdminResource().addRoom(number, price, type);
                            System.out.println("Room created: "+ getHotelResource().getRoom(number));
                            break;
                        case 5:
                            MainMenu.start();
                            keepRunning = false;
                            break;

                        default:
                            throw new Exception("choose a number between 1 and 5");

                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }

    }
}
