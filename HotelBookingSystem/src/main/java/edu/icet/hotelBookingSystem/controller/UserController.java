package edu.icet.hotelBookingSystem.controller;

import edu.icet.hotelBookingSystem.model.AuthResponse;
import edu.icet.hotelBookingSystem.model.User;
import edu.icet.hotelBookingSystem.model.UserLog;
import edu.icet.hotelBookingSystem.service.JwtUtill;
import edu.icet.hotelBookingSystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class UserController {

   final UserService userService;
   @Autowired
   JwtUtill jwtUtill;

    @CrossOrigin()
    @PostMapping("/save-user")
    public Map<String, String> saveUser(@RequestBody User user){

       userService.saveUser(user);
        return Collections.singletonMap("status","sign in successful....");

    }
    
    //-------check for login
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/log-in")
    public ResponseEntity<Map<String, String>> checkUser(@RequestBody UserLog userLog) {
        long id = userService.checkUser(userLog);

        Map<String, String> response = new HashMap<>();

        if (id != 0) {
            String token = jwtUtill.generateToken(userLog.getUserEmail(), id);

            // Return token in a JSON response
            response.put("token", token);
            return ResponseEntity.ok(response);
        } else {
            response.put("error", "Invalid credentials");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }
}
