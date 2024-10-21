package edu.icet.hotelBookingSystem.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class HotelOwner {
    private String ownerName;
    private String ownerContactNumber;
    private String userName;
    private String password;

   // private List<Hotel> hotels; // Optional: A list of hotels if needed

}
