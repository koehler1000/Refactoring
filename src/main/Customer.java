package main;


import java.util.*;

public class Customer {
    private String name;
    private Vector<Rental> rentals = new Vector<Rental>();
    public Customer (String newname){
        name = newname;
    }
    public void addRental(Rental arg) {
        rentals.addElement(arg);
    }
    public String getName (){
        return name;
    }
    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration<Rental> enum_rentals = rentals.elements();	    
        String result = "Rental Record for " + this.getName() + "\n";
        result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        while (enum_rentals.hasMoreElements()) {
            Rental rental = enum_rentals.nextElement();
            frequentRenterPoints = rental.calculateFrequentRenterPoints(frequentRenterPoints);
            //show figures for this rental
            result += "\t" + rental.getMovie().getTitle()+ "\t" + "\t" + rental.getDaysRented() + "\t" + rental.amountFor() + "\n";
            totalAmount += rental.amountFor();
        }
        //add footer lines
        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints + " frequent renter points";
        return result;
    }

}
    