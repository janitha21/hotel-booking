package edu.icet.hotelBookingSystem.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Hotel {

    private long hotelId;

    private String hotelName;
    private String hotelContact;
    private String hotelLoacation;
    private String hotelDescription;
    private String hotelPhotoPath;




}
