package edu.icet.hotelBookingSystem.repository;


import edu.icet.hotelBookingSystem.entity.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity,Long> {

    List<UserEntity> findByUserEmail(String userEmail);
}
