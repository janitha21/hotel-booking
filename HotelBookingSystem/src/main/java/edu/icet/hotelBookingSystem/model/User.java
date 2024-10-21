package edu.icet.hotelBookingSystem.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString

public class User {

    private String userEmail;
    private String userPassword;
    private String userName;
    private String userContactNumber;


}
