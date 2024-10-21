package edu.icet.hotelBookingSystem.service.impl;

import edu.icet.hotelBookingSystem.entity.HotelEntity;
import edu.icet.hotelBookingSystem.entity.HotelOwnerEntity;
import edu.icet.hotelBookingSystem.model.Hotel;
import edu.icet.hotelBookingSystem.repository.HotelOwnerRepository;
import edu.icet.hotelBookingSystem.repository.HotelRepository;
import edu.icet.hotelBookingSystem.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class HotelServiceImpl implements HotelService {

  //  @Autowired
    final HotelRepository hotelRepository;

  //  @Autowired
    final private HotelOwnerRepository hotelOwnerRepository;

    @Override
    public void addHotel(Hotel hotel, long ownerId) {
        Optional<HotelOwnerEntity> ownerOptional = hotelOwnerRepository.findById(ownerId);

        if (ownerOptional.isPresent()) {
            HotelEntity hotelEntity = new HotelEntity();
            hotelEntity.setHotelName(hotel.getHotelName());
            hotelEntity.setHotelContact(hotel.getHotelContact());
            hotelEntity.setHotelLoacation(hotel.getHotelLoacation());
            hotelEntity.setHotelDescription(hotel.getHotelDescription());
            hotelEntity.setHotelPhotoPath(hotel.getHotelPhotoPath());

            // Set the hotel owner
            hotelEntity.setHotelOwner(ownerOptional.get()); // Set the foreign key

            hotelRepository.save(hotelEntity);
        } else {
            throw new RuntimeException("Hotel Owner not found!");
        }
    }

    @Override
    public List<HotelEntity> sendAllHotels() {



        return  hotelRepository.findAll();

    }

    @Override
    public List<HotelEntity> getHotelsByName(String hotelSearch) {
        List<HotelEntity> hotelsSearch = hotelRepository.findByHotelName(hotelSearch);


        return hotelsSearch;


    }
}
