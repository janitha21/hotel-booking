package edu.icet.hotelBookingSystem.service.impl;

import edu.icet.hotelBookingSystem.entity.HotelEntity;
import edu.icet.hotelBookingSystem.entity.HotelOwnerEntity;
import edu.icet.hotelBookingSystem.model.HotelOwner;
import edu.icet.hotelBookingSystem.model.OwnerLog;
import edu.icet.hotelBookingSystem.repository.HotelOwnerRepository;
import edu.icet.hotelBookingSystem.service.HotelOwnerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelOwnerServiceImpl implements HotelOwnerService {

    @Autowired
    HotelOwnerRepository repository;


    @Override
    public void addOwner(HotelOwner hotelOwner) {

        HotelOwnerEntity entity = new HotelOwnerEntity();
        entity.setOwnerName(hotelOwner.getOwnerName());
        entity.setOwnerContactNumber(hotelOwner.getOwnerContactNumber());
        entity.setPassword(hotelOwner.getPassword());
        entity.setUserName(hotelOwner.getUserName());
        repository.save(entity);

    }

    @Override
    public long checkOwner(OwnerLog ownerLog) {

        List<HotelOwnerEntity> ownerNameList = repository.findByUserName(ownerLog.getUserName());

        for (HotelOwnerEntity owner : ownerNameList) {
            // Compare passwords using equals (avoid == for String comparison)
            if (owner.getPassword().equals(ownerLog.getPassword())) {
                return owner.getHotelOwnerId();  // Return the hotelOwnerId if password matches
            }
        }

        return 1;

    }


}

