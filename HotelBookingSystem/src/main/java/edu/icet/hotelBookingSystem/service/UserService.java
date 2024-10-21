package edu.icet.hotelBookingSystem.service;

import edu.icet.hotelBookingSystem.model.User;
import edu.icet.hotelBookingSystem.model.UserLog;

public interface UserService {

    void saveUser(User user);

    long checkUser(UserLog userLog);
}
