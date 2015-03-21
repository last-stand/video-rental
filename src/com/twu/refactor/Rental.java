package com.twu.refactor;

public class Rental {

    private static final int BONUS_RENTER_POINTS = 2;
    private static final int REGULAR_RENTER_POINTS = 1;
    public Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getFrequentRentalPoints() {
        return isEligibleForBonusPoints() ? BONUS_RENTER_POINTS : REGULAR_RENTER_POINTS;
    }

    private boolean isEligibleForBonusPoints() {
        return movie.isNewRelease() && daysRented > 1;
    }

    public double getRentalAmount() {
        return movie.getCostForMovie(daysRented);
    }
}