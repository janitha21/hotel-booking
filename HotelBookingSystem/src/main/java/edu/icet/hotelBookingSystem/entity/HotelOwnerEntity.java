package edu.icet.hotelBookingSystem.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Setter
@Getter
@Entity
@Table(name = "ownerDetails")
public class HotelOwnerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long hotelOwnerId;
    private String ownerName;
    private String ownerContactNumber;
    private String userName;
    private String password;

    //-----------
    @OneToMany(mappedBy = "hotelOwner", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<HotelEntity> hotels; // Foreign key mapping

    //------
}
