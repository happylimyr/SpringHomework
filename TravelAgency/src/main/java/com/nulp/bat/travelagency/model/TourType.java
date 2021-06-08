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
@Table(name = "tour_type")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TourType {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @JsonIgnore
    @Column(name = "id_tour_type")
    private Long idTourType;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "tourType")
    @JsonIgnore
    private List<Tour> tourList = new ArrayList<>();
}
