package scanner;


import api.AdminResource;
import api.HotelResource;

import java.util.Collection;
import java.util.Date;

public class MainMenu {
    //Method to check if an account exists
    private static boolean checkAccount() {
        if (AdminResource.getAllCustomers().size() == 0) {
            System.out.println("You need to create an account first");
            return false;
        }
        return true;
    }

    //Main method
    public static void main (String[] args) {

        //Scanner switch
        boolean keepRunning = true;

        try (java.util.Scanner scanner = new java.util.Scanner(System.in)) {

            //Used scanner switch
            while (keepRunning) {
                try {
                    System.out.println("Main menu");
                    System.out.println("1. Find and reserve a room");
                    System.out.println("2. See my reservations");
                    System.out.println("3. Create an account");
                    System.out.println("4. Admin");
                    System.out.println("5. Exit");
                    int selection = Integer.parseInt(scanner.nextLine());

                    //Find and reserve a room
                    if (selection == 1) {
                        if (checkAccount() == false) {
                            throw new Exception();
                        }
                        System.out.println("Enter a check in date");

                    }
                    //See my reservations
                    else if (selection == 2) {
                        if (checkAccount() == false) {
                            throw new Exception();
                        }
                        System.out.println("Please, type in your e-mail address:");
                        String reservationMail = new String(scanner.nextLine());
                        HotelResource.getCustomersReservations(reservationMail);
                    }
                    else if (selection == 3) {
                        System.out.println("You chose to create an account");
                    }
                    else if (selection == 4) {
                        System.out.println("You chose admin");
                    }
                    else if (selection == 5) {
                        System.out.println("Bye");
                        keepRunning = false;
                    }
                    else {
                        throw new Exception();
                    }
                } catch (Exception ex) {
                    System.out.println("choose a number between 1 and 5");
                }
            }
        }

    }
}
