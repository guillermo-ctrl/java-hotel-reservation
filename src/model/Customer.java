package model;

import java.util.regex.Pattern;

public class Customer {
    //variables
    public String firstName;
    public String lastName;
    public String eMail;
    private final String emailRegex = "^(.+)@(.+).com$";
    private final Pattern pattern = Pattern.compile(emailRegex);

    //Constructor
    public Customer (String firstName, String lastName, String eMail) {
        if (!pattern.matcher(eMail).matches() ) {
            throw new IllegalArgumentException("Error, invalid Email.");
        }
        this.eMail = eMail;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "First name: " + firstName + "\n" + "Last name: " + lastName + "\n" + "Email: " + eMail;
    }

}
