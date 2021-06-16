package model;

import java.util.regex.Pattern;

public class Customer {
    //variables
    private String firstName;
    private String lastName;
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
        return "First name: " + firstName + "\n" + "Last name: " + lastName + "\n" + "Email: " + eMail + "\n";
    }

    //override equals method
    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Customer)) {
            return false;
        }

        Customer customer = (Customer) o;


        return customer.firstName.equals(firstName) &&
                customer.lastName.equals(lastName) &&
                customer.eMail.equals(eMail);
    }

    //Idea from effective Java : Item 9
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + eMail.hashCode();
        return result;
    }

}
