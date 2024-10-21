package edu.icet.hotelBookingSystem.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Setter
@Getter
@ToString
public class Booking {

    private int bookingDate;
    private int bookingDays;
    private double price;


}
