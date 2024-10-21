package edu.icet.hotelBookingSystem.controller;

import edu.icet.hotelBookingSystem.entity.HotelEntity;
import edu.icet.hotelBookingSystem.model.Hotel;
import edu.icet.hotelBookingSystem.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/hotels")
public class HotelController {

   // @Autowired
   final HotelService hotelService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/add/{ownerId}")
    public Map<String, String> saveHotel(@RequestBody Hotel hotel, @PathVariable long ownerId) {
        hotelService.addHotel(hotel, ownerId);
        return Collections.singletonMap("status", "hotel created");
    }

    @CrossOrigin()
    @GetMapping("/getAllHotels")
    public List<HotelEntity> sendAllHotels(){

        List <HotelEntity> list = hotelService.sendAllHotels();
        return list;


    }

    @CrossOrigin()
    @GetMapping("/search-hotel/{searchName}")
    public List<HotelEntity> sendHotelByName(@PathVariable String searchName) {

        List<HotelEntity> hotelsByName = hotelService.getHotelsByName(searchName);
        return hotelsByName;
    }

}
