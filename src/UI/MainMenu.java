package UI;


import api.AdminResource;
import api.HotelResource;
import model.RoomType;

import java.time.LocalDate;

public class MainMenu {
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

            //Used UI switch
            while (keepRunning) {
                //FOR TESTING PURPOSES
                AdminResource.addRoom ("1", 100.00, RoomType.SINGLE);
                AdminResource.addRoom ("2", 200.00, RoomType.DOUBLE);
                AdminResource.addRoom ("3", 300.00, RoomType.SINGLE);
                AdminResource.addRoom ("4", 400.00, RoomType.DOUBLE);
                HotelResource.createACustomer("Jim", "Jimson", "jim@mail.com");
                HotelResource.createACustomer("Jon", "Jonson", "jon@mail.com");
                HotelResource.createACustomer("Jane", "Janeson", "jane@mail.com");
                 //FOR TESTING PURPOSES

                try {
                    System.out.println("Main menu");
                    System.out.println("1. Find and reserve a room");
                    System.out.println("2. See my reservations");
                    System.out.println("3. Create an account");
                    System.out.println("4. Admin");
                    System.out.println("5. Exit");
                    int selection = Integer.parseInt(scanner.nextLine());
                    switch(selection){
                        case 1:
                            if (checkAccount() == false) {
                                throw new Exception("need an account");
                            }
                            System.out.println("Enter the year of the check-in date");
                            int year = Integer.parseInt(scanner.nextLine());
                            System.out.println("Enter the month of the check-in date");
                            int month = Integer.parseInt(scanner.nextLine());
                            System.out.println("Enter the day of the check-in date");
                            int day = Integer.parseInt(scanner.nextLine());
                            System.out.println("How many days are you planing to stay?");
                            int bookLength = Integer.parseInt(scanner.nextLine());
                            LocalDate checkInDate = LocalDate.of(year,month,day);
                            LocalDate checkOutDate = checkInDate.plusDays(bookLength);
                            if (HotelResource.findARoom(checkInDate, checkOutDate).size() == 0 ) {
                                throw new Exception("There are no available rooms for that date");
                            }
                            System.out.println("The following rooms are available:");
                            System.out.println(HotelResource.findARoom(checkInDate, checkOutDate));
                            System.out.println("What room would you like to book? Please enter the room number");
                            String bookRoomNumber = (scanner.nextLine().toString());
                            System.out.println("Enter your e-mail address to book room number " + bookRoomNumber);
                            String bookEmail = (scanner.nextLine().toString());
                            HotelResource.bookARoom(bookEmail, HotelResource.getRoom(bookRoomNumber), checkInDate, checkOutDate);
                            System.out.println("You have successfully booked the following room(s)"+ "\n" + HotelResource.getCustomersReservations(bookEmail));
                            break;
                        case 2:
                            if (checkAccount() == false) {
                                throw new Exception("You need to create an account");
                            }
                            System.out.println("Please, type in your e-mail address:");
                            String reservationMail = new String(scanner.nextLine());
                            HotelResource.getCustomersReservations(reservationMail);
                            break;
                        case 3:
                            System.out.println("Please, enter your first name");
                            String firstName = new String(scanner.nextLine());
                            System.out.println("Please, enter your last name");
                            String lastName = new String(scanner.nextLine());
                            System.out.println("Please, enter your e-mail address");
                            String eMail = new String(scanner.nextLine());
                            HotelResource.createACustomer(firstName, lastName, eMail);
                            break;

                        case 4:
                            AdminMenu.start();
                            keepRunning = false;
                            break;

                        case 5:
                            System.out.println("Bye");
                            keepRunning = false;

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
