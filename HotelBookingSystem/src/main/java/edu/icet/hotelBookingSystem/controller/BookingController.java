package edu.icet.hotelBookingSystem.controller;

import edu.icet.hotelBookingSystem.model.Booking;
import edu.icet.hotelBookingSystem.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class BookingController {

    final BookingService bookingService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/add/{hotelId}/{userId}")
    public Map<String, String> saveBooking(@RequestBody Booking booking, @PathVariable long hotelId, @PathVariable long userId){

        bookingService.saveBooking(booking,hotelId,userId);
        return Collections.singletonMap("status", "booking saved...");




    }

}
