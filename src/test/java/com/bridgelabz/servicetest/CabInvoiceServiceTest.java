package com.bridgelabz.servicetest;

import com.bridgelabz.service.CabInvoiceService;
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
}


