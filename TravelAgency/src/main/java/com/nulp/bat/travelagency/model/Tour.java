package com.nulp.bat.travelagency.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tour")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tour {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @JsonIgnore
    @Column(name = "id_tour")
    private Long idTour;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private Double price;
    @Column(name = "date_start")
    private Date dateStart;
    @Column(name = "date_end")
    private Date dateEnd;
    @Column(name = "people_number")
    private Integer peopleNumber;
    @Column(name = "firePrice")
    private Integer firePrice;
    @ManyToOne
    @JoinColumn(name = "hotel_id_hotel")
    private Hotel hotel;
    @ManyToOne
    @JoinColumn(name = "tour_type_id_tour_type")
    private TourType tourType;
    @OneToMany(mappedBy = "tour")
    @JsonIgnore
    private List<Order> orderList = new ArrayList<>();
}
