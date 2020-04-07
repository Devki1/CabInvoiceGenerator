package com.bridgelabz.servicetest;

import com.bridgelabz.service.CabInvoiceService;
import com.bridgelabz.service.Ride;
import org.junit.Assert;
import org.junit.Test;

public class CabInvoiceServiceTest {
    CabInvoiceService cabInvoiceService = new CabInvoiceService();

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        double distance = 4.0;
        int time = 15;
        double fare = cabInvoiceService.calculateFare(distance, time);
        Assert.assertEquals(55, fare, 0);
    }
    @Test
    public void givenLessDistanceAndTime_ShouldReturnMinimumFare() {

        double distance = 0.1;
        int time = 3;
        double fare = cabInvoiceService.calculateFare(distance, time);
        Assert.assertEquals(5, fare, 0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        Ride[] rides = {
                new Ride(2.0, 5),
                new Ride(0.1, 1),
                new Ride(4.1, 25)
        };
        double totalFare = cabInvoiceService.calculateFareForMultipleRides(rides);
        Assert.assertEquals(96, totalFare, 0);
    }
}


