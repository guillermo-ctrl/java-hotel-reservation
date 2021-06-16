package UI;
import model.Customer;
import model.IRoom;
import java.time.LocalDate;
import static api.AdminResource.getAdminResource;
import static api.HotelResource.getHotelResource;

public class MainMenu {
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

                /*FOR TESTING PURPOSES
                getAdminResource().addRoom ("1", 100.00, RoomType.SINGLE);
                getAdminResource().addRoom ("2", 200.00, RoomType.DOUBLE);
                getAdminResource().addRoom ("3", 300.00, RoomType.SINGLE);
                getAdminResource().addRoom ("4", 400.00, RoomType.DOUBLE);
                getHotelResource().createACustomer("Jim", "Jimson", "jim@mail.com");
                getHotelResource().createACustomer("Jon", "Jonson", "jon@mail.com");
                getHotelResource().createACustomer("Jane", "Janeson", "jane@mail.com");
                FOR TESTING PURPOSES */

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

                            if (getHotelResource().findARoom(checkInDate, checkOutDate).size() == 0 ) {
                                if (getHotelResource().findARoom(checkInDate.plusDays(7), checkOutDate.plusDays(7)).size() == 0 ) {
                                    throw new Exception("There are no available rooms for that date");
                                }
                                System.out.println("There are no rooms for that date. Would you like to check rooms a week later?" + "\n"  + "Please answer YES or NO");

                                Boolean answerSwitch = false;
                                while (!answerSwitch) {
                                    String a = scanner.nextLine();
                                    switch(a.toLowerCase()) {
                                        case "yes":
                                            checkInDate = checkInDate.plusDays(7);
                                            checkOutDate = checkOutDate.plusDays(7);
                                            answerSwitch = true;
                                            break;
                                        case "no":
                                            throw new Exception("Ok then");
                                        default:
                                            throw new Exception("The answer had to be yes or no. Please try again.");
                                    }
                                }

                            }

                            System.out.println("The following rooms are available from "+ checkInDate + " to " + checkOutDate);
                            System.out.println(getHotelResource().findARoom(checkInDate, checkOutDate));

                            boolean roomcheck = false;
                            String bookRoomNumber = new String();
                            while (!roomcheck) {
                                System.out.println("What room would you like to book? Please enter the room number");
                                bookRoomNumber = scanner.nextLine();
                                for (IRoom room : getHotelResource().findARoom(checkInDate, checkOutDate))
                                {
                                    if (room.getRoomNumber().equals(bookRoomNumber)) {
                                        roomcheck = true;
                                    }
                                    else {
                                        System.out.println("You need to pick a room from the list.");
                                    }
                                }
                            }

                            boolean mailCheck = false;
                            String bookEmail = new String();
                            while (!mailCheck) {
                                System.out.println("Enter your e-mail address to book room number " + bookRoomNumber);
                                bookEmail = scanner.nextLine();
                                for (Customer customer : getAdminResource().getAllCustomers())
                                {
                                    if (getAdminResource().getCustomerEmail(customer).equals(bookEmail)) {
                                        mailCheck = true;
                                    }
                                }
                                if (mailCheck == false) {
                                    System.out.println("Email not valid, please try again.");
                                }
                            }

                            getHotelResource().bookARoom(bookEmail, getHotelResource().getRoom(bookRoomNumber), checkInDate, checkOutDate);
                            System.out.println("Reservation successful, press 2 to see your reservations.");
                            break;
                        case 2:
                            if (checkAccount() == false) {
                                throw new Exception("You need to create an account");
                            }

                            System.out.println("Please, type in your e-mail address:");
                            String reservationMail = scanner.nextLine();

                            for (Customer customer : getAdminResource().getAllCustomers()) {
                                if (getAdminResource().getCustomerEmail(customer).equals(reservationMail)) {
                                    if (getHotelResource().getCustomersReservations(reservationMail).size() == 0) {
                                        System.out.println("You have no reservations. Press 1 to find and reserve a room.");
                                        break;
                                    }
                                    System.out.println(getHotelResource().getCustomersReservations(reservationMail));
                                    break;
                                }
                            }

                            break;
                        case 3:
                            System.out.println("Please, enter your first name");
                            String firstName = scanner.nextLine();
                            System.out.println("Please, enter your last name");
                            String lastName = scanner.nextLine();
                            System.out.println("Please, enter your e-mail address");
                            String eMail = scanner.nextLine();
                            getHotelResource().createACustomer(firstName, lastName, eMail);
                            break;

                        case 4:
                            AdminMenu.start();
                            keepRunning = false;
                            break;

                        case 5:
                            System.out.println("Bye");
                            keepRunning = false;

                        default:
                            throw new Exception("Choose a number between 1 and 5");
                    }

                } catch (Exception ex) {
                    System.out.println(ex.getMessage());

                }
            }
        }

    }
}