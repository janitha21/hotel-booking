package edu.icet.hotelBookingSystem.service;

import edu.icet.hotelBookingSystem.entity.HotelEntity;
import edu.icet.hotelBookingSystem.model.Hotel;

import java.util.List;

public interface HotelService {

    void addHotel(Hotel hotel,long ownerId);

    List<HotelEntity> sendAllHotels();

     List<HotelEntity> getHotelsByName(String hotelSearch);

}
