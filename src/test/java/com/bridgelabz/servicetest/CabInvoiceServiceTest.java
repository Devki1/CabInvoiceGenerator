package com.bridgelabz.servicetest;

import com.bridgelabz.service.CabInvoiceService;
import com.bridgelabz.service.InvoiceSummary;
import com.bridgelabz.service.Ride;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CabInvoiceServiceTest {
    CabInvoiceService cabInvoiceGenerator = null;

    @Before
    public void setUp() {
        cabInvoiceGenerator = new CabInvoiceService();
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        double distance = 5.0;
        int time = 15;
        double fare = cabInvoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(65, fare, 0.0);
    }

    @Test
    public void givenLessDistanceAndTime_ShouldReturnMinFare() {
        double distance = 0.1;
        int time = 2;
        double fare = cabInvoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(5, fare, 0.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        Ride[] rides = {
                new Ride(2.0, 5),
                new Ride(0.1, 1),
                new Ride(4.1, 25)
        };
        double totalFare = cabInvoiceGenerator.calculateFareForMultipleRides(rides);
        Assert.assertEquals(96, totalFare, 0);
    }

    @Test
    public void givenUserIdAndRide_shouldReturnInvoiceSummary() {
        String userId = "gdev3123@gmail.com";
        Ride[] rides = {
                new Ride(2.0, 5),
                new Ride(0.1, 1),
                new Ride(4.1, 25)
        };
        cabInvoiceGenerator.addRides(userId);
        InvoiceSummary invoiceSummary = cabInvoiceGenerator.getInvoiceSummary(rides);
        InvoiceSummary fare = new InvoiceSummary(3, 96);
        Assert.assertEquals(fare, invoiceSummary);
        Assert.assertEquals(rides.length, cabInvoiceGenerator.getRidesByUserId(userId).size());
    }
}