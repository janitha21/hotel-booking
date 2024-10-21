package edu.icet.hotelBookingSystem.service.impl;

import edu.icet.hotelBookingSystem.entity.BookingEntity;
import edu.icet.hotelBookingSystem.entity.HotelEntity;
import edu.icet.hotelBookingSystem.entity.HotelOwnerEntity;
import edu.icet.hotelBookingSystem.entity.UserEntity;
import edu.icet.hotelBookingSystem.model.Booking;
import edu.icet.hotelBookingSystem.repository.BookingRepository;
import edu.icet.hotelBookingSystem.repository.HotelRepository;
import edu.icet.hotelBookingSystem.repository.UserRepository;
import edu.icet.hotelBookingSystem.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BookingServiceImpl implements BookingService {

    final BookingRepository bookingRepository;
    final HotelRepository hotelRepository;
    final UserRepository userRepository;

    @Override
    public void saveBooking(Booking booking, long hotelId, long userId) {

        Optional<HotelEntity> hotelOptional= hotelRepository.findById(hotelId);

        Optional<UserEntity> userOptional= userRepository.findById(userId);

        if(hotelOptional.isPresent() && userOptional.isPresent()){

            BookingEntity bookingEntity=new BookingEntity();

            bookingEntity.setBookingDate(booking.getBookingDate());
            bookingEntity.setBookingDays(booking.getBookingDays());
            bookingEntity.setPrice(booking.getPrice());


            //forign keys
            bookingEntity.setHotel(hotelOptional.get());
            bookingEntity.setUser(userOptional.get());


            bookingRepository.save(bookingEntity);


        }

        else{
            throw new RuntimeException("hotel not found!");

        }





    }
}
