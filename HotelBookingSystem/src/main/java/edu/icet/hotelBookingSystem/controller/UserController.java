package edu.icet.hotelBookingSystem.controller;

import edu.icet.hotelBookingSystem.model.User;
import edu.icet.hotelBookingSystem.model.UserLog;
import edu.icet.hotelBookingSystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class UserController {

   final UserService userService;

    @CrossOrigin()
    @PostMapping("/save-user")
    public Map<String, String> saveUser(@RequestBody User user){

       userService.saveUser(user);
        return Collections.singletonMap("status","sign in successful....");

    }
    
    //-------check for login
    @CrossOrigin()
    @PostMapping("/log-in")
    public long checkUser(@RequestBody UserLog userLog){

        long id = userService.checkUser(userLog);
        return id;
    }
}
