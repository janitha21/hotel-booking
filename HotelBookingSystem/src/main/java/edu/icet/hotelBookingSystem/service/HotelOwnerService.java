package edu.icet.hotelBookingSystem.service;

import edu.icet.hotelBookingSystem.entity.HotelOwnerEntity;
import edu.icet.hotelBookingSystem.model.HotelOwner;
import edu.icet.hotelBookingSystem.model.OwnerLog;

public interface HotelOwnerService {

    void addOwner(HotelOwner hotelOwner);

    long checkOwner(OwnerLog ownerLog);


}
