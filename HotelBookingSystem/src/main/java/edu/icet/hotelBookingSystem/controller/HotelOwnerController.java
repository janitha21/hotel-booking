package edu.icet.hotelBookingSystem.controller;

import edu.icet.hotelBookingSystem.model.HotelOwner;
import edu.icet.hotelBookingSystem.model.OwnerLog;
import edu.icet.hotelBookingSystem.service.HotelOwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class HotelOwnerController {

   // @Autowired
    final HotelOwnerService hotelOwnerService;


    @CrossOrigin()
    @PostMapping("/save-owner")
    public Map<String, String> saveHotelOwner(@RequestBody HotelOwner hotelOwner){

        hotelOwnerService.addOwner(hotelOwner);
        return Collections.singletonMap("status","Student create");

    }

    @CrossOrigin()
    @PostMapping("/check-owner")
    public long checkOwner(@RequestBody OwnerLog ownerLog){

        long id = hotelOwnerService.checkOwner(ownerLog);

        return id;
    }
}
