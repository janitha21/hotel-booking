package edu.icet.hotelBookingSystem.service;

import edu.icet.hotelBookingSystem.model.Booking;

public interface BookingService {

    void saveBooking(Booking booking,long hotelId,long userId);
}
