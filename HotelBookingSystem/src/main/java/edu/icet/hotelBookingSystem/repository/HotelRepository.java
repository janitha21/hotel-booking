package edu.icet.hotelBookingSystem.repository;

import edu.icet.hotelBookingSystem.entity.HotelEntity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface HotelRepository extends JpaRepository<HotelEntity,Long> {

    List<HotelEntity> findByHotelName(String hotelName);
}
