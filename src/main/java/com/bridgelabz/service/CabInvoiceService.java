package com.bridgelabz.service;
import java.util.ArrayList;
public class CabInvoiceService {
    private static final double MINIMUM_FARE = 5;
    private static final double PER_KILOMETER_COST = 10;
    private static final int PER_MINUTE_COST = 1;
    RideRepository rideRepository = new RideRepository();
    ArrayList<Ride> listOfRides = new ArrayList<Ride>();
    public Double calculateFare(double distance, int time) {
        double totalFare = (distance * PER_KILOMETER_COST) + (time * PER_MINUTE_COST);
        return Math.max(totalFare, MINIMUM_FARE);
    }
    public double calculateFareForMultipleRides(Ride[] rides) {
        double aggregateFare = 0;
        for (Ride ride : rides) {
            listOfRides.add(ride);
            aggregateFare += calculateFare(ride.distance, ride.time);
        }
        return aggregateFare;
    }

    public InvoiceSummary getInvoiceSummary(Ride[] rides) {
        return new InvoiceSummary(rides.length, calculateFareForMultipleRides(rides));
    }

    public void addRides(String userId) {
        rideRepository.addUserRides(userId, listOfRides);
    }

    public ArrayList<Ride> getRidesByUserId(String userId) {
        ArrayList<Ride> ridesByUserId = rideRepository.getRidesByUserId(userId);
        return ridesByUserId;
    }
}