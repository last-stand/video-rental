package com.twu.refactor;

import java.util.List;

public class TextStatement {
    private final Customer customer;
    private final List<Rental> rentalList;

    public TextStatement(Customer customer) {
        this.customer = customer;
        this.rentalList = customer.getRentalList();
    }

    public String getFooterLines(double totalAmount, int frequentRenterPoints) {
        String statement = "Amount owed is " + String.valueOf(totalAmount) + "\n";
        statement += "You earned " + String.valueOf(frequentRenterPoints)
                + " frequent renter points";
        return statement;
    }

    public String getHeader(Customer customer) {
        return "Rental Record for " + customer.getName() + "\n";
    }

    public String getStatement() {
        String statement = getHeader(customer);
        for (Rental rental : rentalList){
            statement += customer.getRentalSubTotal(rental);
        }
        statement += getFooterLines(customer.getTotalAmount(), customer.getTotalFrequentRentalPoints());
        return statement;
    }
}
