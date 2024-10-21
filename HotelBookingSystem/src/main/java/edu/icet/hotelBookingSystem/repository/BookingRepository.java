package edu.icet.hotelBookingSystem.repository;

import edu.icet.hotelBookingSystem.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<BookingEntity,Long> {
}
