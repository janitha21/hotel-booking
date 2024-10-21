package edu.icet.hotelBookingSystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "hotelDetails")
public class HotelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long hotelId;

    private String hotelName;
    private String hotelContact;
    private String hotelLoacation;
    private String hotelDescription;
    private String hotelPhotoPath;

    // Foreign key linking to HotelOwnerEntity
    @ManyToOne
    @JoinColumn(name = "hotelOwnerId", nullable = false)
    private HotelOwnerEntity hotelOwner;

    //------------it
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<BookingEntity> booking;
}
