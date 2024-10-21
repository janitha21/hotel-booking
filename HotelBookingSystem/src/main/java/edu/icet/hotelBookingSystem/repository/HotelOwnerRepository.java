package edu.icet.hotelBookingSystem.repository;

import edu.icet.hotelBookingSystem.entity.HotelEntity;
import edu.icet.hotelBookingSystem.entity.HotelOwnerEntity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface HotelOwnerRepository extends JpaRepository<HotelOwnerEntity,Long> {
    List<HotelOwnerEntity> findByUserName(String userName);
}

