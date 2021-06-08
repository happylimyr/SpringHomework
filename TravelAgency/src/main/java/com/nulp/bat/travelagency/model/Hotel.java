package com.nulp.bat.travelagency.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "hotel")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @JsonIgnore
    @Column(name = "id_hotel")
    private Long idHotel;
    private String name;
    @ManyToOne
//    @ManyToOne(cascade=CascadeType.PERSIST)
//    @ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id_address", nullable = false)
    private Address address;
    //    private Address address;
    @ManyToOne
    @JoinColumn(name = "hotel_type_id_hotel_type")
    private HotelType hotelType;
    @OneToMany(mappedBy = "hotel")
    @JsonIgnore
    private List<Tour> tourList = new ArrayList<>();


}
