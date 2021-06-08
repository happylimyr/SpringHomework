package com.nulp.bat.travelagency.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "hotel_type")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HotelType {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @JsonIgnore
    @Column(name = "id_hotel_type")
    private Long idHotelType;
    private String name;
    @OneToMany(mappedBy = "hotelType")
    @JsonIgnore
    private List<Hotel> hotelList = new ArrayList<>();
}
