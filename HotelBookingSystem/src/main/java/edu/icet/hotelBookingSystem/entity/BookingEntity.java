package edu.icet.hotelBookingSystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table(name = "bookingDetails")
public class BookingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookingId;

    private int bookingDate;
    private int bookingDays;
    private double price;

    @ManyToOne
    @JoinColumn(name = "hotelId", nullable = false)
    private HotelEntity hotel;



    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private UserEntity user;


}
